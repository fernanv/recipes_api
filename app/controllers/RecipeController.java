package controllers;

import actions.Timed;
import com.fasterxml.jackson.databind.JsonNode;

import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

public class RecipeController {

    @Inject
    private FormFactory formFactory;

    @Inject
    private MessagesApi messagesApi;

    List<Recipe> recipes;

    @Timed
    public Result getAllRecipes(Http.Request request) {

        if(recipes == null) {
            recipes = Recipe.findRecipes();
        }
        return getRecipes(recipes, request);
    }

    @Timed
    public Result getRecipesByTime(Http.Request request, String maxTime) {

        if(recipes == null) {
            recipes = Recipe.findRecipesByTime(Long.valueOf(maxTime));
        }
        return getRecipes(recipes, request);
    }

    @Timed
    public Result getRecipesByTags(Http.Request request, String tag) {

        if(recipes == null) {
            recipes = Recipe.findRecipesByTags(tag);
        }
        return getRecipes(recipes, request);
    }

    @Timed
    public Result getRecipesByLevel(Http.Request request, String level) {

        if(recipes == null) {
            recipes = Recipe.findRecipesByLevel(level);
        }
        return getRecipes(recipes, request);
    }

    @Timed
    public Result getOneRecipe(String recipeId, Http.Request request) {

        Messages messages = messagesApi.preferred(request);

        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml._recipe.render(recipeFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(recipeFound));
        }
        else{
            return Results.status(406, messages.at("unsupported_format"));
        }

    }

    @Timed
    public Result createRecipe(Http.Request request) {

        Messages messages = messagesApi.preferred(request);

        // 1. Leer el texto del body
        // 2. Leer la cabecera Content-Type de la request
        // 3. Utiliza el parseador correspondiente al Content-Type para parsear el body
        // 4. Una vez parseado, mapea y rellena los valores del objeto Recipe

        Form<Recipe> recipeForm = formFactory.form(Recipe.class).bindFromRequest(request);

        if(recipeForm.hasErrors()){
            JsonNode errors = recipeForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        // Se obtienen los datos de la receta pasados en la request
        Recipe recipe = recipeForm.get();

        // Si el tamaño del vector de ingredientes es distinto al tamaño
        // del vector de las cantidades devuelvo un error
        if(recipe.getQuantities().size() != recipe.getIngredients().size()){
            return Results.status(409, messages.at("different_quantities"));
        }

        // Si se encuentra una receta con el mismo título, no se añade la nueva
        Recipe recipeFound = Recipe.findRecipeByTitle(recipe.getTitle());

        if(recipeFound != null && recipe.getTitle().equals(recipeFound.getTitle()) ){
            return Results.status(409, messages.at("recipe_exists"));
        }

        /*
         Se comprueban que los ingredientes, pasos y utensilios pasados en la
         petición no existan ya, si existen se recuperan con su id de la base
         de datos y se utilizan esos en vez de los pasados en la petición.
         */
        checkRequestIngredients(recipe);
        checkRequestSteps(recipe);
        checkRequestUtensils(recipe);
        checkRequestQuantities(recipe);
        checkRequestTags(recipe);

        // Se guarda la nueva receta en la base de datos
        recipe.save();

        JsonNode node = Json.toJson(recipe);

        return Results.ok(messages.at("recipe_created") + node);
    }

    @Timed
    public Result updateRecipe(String recipeId, Http.Request request) {

        Messages messages = messagesApi.preferred(request);

        Form<Recipe> recipeForm = formFactory.form(Recipe.class).bindFromRequest(request);

        if(recipeForm.hasErrors()){
            JsonNode errors = recipeForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        // Se obtienen los datos de la receta pasados en la request
        Recipe recipe = recipeForm.get();

        // Si el tamaño del vector de ingredientes es distinto al tamaño
        // del vector de las cantidades devuelvo un error
        if(recipe.getQuantities().size() != recipe.getIngredients().size()){
            return Results.status(409, messages.at("different_quantities"));
        }

        // Si se encuentra una receta con el mismo título, no se añade la nueva
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound(messages.at("recipe_not_found"));
        }

        // Se realizan las comprobaciones necesarias para los elementos de la receta
        checkRequestIngredients(recipe);
        checkRequestSteps(recipe);
        checkRequestUtensils(recipe);
        checkRequestQuantities(recipe);
        checkRequestTags(recipe);

        // Se añaden los nuevos elementos a la receta de la base de datos
        recipeFound.setIngredients(recipe.getIngredients());
        recipeFound.setSteps(recipe.getSteps());
        recipeFound.setUtensils(recipe.getUtensils());
        recipeFound.setQuantities(recipe.getQuantities());
        recipeFound.setTags(recipe.getTags());

        // Se actualiza la receta en la base de datos
        recipeFound.update();

        JsonNode node = Json.toJson(recipeFound);

        return Results.ok(messages.at("recipe_updated") + node);
    }

    @Timed
    public Result deleteRecipe(String recipeId, Http.Request request) {

        Messages messages = messagesApi.preferred(request);

        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound(messages.at("recipe_not_found"));
        }

        recipeFound.delete();
        JsonNode node = Json.toJson(recipeFound.getTitle());

        return Results.status(200, messages.at("recipe_deleted") + node );
    }

    public void checkRequestIngredients(Recipe recipe){

        List<Ingredient> ingredients = recipe.getIngredients();
        List<Ingredient> allIngredients = Ingredient.findIngredients();

        // Busco si coincide cada ingrediente pasado con alguno de todos los que
        // se encuentran en la base de datos para no volver a añadirlo
        for(int i = 0; i < ingredients.size(); i++){
            for(int j = 0; j < allIngredients.size(); j++) {
                if (ingredients.get(i).getName().equals(allIngredients.get(j).getName())) {
                    Ingredient dbIngredient = Ingredient.findIngredientByName(ingredients.get(i).getName());
                    ingredients.remove(i);
                    ingredients.add(dbIngredient);
                }
            }
        }
        recipe.setIngredients(ingredients);
    }

    public void checkRequestQuantities(Recipe recipe){

        List<IngredientQuantity> quantities = recipe.getQuantities();
        List<Ingredient> ingredients = recipe.getIngredients();

        // Añado a cada cantidad pasada
        for(int i = 0; i < quantities.size(); i++){
            quantities.get(i).setParentIngredient(ingredients.get(i));
        }

        recipe.setQuantities(quantities);
    }

    public void checkRequestSteps(Recipe recipe){
        List<Step> steps = recipe.getSteps();
        List<Step> allSteps = Step.findSteps(recipe.getId());

        for(int i = 0; i < steps.size(); i++){
            for(int j = 0; j < allSteps.size(); j++){
                if(steps.get(i).getDescription().equals(allSteps.get(j).getDescription())){
                    Step dbStep = Step.findStepByDescription(allSteps.get(j).getDescription());
                    steps.remove(i);
                    steps.add(dbStep);
                }
            }
        }
        recipe.setSteps(steps);
    }

    public void checkRequestUtensils(Recipe recipe){
        List<Utensil> utensils = recipe.getUtensils();
        List<Utensil> allUtensils = Utensil.findUtensils();

        for(int i = 0; i < utensils.size(); i++){
            for(int j = 0; j < allUtensils.size(); j++){
                if(utensils.get(i).getName().equals(allUtensils.get(j).getName())){
                    Utensil dbUtensil = Utensil.findUtensilByName(allUtensils.get(j).getName());
                    utensils.remove(i);
                    utensils.add(dbUtensil);
                }
            }
        }
        recipe.setUtensils(utensils);
    }

    public void checkRequestTags(Recipe recipe){
        List<Tag> tags = recipe.getTags();
        List<Tag> allTags = Tag.findTags();

        for(int i = 0; i < tags.size(); i++){
            for(int j = 0; j < allTags.size(); j++){
                if(tags.get(i).getName().equals(allTags.get(j).getName())){
                    Tag dbTag = Tag.findTagByName(allTags.get(j).getName());
                    tags.remove(i);
                    tags.add(dbTag);
                }
            }
        }
        recipe.setTags(tags);
    }

    public Result getRecipes(List<Recipe> recipes, Http.Request request){

        Messages messages = messagesApi.preferred(request);

        if(recipes == null){
            return Results.notFound(messages.at("recipe_not_found"));
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.recipes.render(recipes));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(recipes));
        }
        else{
            return Results.status(406, messages.at("unsupported_format"));
        }
    }

}

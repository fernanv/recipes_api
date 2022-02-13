package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Ingredient;
import models.IngredientQuantity;
import models.Recipe;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

public class IngredientController {

    @Inject
    private FormFactory formFactory;

    @Inject
    private MessagesApi messagesApi;

    public Result createIngredient(Http.Request request){

        Form<Ingredient> ingredientForm = formFactory.form(Ingredient.class).bindFromRequest(request);

        Messages messages = messagesApi.preferred(request);

        if(ingredientForm.hasErrors()){
            JsonNode errors = ingredientForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        Ingredient ingredient = ingredientForm.get();

        // Si se encuentra un ingrediente con el mismo nombre, no se añade de nuevo
        Ingredient ingredientFound = Ingredient.findIngredientByName(ingredient.getName());

        if(ingredientFound != null && ingredient.getName().equals(ingredientFound.getName()) ){
            return Results.status(409, messages.at("ingredient_exists"));
        }

        ingredient.save();

        JsonNode node = Json.toJson(ingredient);

        return Results.ok(messages.at("ingredient_created") + node );

    }

    public Result deleteIngredient(String ingredientId, Http.Request request){

        Messages messages = messagesApi.preferred(request);

        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));

        if(ingredientFound == null){
            return Results.notFound(messages.at("ingredient_not_found"));
        }

        ingredientFound.delete();
        JsonNode node = Json.toJson(ingredientFound);

        return Results.status(200, messages.at("ingredient_deleted") + node);

    }

    public Result getAllIngredients(Http.Request request){

        Messages messages = messagesApi.preferred(request);

        List<Ingredient> ingredients = Ingredient.findIngredients();

        if(ingredients == null){
            return Results.notFound(messages.at("ingredient_not_found"));
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.ingredients.render(ingredients));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(ingredients));
        }
        else{
            return Results.status(406, messages.at("unsupported_format"));
        }
    }

    public Result getOneIngredient(String ingredientId, Http.Request request) {

        Messages messages = messagesApi.preferred(request);

        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));

        if(ingredientFound == null){
            return Results.notFound(messages.at("ingredient_not_found"));
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml._ingredient.render(ingredientFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(ingredientFound));
        }
        else{
            return Results.status(406, messages.at("unsupported_format"));
        }

    }

    public Result addIngredient(String recipeId, String ingredientId, Http.Request request){

        Messages messages = messagesApi.preferred(request);

        Form<IngredientQuantity> quantityForm = formFactory.form(IngredientQuantity.class).bindFromRequest(request);

        if(quantityForm.hasErrors()){
            JsonNode errors = quantityForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        IngredientQuantity ingredientQuantity = quantityForm.get();

        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound(messages.at("recipe_not_found"));
        }

        if(ingredientFound == null){
            return Results.notFound(messages.at("ingredient_not_found"));
        }

        ingredientQuantity.setParentIngredient(ingredientFound);

        recipeFound.addIngredient(ingredientFound);
        recipeFound.addQuantity(ingredientQuantity);

        ingredientQuantity.save();

        JsonNode node = Json.toJson(ingredientQuantity);

        return Results.ok(messages.at("ingredient_added") + ingredientQuantity);
    }

    public Result quitIngredient(String recipeId, String ingredientId, String quantityId, Http.Request request){

        Messages messages = messagesApi.preferred(request);

        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));
        IngredientQuantity quantityFound = IngredientQuantity.findIngredientQuantityById(Long.valueOf(quantityId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound(messages.at("recipe_not_found"));
        }

        if(ingredientFound == null){
            return Results.notFound(messages.at("ingredient_not_found"));
        }

        if(quantityFound == null){
            return Results.notFound();
        }

        recipeFound.quitIngredient(ingredientFound);
        recipeFound.quitQuantity(quantityFound);

        quantityFound.delete();

        JsonNode node = Json.toJson(quantityFound);

        return Results.ok(messages.at("ingredient_removed") + node);
    }

    public Result getRecipeIngredients(String recipeId, Http.Request request){

        Messages messages = messagesApi.preferred(request);

        List<IngredientQuantity> ingredientsFound = IngredientQuantity.findIngredientsByRecipeId(Long.valueOf(recipeId));

        if(ingredientsFound == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.ingredients_quantities.render(ingredientsFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(ingredientsFound));
        }
        else{
            return Results.status(406, messages.at("unsupported_format"));
        }
    }
}

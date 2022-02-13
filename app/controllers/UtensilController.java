package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Ingredient;
import models.Recipe;
import models.Utensil;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Content;

import javax.inject.Inject;
import java.util.List;

public class UtensilController {

    @Inject
    private FormFactory formFactory;

    public Result createUtensil(Http.Request request){

        Form<Utensil> utensilForm = formFactory.form(Utensil.class).bindFromRequest(request);

        if(utensilForm.hasErrors()){
            JsonNode errors = utensilForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        Utensil utensil = utensilForm.get();

        // Si se encuentra un utensilio con el mismo nombre, no se añade de nuevo
        Utensil utensilFound = Utensil.findUtensilByName(utensil.getName());

        if(utensilFound != null && utensil.getName().equals(utensilFound.getName()) ){
            return Results.status(409,"Utensil already exists");
        }

        utensil.save();

        JsonNode node = Json.toJson(utensil);

        return Results.ok("Utensil created" + node);
    }

    public Result deleteUtensil(String utensilId){

        Utensil utensilFound = Utensil.findUtensilById(Long.valueOf(utensilId));

        if(utensilFound == null){
            return Results.notFound();
        }

        utensilFound.delete();

        JsonNode node = Json.toJson(utensilFound);

        return Results.status(200, "Utensil deleted" + node);
    }

    public Result getAllUtensils(Http.Request request){

        List<Utensil> utensils = Utensil.findUtensils();

        if(utensils == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.utensils.render(utensils));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(utensils));
        }
        else{
            return Results.status(406,"Unsupported format");
        }

    }

    public Result getOneUtensil(String utensilId, Http.Request request) {

        Utensil utensilFound = Utensil.findUtensilById(Long.valueOf(utensilId));

        if(utensilFound == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml._utensil.render(utensilFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(utensilFound));
        }
        else{
            return Results.status(406,"Unsupported format");
        }

    }

    public Result addUtensil(String recipeId, String utensilId){

        Utensil utensilFound = Utensil.findUtensilById(Long.valueOf(utensilId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(utensilFound == null){
            return Results.notFound();
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        recipeFound.addUtensil(utensilFound);
        utensilFound.update();

        JsonNode node = Json.toJson(utensilFound);

        return Results.ok("Utensil added to recipe " + node);
    }

    public Result quitUtensil(String recipeId, String utensilId){

        Utensil utensilFound = Utensil.findUtensilById(Long.valueOf(utensilId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(utensilFound == null){
            return Results.notFound();
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        recipeFound.quitUtensil(utensilFound);
        utensilFound.update();

        JsonNode node = Json.toJson(utensilFound);

        return Results.ok("Utensil deleted from recipe " + node);
    }

    public Result getRecipeUtensils(String recipeId, Http.Request request){

        List<Utensil> utensilsFound = Utensil.findUtensilsByRecipeId(Long.valueOf(recipeId));

        if(utensilsFound == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.utensils.render(utensilsFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(utensilsFound));
        }
        else{
            return Results.status(406,"Unsupported format");
        }
    }
}

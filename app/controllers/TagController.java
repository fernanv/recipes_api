package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Recipe;
import models.Tag;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

public class TagController {

    @Inject
    private FormFactory formFactory;

    public Result createTag(Http.Request request){

        Form<Tag> tagForm = formFactory.form(Tag.class).bindFromRequest(request);

        if(tagForm.hasErrors()){
            JsonNode errors = tagForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        Tag tag = tagForm.get();

        // Si se encuentra una etiqueta con el mismo título, no se añade de nuevo
        Tag tagFound = Tag.findTagByName(tag.getName());

        if(tagFound != null && tag.getName().equals(tagFound.getName()) ){
            return Results.status(409,"Tag already exists");
        }

        tag.save();

        JsonNode node = Json.toJson(tag);

        return Results.ok("Tag created" + node);
    }

    public Result deleteTag(String utensilId){

        Tag tagFound = Tag.findTagById(Long.valueOf(utensilId));

        if(tagFound == null){
            return Results.notFound("Tag not found");
        }

        tagFound.delete();
        JsonNode node = Json.toJson(tagFound);

        return Results.status(200, "Tag deleted" + node);
    }

    public Result getAllTags(Http.Request request){

        List<Tag> tags = Tag.findTags();

        if(tags == null){
            return Results.notFound("Tags not found");
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.tags.render(tags));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(tags));
        }
        else{
            return Results.status(406,"Unsupported format");
        }

    }

    public Result getOneTag(String tagId, Http.Request request) {

        Tag tagFound = Tag.findTagById(Long.valueOf(tagId));

        if(tagFound == null){
            return Results.notFound("Tag not found");
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml._tag.render(tagFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(tagFound));
        }
        else{
            return Results.status(406,"Unsupported format");
        }

    }

    public Result addTag(String recipeId, String tagId){

        Tag tagFound = Tag.findTagById(Long.valueOf(tagId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(tagFound == null){
            return Results.notFound("Tag not found");
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        recipeFound.addTag(tagFound);
        tagFound.update();

        JsonNode node = Json.toJson(tagFound);

        return Results.ok("Tag added to recipe " + node);
    }

    public Result quitTag(String recipeId, String tagId){

        Tag tagFound = Tag.findTagById(Long.valueOf(tagId));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(tagFound == null){
            return Results.notFound("Tag not found");
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        recipeFound.quitTag(tagFound);
        tagFound.update();

        JsonNode node = Json.toJson(tagFound);

        return Results.ok("Tag deleted from recipe " + node);
    }

    public Result getRecipeTags(String recipeId, Http.Request request){

        List<Tag> tagsFound = Tag.findTagsByRecipeId(Long.valueOf(recipeId));

        if(tagsFound == null){
            return Results.notFound("Tags not found");
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.tags.render(tagsFound));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(tagsFound));
        }
        else{
            return Results.status(406,"Unsupported format");
        }
    }
}


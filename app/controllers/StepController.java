package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Recipe;
import models.Step;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;

public class StepController {

    @Inject
    private FormFactory formFactory;

    public Result addStep(String recipeId, Http.Request request){

        Form<Step> stepForm = formFactory.form(Step.class).bindFromRequest(request);

        if(stepForm.hasErrors()){
            JsonNode errors = stepForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        Step step = stepForm.get();
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        step.setParentRecipe(recipeFound);

        step.save();

        JsonNode node = Json.toJson(step);

        return Results.ok("Step created for recipe" + node);

    }

    public Result updateStep(String recipeId, String stepNumber, Http.Request request){

        Form<Step> stepForm = formFactory.form(Step.class).bindFromRequest(request);

        if(stepForm.hasErrors()){
            JsonNode errors = stepForm.errorsAsJson();
            return Results.notAcceptable(errors);
        }

        Step step = stepForm.get();
        Step stepFound = Step.findStepByRecipe(Long.valueOf(recipeId), Long.valueOf(stepNumber));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(stepFound == null){
            return Results.notFound("Step not found");
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        // Se quita el paso de la receta y se vuelve a añadir modificado
        recipeFound.deleteStep(stepFound);
        stepFound.setDescription(step.getDescription());
        stepFound.setDescription(step.getDescription());
        recipeFound.addStep(stepFound);

        stepFound.update();

        JsonNode node = Json.toJson(stepFound);

        return Results.ok("Step updated" + node);
    }

    public Result deleteStep(String recipeId, String order){

        Step stepFound = Step.findStepByRecipe(Long.valueOf(recipeId), Long.valueOf(order));
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(stepFound == null){
            return Results.notFound();
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        recipeFound.deleteStep(stepFound);
        stepFound.delete();

        JsonNode node = Json.toJson("Step deleted from recipe " + recipeFound);

        return Results.status(200, node);
    }

    public Result getAllSteps(String recipeId, Http.Request request){

        List<Step> steps = Step.findSteps(Long.valueOf(recipeId));

        if(steps == null){
            return Results.notFound();
        }
        else if(request.accepts("application/xml")){
            return Results.ok(views.xml.steps.render(steps));
        }
        else if(request.accepts("application/json")){
            return Results.ok(Json.toJson(steps));
        }
        else{
            return Results.status(406,"Unsupported format");
        }

    }

    public Result updateAllSteps(String recipeId, Http.Request request){

        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));
        List<Step> steps = Step.findSteps(Long.valueOf(recipeId));

        if(steps == null){
            return Results.notFound("Steps not found");
        }

        if(recipeFound == null){
            return Results.notFound("recipe_not_found");
        }

        for(int i = 0; i < steps.size(); i++){
            recipeFound.addStep(steps.get(i));
            steps.get(i).update();
        }

        JsonNode node = Json.toJson(recipeFound);

        return Results.ok("Steps from recipe updated" + node);

    }
}

// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTagController TagController = new controllers.ReverseTagController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRecipeController RecipeController = new controllers.ReverseRecipeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUtensilController UtensilController = new controllers.ReverseUtensilController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseIngredientController IngredientController = new controllers.ReverseIngredientController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseStepController StepController = new controllers.ReverseStepController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTagController TagController = new controllers.javascript.ReverseTagController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRecipeController RecipeController = new controllers.javascript.ReverseRecipeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUtensilController UtensilController = new controllers.javascript.ReverseUtensilController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseIngredientController IngredientController = new controllers.javascript.ReverseIngredientController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseStepController StepController = new controllers.javascript.ReverseStepController(RoutesPrefix.byNamePrefix());
  }

}

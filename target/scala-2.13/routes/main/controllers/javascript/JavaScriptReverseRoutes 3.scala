// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:33
  class ReverseTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def getAllTags: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getAllTags",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "etiquetas"})
        }
      """
    )
  
    // @LINE:36
    def addTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTag",
      """
        function(recipeId0,tagId1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/etiqueta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tagId", tagId1))})
        }
      """
    )
  
    // @LINE:37
    def quitTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.quitTag",
      """
        function(recipeId0,tagId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/etiqueta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tagId", tagId1))})
        }
      """
    )
  
    // @LINE:42
    def deleteTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTag",
      """
        function(tagId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "etiqueta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tagId", tagId0))})
        }
      """
    )
  
    // @LINE:40
    def getOneTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getOneTag",
      """
        function(tagId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "etiqueta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tagId", tagId0))})
        }
      """
    )
  
    // @LINE:45
    def getRecipeTags: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getRecipeTags",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/etiquetas"})
        }
      """
    )
  
    // @LINE:41
    def createTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.createTag",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "etiquetas"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseRecipeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def deleteRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteRecipe",
      """
        function(recipeId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:6
    def getAllRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getAllRecipes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas"})
        }
      """
    )
  
    // @LINE:12
    def getOneRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getOneRecipe",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:14
    def updateRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.updateRecipe",
      """
        function(recipeId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:8
    def getRecipesByTags: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getRecipesByTags",
      """
        function(tag0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/etiqueta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("tag", tag0))})
        }
      """
    )
  
    // @LINE:9
    def getRecipesByLevel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getRecipesByLevel",
      """
        function(level0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/dificultad/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("level", level0))})
        }
      """
    )
  
    // @LINE:13
    def createRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.createRecipe",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas"})
        }
      """
    )
  
    // @LINE:7
    def getRecipesByTime: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getRecipesByTime",
      """
        function(maxTime0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/tiempo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("maxTime", maxTime0))})
        }
      """
    )
  
  }

  // @LINE:48
  class ReverseUtensilController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:55
    def getOneUtensil: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.getOneUtensil",
      """
        function(utensilId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "utensilio/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("utensilId", utensilId0))})
        }
      """
    )
  
    // @LINE:51
    def addUtensil: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.addUtensil",
      """
        function(recipeId0,utensilId1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/utensilio/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("utensilId", utensilId1))})
        }
      """
    )
  
    // @LINE:52
    def quitUtensil: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.quitUtensil",
      """
        function(recipeId0,utensilId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/utensilio/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("utensilId", utensilId1))})
        }
      """
    )
  
    // @LINE:48
    def getAllUtensils: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.getAllUtensils",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "utensilios"})
        }
      """
    )
  
    // @LINE:56
    def createUtensil: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.createUtensil",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "utensilios"})
        }
      """
    )
  
    // @LINE:60
    def getRecipeUtensils: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.getRecipeUtensils",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/utensilios"})
        }
      """
    )
  
    // @LINE:57
    def deleteUtensil: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UtensilController.deleteUtensil",
      """
        function(utensilId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "utensilio/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("utensilId", utensilId0))})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseIngredientController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def getAllIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.getAllIngredients",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes"})
        }
      """
    )
  
    // @LINE:26
    def addIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.addIngredient",
      """
        function(recipeId0,ingredientId1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId1))})
        }
      """
    )
  
    // @LINE:18
    def getOneIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.getOneIngredient",
      """
        function(ingredientId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId0))})
        }
      """
    )
  
    // @LINE:19
    def createIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.createIngredient",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes"})
        }
      """
    )
  
    // @LINE:27
    def quitIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.quitIngredient",
      """
        function(recipeId0,ingredientId1,quantityId2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId1)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("quantityId", quantityId2)])})
        }
      """
    )
  
    // @LINE:30
    def getRecipeIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.getRecipeIngredients",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingredientes"})
        }
      """
    )
  
    // @LINE:20
    def deleteIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.deleteIngredient",
      """
        function(ingredientId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId0))})
        }
      """
    )
  
  }

  // @LINE:63
  class ReverseStepController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:65
    def deleteStep: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StepController.deleteStep",
      """
        function(recipeId0,order1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/paso" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("order", order1))})
        }
      """
    )
  
    // @LINE:69
    def updateAllSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StepController.updateAllSteps",
      """
        function(recipeId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/pasos"})
        }
      """
    )
  
    // @LINE:64
    def updateStep: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StepController.updateStep",
      """
        function(recipeId0,order1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/paso" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("order", order1))})
        }
      """
    )
  
    // @LINE:63
    def addStep: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StepController.addStep",
      """
        function(recipeId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/pasos"})
        }
      """
    )
  
    // @LINE:68
    def getAllSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StepController.getAllSteps",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/pasos"})
        }
      """
    )
  
  }


}

// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:33
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def getAllTags(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "etiquetas")
    }
  
    // @LINE:36
    def addTag(recipeId:String, tagId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/etiqueta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tagId", tagId)))
    }
  
    // @LINE:37
    def quitTag(recipeId:String, tagId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/etiqueta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tagId", tagId)))
    }
  
    // @LINE:42
    def deleteTag(tagId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "etiqueta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tagId", tagId)))
    }
  
    // @LINE:40
    def getOneTag(tagId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "etiqueta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tagId", tagId)))
    }
  
    // @LINE:45
    def getRecipeTags(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/etiquetas")
    }
  
    // @LINE:41
    def createTag(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "etiquetas")
    }
  
  }

  // @LINE:6
  class ReverseRecipeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def deleteRecipe(recipeId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:6
    def getAllRecipes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas")
    }
  
    // @LINE:12
    def getOneRecipe(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:14
    def updateRecipe(recipeId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:8
    def getRecipesByTags(tag:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/etiqueta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("tag", tag)))
    }
  
    // @LINE:9
    def getRecipesByLevel(level:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/dificultad/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("level", level)))
    }
  
    // @LINE:13
    def createRecipe(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recetas")
    }
  
    // @LINE:7
    def getRecipesByTime(maxTime:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/tiempo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("maxTime", maxTime)))
    }
  
  }

  // @LINE:48
  class ReverseUtensilController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:55
    def getOneUtensil(utensilId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "utensilio/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("utensilId", utensilId)))
    }
  
    // @LINE:51
    def addUtensil(recipeId:String, utensilId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/utensilio/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("utensilId", utensilId)))
    }
  
    // @LINE:52
    def quitUtensil(recipeId:String, utensilId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/utensilio/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("utensilId", utensilId)))
    }
  
    // @LINE:48
    def getAllUtensils(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "utensilios")
    }
  
    // @LINE:56
    def createUtensil(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "utensilios")
    }
  
    // @LINE:60
    def getRecipeUtensils(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/utensilios")
    }
  
    // @LINE:57
    def deleteUtensil(utensilId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "utensilio/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("utensilId", utensilId)))
    }
  
  }

  // @LINE:18
  class ReverseIngredientController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def getAllIngredients(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes")
    }
  
    // @LINE:26
    def addIngredient(recipeId:String, ingredientId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("ingredientId", ingredientId)))
    }
  
    // @LINE:18
    def getOneIngredient(ingredientId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("ingredientId", ingredientId)))
    }
  
    // @LINE:19
    def createIngredient(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ingredientes")
    }
  
    // @LINE:27
    def quitIngredient(recipeId:String, ingredientId:String, quantityId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("ingredientId", ingredientId)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("quantityId", quantityId)))))
    }
  
    // @LINE:30
    def getRecipeIngredients(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/ingredientes")
    }
  
    // @LINE:20
    def deleteIngredient(ingredientId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("ingredientId", ingredientId)))
    }
  
  }

  // @LINE:63
  class ReverseStepController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:65
    def deleteStep(recipeId:String, order:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/paso" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("order", order)))
    }
  
    // @LINE:69
    def updateAllSteps(recipeId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/pasos")
    }
  
    // @LINE:64
    def updateStep(recipeId:String, order:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/paso" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("order", order)))
    }
  
    // @LINE:63
    def addStep(recipeId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/pasos")
    }
  
    // @LINE:68
    def getAllSteps(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/pasos")
    }
  
  }


}

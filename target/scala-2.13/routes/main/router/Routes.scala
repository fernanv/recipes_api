// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  RecipeController_2: controllers.RecipeController,
  // @LINE:18
  IngredientController_1: controllers.IngredientController,
  // @LINE:33
  TagController_3: controllers.TagController,
  // @LINE:48
  UtensilController_0: controllers.UtensilController,
  // @LINE:63
  StepController_4: controllers.StepController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    RecipeController_2: controllers.RecipeController,
    // @LINE:18
    IngredientController_1: controllers.IngredientController,
    // @LINE:33
    TagController_3: controllers.TagController,
    // @LINE:48
    UtensilController_0: controllers.UtensilController,
    // @LINE:63
    StepController_4: controllers.StepController
  ) = this(errorHandler, RecipeController_2, IngredientController_1, TagController_3, UtensilController_0, StepController_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RecipeController_2, IngredientController_1, TagController_3, UtensilController_0, StepController_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas""", """controllers.RecipeController.getAllRecipes(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/tiempo/""" + "$" + """maxTime<[^/]+>""", """controllers.RecipeController.getRecipesByTime(request:Request, maxTime:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/etiqueta/""" + "$" + """tag<[^/]+>""", """controllers.RecipeController.getRecipesByTags(request:Request, tag:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/dificultad/""" + "$" + """level<[^/]+>""", """controllers.RecipeController.getRecipesByLevel(request:Request, level:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.getOneRecipe(recipeId:String, request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas""", """controllers.RecipeController.createRecipe(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.updateRecipe(recipeId:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.deleteRecipe(recipeId:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingrediente/""" + "$" + """ingredientId<[^/]+>""", """controllers.IngredientController.getOneIngredient(ingredientId:String, request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes""", """controllers.IngredientController.createIngredient(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingrediente/""" + "$" + """ingredientId<[^/]+>""", """controllers.IngredientController.deleteIngredient(ingredientId:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes""", """controllers.IngredientController.getAllIngredients(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/ingrediente/""" + "$" + """ingredientId<[^/]+>""", """controllers.IngredientController.addIngredient(recipeId:String, ingredientId:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/ingrediente/""" + "$" + """ingredientId<[^/]+>/quantity/""" + "$" + """quantityId<[^/]+>""", """controllers.IngredientController.quitIngredient(recipeId:String, ingredientId:String, quantityId:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/ingredientes""", """controllers.IngredientController.getRecipeIngredients(recipeId:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """etiquetas""", """controllers.TagController.getAllTags(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/etiqueta/""" + "$" + """tagId<[^/]+>""", """controllers.TagController.addTag(recipeId:String, tagId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/etiqueta/""" + "$" + """tagId<[^/]+>""", """controllers.TagController.quitTag(recipeId:String, tagId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """etiqueta/""" + "$" + """tagId<[^/]+>""", """controllers.TagController.getOneTag(tagId:String, request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """etiquetas""", """controllers.TagController.createTag(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """etiqueta/""" + "$" + """tagId<[^/]+>""", """controllers.TagController.deleteTag(tagId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/etiquetas""", """controllers.TagController.getRecipeTags(recipeId:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """utensilios""", """controllers.UtensilController.getAllUtensils(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/utensilio/""" + "$" + """utensilId<[^/]+>""", """controllers.UtensilController.addUtensil(recipeId:String, utensilId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/utensilio/""" + "$" + """utensilId<[^/]+>""", """controllers.UtensilController.quitUtensil(recipeId:String, utensilId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """utensilio/""" + "$" + """utensilId<[^/]+>""", """controllers.UtensilController.getOneUtensil(utensilId:String, request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """utensilios""", """controllers.UtensilController.createUtensil(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """utensilio/""" + "$" + """utensilId<[^/]+>""", """controllers.UtensilController.deleteUtensil(utensilId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/utensilios""", """controllers.UtensilController.getRecipeUtensils(recipeId:String, request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/pasos""", """controllers.StepController.addStep(recipeId:String, request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/paso""" + "$" + """order<[^/]+>""", """controllers.StepController.updateStep(recipeId:String, order:String, request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/paso""" + "$" + """order<[^/]+>""", """controllers.StepController.deleteStep(recipeId:String, order:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/pasos""", """controllers.StepController.getAllSteps(recipeId:String, request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>/pasos""", """controllers.StepController.updateAllSteps(recipeId:String, request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_RecipeController_getAllRecipes0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas")))
  )
  private[this] lazy val controllers_RecipeController_getAllRecipes0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.getAllRecipes(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getAllRecipes",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """recetas""",
      """ Consultar todas las recetas y filtrarlas por tiempo máximo, etiqueta o dificultad""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_RecipeController_getRecipesByTime1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/tiempo/"), DynamicPart("maxTime", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getRecipesByTime1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.getRecipesByTime(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getRecipesByTime",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/tiempo/""" + "$" + """maxTime<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_RecipeController_getRecipesByTags2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/etiqueta/"), DynamicPart("tag", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getRecipesByTags2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.getRecipesByTags(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getRecipesByTags",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/etiqueta/""" + "$" + """tag<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_RecipeController_getRecipesByLevel3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/dificultad/"), DynamicPart("level", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getRecipesByLevel3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.getRecipesByLevel(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getRecipesByLevel",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recetas/dificultad/""" + "$" + """level<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_RecipeController_getOneRecipe4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getOneRecipe4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.getOneRecipe(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getOneRecipe",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>""",
      """ Consultar, crear, actualizar y borrar una receta""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_RecipeController_createRecipe5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas")))
  )
  private[this] lazy val controllers_RecipeController_createRecipe5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.createRecipe(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "createRecipe",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """recetas""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_RecipeController_updateRecipe6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_updateRecipe6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.updateRecipe(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "updateRecipe",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_RecipeController_deleteRecipe7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_deleteRecipe7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_2.deleteRecipe(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "deleteRecipe",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_IngredientController_getOneIngredient8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingrediente/"), DynamicPart("ingredientId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientController_getOneIngredient8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.getOneIngredient(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "getOneIngredient",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """ingrediente/""" + "$" + """ingredientId<[^/]+>""",
      """ Consultar, crear y borrar un ingrediente""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_IngredientController_createIngredient9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes")))
  )
  private[this] lazy val controllers_IngredientController_createIngredient9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.createIngredient(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "createIngredient",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """ingredientes""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_IngredientController_deleteIngredient10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingrediente/"), DynamicPart("ingredientId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientController_deleteIngredient10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.deleteIngredient(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "deleteIngredient",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "DELETE",
      this.prefix + """ingrediente/""" + "$" + """ingredientId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_IngredientController_getAllIngredients11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes")))
  )
  private[this] lazy val controllers_IngredientController_getAllIngredients11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.getAllIngredients(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "getAllIngredients",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """ingredientes""",
      """ Consultar todos los ingredientes""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_IngredientController_addIngredient12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/ingrediente/"), DynamicPart("ingredientId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientController_addIngredient12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.addIngredient(fakeValue[String], fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "addIngredient",
      Seq(classOf[String], classOf[String], classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/ingrediente/""" + "$" + """ingredientId<[^/]+>""",
      """ Añadir y quitar un ingrediente de una receta""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_IngredientController_quitIngredient13_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/ingrediente/"), DynamicPart("ingredientId", """[^/]+""",true), StaticPart("/quantity/"), DynamicPart("quantityId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredientController_quitIngredient13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.quitIngredient(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "quitIngredient",
      Seq(classOf[String], classOf[String], classOf[String], classOf[play.mvc.Http.Request]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/ingrediente/""" + "$" + """ingredientId<[^/]+>/quantity/""" + "$" + """quantityId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_IngredientController_getRecipeIngredients14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/ingredientes")))
  )
  private[this] lazy val controllers_IngredientController_getRecipeIngredients14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      IngredientController_1.getRecipeIngredients(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredientController",
      "getRecipeIngredients",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/ingredientes""",
      """ Consultar todos los ingredientes de una receta""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_TagController_getAllTags15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("etiquetas")))
  )
  private[this] lazy val controllers_TagController_getAllTags15_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TagController_3.getAllTags(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getAllTags",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """etiquetas""",
      """ Consultar todas las etiquetas""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_TagController_addTag16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/etiqueta/"), DynamicPart("tagId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTag16_invoker = createInvoker(
    TagController_3.addTag(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "addTag",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/etiqueta/""" + "$" + """tagId<[^/]+>""",
      """ Añadir y quitar una etiqueta asociado a una receta""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_TagController_quitTag17_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/etiqueta/"), DynamicPart("tagId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_quitTag17_invoker = createInvoker(
    TagController_3.quitTag(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "quitTag",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/etiqueta/""" + "$" + """tagId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_TagController_getOneTag18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("etiqueta/"), DynamicPart("tagId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getOneTag18_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TagController_3.getOneTag(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getOneTag",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """etiqueta/""" + "$" + """tagId<[^/]+>""",
      """ Consultar, crear y borrar una etiqueta""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_TagController_createTag19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("etiquetas")))
  )
  private[this] lazy val controllers_TagController_createTag19_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TagController_3.createTag(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "createTag",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """etiquetas""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_TagController_deleteTag20_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("etiqueta/"), DynamicPart("tagId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTag20_invoker = createInvoker(
    TagController_3.deleteTag(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "deleteTag",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """etiqueta/""" + "$" + """tagId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_TagController_getRecipeTags21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/etiquetas")))
  )
  private[this] lazy val controllers_TagController_getRecipeTags21_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TagController_3.getRecipeTags(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getRecipeTags",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/etiquetas""",
      """ Consultar todas las etiquetas de una receta""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_UtensilController_getAllUtensils22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("utensilios")))
  )
  private[this] lazy val controllers_UtensilController_getAllUtensils22_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UtensilController_0.getAllUtensils(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "getAllUtensils",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """utensilios""",
      """ Consultar todos los utensilios""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_UtensilController_addUtensil23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/utensilio/"), DynamicPart("utensilId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UtensilController_addUtensil23_invoker = createInvoker(
    UtensilController_0.addUtensil(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "addUtensil",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/utensilio/""" + "$" + """utensilId<[^/]+>""",
      """ Añadir y quitar un utensilio asociado a una receta""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_UtensilController_quitUtensil24_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/utensilio/"), DynamicPart("utensilId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UtensilController_quitUtensil24_invoker = createInvoker(
    UtensilController_0.quitUtensil(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "quitUtensil",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/utensilio/""" + "$" + """utensilId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_UtensilController_getOneUtensil25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("utensilio/"), DynamicPart("utensilId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UtensilController_getOneUtensil25_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UtensilController_0.getOneUtensil(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "getOneUtensil",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """utensilio/""" + "$" + """utensilId<[^/]+>""",
      """ Consultar, crear y borrar un utensilio""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_UtensilController_createUtensil26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("utensilios")))
  )
  private[this] lazy val controllers_UtensilController_createUtensil26_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UtensilController_0.createUtensil(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "createUtensil",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """utensilios""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_UtensilController_deleteUtensil27_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("utensilio/"), DynamicPart("utensilId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UtensilController_deleteUtensil27_invoker = createInvoker(
    UtensilController_0.deleteUtensil(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "deleteUtensil",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """utensilio/""" + "$" + """utensilId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_UtensilController_getRecipeUtensils28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/utensilios")))
  )
  private[this] lazy val controllers_UtensilController_getRecipeUtensils28_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UtensilController_0.getRecipeUtensils(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UtensilController",
      "getRecipeUtensils",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/utensilios""",
      """ Consultar todos los utensilios necesarios para una receta""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_StepController_addStep29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/pasos")))
  )
  private[this] lazy val controllers_StepController_addStep29_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StepController_4.addStep(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StepController",
      "addStep",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/pasos""",
      """ Añadir, actualizar y borrar un paso de una receta""",
      Seq()
    )
  )

  // @LINE:64
  private[this] lazy val controllers_StepController_updateStep30_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/paso"), DynamicPart("order", """[^/]+""",true)))
  )
  private[this] lazy val controllers_StepController_updateStep30_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StepController_4.updateStep(fakeValue[String], fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StepController",
      "updateStep",
      Seq(classOf[String], classOf[String], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/paso""" + "$" + """order<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_StepController_deleteStep31_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/paso"), DynamicPart("order", """[^/]+""",true)))
  )
  private[this] lazy val controllers_StepController_deleteStep31_invoker = createInvoker(
    StepController_4.deleteStep(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StepController",
      "deleteStep",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/paso""" + "$" + """order<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:68
  private[this] lazy val controllers_StepController_getAllSteps32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/pasos")))
  )
  private[this] lazy val controllers_StepController_getAllSteps32_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StepController_4.getAllSteps(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StepController",
      "getAllSteps",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/pasos""",
      """ Consultar y actualizar todos los pasos necesarios para elaborar una receta""",
      Seq()
    )
  )

  // @LINE:69
  private[this] lazy val controllers_StepController_updateAllSteps33_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/pasos")))
  )
  private[this] lazy val controllers_StepController_updateAllSteps33_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      StepController_4.updateAllSteps(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StepController",
      "updateAllSteps",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "PUT",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>/pasos""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_RecipeController_getAllRecipes0_route(params@_) =>
      call { 
        controllers_RecipeController_getAllRecipes0_invoker.call(
          req => RecipeController_2.getAllRecipes(req))
      }
  
    // @LINE:7
    case controllers_RecipeController_getRecipesByTime1_route(params@_) =>
      call(params.fromPath[String]("maxTime", None)) { (maxTime) =>
        controllers_RecipeController_getRecipesByTime1_invoker.call(
          req => RecipeController_2.getRecipesByTime(req, maxTime))
      }
  
    // @LINE:8
    case controllers_RecipeController_getRecipesByTags2_route(params@_) =>
      call(params.fromPath[String]("tag", None)) { (tag) =>
        controllers_RecipeController_getRecipesByTags2_invoker.call(
          req => RecipeController_2.getRecipesByTags(req, tag))
      }
  
    // @LINE:9
    case controllers_RecipeController_getRecipesByLevel3_route(params@_) =>
      call(params.fromPath[String]("level", None)) { (level) =>
        controllers_RecipeController_getRecipesByLevel3_invoker.call(
          req => RecipeController_2.getRecipesByLevel(req, level))
      }
  
    // @LINE:12
    case controllers_RecipeController_getOneRecipe4_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_getOneRecipe4_invoker.call(
          req => RecipeController_2.getOneRecipe(recipeId, req))
      }
  
    // @LINE:13
    case controllers_RecipeController_createRecipe5_route(params@_) =>
      call { 
        controllers_RecipeController_createRecipe5_invoker.call(
          req => RecipeController_2.createRecipe(req))
      }
  
    // @LINE:14
    case controllers_RecipeController_updateRecipe6_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_updateRecipe6_invoker.call(
          req => RecipeController_2.updateRecipe(recipeId, req))
      }
  
    // @LINE:15
    case controllers_RecipeController_deleteRecipe7_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_deleteRecipe7_invoker.call(
          req => RecipeController_2.deleteRecipe(recipeId, req))
      }
  
    // @LINE:18
    case controllers_IngredientController_getOneIngredient8_route(params@_) =>
      call(params.fromPath[String]("ingredientId", None)) { (ingredientId) =>
        controllers_IngredientController_getOneIngredient8_invoker.call(
          req => IngredientController_1.getOneIngredient(ingredientId, req))
      }
  
    // @LINE:19
    case controllers_IngredientController_createIngredient9_route(params@_) =>
      call { 
        controllers_IngredientController_createIngredient9_invoker.call(
          req => IngredientController_1.createIngredient(req))
      }
  
    // @LINE:20
    case controllers_IngredientController_deleteIngredient10_route(params@_) =>
      call(params.fromPath[String]("ingredientId", None)) { (ingredientId) =>
        controllers_IngredientController_deleteIngredient10_invoker.call(
          req => IngredientController_1.deleteIngredient(ingredientId, req))
      }
  
    // @LINE:23
    case controllers_IngredientController_getAllIngredients11_route(params@_) =>
      call { 
        controllers_IngredientController_getAllIngredients11_invoker.call(
          req => IngredientController_1.getAllIngredients(req))
      }
  
    // @LINE:26
    case controllers_IngredientController_addIngredient12_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("ingredientId", None)) { (recipeId, ingredientId) =>
        controllers_IngredientController_addIngredient12_invoker.call(
          req => IngredientController_1.addIngredient(recipeId, ingredientId, req))
      }
  
    // @LINE:27
    case controllers_IngredientController_quitIngredient13_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("ingredientId", None), params.fromPath[String]("quantityId", None)) { (recipeId, ingredientId, quantityId) =>
        controllers_IngredientController_quitIngredient13_invoker.call(
          req => IngredientController_1.quitIngredient(recipeId, ingredientId, quantityId, req))
      }
  
    // @LINE:30
    case controllers_IngredientController_getRecipeIngredients14_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_IngredientController_getRecipeIngredients14_invoker.call(
          req => IngredientController_1.getRecipeIngredients(recipeId, req))
      }
  
    // @LINE:33
    case controllers_TagController_getAllTags15_route(params@_) =>
      call { 
        controllers_TagController_getAllTags15_invoker.call(
          req => TagController_3.getAllTags(req))
      }
  
    // @LINE:36
    case controllers_TagController_addTag16_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("tagId", None)) { (recipeId, tagId) =>
        controllers_TagController_addTag16_invoker.call(TagController_3.addTag(recipeId, tagId))
      }
  
    // @LINE:37
    case controllers_TagController_quitTag17_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("tagId", None)) { (recipeId, tagId) =>
        controllers_TagController_quitTag17_invoker.call(TagController_3.quitTag(recipeId, tagId))
      }
  
    // @LINE:40
    case controllers_TagController_getOneTag18_route(params@_) =>
      call(params.fromPath[String]("tagId", None)) { (tagId) =>
        controllers_TagController_getOneTag18_invoker.call(
          req => TagController_3.getOneTag(tagId, req))
      }
  
    // @LINE:41
    case controllers_TagController_createTag19_route(params@_) =>
      call { 
        controllers_TagController_createTag19_invoker.call(
          req => TagController_3.createTag(req))
      }
  
    // @LINE:42
    case controllers_TagController_deleteTag20_route(params@_) =>
      call(params.fromPath[String]("tagId", None)) { (tagId) =>
        controllers_TagController_deleteTag20_invoker.call(TagController_3.deleteTag(tagId))
      }
  
    // @LINE:45
    case controllers_TagController_getRecipeTags21_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_TagController_getRecipeTags21_invoker.call(
          req => TagController_3.getRecipeTags(recipeId, req))
      }
  
    // @LINE:48
    case controllers_UtensilController_getAllUtensils22_route(params@_) =>
      call { 
        controllers_UtensilController_getAllUtensils22_invoker.call(
          req => UtensilController_0.getAllUtensils(req))
      }
  
    // @LINE:51
    case controllers_UtensilController_addUtensil23_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("utensilId", None)) { (recipeId, utensilId) =>
        controllers_UtensilController_addUtensil23_invoker.call(UtensilController_0.addUtensil(recipeId, utensilId))
      }
  
    // @LINE:52
    case controllers_UtensilController_quitUtensil24_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("utensilId", None)) { (recipeId, utensilId) =>
        controllers_UtensilController_quitUtensil24_invoker.call(UtensilController_0.quitUtensil(recipeId, utensilId))
      }
  
    // @LINE:55
    case controllers_UtensilController_getOneUtensil25_route(params@_) =>
      call(params.fromPath[String]("utensilId", None)) { (utensilId) =>
        controllers_UtensilController_getOneUtensil25_invoker.call(
          req => UtensilController_0.getOneUtensil(utensilId, req))
      }
  
    // @LINE:56
    case controllers_UtensilController_createUtensil26_route(params@_) =>
      call { 
        controllers_UtensilController_createUtensil26_invoker.call(
          req => UtensilController_0.createUtensil(req))
      }
  
    // @LINE:57
    case controllers_UtensilController_deleteUtensil27_route(params@_) =>
      call(params.fromPath[String]("utensilId", None)) { (utensilId) =>
        controllers_UtensilController_deleteUtensil27_invoker.call(UtensilController_0.deleteUtensil(utensilId))
      }
  
    // @LINE:60
    case controllers_UtensilController_getRecipeUtensils28_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_UtensilController_getRecipeUtensils28_invoker.call(
          req => UtensilController_0.getRecipeUtensils(recipeId, req))
      }
  
    // @LINE:63
    case controllers_StepController_addStep29_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_StepController_addStep29_invoker.call(
          req => StepController_4.addStep(recipeId, req))
      }
  
    // @LINE:64
    case controllers_StepController_updateStep30_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("order", None)) { (recipeId, order) =>
        controllers_StepController_updateStep30_invoker.call(
          req => StepController_4.updateStep(recipeId, order, req))
      }
  
    // @LINE:65
    case controllers_StepController_deleteStep31_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("order", None)) { (recipeId, order) =>
        controllers_StepController_deleteStep31_invoker.call(StepController_4.deleteStep(recipeId, order))
      }
  
    // @LINE:68
    case controllers_StepController_getAllSteps32_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_StepController_getAllSteps32_invoker.call(
          req => StepController_4.getAllSteps(recipeId, req))
      }
  
    // @LINE:69
    case controllers_StepController_updateAllSteps33_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_StepController_updateAllSteps33_invoker.call(
          req => StepController_4.updateAllSteps(recipeId, req))
      }
  }
}

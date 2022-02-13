
import com.fasterxml.jackson.databind.JsonNode;
import controllers.TagController;
import models.*;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.junit.Assert.*;
import static play.test.Helpers.contentAsString;

public class FunctionalTest extends WithApplication {

    // Test MODELO
    @Test
    public void testRecipeModel() {
        Recipe r = Recipe.findRecipeById(5L);
        assertNotNull(r);
        assertEquals("Patatas fritas", r.getTitle());
    }

    // Test VISTA
    @Test
    public void testViewRecipe(){

        Recipe recipe = new Recipe();
        recipe.setTitle("Pasta carbonara");

        RecipeDescription description = new RecipeDescription();
        description.setDescription("La pasta carbonara de toda la vida (sin huevo)");
        recipe.setDescription(description);

        recipe.setPreparationTime(15);
        recipe.setLevel("facil");

        Step step1 = new Step();
        step1.setDescription("Cocer la pasta");
        step1.setStepNumber(1L);
        recipe.addStep(step1);

        Step step2 = new Step();
        step2.setDescription("Añadir la salsa carbonara");
        step2.setStepNumber(2L);
        recipe.addStep(step2);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Pasta");
        recipe.addIngredient(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Salsa Carbonara");
        recipe.addIngredient(ingredient2);

        IngredientQuantity quantity1 = new IngredientQuantity();
        quantity1.setQuantity(500L);
        quantity1.setType("gr");
        quantity1.setParentIngredient(ingredient1);
        recipe.addQuantity(quantity1);

        IngredientQuantity quantity2 = new IngredientQuantity();
        quantity2.setQuantity(200L);
        quantity2.setType("ml");
        quantity2.setParentIngredient(ingredient2);
        recipe.addQuantity(quantity2);

        Utensil utensil1 = new Utensil();
        utensil1.setName("Olla");
        recipe.addUtensil(utensil1);

        Utensil utensil2 = new Utensil();
        utensil2.setName("Colador");
        recipe.addUtensil(utensil2);

        Tag tag = new Tag("Italiano");
        recipe.addTag(tag);

        Content content = views.xml._recipe.render(recipe);
        assertEquals("application/xml", content.contentType());
        assertTrue(content.body().contains("<title>"));
        assertTrue(content.body().contains("<description>"));
        assertTrue(content.body().contains("<level>"));
        assertTrue(content.body().contains("<preparation_time>"));
        assertTrue(content.body().contains("<step>"));
        assertTrue(content.body().contains("<ingredient>"));
        assertTrue(content.body().contains("<quantity>"));
        assertTrue(content.body().contains("<utensil>"));
        assertTrue(content.body().contains("<tag>"));

    }

    // Test CONTROLADOR
    @Test
    public void testController(){

        Http.Request request = Helpers.fakeRequest()
                .method("GET")
                .uri("/tags")
                .header("Accept", "application/json")
                .build();

        TagController tagController = new TagController();
        Result r = tagController.getAllTags(request);
        assertEquals("application/json", r.contentType().get());
        JsonNode n = Json.parse(contentAsString(r));
        assertNotNull(n);
    }
}

import models.Ingredient;
import models.Recipe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UnitTest {

    Recipe recipe;

    @Before
    public void createRecipeIngredients() {

        recipe = new Recipe();

        List<String> ingredients = Arrays.asList(new String[]{"Pasta", "Arroz"});
        for(int i = 0; i < ingredients.size(); i++){
            Ingredient ingredient1 = new Ingredient();
            ingredient1.setName("Pasta");
            recipe.addIngredient(ingredient1);
        }
    }

    @Test
    public void checkRecipeIngredients() {

        List<String> ingredients = Arrays.asList(new String[]{"Pasta", "Arroz"});

        for(int i = 0; i < ingredients.size(); i++){
            assertNotNull(ingredients.get(i));
            assertNotNull(recipe.getIngredients().get(i).getName());
            assertTrue(ingredients.contains(recipe.getIngredients().get(i).getName()));
        }
    }

    @After
    public void cleanRecipeIngredients() {

        for(int i = 0; i < recipe.getIngredients().size(); i++){
            recipe.quitIngredient(recipe.getIngredients().get(i));
        }

    }
}

package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class IngredientQuantity extends Model {

    private static final Finder<Long,IngredientQuantity> finder = new Finder<>(IngredientQuantity.class);

    @Id
    private Long id;

    @Constraints.Required
    private Long quantity;

    @Constraints.Required
    private String type;

    @ManyToOne
    @JsonManagedReference
    private Ingredient parentIngredient;

    @ManyToMany(mappedBy = "quantities")
    @JsonBackReference
    private List<Recipe> recipes = new ArrayList<>();

    @WhenCreated
    private Timestamp whenCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() { return quantity; }

    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Ingredient getParentIngredient() { return parentIngredient; }

    public void setParentIngredient(Ingredient parentIngredient) { this.parentIngredient = parentIngredient; }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public List<Recipe> getRecipes() { return recipes; }

    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }

    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void quitRecipe(Recipe recipe){
        this.recipes.remove(recipe);
    }

    public static IngredientQuantity findIngredientQuantityById(Long id){
        return finder.byId(id);
    }

    // Este método devuelve los ingredientes y sus cantidades asociados a una receta concreta
    public static List<IngredientQuantity> findIngredientsByRecipeId(Long recipeId){

        // Ref: https://stackoverflow.com/questions/30346891/play-framework-2-x-ebean-query-manytomany-for-all

        String sql = "SELECT *\n" +
                "FROM INGREDIENT_QUANTITY i\n" +
                "JOIN RECIPE_INGREDIENT_QUANTITY r ON i.ID = r.INGREDIENT_QUANTITY_ID\n" +
                "WHERE r.RECIPE_ID = ( :recipe_id )\n";

        return finder
                .nativeSql(sql)
                .setParameter("recipe_id", recipeId)
                .orderBy("id")
                .setMaxRows(300)
                .findList();
    }

    public static List<IngredientQuantity> findIngredientsQuantity(){
        return finder
                .query()
                .where()
                .setMaxRows(800)
                .findList();
    }
}

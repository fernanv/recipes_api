package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.*;
import io.ebean.annotation.WhenCreated;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends Model{

    private static final Finder<Long,Ingredient> finder = new Finder<>(Ingredient.class);

    @Id
    private Long id;

    @Constraints.Required(message = "ingredient_required")
    @Column(unique = true)
    @NotBlank(message = "ingredient_blank")
    @Constraints.MinLength(value = 5, message = "ingredient_min")
    @Constraints.MaxLength(value = 50, message = "ingredient_max")
    private String name;

    // Relación N-M (múltiples recetas, múltiples ingredientes)
    @ManyToMany(mappedBy = "ingredients")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static Ingredient findIngredientById(Long id){
        return finder.byId(id);
    }

    public static Ingredient findIngredientByName(String name){
        return finder
                .query()
                .where()
                .eq("name", name)
                .findOne();
    }

    public static List<Ingredient> findIngredients(){
        return finder
                .query()
                .where()
                .setMaxRows(300)
                .findList();
    }

}

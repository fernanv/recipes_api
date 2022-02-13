package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Model;
import io.ebean.Finder;
import io.ebean.annotation.WhenCreated;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utensil extends Model{

    private static final Finder<Long,Utensil> finder = new Finder<>(Utensil.class);

    @Id
    private Long id;

    @Constraints.Required
    @Column(unique = true)
    @NotBlank
    @Constraints.MinLength(3)
    @Constraints.MaxLength(20)
    private String name;

    @ManyToMany(mappedBy = "utensils")
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

    public List<Recipe> getRecipes() { return recipes; }

    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }

    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void quitRecipe(Recipe recipe){
        this.recipes.remove(recipe);
    }

    public Timestamp getWhenCreated() { return whenCreated; }

    public void setWhenCreated(Timestamp whenCreated) { this.whenCreated = whenCreated; }

    public static Utensil findUtensilById(Long id){
        return finder.byId(id);
    }

    public static Utensil findUtensilByName(String name){
        return finder
                .query()
                .where()
                .eq("name", name)
                .findOne();
    }

    // Este método devuelve los utensilios asociados a una receta concreta
    public static List<Utensil> findUtensilsByRecipeId(Long recipeId){

        String sql = "SELECT *\n" +
                "FROM UTENSIL i\n" +
                "JOIN RECIPE_UTENSIL r ON i.ID = r.UTENSIL_ID\n" +
                "WHERE r.RECIPE_ID = ( :recipe_id )\n";

        return finder
                .nativeSql(sql)
                .setParameter("recipe_id", recipeId)
                .orderBy("id")
                .setMaxRows(200)
                .findList();
    }

    public static List<Utensil> findUtensils(){
        return finder
                .query()
                .where()
                .orderBy("id")
                .setMaxRows(200)
                .findList();
    }

}

package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends Model {

    private static final Finder<Long,Tag> finder = new Finder<>(Tag.class);

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank
    @Column(unique = true)
    @Constraints.MinLength(4)
    @Constraints.MaxLength(15)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private List<Recipe> recipes = new ArrayList<>();

    @WhenCreated
    private Timestamp whenCreated;

    public Tag(String name){
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Recipe> getRecipes() { return recipes; }

    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }

    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void quitRecipe(Recipe recipe){ this.recipes.remove(recipe); }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public static Tag findTagById(Long id){
        return finder.byId(id);
    }

    public static Tag findTagByName(String name){
        return finder
                .query()
                .where()
                .eq("name", name)
                .findOne();
    }

    public static List<Tag> findTags(){
        return finder
                .query()
                .where()
                .setMaxRows(200)
                .orderBy("id")
                .findList();
    }

    // Este método devuelve las etiquetas asociadas a una receta concreta
    public static List<Tag> findTagsByRecipeId(Long recipeId){

        String sql = "SELECT *\n" +
                "FROM TAG t\n" +
                "JOIN RECIPE_TAG r ON t.ID = r.TAG_ID\n" +
                "WHERE r.RECIPE_ID = ( :recipe_id )\n";

        return finder
                .nativeSql(sql)
                .setParameter("recipe_id", recipeId)
                .setMaxRows(200)
                .orderBy("id")
                .findList();
    }

}

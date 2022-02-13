package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Model;
import io.ebean.Finder;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import play.data.validation.Constraints;
import validators.RecipeLevelValid;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

@Entity
public class Recipe extends Model{

    private static final Finder<Long,Recipe> finder = new Finder<>(Recipe.class);

    @Id
    private Long id;

    @Constraints.Required(message = "title_required")
    @NotBlank(message = "recipe_blank")
    @Constraints.MinLength(value = 5, message = "recipe_min")
    @Constraints.MaxLength(value = 50, message = "recipe_max")
    // Ref: https://stackoverflow.com/questions/28906096/play-framework-2-3-how-to-add-unique-constraint-to-sample-application
    @Column(unique = true)
    private String title;

    /*
       Relación 1-1 (Una descripción dada solo puede pertener a una
       receta y una receta solo puede tener una descripción.
    */
    @Constraints.Required(message = "description_required")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private RecipeDescription description;

    @Constraints.Required(message = "time_required")
    @Constraints.Min(value = 5, message = "time_min")
    @Constraints.Max(value = 300, message = "time_max")
    private int preparationTime; // minutos

    @Constraints.Required(message = "level_required")
    @RecipeLevelValid
    private String level;

    // Relación 1-N (1 receta, múltiples pasos)
    @Constraints.Required(message = "steps_required")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentRecipe")
    @JsonManagedReference
    private List<Step> steps = new ArrayList<>();

    // Relación N-M (múltiples ingredientes, múltiples recetas)
    @Constraints.Required(message = "ingredients_required")
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    // Relación N-M (múltiples cantidades, múltiples recetas)
    @Constraints.Required(message = "quantities_required")
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IngredientQuantity> quantities = new ArrayList<>();

    // Relación N-M (múltiples utensilios, múltiples recetas)
    @Constraints.Required(message = "utensils_required")
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Utensil> utensils = new ArrayList<>();

    // Relación N-M (múltiples etiquetas, múltiples recetas)
    @Constraints.Required(message = "tags_required")
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tag> tags = new ArrayList<>();

    @Version
    private Long version;

    @WhenCreated
    private Timestamp whenCreated;

    @WhenModified
    private Timestamp whenModified;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public RecipeDescription getDescription() { return description; }

    public void setDescription(RecipeDescription description) {
        // Al añadir otra entidad es necesario asociarla también en esa otra entidad
        description.setParentRecipe(this);
        this.description = description;
    }

    public int getPreparationTime() { return preparationTime; }

    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }

    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public List<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public void addIngredient(Ingredient ingredient){
        ingredient.addRecipe(this);
        this.ingredients.add(ingredient);
    }

    public void quitIngredient(Ingredient ingredient){
        ingredient.quitRecipe(this);
        this.ingredients.remove(ingredient);
    }

    public List<IngredientQuantity> getQuantities() { return quantities; }

    public void setQuantities(List<IngredientQuantity> quantities) { this.quantities = quantities; }

    public void addQuantity(IngredientQuantity quantity){
        quantity.addRecipe(this);
        this.quantities.add(quantity);
    }

    public void quitQuantity(IngredientQuantity quantity){
        quantity.quitRecipe(this);
        this.quantities.remove(quantity);
    }

    public List<Step> getSteps() { return steps; }

    public void setSteps(List<Step> steps) { this.steps = steps; }

    public void addStep(Step step) {
        step.setParentRecipe(this);
        this.steps.add(step);
    }

    public void deleteStep(Step step) { this.steps.remove(step); }

    public List<Utensil> getUtensils() { return utensils; }

    public void setUtensils(List<Utensil> utensils) { this.utensils = utensils; }

    public void addUtensil(Utensil utensil) {
        utensil.addRecipe(this);
        this.utensils.add(utensil);
    }

    public void quitUtensil(Utensil utensil) {
        utensil.quitRecipe(this);
        this.utensils.remove(utensil);
    }

    public List<Tag> getTags() { return tags; }

    public void setTags(List<Tag> tags) { this.tags = tags; }

    public void addTag(Tag tag) {
        tag.addRecipe(this);
        this.tags.add(tag);
    }

    public void quitTag(Tag tag) {
        tag.quitRecipe(this);
        this.tags.remove(tag);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null){
            return false;
        }

        if(obj instanceof Recipe){
            Recipe objRecipe = (Recipe) obj;

            if(objRecipe.getTitle() == null){
                return false;
            }
            else {
                return objRecipe.getTitle().equals(this.getTitle());
            }
        }
        else{
            return false;
        }
    }

    public Long getVersion() { return version; }

    public void setVersion(Long version) { this.version = version; }

    public Timestamp getWhenCreated() { return whenCreated; }

    public void setWhenCreated(Timestamp whenCreated) { this.whenCreated = whenCreated; }

    public Timestamp getWhenModified() { return whenModified; }

    public void setWhenModified(Timestamp whenModified) { this.whenModified = whenModified; }

    public static Recipe findRecipeById(Long id){ return finder.byId(id); }

    public static Recipe findRecipeByTitle(String title){
        return finder
                .query()
                .where()
                .eq("title", title)
                .findOne();
    }

    public static List<Recipe> findRecipes(){
        return finder
                .query()
                .where()
                .setMaxRows(400)
                .orderBy("level")
                .findList();
    }

    /*
     Devuelve todas las recetas que tienen un tiempo de preparación menor
     o igual que el tiempo pasado como argumento
    */
    public static List<Recipe> findRecipesByTime(Long maxTime){
        return finder
                .query()
                .where()
                .lt("preparationTime", maxTime)
                .setMaxRows(400)
                .orderBy("preparationTime")
                .findList();
    }

    /*
     Devuelve todas las recetas que contienen la
     etiqueta pasada como argumento.
    */
    public static List<Recipe> findRecipesByTags(String tag){

        String sql = "SELECT *\n" +
                "FROM RECIPE r\n" +
                "JOIN RECIPE_TAG rt ON r.ID = rt.RECIPE_ID\n" +
                "JOIN TAG t ON t.ID = rt.TAG_ID\n" +
                "WHERE t.NAME = ( :tag )\n";

        return finder
                .nativeSql(sql)
                .setParameter("tag", tag)
                .setMaxRows(400)
                .orderBy("tag")
                .findList();
    }

    /*
     Devueleve todas la recetas que tienen el
     nivel de difcultad pasado como argumento.
    */
    public static List<Recipe> findRecipesByLevel(String level){
        return finder
                .query()
                .where()
                .lt("level", level)
                .setMaxRows(400)
                .orderBy("id")
                .findList();
    }
}

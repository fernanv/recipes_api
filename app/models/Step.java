package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Model;
import io.ebean.Finder;
import io.ebean.annotation.WhenCreated;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Step extends Model{

    private static final Finder<Long,Step> finder = new Finder<>(Step.class);

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank
    @Column(unique = true)
    @Constraints.MinLength(5)
    @Constraints.MaxLength(60)
    private String description;

    @Constraints.Required
    @NotBlank
    @Constraints.Min(1)
    @Constraints.Max(30)
    private Long stepNumber;

    @ManyToOne
    @JsonBackReference
    private Recipe parentRecipe;

    @WhenCreated
    private Timestamp whenCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStepNumber() { return stepNumber; }

    public void setStepNumber(Long recipeOrder) { this.stepNumber = recipeOrder; }

    public Recipe getParentRecipe() { return parentRecipe; }

    public void setParentRecipe(Recipe parentRecipe) { this.parentRecipe = parentRecipe; }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public static Step findStepById(Long id){
        return finder.byId(id);
    }

    public static Step findStepByDescription(String description){
        return finder
                .query()
                .where()
                .eq("description", description)
                .findOne();
    }

    // Este método devuelve el paso de una receta concreta según su orden dentro de la misma
    public static Step findStepByRecipe(Long recipeId, Long stepNumber){
        return finder
                .query()
                .where()
                .eq("parentRecipe", recipeId)
                .eq("stepNumber", stepNumber)
                .findOne();
    }

    // Este método devuelve todos los pasos de una receta concreta
    public static List<Step> findSteps(Long recipeId){

        return finder
                .query()
                .where()
                .eq("parentRecipe", recipeId)
                .orderBy("stepNumber")
                .setMaxRows(200)
                .findList();
    }

}

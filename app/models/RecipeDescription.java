package models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class RecipeDescription extends Model {

    @Id
    private Long id;

    @Constraints.Required
    @NotBlank(message = "description_blank")
    @Constraints.MinLength(value = 10, message = "description_min")
    @Constraints.MaxLength(value = 120, message = "description_max")
    // Ref: https://stackoverflow.com/questions/28906096/play-framework-2-3-how-to-add-unique-constraint-to-sample-application
    @Column(unique = true)
    private String description;

    @OneToOne(mappedBy = "description")
    @JsonBackReference
    private Recipe parentRecipe;

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

    public Recipe getParentRecipe() { return parentRecipe; }

    public void setParentRecipe(Recipe recipe) { this.parentRecipe = recipe; }

}

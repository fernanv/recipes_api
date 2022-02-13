package validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RecipeLevelValidator.class) public @interface RecipeLevelValid {
    String message() default "Level is not valid because doesn't match with 'facil', 'medio' or 'dificil'"; Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

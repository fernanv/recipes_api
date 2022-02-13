package validators;

import play.data.validation.Constraints;
import play.i18n.MessagesApi;
import play.libs.F;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;

public class RecipeLevelValidator extends Constraints.Validator<String> implements ConstraintValidator<RecipeLevelValid, String> {

    @Override
    public boolean isValid(String recipeLevel){
        return this.isValid(recipeLevel, null);
    }

    @Override
    public F.Tuple<String, Object[]> getErrorMessageKey(){
        return new F.Tuple<>(
            "Level is not valid because doesn't match with 'facil', 'medio' or 'dificil'", new Object[]{}
        );
    }

    @Override
    public boolean isValid(String recipeLevel, ConstraintValidatorContext context){

        String[] levels = {"facil","medio","dificil"};
        Boolean valid = false;

        if(recipeLevel != null){
            for(int i = 0; i < levels.length && !valid; i++) {
                if (levels[i].equals(recipeLevel) || levels[i].equals(recipeLevel.toLowerCase(Locale.ROOT))
                        || levels[i].equals(recipeLevel.toUpperCase(Locale.ROOT))) {
                    valid = true;
                }
            }
        }

        return valid;
    }

}

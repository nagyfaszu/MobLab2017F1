package moblab.bme.sipka.bence.mobillabor2017f1.interactor;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetRecipeEvent {

    private Recipe recipe;
    private Throwable exception;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}

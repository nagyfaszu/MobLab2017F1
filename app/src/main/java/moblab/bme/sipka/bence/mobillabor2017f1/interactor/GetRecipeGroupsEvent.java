package moblab.bme.sipka.bence.mobillabor2017f1.interactor;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class GetRecipeGroupsEvent {
    private List<RecipeGroup> recipeGroups;
    private Throwable exception;

    public List<RecipeGroup> getRecipeGroups() {
        return recipeGroups;
    }

    public void setRecipeGroups(List<RecipeGroup> recipeGroups) {
        this.recipeGroups = recipeGroups;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}

package moblab.bme.sipka.bence.mobillabor2017f1.interactor;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class FavoriteSetEvent {
    private Recipe recipe;
    private boolean favorite;
    private Throwable exception;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}

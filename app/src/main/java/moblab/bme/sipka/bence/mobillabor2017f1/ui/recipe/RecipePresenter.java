package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipePresenter extends Presenter<RecipeScreen> {

    @Inject
    RecipeInteractor recipeInteractor;

    public void showRecipe(Recipe recipe){
        screen.showRecipe(recipe);
    }
    public void setFavorite(boolean favorite){
        screen.setFavorite(favorite);
    }

    @Override
    public void attachScreen(RecipeScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
    }
}

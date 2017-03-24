package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipePresenter extends Presenter<RecipeScreen> {

    public void showRecipe(Recipe recipe){
        screen.showRecipe(recipe);
    }
}

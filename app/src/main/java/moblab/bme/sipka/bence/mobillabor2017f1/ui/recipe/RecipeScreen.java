package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface RecipeScreen {
    public void showRecipe(Recipe recipe);

    public void showFavorite(boolean favorite);

    public void showMessage(String message);
}

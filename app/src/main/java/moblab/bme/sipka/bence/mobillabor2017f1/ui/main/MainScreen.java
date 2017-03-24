package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface MainScreen {
    public void showRecipeGroups(List<RecipeGroup> groups);

    public void showRecipe(RecipeHeader recipe);
}
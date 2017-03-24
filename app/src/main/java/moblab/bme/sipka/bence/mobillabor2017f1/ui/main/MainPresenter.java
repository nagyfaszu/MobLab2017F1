package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    public void showRecipeGroups(List<RecipeGroup> groups){
        screen.showRecipeGroups(groups);
    }

    public void showRecipe(RecipeHeader recipe){
        screen.showRecipe(recipe);
    }
}
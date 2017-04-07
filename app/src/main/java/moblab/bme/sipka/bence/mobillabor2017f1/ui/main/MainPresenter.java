package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import java.util.List;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipeScreen;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    MainInteractor mainInteractor;

    public void showRecipeGroups(List<RecipeGroup> groups){
        screen.showRecipeGroups(groups);
    }

    public void showRecipe(RecipeHeader recipe){
        screen.showRecipe(recipe);
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
    }
}
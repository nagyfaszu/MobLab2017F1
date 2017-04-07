package moblab.bme.sipka.bence.mobillabor2017f1.interactor.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class RecipeInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public RecipeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public List<Recipe> getRecipes(RecipeGroup group){
        List<Recipe> result=new ArrayList<>();
        //TODO query recipe ids from server
        //TODO look up repository for cached recipes
        //TODO query the rest from server
        return result;
    }

    public void setFavorite(Recipe recipe){
        //TODO notify server about changing favorite
        recipe.setFavorite(true);
        repository.saveRecipe(recipe);
    }
    public void unsetFavorite(Recipe recipe){
        //TODO notify server about changing favorite
        recipe.setFavorite(true);
        repository.saveRecipe(recipe);
    }
}

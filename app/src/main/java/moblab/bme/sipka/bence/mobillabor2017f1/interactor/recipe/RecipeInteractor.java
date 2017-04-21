package moblab.bme.sipka.bence.mobillabor2017f1.interactor.recipe;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.FavoriteSetEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.GetRecipeEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.network.recipe.RecipeApi;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class RecipeInteractor {

    @Inject
    Repository repository;

    @Inject
    RecipeApi networkApi;

    @Inject
    EventBus bus;

    public RecipeInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getRecipe(String id) {
        GetRecipeEvent event = new GetRecipeEvent();
        try {
            Recipe recipe = repository.getRecipe(id);
            if (recipe == null) {
                recipe = networkApi.recipesIdGet(id).execute().body();
                repository.saveRecipe(recipe);
            }
            event.setRecipe(recipe);
            bus.post(event);
        } catch (Exception e) {
            event.setException(e);
            bus.post(event);
        }
    }

    public void setFavorite(Recipe recipe) {
        FavoriteSetEvent event = new FavoriteSetEvent();
        try {
            event.setRecipe(recipe);
            event.setFavorite(true);

            //TODO notify server about changing favorite
            recipe.setFavorite(true);
            repository.saveRecipe(recipe);
        } catch (Exception e) {
            event.setException(e);
            bus.post(event);
        }

    }

    public void unsetFavorite(Recipe recipe) {
        FavoriteSetEvent event = new FavoriteSetEvent();
        try {
            event.setRecipe(recipe);
            event.setFavorite(false);

            //TODO notify server about changing favorite
            recipe.setFavorite(false);
            repository.saveRecipe(recipe);
        } catch (Exception e) {
            event.setException(e);
            bus.post(event);
        }
    }


}

package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.FavoriteSetEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.GetRecipeEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.recipe.RecipeInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipePresenter extends Presenter<RecipeScreen> {

    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public void showRecipe(Recipe recipe) {
        screen.showRecipe(recipe);
    }

    public void setFavorite(final Recipe recipe, final boolean favorite) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (favorite) {
                    recipeInteractor.setFavorite(recipe);
                } else {
                    recipeInteractor.unsetFavorite(recipe);
                }
            }
        });
    }

    @Override
    public void attachScreen(RecipeScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    @Override
    public void showMessage(String message) {
        screen.showMessage(message);
    }

    public void getRecipe(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipeInteractor.getRecipe(id);
            }
        });
    }

    public void onEventMainThread(GetRecipeEvent event) {
        if (event.getException() != null) {
            event.getException().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getException().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showRecipe(event.getRecipe());
            }
        }
    }

    public void onEventMainThread(FavoriteSetEvent event) {
        if (event.getException() != null) {
            event.getException().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getException().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showFavorite(event.isFavorite());
            }
        }
    }

}

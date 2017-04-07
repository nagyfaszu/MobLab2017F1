package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.GetRecipeGroupsEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.main.MainInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    MainInteractor mainInteractor;

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    public void showRecipeGroups(List<RecipeGroup> groups) {
        screen.showRecipeGroups(groups);
    }

    public void showRecipe(RecipeHeader recipe) {
        screen.showRecipe(recipe);
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    public void getRecipeGroups() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.getRecipeGroups();
            }
        });
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

    public void onEventMainThread(GetRecipeGroupsEvent event) {
        if (event.getException() != null) {
            event.getException().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getException().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showRecipeGroups(event.getRecipeGroups());
            }
        }
    }
}
package moblab.bme.sipka.bence.mobillabor2017f1.ui;

import android.content.Context;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.about.AboutPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipePresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    public RecipePresenter provideRecipePresenter() {
        return new RecipePresenter();
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter() {
        return new AboutPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
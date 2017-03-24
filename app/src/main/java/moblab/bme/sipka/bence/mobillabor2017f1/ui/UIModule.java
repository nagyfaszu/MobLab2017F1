package moblab.bme.sipka.bence.mobillabor2017f1.ui;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    public RecipePresenter provideRecipePresenter(){
        return new RecipePresenter();
    }

}
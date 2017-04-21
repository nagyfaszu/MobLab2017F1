package moblab.bme.sipka.bence.mobillabor2017f1;

import javax.inject.Singleton;

import dagger.Component;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.InteractorModule;
import moblab.bme.sipka.bence.mobillabor2017f1.network.NetworkModule;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.RepositoryModule;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.about.AboutActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.main.MainInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipeActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.recipe.RecipeInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipePresenter;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity activity);

    void inject(RecipeActivity activity);

    void inject(AboutActivity activity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainInteractor interactor);

    void inject(RecipeInteractor interactor);

    void inject(MainPresenter presenter);

    void inject(RecipePresenter presenter);
}
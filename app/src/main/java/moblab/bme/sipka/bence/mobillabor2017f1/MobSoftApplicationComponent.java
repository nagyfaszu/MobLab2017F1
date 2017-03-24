package moblab.bme.sipka.bence.mobillabor2017f1;

import javax.inject.Singleton;

import dagger.Component;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.about.AboutActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipeActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity activity);

    void inject(RecipeActivity activity);

    void inject(AboutActivity activity);
}
package moblab.bme.sipka.bence.mobillabor2017f1;

import javax.inject.Singleton;

import dagger.Component;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
package moblab.bme.sipka.bence.mobillabor2017f1;

import android.app.Application;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder().
                uIModule(new UIModule(this)).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
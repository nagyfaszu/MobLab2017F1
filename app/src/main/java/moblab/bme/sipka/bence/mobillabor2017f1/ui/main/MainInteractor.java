package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class MainInteractor {

    @Inject
    Repository repository;

    public MainInteractor() {
        MobSoftApplication.injector.inject(this);
    }
}

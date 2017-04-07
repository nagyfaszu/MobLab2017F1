package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class RecipeInteractor {

    @Inject
    Repository repository;

    public RecipeInteractor() {
        MobSoftApplication.injector.inject(this);
    }
}

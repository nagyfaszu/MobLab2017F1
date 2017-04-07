package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
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

    public List<RecipeGroup> getRecipeGroups(){
        List<RecipeGroup> result = new ArrayList<>();
        //TODO query group ids from server
        //TODO look up values in repository
        //TODO query non cached groups
        return result;
    }
}

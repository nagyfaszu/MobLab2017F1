package moblab.bme.sipka.bence.mobillabor2017f1.interactor.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.GetRecipeGroupsEvent;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

public class MainInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public MainInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getRecipeGroups() {
        GetRecipeGroupsEvent event = new GetRecipeGroupsEvent();
        try {
            List<RecipeGroup> result = new ArrayList<>();
            //TODO query group ids from server
            //TODO look up values in repository
            //TODO query non cached groups
            event.setRecipeGroups(result);
            bus.post(event);
        } catch (Exception e) {
            event.setException(e);
            bus.post(event);
        }
    }
}

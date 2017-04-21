package moblab.bme.sipka.bence.mobillabor2017f1;

import javax.inject.Singleton;

import dagger.Component;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.InteractorModule;
import moblab.bme.sipka.bence.mobillabor2017f1.mock.MockNetworkModule;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
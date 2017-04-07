package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}
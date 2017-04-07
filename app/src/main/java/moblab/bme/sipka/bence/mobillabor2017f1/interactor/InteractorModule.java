package moblab.bme.sipka.bence.mobillabor2017f1.interactor;

import dagger.Module;
import dagger.Provides;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.main.MainInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.interactor.recipe.RecipeInteractor;

@Module
public class InteractorModule {


	@Provides
	public RecipeInteractor provideRecipes() {
		return new RecipeInteractor();
	}


	@Provides
	public MainInteractor provideMain() {
		return new MainInteractor();
	}
}
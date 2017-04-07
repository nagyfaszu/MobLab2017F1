package moblab.bme.sipka.bence.mobillabor2017f1;

import dagger.Module;
import dagger.Provides;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainInteractor;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipesInteractor;

@Module
public class InteractorModule {


	@Provides
	public RecipesInteractor provideRecipes() {
		return new RecipesInteractor();
	}


	@Provides
	public MainInteractor provideMain() {
		return new MainInteractor();
	}
}
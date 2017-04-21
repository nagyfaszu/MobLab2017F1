package moblab.bme.sipka.bence.mobillabor2017f1;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.about.AboutPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipePresenter;

@Module
public class TestModule {

	private final UIModule UIModule;

	public TestModule(Context context) {
		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}


	@Provides
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}

	@Provides
	public AboutPresenter provideAboutPresenter() {
		return UIModule.provideAboutPresenter();
	}
	@Provides
	public RecipePresenter provideRecipePresenter() {
		return UIModule.provideRecipePresenter();
	}


	@Provides
	@Singleton
	public EventBus provideEventBus() {
		return EventBus.getDefault();
	}

	@Provides
	@Singleton
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}


}
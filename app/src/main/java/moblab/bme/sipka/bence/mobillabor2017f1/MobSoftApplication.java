package moblab.bme.sipka.bence.mobillabor2017f1;

import android.app.Application;

import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;

public class MobSoftApplication extends Application {

	public static MobSoftApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector = DaggerMobSoftApplicationComponent.builder().
						uIModule(new UIModule(this)).build();
	}
}
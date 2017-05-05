package moblab.bme.sipka.bence.mobillabor2017f1;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.repository.Repository;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.UIModule;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    private Tracker mTracker;

    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerMobSoftApplicationComponent.builder().
                uIModule(new UIModule(this)).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
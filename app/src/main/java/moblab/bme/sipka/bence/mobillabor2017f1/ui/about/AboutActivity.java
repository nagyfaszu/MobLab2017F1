package moblab.bme.sipka.bence.mobillabor2017f1.ui.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.R;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;

public class AboutActivity extends AppCompatActivity implements AboutScreen {

    @Inject
    AboutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }
}

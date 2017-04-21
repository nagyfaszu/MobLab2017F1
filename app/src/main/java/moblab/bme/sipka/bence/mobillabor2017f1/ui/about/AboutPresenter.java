package moblab.bme.sipka.bence.mobillabor2017f1.ui.about;

import android.util.Log;

import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;

public class AboutPresenter extends Presenter<AboutScreen> {

    @Override
    public void showMessage(String message) {
        Log.i("AboutPresenter", message);
    }
}
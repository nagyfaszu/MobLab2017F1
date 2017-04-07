package moblab.bme.sipka.bence.mobillabor2017f1.ui.about;

import android.util.Log;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.Presenter;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainScreen;

public class AboutPresenter extends Presenter<AboutScreen> {

    @Override
    public void showMessage(String message) {
        Log.i("AboutPresenter", message);
    }
}
package moblab.bme.sipka.bence.mobillabor2017f1.ui;

/**
 * Created by mobsoft on 2017. 03. 24..
 */


public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }

    public abstract void showMessage(String message);
}

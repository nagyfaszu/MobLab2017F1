package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.R;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.main.MainPresenter;

public class RecipeActivity extends AppCompatActivity implements RecipeScreen {

    public static final String EXTRA_RECIPE_ID = "recipe_id";

    @Inject
    RecipePresenter presenter;

    private int recipeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeId = getIntent().getIntExtra(EXTRA_RECIPE_ID, -1);

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

    @Override
    public void showRecipe(Recipe recipe) {
        //TODO
    }
}

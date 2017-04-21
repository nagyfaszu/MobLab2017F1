package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.R;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;

public class RecipeActivity extends AppCompatActivity implements RecipeScreen {

    public static final String EXTRA_RECIPE_ID = "recipe_id";

    @Inject
    RecipePresenter presenter;

    private String recipeId;
    private Recipe recipe;

    TextView name;
    ImageView image;
    LinearLayout ingredients;
    TextView directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);


        name = (TextView) findViewById(R.id.recipe_name_text);
        image = (ImageView) findViewById(R.id.recipe_image);
        ingredients = (LinearLayout) findViewById(R.id.recipe_ingredients_linear);
        directions = (TextView) findViewById(R.id.recipe_directions_text);

        recipeId = getIntent().getStringExtra(EXTRA_RECIPE_ID);

        presenter.getRecipe(recipeId);

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
        this.recipe = recipe;
        name.setText(recipe.getTitle());
        directions.setText(recipe.getDirections());
        showFavorite(recipe.getFavorite());
    }

    @Override
    public void showFavorite(boolean favorite) {
        //TODO
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

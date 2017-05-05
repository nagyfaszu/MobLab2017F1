package moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

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

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean fav = recipe.getFavorite();
                boolean favorite = !(fav==null?false:fav);
                presenter.setFavorite(recipe, favorite);
                showFavorite(favorite);
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        presenter.getRecipe(recipeId);
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
        Boolean fav = recipe.getFavorite();
        showFavorite(fav==null?false:fav);

        List<String> ingredients = recipe.getIngredients();
        while(this.ingredients.getChildCount()>1){
            this.ingredients.removeViewAt(this.ingredients.getChildCount()-1);
        }
        for(int i = 0; i < ingredients.size(); ++i) {
            TextView text = new TextView(this);
            text.setText(ingredients.get(i));
            this.ingredients.addView(text);
        }

        if(recipe.getTileImage()!=null) {
            Glide.with(this).load(recipe.getTileImage()).into(image);
        }
    }

    @Override
    public void showFavorite(boolean favorite) {

        if(favorite){
            name.setTypeface(null, Typeface.BOLD_ITALIC);
        }else{
            name.setTypeface(null, Typeface.NORMAL);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import android.content.Context;

import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;

public interface Repository {

    void open(Context context);

    void close();

    void saveRecipe(Recipe recipe);

    Recipe getRecipe(Long id);

    RecipeGroup getRecipeGroup(Long id);

    void saveRecipeGroup(RecipeGroup group);

}
package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        SugarRecord.saveInTx(recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return SugarRecord.findById(Recipe.class, id);
    }

    @Override
    public RecipeGroup getRecipeGroup(Long id) {
        return SugarRecord.findById(RecipeGroup.class, id);
    }

    @Override
    public void saveRecipeGroup(RecipeGroup group) {
        SugarRecord.save(group);
    }

}
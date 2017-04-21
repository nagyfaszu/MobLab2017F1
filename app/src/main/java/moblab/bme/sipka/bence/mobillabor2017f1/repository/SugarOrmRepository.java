package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

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
    public Recipe getRecipe(String id) {
        return SugarRecord.findById(Recipe.class, new String[]{id}).get(0);
    }

    @Override
    public RecipeGroup getRecipeGroup(String id) {
        return SugarRecord.findById(RecipeGroup.class, new String[]{id}).get(0);
    }

    @Override
    public List<RecipeGroup> getRecipeGroups() {
        return SugarRecord.listAll(RecipeGroup.class);
    }

    @Override
    public void saveRecipeGroup(RecipeGroup group) {
        SugarRecord.save(group);
    }

}
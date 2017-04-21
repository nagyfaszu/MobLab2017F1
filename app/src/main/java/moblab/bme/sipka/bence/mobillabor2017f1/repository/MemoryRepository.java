package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public List<Recipe> recipes;
    public List<RecipeGroup> recipeGroups;

    @Override
    public void open(Context context) {
        //TODO create mock data

        RecipeHeader r11h=new RecipeHeader();
        r11h.setId("11");
        RecipeHeader r12h=new RecipeHeader();
        r11h.setId("12");
        RecipeHeader  r21h=new RecipeHeader();
        r11h.setId("21");

        Recipe r11=new Recipe();
        r11.setId(r11h.getId());
        Recipe r12=new Recipe();
        r12.setId(r12h.getId());
        Recipe r21=new Recipe();
        r21.setId(r21h.getId());

        RecipeGroup g1=new RecipeGroup();
        g1.setId("1");
        g1.getRecipes().add(r11h);
        g1.getRecipes().add(r12h);

        RecipeGroup g2=new RecipeGroup();
        g2.setId("2");
        g2.getRecipes().add(r21h);

        recipeGroups=new ArrayList<>();
        recipes=new ArrayList<>();

        recipeGroups.add(g1);
        recipeGroups.add(g2);

        recipes.add(r11);
        recipes.add(r12);
        recipes.add(r21);
    }

    @Override
    public void close() {

    }

    @Override
    public void saveRecipe(Recipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getId().equals(recipe.getId())) {
                recipes.set(i, recipe);
                return;
            }
        }
        recipes.add(recipe);
    }

    @Override
    public Recipe getRecipe(String id) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public RecipeGroup getRecipeGroup(String id) {
        for (int i = 0; i < recipeGroups.size(); i++) {
            RecipeGroup r = recipeGroups.get(i);
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<RecipeGroup> getRecipeGroups() {
        return recipeGroups;
    }

    @Override
    public void saveRecipeGroup(RecipeGroup group) {
        for (int i = 0; i < recipeGroups.size(); i++) {
            RecipeGroup r = recipeGroups.get(i);
            if (r.getId().equals(group.getId())) {
                recipeGroups.set(i, group);
                return;
            }
        }
        recipeGroups.add(group);
    }


}

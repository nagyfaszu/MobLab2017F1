package moblab.bme.sipka.bence.mobillabor2017f1.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	public List<Recipe> recipes;
	public List<RecipeGroup> recipeGroups;

	@Override
	public void open(Context context) {

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
	public Recipe getRecipe(Long id) {
		for (int i = 0; i < recipes.size(); i++) {
			Recipe r = recipes.get(i);
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}

	@Override
	public RecipeGroup getRecipeGroup(Long id) {
		for (int i = 0; i < recipeGroups.size(); i++) {
			RecipeGroup r = recipeGroups.get(i);
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
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

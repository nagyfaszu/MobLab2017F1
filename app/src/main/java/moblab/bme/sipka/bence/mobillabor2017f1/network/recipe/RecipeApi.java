package moblab.bme.sipka.bence.mobillabor2017f1.network.recipe;



import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeResult;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecipeApi {
  
  /**
   * Favorite recipe
   * Favorites a recipe with Id
   * @param id recipe id
   * @return Call<RecipeResult>
   */
  
  @POST("Favorite/{id}")
  Call<RecipeResult> favoriteIdPost(
          @Path("id") String id
  );

  
  /**
   * Get recipe groups
   * List of recipe groups
   * @return Call<List<RecipeGroup>>
   */
  
  @GET("Recipes/Groups")
  Call<List<RecipeGroup>> recipesGroupsGet();
    

  
  /**
   * Get recipe
   * Recipe
   * @param id recipe id
   * @return Call<Recipe>
   */
  
  @GET("Recipes/{id}")
  Call<Recipe> recipesIdGet(
          @Path("id") String id
  );

  
  /**
   * Unfavorite recipe
   * Unfavorites a recipe with Id
   * @param id recipe id
   * @return Call<RecipeResult>
   */
  
  @POST("Unfavorite/{id}")
  Call<RecipeResult> unfavoriteIdPost(
          @Path("id") String id
  );

  
}

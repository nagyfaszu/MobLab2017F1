package moblab.bme.sipka.bence.mobillabor2017f1.mock.interceptors;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

import android.net.Uri;

import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeResult;
import moblab.bme.sipka.bence.mobillabor2017f1.network.NetworkConfig;
import moblab.bme.sipka.bence.mobillabor2017f1.repository.MemoryRepository;
import moblab.bme.sipka.bence.mobillabor2017f1.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static moblab.bme.sipka.bence.mobillabor2017f1.mock.interceptors.MockHelper.makeResponse;

public class RecipeMock {
    public static Response process(Request request) {
        //TODO
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Recipes/Groups") && request.method().equals("GET")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRecipeGroups());
            responseCode = 200;
        }else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "Recipes/") && request.method().equals("GET")) {
            String id = uri.getPath().substring(NetworkConfig.ENDPOINT_PREFIX.length() + 8);
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRecipe(id));
            responseCode = 200;
        }else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "Favorite/") && request.method().equals("POST"))   {
            String id = uri.getPath().substring(NetworkConfig.ENDPOINT_PREFIX.length() + 9);
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            Recipe r =memoryRepository.getRecipe(id);
            r.setFavorite(true);
            memoryRepository.saveRecipe(r);
            RecipeResult res = new RecipeResult();
            res.setId(id);
            responseString = GsonHelper.getGson().toJson(res);
            responseCode = 200;
        }else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "Unfavorite/") && request.method().equals("POST"))   {
            String id = uri.getPath().substring(NetworkConfig.ENDPOINT_PREFIX.length() + 11);
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            Recipe r = memoryRepository.getRecipe(id);
            r.setFavorite(false);
            memoryRepository.saveRecipe(r);
            RecipeResult res = new RecipeResult();
            res.setId(id);
            responseString = GsonHelper.getGson().toJson(res);
            responseCode = 200;
        }
        else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }

}

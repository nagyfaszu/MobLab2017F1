package moblab.bme.sipka.bence.mobillabor2017f1.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.IllegalFormatException;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class Recipe extends RecipeHeader {
    public Collection<String> extraImages;
    public Collection<String> ingredients;
    public String directions;
    public String video;


    public Recipe(JSONObject json) throws JSONException{
        super(json);
        JSONArray extraimages = json.getJSONArray("ExtraImages");
        JSONArray ingredients = json.getJSONArray("Ingredients");
        for (int i = 0; i < extraimages.length();++i){
            this.extraImages.add(extraimages.getString(i));
        }
        for (int i = 0; i < ingredients.length();++i){
            this.ingredients.add(ingredients.getString(i));
        }
        this.directions = json.getString("Directions");
        this.video = json.getString("Video");
    }
}

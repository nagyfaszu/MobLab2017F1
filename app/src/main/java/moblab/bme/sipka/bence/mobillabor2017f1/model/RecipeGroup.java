package moblab.bme.sipka.bence.mobillabor2017f1.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipeGroup {
    public String id;
    public String title;
    public List<RecipeHeader> recipeHeaders;

    public RecipeGroup(JSONObject json) throws JSONException{
        id = json.getString("Id");
        title = json.getString("Title");
        JSONArray headers = json.getJSONArray("RecipeHeaders");
        for (int i = 0; i < headers.length(); ++i){
            this.recipeHeaders.add(new RecipeHeader(headers.getJSONObject(i)));
        }
    }
}

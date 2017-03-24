package moblab.bme.sipka.bence.mobillabor2017f1.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipeHeader {
    public int id;
    public String title;
    public String backgroundImage;
    public String tileImage;

    public RecipeHeader(JSONObject json) throws JSONException {
        id = json.getInt("Id");
        title = json.getString("Title");
        backgroundImage = json.getString("BackgroundImage");
        tileImage = json.getString("TileImage");
    }
}

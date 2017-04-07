package moblab.bme.sipka.bence.mobillabor2017f1.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class RecipeHeader {
    public Long id;
    public String title;
    public String backgroundImage;
    public String tileImage;

    public RecipeHeader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getTileImage() {
        return tileImage;
    }

    public void setTileImage(String tileImage) {
        this.tileImage = tileImage;
    }
}

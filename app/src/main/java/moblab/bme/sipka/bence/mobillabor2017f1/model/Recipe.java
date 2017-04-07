package moblab.bme.sipka.bence.mobillabor2017f1.model;

import com.orm.dsl.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.IllegalFormatException;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

@Table
public class Recipe extends RecipeHeader {
    public Long id;
    public String title;
    public String backgroundImage;
    public String tileImage;
    public Collection<String> extraImages;
    public Collection<String> ingredients;
    public String directions;
    public boolean favorite;

    public Recipe() {
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

    public Collection<String> getExtraImages() {
        return extraImages;
    }

    public void setExtraImages(Collection<String> extraImages) {
        this.extraImages = extraImages;
    }

    public Collection<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}

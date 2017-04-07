package moblab.bme.sipka.bence.mobillabor2017f1.model;

import com.orm.dsl.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

@Table
public class RecipeGroup {
    public Long id;
    public String title;
    public List<RecipeHeader> recipeHeaders;

    public RecipeGroup() {
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

    public List<RecipeHeader> getRecipeHeaders() {
        return recipeHeaders;
    }

    public void setRecipeHeaders(List<RecipeHeader> recipeHeaders) {
        this.recipeHeaders = recipeHeaders;
    }
}

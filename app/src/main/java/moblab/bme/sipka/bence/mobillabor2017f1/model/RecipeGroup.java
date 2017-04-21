package moblab.bme.sipka.bence.mobillabor2017f1.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;


@ApiModel(description = "")
@Table
public class RecipeGroup   {
  
  @SerializedName("Id")
  private String id = null;
  
  @SerializedName("Title")
  private String title = null;
  
  @SerializedName("Recipes")
  private List<RecipeHeader> recipes = new ArrayList<RecipeHeader>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<RecipeHeader> getRecipes() {
    return recipes;
  }
  public void setRecipes(List<RecipeHeader> recipes) {
    this.recipes = recipes;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeGroup recipeGroup = (RecipeGroup) o;
    return Objects.equals(id, recipeGroup.id) &&
        Objects.equals(title, recipeGroup.title) &&
        Objects.equals(recipes, recipeGroup.recipes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, recipes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeGroup {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    recipes: ").append(toIndentedString(recipes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

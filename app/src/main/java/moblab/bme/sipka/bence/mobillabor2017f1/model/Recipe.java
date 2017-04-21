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
public class Recipe   {

  @SerializedName("Id")
  private String id = null;
  
  @SerializedName("Title")
  private String title = null;
  
  @SerializedName("BackgroundImage")
  private String backgroundImage = null;
  
  @SerializedName("TileImage")
  private String tileImage = null;
  
  @SerializedName("Ingredients")
  private List<String> ingredients = new ArrayList<String>();
  
  @SerializedName("Directions")
  private String directions = null;
  
  @SerializedName("ExtraImages")
  private List<String> extraImages = new ArrayList<String>();
  
  @SerializedName("Favorite")
  private Boolean favorite = null;
  

  
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
  public String getBackgroundImage() {
    return backgroundImage;
  }
  public void setBackgroundImage(String backgroundImage) {
    this.backgroundImage = backgroundImage;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTileImage() {
    return tileImage;
  }
  public void setTileImage(String tileImage) {
    this.tileImage = tileImage;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<String> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getDirections() {
    return directions;
  }
  public void setDirections(String directions) {
    this.directions = directions;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<String> getExtraImages() {
    return extraImages;
  }
  public void setExtraImages(List<String> extraImages) {
    this.extraImages = extraImages;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getFavorite() {
    return favorite;
  }
  public void setFavorite(Boolean favorite) {
    this.favorite = favorite;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(id, recipe.id) &&
        Objects.equals(title, recipe.title) &&
        Objects.equals(backgroundImage, recipe.backgroundImage) &&
        Objects.equals(tileImage, recipe.tileImage) &&
        Objects.equals(ingredients, recipe.ingredients) &&
        Objects.equals(directions, recipe.directions) &&
        Objects.equals(extraImages, recipe.extraImages) &&
        Objects.equals(favorite, recipe.favorite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, backgroundImage, tileImage, ingredients, directions, extraImages, favorite);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    backgroundImage: ").append(toIndentedString(backgroundImage)).append("\n");
    sb.append("    tileImage: ").append(toIndentedString(tileImage)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    directions: ").append(toIndentedString(directions)).append("\n");
    sb.append("    extraImages: ").append(toIndentedString(extraImages)).append("\n");
    sb.append("    favorite: ").append(toIndentedString(favorite)).append("\n");
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

package moblab.bme.sipka.bence.mobillabor2017f1.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class RecipeHeader   {
  
  @SerializedName("Id")
  private String id = null;
  
  @SerializedName("Title")
  private String title = null;
  
  @SerializedName("BackgroundImage")
  private String backgroundImage = null;
  
  @SerializedName("TileImage")
  private String tileImage = null;
  

  
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

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeHeader recipeHeader = (RecipeHeader) o;
    return Objects.equals(id, recipeHeader.id) &&
        Objects.equals(title, recipeHeader.title) &&
        Objects.equals(backgroundImage, recipeHeader.backgroundImage) &&
        Objects.equals(tileImage, recipeHeader.tileImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, backgroundImage, tileImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeHeader {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    backgroundImage: ").append(toIndentedString(backgroundImage)).append("\n");
    sb.append("    tileImage: ").append(toIndentedString(tileImage)).append("\n");
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

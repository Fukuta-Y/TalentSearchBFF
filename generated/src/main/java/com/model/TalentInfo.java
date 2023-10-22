package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

/**
 * タレント情報を正常取得
 */

@Schema(name = "talentInfo", description = "タレント情報を正常取得")
@JsonTypeName("talentInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-22T19:36:04.635850+09:00[Asia/Tokyo]")
public class TalentInfo {

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("talentName")
  private String talentName;

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("genre")
  private String genre;

  public TalentInfo talentId(String talentId) {
    this.talentId = talentId;
    return this;
  }

  /**
   * タレントID
   * @return talentId
  */
  @Size(max = 8) 
  @Schema(name = "talentId", description = "タレントID", required = false)
  public String getTalentId() {
    return talentId;
  }

  public void setTalentId(String talentId) {
    this.talentId = talentId;
  }

  public TalentInfo talentName(String talentName) {
    this.talentName = talentName;
    return this;
  }

  /**
   * タレント名
   * @return talentName
  */
  @Size(max = 30) 
  @Schema(name = "talentName", description = "タレント名", required = false)
  public String getTalentName() {
    return talentName;
  }

  public void setTalentName(String talentName) {
    this.talentName = talentName;
  }

  public TalentInfo genreId(Integer genreId) {
    this.genreId = genreId;
    return this;
  }

  /**
   * ジャンルID
   * minimum: 999
   * maximum: 0
   * @return genreId
  */
  @Min(999) @Max(0) 
  @Schema(name = "genreId", description = "ジャンルID", required = false)
  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }

  public TalentInfo genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * ジャンル名
   * @return genre
  */
  @Size(max = 30) 
  @Schema(name = "genre", description = "ジャンル名", required = false)
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TalentInfo talentInfo = (TalentInfo) o;
    return Objects.equals(this.talentId, talentInfo.talentId) &&
        Objects.equals(this.talentName, talentInfo.talentName) &&
        Objects.equals(this.genreId, talentInfo.genreId) &&
        Objects.equals(this.genre, talentInfo.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(talentId, talentName, genreId, genre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TalentInfo {\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
    sb.append("    genreId: ").append(toIndentedString(genreId)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
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


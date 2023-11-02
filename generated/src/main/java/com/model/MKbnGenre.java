package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 区分ジャンルマスタ情報（全列）
 */

@Schema(name = "mKbnGenre", description = "区分ジャンルマスタ情報（全列）")
@JsonTypeName("mKbnGenre")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-30T23:19:53.687173+09:00[Asia/Tokyo]")
public class MKbnGenre {

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("jyunjyo")
  private Integer jyunjyo;

  @JsonProperty("genre")
  private String genre;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MKbnGenre genreId(Integer genreId) {
    this.genreId = genreId;
    return this;
  }

  /**
   * Get genreId
   * minimum: 999
   * maximum: 0
   * @return genreId
  */
  @NotNull @Min(999) @Max(0) 
  @Schema(name = "genreId", required = true)
  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }

  public MKbnGenre jyunjyo(Integer jyunjyo) {
    this.jyunjyo = jyunjyo;
    return this;
  }

  /**
   * Get jyunjyo
   * minimum: 999
   * maximum: 0
   * @return jyunjyo
  */
  @NotNull @Min(999) @Max(0) 
  @Schema(name = "jyunjyo", required = true)
  public Integer getJyunjyo() {
    return jyunjyo;
  }

  public void setJyunjyo(Integer jyunjyo) {
    this.jyunjyo = jyunjyo;
  }

  public MKbnGenre genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * ジャンル
   * @return genre
  */
  @Size(max = 30) 
  @Schema(name = "genre", description = "ジャンル", required = false)
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public MKbnGenre deleteFlg(Integer deleteFlg) {
    this.deleteFlg = deleteFlg;
    return this;
  }

  /**
   * 論理削除フラグ
   * minimum: 0
   * maximum: 9
   * @return deleteFlg
  */
  @Min(0) @Max(9) 
  @Schema(name = "deleteFlg", description = "論理削除フラグ", required = false)
  public Integer getDeleteFlg() {
    return deleteFlg;
  }

  public void setDeleteFlg(Integer deleteFlg) {
    this.deleteFlg = deleteFlg;
  }

  public MKbnGenre torokuDay(String torokuDay) {
    this.torokuDay = torokuDay;
    return this;
  }

  /**
   * 登録日
   * @return torokuDay
  */
  
  @Schema(name = "torokuDay", description = "登録日", required = false)
  public String getTorokuDay() {
    return torokuDay;
  }

  public void setTorokuDay(String torokuDay) {
    this.torokuDay = torokuDay;
  }

  public MKbnGenre koushinDay(String koushinDay) {
    this.koushinDay = koushinDay;
    return this;
  }

  /**
   * 更新日
   * @return koushinDay
  */
  
  @Schema(name = "koushinDay", description = "更新日", required = false)
  public String getKoushinDay() {
    return koushinDay;
  }

  public void setKoushinDay(String koushinDay) {
    this.koushinDay = koushinDay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MKbnGenre mKbnGenre = (MKbnGenre) o;
    return Objects.equals(this.genreId, mKbnGenre.genreId) &&
        Objects.equals(this.jyunjyo, mKbnGenre.jyunjyo) &&
        Objects.equals(this.genre, mKbnGenre.genre) &&
        Objects.equals(this.deleteFlg, mKbnGenre.deleteFlg) &&
        Objects.equals(this.torokuDay, mKbnGenre.torokuDay) &&
        Objects.equals(this.koushinDay, mKbnGenre.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genreId, jyunjyo, genre, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MKbnGenre {\n");
    sb.append("    genreId: ").append(toIndentedString(genreId)).append("\n");
    sb.append("    jyunjyo: ").append(toIndentedString(jyunjyo)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    deleteFlg: ").append(toIndentedString(deleteFlg)).append("\n");
    sb.append("    torokuDay: ").append(toIndentedString(torokuDay)).append("\n");
    sb.append("    koushinDay: ").append(toIndentedString(koushinDay)).append("\n");
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


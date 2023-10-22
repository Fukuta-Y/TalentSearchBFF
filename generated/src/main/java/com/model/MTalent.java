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
 * タレントマスタ情報（全列）
 */

@Schema(name = "mTalent", description = "タレントマスタ情報（全列）")
@JsonTypeName("mTalent")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-22T19:36:04.635850+09:00[Asia/Tokyo]")
public class MTalent {

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("talentName")
  private String talentName;

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MTalent talentId(String talentId) {
    this.talentId = talentId;
    return this;
  }

  /**
   * タレントID
   * @return talentId
  */
  @NotNull @Size(max = 8) 
  @Schema(name = "talentId", description = "タレントID", required = true)
  public String getTalentId() {
    return talentId;
  }

  public void setTalentId(String talentId) {
    this.talentId = talentId;
  }

  public MTalent talentName(String talentName) {
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

  public MTalent genreId(Integer genreId) {
    this.genreId = genreId;
    return this;
  }

  /**
   * ジャンルID
   * minimum: 0
   * maximum: 99
   * @return genreId
  */
  @Min(0) @Max(99) 
  @Schema(name = "genreId", description = "ジャンルID", required = false)
  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }

  public MTalent deleteFlg(Integer deleteFlg) {
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

  public MTalent torokuDay(String torokuDay) {
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

  public MTalent koushinDay(String koushinDay) {
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
    MTalent mTalent = (MTalent) o;
    return Objects.equals(this.talentId, mTalent.talentId) &&
        Objects.equals(this.talentName, mTalent.talentName) &&
        Objects.equals(this.genreId, mTalent.genreId) &&
        Objects.equals(this.deleteFlg, mTalent.deleteFlg) &&
        Objects.equals(this.torokuDay, mTalent.torokuDay) &&
        Objects.equals(this.koushinDay, mTalent.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(talentId, talentName, genreId, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MTalent {\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
    sb.append("    genreId: ").append(toIndentedString(genreId)).append("\n");
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


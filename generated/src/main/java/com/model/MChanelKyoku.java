package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * チャンネル局マスタ情報（全列）
 */

@Schema(name = "mChanelKyoku", description = "チャンネル局マスタ情報（全列）")
@JsonTypeName("mChanelKyoku")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T23:29:51.001355+09:00[Asia/Tokyo]")
public class MChanelKyoku {

  @JsonProperty("chanelId")
  private Integer chanelId;

  @JsonProperty("chanelKyokuId")
  private Integer chanelKyokuId;

  @JsonProperty("areaId")
  private Integer areaId;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MChanelKyoku chanelId(Integer chanelId) {
    this.chanelId = chanelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 99
   * @return chanelId
  */
  @NotNull @Min(0) @Max(99) 
  @Schema(name = "chanelId", description = "チャンネルID", required = true)
  public Integer getChanelId() {
    return chanelId;
  }

  public void setChanelId(Integer chanelId) {
    this.chanelId = chanelId;
  }

  public MChanelKyoku chanelKyokuId(Integer chanelKyokuId) {
    this.chanelKyokuId = chanelKyokuId;
    return this;
  }

  /**
   * チャンネル局ID
   * minimum: 0
   * maximum: 99
   * @return chanelKyoku
  */
  @NotNull @Min(0) @Max(99) 
  @Schema(name = "chanelKyokuId", description = "チャンネル局ID", required = true)
  public Integer getChanelKyokuId() {
    return chanelKyokuId;
  }

  public void setChanelKyokuId(Integer chanelKyokuId) {
    this.chanelKyokuId = chanelKyokuId;
  }

  public MChanelKyoku areaId(Integer areaId) {
    this.areaId = areaId;
    return this;
  }

  /**
   * エリアID
   * minimum: 0
   * maximum: 9
   * @return areaId
  */
  @NotNull @Min(0) @Max(9) 
  @Schema(name = "areaId", description = "エリアID", required = true)
  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public MChanelKyoku deleteFlg(Integer deleteFlg) {
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

  public MChanelKyoku torokuDay(String torokuDay) {
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

  public MChanelKyoku koushinDay(String koushinDay) {
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
    MChanelKyoku mChanelKyoku = (MChanelKyoku) o;
    return Objects.equals(this.chanelId, mChanelKyoku.chanelId) &&
        Objects.equals(this.chanelKyokuId, mChanelKyoku.chanelKyokuId) &&
        Objects.equals(this.areaId, mChanelKyoku.areaId) &&
        Objects.equals(this.deleteFlg, mChanelKyoku.deleteFlg) &&
        Objects.equals(this.torokuDay, mChanelKyoku.torokuDay) &&
        Objects.equals(this.koushinDay, mChanelKyoku.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chanelId, chanelKyokuId, areaId, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MChanelKyoku {\n");
    sb.append("    chanelId: ").append(toIndentedString(chanelId)).append("\n");
    sb.append("    chanelKyoku: ").append(toIndentedString(chanelKyokuId)).append("\n");
    sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
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


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

@Schema(name = "mChannelKyoku", description = "チャンネル局マスタ情報（全列）")
@JsonTypeName("mChannelKyoku")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:38:17.040026+09:00[Asia/Tokyo]")
public class MChannelKyoku {

  @JsonProperty("channelId")
  private Integer channelId;

  @JsonProperty("channelKyokuId")
  private Integer channelKyokuId;

  @JsonProperty("areaId")
  private Integer areaId;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MChannelKyoku channelId(Integer channelId) {
    this.channelId = channelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 99
   * @return channelId
  */
  @NotNull @Min(0) @Max(99) 
  @Schema(name = "channelId", description = "チャンネルID", required = true)
  public Integer getChannelId() {
    return channelId;
  }

  public void setChannelId(Integer channelId) {
    this.channelId = channelId;
  }

  public MChannelKyoku channelKyokuId(Integer channelKyokuId) {
    this.channelKyokuId = channelKyokuId;
    return this;
  }

  /**
   * チャンネル局ID
   * minimum: 0
   * maximum: 99
   * @return channelKyokuId
  */
  @Min(0) @Max(99) 
  @Schema(name = "channelKyokuId", description = "チャンネル局ID", required = false)
  public Integer getChannelKyokuId() {
    return channelKyokuId;
  }

  public void setChannelKyokuId(Integer channelKyokuId) {
    this.channelKyokuId = channelKyokuId;
  }

  public MChannelKyoku areaId(Integer areaId) {
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

  public MChannelKyoku deleteFlg(Integer deleteFlg) {
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

  public MChannelKyoku torokuDay(String torokuDay) {
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

  public MChannelKyoku koushinDay(String koushinDay) {
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
    MChannelKyoku mChannelKyoku = (MChannelKyoku) o;
    return Objects.equals(this.channelId, mChannelKyoku.channelId) &&
        Objects.equals(this.channelKyokuId, mChannelKyoku.channelKyokuId) &&
        Objects.equals(this.areaId, mChannelKyoku.areaId) &&
        Objects.equals(this.deleteFlg, mChannelKyoku.deleteFlg) &&
        Objects.equals(this.torokuDay, mChannelKyoku.torokuDay) &&
        Objects.equals(this.koushinDay, mChannelKyoku.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelId, channelKyokuId, areaId, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MChannelKyoku {\n");
    sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
    sb.append("    channelKyokuId: ").append(toIndentedString(channelKyokuId)).append("\n");
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


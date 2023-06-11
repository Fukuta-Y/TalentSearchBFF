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
 * 年月週管理マスタ情報（全列）
 */

@Schema(name = "mNentsukiShuKanri", description = "年月週管理マスタ情報（全列）")
@JsonTypeName("mNentsukiShuKanri")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T12:06:20.247335+09:00[Asia/Tokyo]")
public class MNentsukiShuKanri {

  @JsonProperty("nentsuki")
  private Integer nentsuki;

  @JsonProperty("shu")
  private Integer shu;

  @JsonProperty("shuFrom")
  private String shuFrom;

  @JsonProperty("shuTo")
  private String shuTo;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MNentsukiShuKanri nentsuki(Integer nentsuki) {
    this.nentsuki = nentsuki;
    return this;
  }

  /**
   * 年月
   * minimum: 199001
   * maximum: 210012
   * @return nentsuki
  */
  @NotNull @Min(199001) @Max(210012) 
  @Schema(name = "nentsuki", description = "年月", required = true)
  public Integer getNentsuki() {
    return nentsuki;
  }

  public void setNentsuki(Integer nentsuki) {
    this.nentsuki = nentsuki;
  }

  public MNentsukiShuKanri shu(Integer shu) {
    this.shu = shu;
    return this;
  }

  /**
   * 週
   * minimum: 1
   * maximum: 5
   * @return shu
  */
  @NotNull @Min(1) @Max(5) 
  @Schema(name = "shu", description = "週", required = true)
  public Integer getShu() {
    return shu;
  }

  public void setShu(Integer shu) {
    this.shu = shu;
  }

  public MNentsukiShuKanri shuFrom(String shuFrom) {
    this.shuFrom = shuFrom;
    return this;
  }

  /**
   * 週の開始日（日曜日）
   * @return shuFrom
  */
  
  @Schema(name = "shuFrom", description = "週の開始日（日曜日）", required = false)
  public String getShuFrom() {
    return shuFrom;
  }

  public void setShuFrom(String shuFrom) {
    this.shuFrom = shuFrom;
  }

  public MNentsukiShuKanri shuTo(String shuTo) {
    this.shuTo = shuTo;
    return this;
  }

  /**
   * 週の終了日（土曜日）
   * @return shuTo
  */
  
  @Schema(name = "shuTo", description = "週の終了日（土曜日）", required = false)
  public String getShuTo() {
    return shuTo;
  }

  public void setShuTo(String shuTo) {
    this.shuTo = shuTo;
  }

  public MNentsukiShuKanri torokuDay(String torokuDay) {
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

  public MNentsukiShuKanri koushinDay(String koushinDay) {
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
    MNentsukiShuKanri mNentsukiShuKanri = (MNentsukiShuKanri) o;
    return Objects.equals(this.nentsuki, mNentsukiShuKanri.nentsuki) &&
        Objects.equals(this.shu, mNentsukiShuKanri.shu) &&
        Objects.equals(this.shuFrom, mNentsukiShuKanri.shuFrom) &&
        Objects.equals(this.shuTo, mNentsukiShuKanri.shuTo) &&
        Objects.equals(this.torokuDay, mNentsukiShuKanri.torokuDay) &&
        Objects.equals(this.koushinDay, mNentsukiShuKanri.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nentsuki, shu, shuFrom, shuTo, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MNentsukiShuKanri {\n");
    sb.append("    nentsuki: ").append(toIndentedString(nentsuki)).append("\n");
    sb.append("    shu: ").append(toIndentedString(shu)).append("\n");
    sb.append("    shuFrom: ").append(toIndentedString(shuFrom)).append("\n");
    sb.append("    shuTo: ").append(toIndentedString(shuTo)).append("\n");
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


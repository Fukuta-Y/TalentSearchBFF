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
 * １週間においてのタレントごとの情報
 */

@Schema(name = "shukanTalentJohoSearchBFF", description = "１週間においてのタレントごとの情報")
@JsonTypeName("shukanTalentJohoSearchBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T16:02:48.702321+09:00[Asia/Tokyo]")
public class ShukanTalentJohoSearchBFF {

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("talentName")
  private String talentName;

  @JsonProperty("shukanShutsuenProgramHonsu")
  private Integer shukanShutsuenProgramHonsu;

  @JsonProperty("shutsuenProgramChokin")
  private String shutsuenProgramChokin;

  @JsonProperty("onAirDayChokin")
  private String onAirDayChokin;

  @JsonProperty("shuFrom")
  private String shuFrom;

  @JsonProperty("shuTo")
  private String shuTo;

  public ShukanTalentJohoSearchBFF talentId(String talentId) {
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

  public ShukanTalentJohoSearchBFF talentName(String talentName) {
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

  public ShukanTalentJohoSearchBFF shukanShutsuenProgramHonsu(Integer shukanShutsuenProgramHonsu) {
    this.shukanShutsuenProgramHonsu = shukanShutsuenProgramHonsu;
    return this;
  }

  /**
   * 週間出演番組本数
   * minimum: 0
   * maximum: 999
   * @return shukanShutsuenProgramHonsu
  */
  @Min(0) @Max(999) 
  @Schema(name = "shukanShutsuenProgramHonsu", description = "週間出演番組本数", required = false)
  public Integer getShukanShutsuenProgramHonsu() {
    return shukanShutsuenProgramHonsu;
  }

  public void setShukanShutsuenProgramHonsu(Integer shukanShutsuenProgramHonsu) {
    this.shukanShutsuenProgramHonsu = shukanShutsuenProgramHonsu;
  }

  public ShukanTalentJohoSearchBFF shutsuenProgramChokin(String shutsuenProgramChokin) {
    this.shutsuenProgramChokin = shutsuenProgramChokin;
    return this;
  }

  /**
   * 出演番組（直近）
   * @return shutsuenProgramChokin
  */
  @Size(max = 30) 
  @Schema(name = "shutsuenProgramChokin", description = "出演番組（直近）", required = false)
  public String getShutsuenProgramChokin() {
    return shutsuenProgramChokin;
  }

  public void setShutsuenProgramChokin(String shutsuenProgramChokin) {
    this.shutsuenProgramChokin = shutsuenProgramChokin;
  }

  public ShukanTalentJohoSearchBFF onAirDayChokin(String onAirDayChokin) {
    this.onAirDayChokin = onAirDayChokin;
    return this;
  }

  /**
   * オンエア日（直近）
   * @return onAirDayChokin
  */
  
  @Schema(name = "onAirDayChokin", description = "オンエア日（直近）", required = false)
  public String getOnAirDayChokin() {
    return onAirDayChokin;
  }

  public void setOnAirDayChokin(String onAirDayChokin) {
    this.onAirDayChokin = onAirDayChokin;
  }

  public ShukanTalentJohoSearchBFF shuFrom(String shuFrom) {
    this.shuFrom = shuFrom;
    return this;
  }

  /**
   * 対象週(FROM)
   * @return shuFrom
  */
  
  @Schema(name = "shuFrom", description = "対象週(FROM)", required = false)
  public String getShuFrom() {
    return shuFrom;
  }

  public void setShuFrom(String shuFrom) {
    this.shuFrom = shuFrom;
  }

  public ShukanTalentJohoSearchBFF shuTo(String shuTo) {
    this.shuTo = shuTo;
    return this;
  }

  /**
   * 対象週(TO)
   * @return shuTo
  */
  
  @Schema(name = "shuTo", description = "対象週(TO)", required = false)
  public String getShuTo() {
    return shuTo;
  }

  public void setShuTo(String shuTo) {
    this.shuTo = shuTo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShukanTalentJohoSearchBFF shukanTalentJohoSearchBFF = (ShukanTalentJohoSearchBFF) o;
    return Objects.equals(this.talentId, shukanTalentJohoSearchBFF.talentId) &&
        Objects.equals(this.talentName, shukanTalentJohoSearchBFF.talentName) &&
        Objects.equals(this.shukanShutsuenProgramHonsu, shukanTalentJohoSearchBFF.shukanShutsuenProgramHonsu) &&
        Objects.equals(this.shutsuenProgramChokin, shukanTalentJohoSearchBFF.shutsuenProgramChokin) &&
        Objects.equals(this.onAirDayChokin, shukanTalentJohoSearchBFF.onAirDayChokin) &&
        Objects.equals(this.shuFrom, shukanTalentJohoSearchBFF.shuFrom) &&
        Objects.equals(this.shuTo, shukanTalentJohoSearchBFF.shuTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(talentId, talentName, shukanShutsuenProgramHonsu, shutsuenProgramChokin, onAirDayChokin, shuFrom, shuTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShukanTalentJohoSearchBFF {\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
    sb.append("    shukanShutsuenProgramHonsu: ").append(toIndentedString(shukanShutsuenProgramHonsu)).append("\n");
    sb.append("    shutsuenProgramChokin: ").append(toIndentedString(shutsuenProgramChokin)).append("\n");
    sb.append("    onAirDayChokin: ").append(toIndentedString(onAirDayChokin)).append("\n");
    sb.append("    shuFrom: ").append(toIndentedString(shuFrom)).append("\n");
    sb.append("    shuTo: ").append(toIndentedString(shuTo)).append("\n");
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

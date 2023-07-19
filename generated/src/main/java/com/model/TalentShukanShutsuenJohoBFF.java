package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

/**
 * タレントにおいての１週間ごとの情報
 */

@Schema(name = "talentShukanShutsuenJohoBFF", description = "タレントにおいての１週間ごとの情報")
@JsonTypeName("talentShukanShutsuenJohoBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-18T23:25:05.092800+09:00[Asia/Tokyo]")
public class TalentShukanShutsuenJohoBFF {

  @JsonProperty("talentName")
  private String talentName;

  @JsonProperty("shutsuenshaGenre")
  private String shutsuenshaGenre;

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("shutsuenProgram")
  private String shutsuenProgram;

  @JsonProperty("hosokyokuChannel")
  private String hosokyokuChannel;

  @JsonProperty("onAirDay")
  private String onAirDay;

  @JsonProperty("onAirTime")
  private String onAirTime;

  @JsonProperty("programGenre")
  private String programGenre;

  @JsonProperty("shuFrom")
  private String shuFrom;

  @JsonProperty("shuTo")
  private String shuTo;

  public TalentShukanShutsuenJohoBFF talentName(String talentName) {
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

  public TalentShukanShutsuenJohoBFF shutsuenshaGenre(String shutsuenshaGenre) {
    this.shutsuenshaGenre = shutsuenshaGenre;
    return this;
  }

  /**
   * 出演者ジャンル
   * @return shutsuenshaGenre
  */
  @Size(max = 30) 
  @Schema(name = "shutsuenshaGenre", description = "出演者ジャンル", required = false)
  public String getShutsuenshaGenre() {
    return shutsuenshaGenre;
  }

  public void setShutsuenshaGenre(String shutsuenshaGenre) {
    this.shutsuenshaGenre = shutsuenshaGenre;
  }

  public TalentShukanShutsuenJohoBFF programId(String programId) {
    this.programId = programId;
    return this;
  }

  /**
   * 番組ID
   * @return programId
  */
  @Size(max = 8) 
  @Schema(name = "programId", description = "番組ID", required = false)
  public String getProgramId() {
    return programId;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }

  public TalentShukanShutsuenJohoBFF shutsuenProgram(String shutsuenProgram) {
    this.shutsuenProgram = shutsuenProgram;
    return this;
  }

  /**
   * 出演番組
   * @return shutsuenProgram
  */
  @Size(max = 30) 
  @Schema(name = "shutsuenProgram", description = "出演番組", required = false)
  public String getShutsuenProgram() {
    return shutsuenProgram;
  }

  public void setShutsuenProgram(String shutsuenProgram) {
    this.shutsuenProgram = shutsuenProgram;
  }

  public TalentShukanShutsuenJohoBFF hosokyokuChannel(String hosokyokuChannel) {
    this.hosokyokuChannel = hosokyokuChannel;
    return this;
  }

  /**
   * 放送局（チャンネル）
   * @return hosokyokuChannel
  */
  @Size(max = 30) 
  @Schema(name = "hosokyokuChannel", description = "放送局（チャンネル）", required = false)
  public String getHosokyokuChannel() {
    return hosokyokuChannel;
  }

  public void setHosokyokuChannel(String hosokyokuChannel) {
    this.hosokyokuChannel = hosokyokuChannel;
  }

  public TalentShukanShutsuenJohoBFF onAirDay(String onAirDay) {
    this.onAirDay = onAirDay;
    return this;
  }

  /**
   * オンエア日
   * @return onAirDay
  */
  
  @Schema(name = "onAirDay", description = "オンエア日", required = false)
  public String getOnAirDay() {
    return onAirDay;
  }

  public void setOnAirDay(String onAirDay) {
    this.onAirDay = onAirDay;
  }

  public TalentShukanShutsuenJohoBFF onAirTime(String onAirTime) {
    this.onAirTime = onAirTime;
    return this;
  }

  /**
   * 放送時間
   * @return onAirTime
  */
  
  @Schema(name = "onAirTime", description = "放送時間", required = false)
  public String getOnAirTime() {
    return onAirTime;
  }

  public void setOnAirTime(String onAirTime) {
    this.onAirTime = onAirTime;
  }

  public TalentShukanShutsuenJohoBFF programGenre(String programGenre) {
    this.programGenre = programGenre;
    return this;
  }

  /**
   * 番組ジャンル
   * @return programGenre
  */
  @Size(max = 30) 
  @Schema(name = "programGenre", description = "番組ジャンル", required = false)
  public String getProgramGenre() {
    return programGenre;
  }

  public void setProgramGenre(String programGenre) {
    this.programGenre = programGenre;
  }

  public TalentShukanShutsuenJohoBFF shuFrom(String shuFrom) {
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

  public TalentShukanShutsuenJohoBFF shuTo(String shuTo) {
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
    TalentShukanShutsuenJohoBFF talentShukanShutsuenJohoBFF = (TalentShukanShutsuenJohoBFF) o;
    return Objects.equals(this.talentName, talentShukanShutsuenJohoBFF.talentName) &&
        Objects.equals(this.shutsuenshaGenre, talentShukanShutsuenJohoBFF.shutsuenshaGenre) &&
        Objects.equals(this.programId, talentShukanShutsuenJohoBFF.programId) &&
        Objects.equals(this.shutsuenProgram, talentShukanShutsuenJohoBFF.shutsuenProgram) &&
        Objects.equals(this.hosokyokuChannel, talentShukanShutsuenJohoBFF.hosokyokuChannel) &&
        Objects.equals(this.onAirDay, talentShukanShutsuenJohoBFF.onAirDay) &&
        Objects.equals(this.onAirTime, talentShukanShutsuenJohoBFF.onAirTime) &&
        Objects.equals(this.programGenre, talentShukanShutsuenJohoBFF.programGenre) &&
        Objects.equals(this.shuFrom, talentShukanShutsuenJohoBFF.shuFrom) &&
        Objects.equals(this.shuTo, talentShukanShutsuenJohoBFF.shuTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(talentName, shutsuenshaGenre, programId, shutsuenProgram, hosokyokuChannel, onAirDay, onAirTime, programGenre, shuFrom, shuTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TalentShukanShutsuenJohoBFF {\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
    sb.append("    shutsuenshaGenre: ").append(toIndentedString(shutsuenshaGenre)).append("\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    shutsuenProgram: ").append(toIndentedString(shutsuenProgram)).append("\n");
    sb.append("    hosokyokuChannel: ").append(toIndentedString(hosokyokuChannel)).append("\n");
    sb.append("    onAirDay: ").append(toIndentedString(onAirDay)).append("\n");
    sb.append("    onAirTime: ").append(toIndentedString(onAirTime)).append("\n");
    sb.append("    programGenre: ").append(toIndentedString(programGenre)).append("\n");
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


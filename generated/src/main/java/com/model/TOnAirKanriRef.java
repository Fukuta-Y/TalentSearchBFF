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
 * オンエア管理参照DTOの情報
 */

@Schema(name = "tOnAirKanriRef", description = "オンエア管理参照DTOの情報")
@JsonTypeName("tOnAirKanriRef")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-25T15:21:19.142632+09:00[Asia/Tokyo]")
public class TOnAirKanriRef {

  @JsonProperty("id")
  private String id;

  @JsonProperty("onAirDay")
  private String onAirDay;

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("programName")
  private String programName;

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("talentName")
  private String talentName;

  @JsonProperty("nentsuki")
  private Integer nentsuki;

  @JsonProperty("shu")
  private Integer shu;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public TOnAirKanriRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @Size(max = 8) 
  @Schema(name = "id", description = "ID", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TOnAirKanriRef onAirDay(String onAirDay) {
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

  public TOnAirKanriRef programId(String programId) {
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

  public TOnAirKanriRef programName(String programName) {
    this.programName = programName;
    return this;
  }

  /**
   * 番組名
   * @return programName
  */
  @Size(max = 30) 
  @Schema(name = "programName", description = "番組名", required = false)
  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public TOnAirKanriRef talentId(String talentId) {
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

  public TOnAirKanriRef talentName(String talentName) {
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

  public TOnAirKanriRef nentsuki(Integer nentsuki) {
    this.nentsuki = nentsuki;
    return this;
  }

  /**
   * 対象年月
   * minimum: 199001
   * maximum: 210012
   * @return nentsuki
  */
  @Min(199001) @Max(210012) 
  @Schema(name = "nentsuki", description = "対象年月", required = false)
  public Integer getNentsuki() {
    return nentsuki;
  }

  public void setNentsuki(Integer nentsuki) {
    this.nentsuki = nentsuki;
  }

  public TOnAirKanriRef shu(Integer shu) {
    this.shu = shu;
    return this;
  }

  /**
   * 対象週
   * minimum: 1
   * maximum: 5
   * @return shu
  */
  @Min(1) @Max(5) 
  @Schema(name = "shu", description = "対象週", required = false)
  public Integer getShu() {
    return shu;
  }

  public void setShu(Integer shu) {
    this.shu = shu;
  }

  public TOnAirKanriRef deleteFlg(Integer deleteFlg) {
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

  public TOnAirKanriRef torokuDay(String torokuDay) {
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

  public TOnAirKanriRef koushinDay(String koushinDay) {
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
    TOnAirKanriRef tOnAirKanriRef = (TOnAirKanriRef) o;
    return Objects.equals(this.id, tOnAirKanriRef.id) &&
        Objects.equals(this.onAirDay, tOnAirKanriRef.onAirDay) &&
        Objects.equals(this.programId, tOnAirKanriRef.programId) &&
        Objects.equals(this.programName, tOnAirKanriRef.programName) &&
        Objects.equals(this.talentId, tOnAirKanriRef.talentId) &&
        Objects.equals(this.talentName, tOnAirKanriRef.talentName) &&
        Objects.equals(this.nentsuki, tOnAirKanriRef.nentsuki) &&
        Objects.equals(this.shu, tOnAirKanriRef.shu) &&
        Objects.equals(this.deleteFlg, tOnAirKanriRef.deleteFlg) &&
        Objects.equals(this.torokuDay, tOnAirKanriRef.torokuDay) &&
        Objects.equals(this.koushinDay, tOnAirKanriRef.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, onAirDay, programId, programName, talentId, talentName, nentsuki, shu, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TOnAirKanriRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    onAirDay: ").append(toIndentedString(onAirDay)).append("\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
    sb.append("    nentsuki: ").append(toIndentedString(nentsuki)).append("\n");
    sb.append("    shu: ").append(toIndentedString(shu)).append("\n");
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


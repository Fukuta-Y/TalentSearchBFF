package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * オンエア管理テーブル情報（全列）
 */

@Schema(name = "tOnAirKanri", description = "オンエア管理テーブル情報（全列）")
@JsonTypeName("tOnAirKanri")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-12T21:30:49.581521+09:00[Asia/Tokyo]")
public class TOnAirKanri {

  @JsonProperty("id")
  private String id;

  @JsonProperty("onairDay")
  private String onairDay;

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("targetNentsuki")
  private Integer targetNentsuki;

  @JsonProperty("targetShu")
  private Integer targetShu;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public TOnAirKanri id(String id) {
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

  public TOnAirKanri onairDay(String onairDay) {
    this.onairDay = onairDay;
    return this;
  }

  /**
   * オンエア日
   * @return onairDay
  */
  @Valid 
  @Schema(name = "onairDay", description = "オンエア日", required = false)
  public String getonairDay() {
    return onairDay;
  }

  public void setonairDay(String onairDay) {
    this.onairDay = onairDay;
  }

  public TOnAirKanri programId(String programId) {
    this.programId = programId;
    return this;
  }

  /**
   * 番組ID
   * @return programId
  */
  @NotNull @Size(max = 8) 
  @Schema(name = "programId", description = "番組ID", required = true)
  public String getProgramId() {
    return programId;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }

  public TOnAirKanri talentId(String talentId) {
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

  public TOnAirKanri targetNentsuki(Integer targetNentsuki) {
    this.targetNentsuki = targetNentsuki;
    return this;
  }

  /**
   * 対象年月
   * minimum: 1990
   * maximum: 2100
   * @return targetNentsuki
  */
  @Min(1990) @Max(2100) 
  @Schema(name = "targetNentsuki", description = "対象年月", required = false)
  public Integer getTargetNentsuki() {
    return targetNentsuki;
  }

  public void setTargetNentsuki(Integer targetNentsuki) {
    this.targetNentsuki = targetNentsuki;
  }

  public TOnAirKanri targetShu(Integer targetShu) {
    this.targetShu = targetShu;
    return this;
  }

  /**
   * 対象週
   * minimum: 1
   * maximum: 5
   * @return targetShu
  */
  @Min(1) @Max(5) 
  @Schema(name = "targetShu", description = "対象週", required = false)
  public Integer getTargetShu() {
    return targetShu;
  }

  public void setTargetShu(Integer targetShu) {
    this.targetShu = targetShu;
  }

  public TOnAirKanri deleteFlg(Integer deleteFlg) {
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

  public TOnAirKanri torokuDay(String torokuDay) {
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

  public TOnAirKanri koushinDay(String koushinDay) {
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
    TOnAirKanri tOnAirKanri = (TOnAirKanri) o;
    return Objects.equals(this.id, tOnAirKanri.id) &&
        Objects.equals(this.onairDay, tOnAirKanri.onairDay) &&
        Objects.equals(this.programId, tOnAirKanri.programId) &&
        Objects.equals(this.talentId, tOnAirKanri.talentId) &&
        Objects.equals(this.targetNentsuki, tOnAirKanri.targetNentsuki) &&
        Objects.equals(this.targetShu, tOnAirKanri.targetShu) &&
        Objects.equals(this.deleteFlg, tOnAirKanri.deleteFlg) &&
        Objects.equals(this.torokuDay, tOnAirKanri.torokuDay) &&
        Objects.equals(this.koushinDay, tOnAirKanri.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, onairDay, programId, talentId, targetNentsuki, targetShu, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TOnAirKanri {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    onairDay: ").append(toIndentedString(onairDay)).append("\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    targetNentsuki: ").append(toIndentedString(targetNentsuki)).append("\n");
    sb.append("    targetShu: ").append(toIndentedString(targetShu)).append("\n");
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


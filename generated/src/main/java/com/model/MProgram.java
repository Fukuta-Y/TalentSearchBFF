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
 * 番組マスタ情報（全列）
 */

@Schema(name = "mProgram", description = "番組マスタ情報（全列）")
@JsonTypeName("mProgram")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T16:51:08.111744+09:00[Asia/Tokyo]")
public class MProgram {

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("programName")
  private String programName;

  @JsonProperty("chanelId")
  private Integer chanelId;

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public MProgram programId(String programId) {
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

  public MProgram programName(String programName) {
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

  public MProgram chanelId(Integer chanelId) {
    this.chanelId = chanelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 9
   * @return chanelId
  */
  @Min(0) @Max(9) 
  @Schema(name = "chanelId", description = "チャンネルID", required = false)
  public Integer getChanelId() {
    return chanelId;
  }

  public void setChanelId(Integer chanelId) {
    this.chanelId = chanelId;
  }

  public MProgram genreId(Integer genreId) {
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

  public MProgram deleteFlg(Integer deleteFlg) {
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

  public MProgram torokuDay(String torokuDay) {
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

  public MProgram koushinDay(String koushinDay) {
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
    MProgram mProgram = (MProgram) o;
    return Objects.equals(this.programId, mProgram.programId) &&
        Objects.equals(this.programName, mProgram.programName) &&
        Objects.equals(this.chanelId, mProgram.chanelId) &&
        Objects.equals(this.genreId, mProgram.genreId) &&
        Objects.equals(this.deleteFlg, mProgram.deleteFlg) &&
        Objects.equals(this.torokuDay, mProgram.torokuDay) &&
        Objects.equals(this.koushinDay, mProgram.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programId, programName, chanelId, genreId, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MProgram {\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    chanelId: ").append(toIndentedString(chanelId)).append("\n");
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


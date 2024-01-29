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
 * 番組マスタ情報DTOの情報
 */

@Schema(name = "programInfoRef", description = "番組マスタ情報DTOの情報")
@JsonTypeName("programInfoRef")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-29T15:14:26.917324+09:00[Asia/Tokyo]")
public class ProgramInfoRef {

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("programName")
  private String programName;

  @JsonProperty("channelId")
  private Integer channelId;

  @JsonProperty("channelKyokuId")
  private Integer channelKyokuId;

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("deleteFlg")
  private Integer deleteFlg;

  @JsonProperty("torokuDay")
  private String torokuDay;

  @JsonProperty("koushinDay")
  private String koushinDay;

  public ProgramInfoRef programId(String programId) {
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

  public ProgramInfoRef programName(String programName) {
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

  public ProgramInfoRef channelId(Integer channelId) {
    this.channelId = channelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 9
   * @return channelId
  */
  @Min(0) @Max(9) 
  @Schema(name = "channelId", description = "チャンネルID", required = false)
  public Integer getChannelId() {
    return channelId;
  }

  public void setChannelId(Integer channelId) {
    this.channelId = channelId;
  }

  public ProgramInfoRef channelKyokuId(Integer channelKyokuId) {
    this.channelKyokuId = channelKyokuId;
    return this;
  }

  /**
   * チャンネル局ID
   * minimum: 0
   * maximum: 9
   * @return channelKyokuId
  */
  @Min(0) @Max(9) 
  @Schema(name = "channelKyokuId", description = "チャンネル局ID", required = false)
  public Integer getChannelKyokuId() {
    return channelKyokuId;
  }

  public void setChannelKyokuId(Integer channelKyokuId) {
    this.channelKyokuId = channelKyokuId;
  }

  public ProgramInfoRef genreId(Integer genreId) {
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

  public ProgramInfoRef deleteFlg(Integer deleteFlg) {
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

  public ProgramInfoRef torokuDay(String torokuDay) {
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

  public ProgramInfoRef koushinDay(String koushinDay) {
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
    ProgramInfoRef programInfoRef = (ProgramInfoRef) o;
    return Objects.equals(this.programId, programInfoRef.programId) &&
        Objects.equals(this.programName, programInfoRef.programName) &&
        Objects.equals(this.channelId, programInfoRef.channelId) &&
        Objects.equals(this.channelKyokuId, programInfoRef.channelKyokuId) &&
        Objects.equals(this.genreId, programInfoRef.genreId) &&
        Objects.equals(this.deleteFlg, programInfoRef.deleteFlg) &&
        Objects.equals(this.torokuDay, programInfoRef.torokuDay) &&
        Objects.equals(this.koushinDay, programInfoRef.koushinDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programId, programName, channelId, channelKyokuId, genreId, deleteFlg, torokuDay, koushinDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramInfoRef {\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
    sb.append("    channelKyokuId: ").append(toIndentedString(channelKyokuId)).append("\n");
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


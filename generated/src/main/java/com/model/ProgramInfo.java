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
 * 番組情報を正常取得
 */

@Schema(name = "programInfo", description = "番組情報を正常取得")
@JsonTypeName("programInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:38:17.040026+09:00[Asia/Tokyo]")
public class ProgramInfo {

  @JsonProperty("programId")
  private String programId;

  @JsonProperty("programName")
  private String programName;

  @JsonProperty("channelId")
  private Integer channelId;

  @JsonProperty("channelName")
  private String channelName;

  @JsonProperty("genreId")
  private Integer genreId;

  @JsonProperty("genre")
  private String genre;

  public ProgramInfo programId(String programId) {
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

  public ProgramInfo programName(String programName) {
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

  public ProgramInfo channelId(Integer channelId) {
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

  public ProgramInfo channelName(String channelName) {
    this.channelName = channelName;
    return this;
  }

  /**
   * チャンネル名
   * @return channelName
  */
  @Size(max = 30) 
  @Schema(name = "channelName", description = "チャンネル名", required = false)
  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public ProgramInfo genreId(Integer genreId) {
    this.genreId = genreId;
    return this;
  }

  /**
   * ジャンルID
   * minimum: 999
   * maximum: 0
   * @return genreId
  */
  @Min(999) @Max(0) 
  @Schema(name = "genreId", description = "ジャンルID", required = false)
  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }

  public ProgramInfo genre(String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * ジャンル名
   * @return genre
  */
  @Size(max = 30) 
  @Schema(name = "genre", description = "ジャンル名", required = false)
  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramInfo programInfo = (ProgramInfo) o;
    return Objects.equals(this.programId, programInfo.programId) &&
        Objects.equals(this.programName, programInfo.programName) &&
        Objects.equals(this.channelId, programInfo.channelId) &&
        Objects.equals(this.channelName, programInfo.channelName) &&
        Objects.equals(this.genreId, programInfo.genreId) &&
        Objects.equals(this.genre, programInfo.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programId, programName, channelId, channelName, genreId, genre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramInfo {\n");
    sb.append("    programId: ").append(toIndentedString(programId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
    sb.append("    channelName: ").append(toIndentedString(channelName)).append("\n");
    sb.append("    genreId: ").append(toIndentedString(genreId)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
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


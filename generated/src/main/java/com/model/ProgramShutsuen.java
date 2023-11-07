package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

/**
 * 番組においての対象週の出演者を情報
 */

@Schema(name = "programShutsuen", description = "番組においての対象週の出演者を情報")
@JsonTypeName("programShutsuen")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T11:38:00.011657+09:00[Asia/Tokyo]")
public class ProgramShutsuen {

  @JsonProperty("programName")
  private String programName;

  @JsonProperty("programGenre")
  private String programGenre;

  @JsonProperty("talentId")
  private String talentId;

  @JsonProperty("talentName")
  private String talentName;

  public ProgramShutsuen programName(String programName) {
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

  public ProgramShutsuen programGenre(String programGenre) {
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

  public ProgramShutsuen talentId(String talentId) {
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

  public ProgramShutsuen talentName(String talentName) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramShutsuen programShutsuen = (ProgramShutsuen) o;
    return Objects.equals(this.programName, programShutsuen.programName) &&
        Objects.equals(this.programGenre, programShutsuen.programGenre) &&
        Objects.equals(this.talentId, programShutsuen.talentId) &&
        Objects.equals(this.talentName, programShutsuen.talentName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programName, programGenre, talentId, talentName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramShutsuen {\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    programGenre: ").append(toIndentedString(programGenre)).append("\n");
    sb.append("    talentId: ").append(toIndentedString(talentId)).append("\n");
    sb.append("    talentName: ").append(toIndentedString(talentName)).append("\n");
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


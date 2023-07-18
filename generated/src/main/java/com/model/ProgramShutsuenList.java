package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 番組においての対象週の出演者を情報のリスト
 */

@Schema(name = "programShutsuenList", description = "番組においての対象週の出演者を情報のリスト")
@JsonTypeName("programShutsuenList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-18T14:05:39.271554+09:00[Asia/Tokyo]")
public class ProgramShutsuenList {

  @JsonProperty("programShutsuen")
  @Valid
  private List<ProgramShutsuen> programShutsuen = null;

  public ProgramShutsuenList programShutsuen(List<ProgramShutsuen> programShutsuen) {
    this.programShutsuen = programShutsuen;
    return this;
  }

  public ProgramShutsuenList addProgramShutsuenItem(ProgramShutsuen programShutsuenItem) {
    if (this.programShutsuen == null) {
      this.programShutsuen = new ArrayList<>();
    }
    this.programShutsuen.add(programShutsuenItem);
    return this;
  }

  /**
   * 番組においての対象週の出演者を情報
   * @return programShutsuen
  */
  @Valid 
  @Schema(name = "programShutsuen", description = "番組においての対象週の出演者を情報", required = false)
  public List<ProgramShutsuen> getProgramShutsuen() {
    return programShutsuen;
  }

  public void setProgramShutsuen(List<ProgramShutsuen> programShutsuen) {
    this.programShutsuen = programShutsuen;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramShutsuenList programShutsuenList = (ProgramShutsuenList) o;
    return Objects.equals(this.programShutsuen, programShutsuenList.programShutsuen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programShutsuen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramShutsuenList {\n");
    sb.append("    programShutsuen: ").append(toIndentedString(programShutsuen)).append("\n");
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


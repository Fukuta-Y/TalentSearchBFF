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

@Schema(name = "programShutsuenBFF", description = "番組においての対象週の出演者を情報のリスト")
@JsonTypeName("programShutsuenBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T11:38:00.011657+09:00[Asia/Tokyo]")
public class ProgramShutsuenBFF {

  @JsonProperty("programShutsuen")
  @Valid
  private List<ProgramShutsuen> programShutsuen = null;

  public ProgramShutsuenBFF programShutsuen(List<ProgramShutsuen> programShutsuen) {
    this.programShutsuen = programShutsuen;
    return this;
  }

  public ProgramShutsuenBFF addProgramShutsuenItem(ProgramShutsuen programShutsuenItem) {
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
    ProgramShutsuenBFF programShutsuenBFF = (ProgramShutsuenBFF) o;
    return Objects.equals(this.programShutsuen, programShutsuenBFF.programShutsuen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programShutsuen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramShutsuenBFF {\n");
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


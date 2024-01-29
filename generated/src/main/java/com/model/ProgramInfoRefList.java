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
 * 番組マスタ情報DTO
 */

@Schema(name = "programInfoRefList", description = "番組マスタ情報DTO")
@JsonTypeName("programInfoRefList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-29T15:14:26.917324+09:00[Asia/Tokyo]")
public class ProgramInfoRefList {

  @JsonProperty("programInfoRef")
  @Valid
  private List<ProgramInfoRef> programInfoRef = null;

  public ProgramInfoRefList programInfoRef(List<ProgramInfoRef> programInfoRef) {
    this.programInfoRef = programInfoRef;
    return this;
  }

  public ProgramInfoRefList addProgramInfoRefItem(ProgramInfoRef programInfoRefItem) {
    if (this.programInfoRef == null) {
      this.programInfoRef = new ArrayList<>();
    }
    this.programInfoRef.add(programInfoRefItem);
    return this;
  }

  /**
   * 番組マスタDTO
   * @return programInfoRef
  */
  @Valid 
  @Schema(name = "programInfoRef", description = "番組マスタDTO", required = false)
  public List<ProgramInfoRef> getProgramInfoRef() {
    return programInfoRef;
  }

  public void setProgramInfoRef(List<ProgramInfoRef> programInfoRef) {
    this.programInfoRef = programInfoRef;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgramInfoRefList programInfoRefList = (ProgramInfoRefList) o;
    return Objects.equals(this.programInfoRef, programInfoRefList.programInfoRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programInfoRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramInfoRefList {\n");
    sb.append("    programInfoRef: ").append(toIndentedString(programInfoRef)).append("\n");
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


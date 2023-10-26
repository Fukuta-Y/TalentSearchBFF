package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 番組マスタ情報DTO
 */

@Schema(name = "programInfo", description = "番組マスタ情報DTO")
@JsonTypeName("programInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-24T18:03:14.333095+09:00[Asia/Tokyo]")
public class ProgramInfo {

  @JsonProperty("items")
  private MProgram items;

  public ProgramInfo items(MProgram items) {
    this.items = items;
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @Valid 
  @Schema(name = "items", required = false)
  public MProgram getItems() {
    return items;
  }

  public void setItems(MProgram items) {
    this.items = items;
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
    return Objects.equals(this.items, programInfo.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramInfo {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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


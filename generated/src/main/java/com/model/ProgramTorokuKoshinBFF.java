package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 登録または更新した番組マスタ情報
 */

@Schema(name = "programTorokuKoshinBFF", description = "登録または更新した番組マスタ情報")
@JsonTypeName("programTorokuKoshinBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-30T23:19:53.687173+09:00[Asia/Tokyo]")
public class ProgramTorokuKoshinBFF {

  @JsonProperty("items")
  private MProgram items;

  public ProgramTorokuKoshinBFF items(MProgram items) {
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
    ProgramTorokuKoshinBFF programTorokuKoshinBFF = (ProgramTorokuKoshinBFF) o;
    return Objects.equals(this.items, programTorokuKoshinBFF.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgramTorokuKoshinBFF {\n");
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


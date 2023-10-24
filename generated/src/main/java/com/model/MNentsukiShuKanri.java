package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 年月週管理マスタDTO
 */

@Schema(name = "mNentsukiShuKanri", description = "年月週管理マスタDTO")
@JsonTypeName("mNentsukiShuKanri")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-24T18:11:02.177067+09:00[Asia/Tokyo]")
public class MNentsukiShuKanri {

  @JsonProperty("items")
  private MNentsukiShuKanri1 items;

  public MNentsukiShuKanri items(MNentsukiShuKanri1 items) {
    this.items = items;
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @Valid 
  @Schema(name = "items", required = false)
  public MNentsukiShuKanri1 getItems() {
    return items;
  }

  public void setItems(MNentsukiShuKanri1 items) {
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
    MNentsukiShuKanri mNentsukiShuKanri = (MNentsukiShuKanri) o;
    return Objects.equals(this.items, mNentsukiShuKanri.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MNentsukiShuKanri {\n");
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


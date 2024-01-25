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
 * オンエア管理参照DTOの情報
 */

@Schema(name = "onAirKanriRefList", description = "オンエア管理参照DTOの情報")
@JsonTypeName("onAirKanriRefList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-25T15:21:19.142632+09:00[Asia/Tokyo]")
public class OnAirKanriRefList {

  @JsonProperty("tOnAirKanriRef")
  @Valid
  private List<TOnAirKanriRef> tOnAirKanriRef = null;

  public OnAirKanriRefList tOnAirKanriRef(List<TOnAirKanriRef> tOnAirKanriRef) {
    this.tOnAirKanriRef = tOnAirKanriRef;
    return this;
  }

  public OnAirKanriRefList addTOnAirKanriRefItem(TOnAirKanriRef tOnAirKanriRefItem) {
    if (this.tOnAirKanriRef == null) {
      this.tOnAirKanriRef = new ArrayList<>();
    }
    this.tOnAirKanriRef.add(tOnAirKanriRefItem);
    return this;
  }

  /**
   * オンエア管理参照DTO
   * @return tOnAirKanriRef
  */
  @Valid 
  @Schema(name = "tOnAirKanriRef", description = "オンエア管理参照DTO", required = false)
  public List<TOnAirKanriRef> gettOnAirKanriRef() {
    return tOnAirKanriRef;
  }

  public void settOnAirKanriRef(List<TOnAirKanriRef> tOnAirKanriRef) {
    this.tOnAirKanriRef = tOnAirKanriRef;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnAirKanriRefList onAirKanriRefList = (OnAirKanriRefList) o;
    return Objects.equals(this.tOnAirKanriRef, onAirKanriRefList.tOnAirKanriRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tOnAirKanriRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnAirKanriRefList {\n");
    sb.append("    tOnAirKanriRef: ").append(toIndentedString(tOnAirKanriRef)).append("\n");
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


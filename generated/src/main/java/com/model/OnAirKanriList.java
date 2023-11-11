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
 * オンエア管理テーブルDTO
 */

@Schema(name = "onAirKanriList", description = "オンエア管理テーブルDTO")
@JsonTypeName("onAirKanriList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T20:25:49.717295+09:00[Asia/Tokyo]")
public class OnAirKanriList {

  @JsonProperty("tOnAirKanri")
  @Valid
  private List<TOnAirKanri> tOnAirKanri = null;

  public OnAirKanriList tOnAirKanri(List<TOnAirKanri> tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
    return this;
  }

  public OnAirKanriList addTOnAirKanriItem(TOnAirKanri tOnAirKanriItem) {
    if (this.tOnAirKanri == null) {
      this.tOnAirKanri = new ArrayList<>();
    }
    this.tOnAirKanri.add(tOnAirKanriItem);
    return this;
  }

  /**
   * オンエア管理テーブルDTO
   * @return tOnAirKanri
  */
  @Valid 
  @Schema(name = "tOnAirKanri", description = "オンエア管理テーブルDTO", required = false)
  public List<TOnAirKanri> gettOnAirKanri() {
    return tOnAirKanri;
  }

  public void settOnAirKanri(List<TOnAirKanri> tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnAirKanriList onAirKanriList = (OnAirKanriList) o;
    return Objects.equals(this.tOnAirKanri, onAirKanriList.tOnAirKanri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tOnAirKanri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnAirKanriList {\n");
    sb.append("    tOnAirKanri: ").append(toIndentedString(tOnAirKanri)).append("\n");
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


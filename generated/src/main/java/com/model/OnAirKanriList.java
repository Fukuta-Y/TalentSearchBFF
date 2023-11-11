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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T20:10:32.597804+09:00[Asia/Tokyo]")
public class OnAirKanriList {

  @JsonProperty("mProgram")
  @Valid
  private List<TOnAirKanri> mProgram = null;

  public OnAirKanriList mProgram(List<TOnAirKanri> mProgram) {
    this.mProgram = mProgram;
    return this;
  }

  public OnAirKanriList addMProgramItem(TOnAirKanri mProgramItem) {
    if (this.mProgram == null) {
      this.mProgram = new ArrayList<>();
    }
    this.mProgram.add(mProgramItem);
    return this;
  }

  /**
   * オンエア管理テーブルDTO
   * @return mProgram
  */
  @Valid 
  @Schema(name = "mProgram", description = "オンエア管理テーブルDTO", required = false)
  public List<TOnAirKanri> getmProgram() {
    return mProgram;
  }

  public void setmProgram(List<TOnAirKanri> mProgram) {
    this.mProgram = mProgram;
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
    return Objects.equals(this.mProgram, onAirKanriList.mProgram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mProgram);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnAirKanriList {\n");
    sb.append("    mProgram: ").append(toIndentedString(mProgram)).append("\n");
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


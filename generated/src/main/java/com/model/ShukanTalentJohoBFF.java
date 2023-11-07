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
 * １週間においてのタレントごとの情報のリスト
 */

@Schema(name = "shukanTalentJohoBFF", description = "１週間においてのタレントごとの情報のリスト")
@JsonTypeName("shukanTalentJohoBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T12:44:09.196542+09:00[Asia/Tokyo]")
public class ShukanTalentJohoBFF {

  @JsonProperty("shukanTalent")
  @Valid
  private List<ShukanTalent> shukanTalent = null;

  public ShukanTalentJohoBFF shukanTalent(List<ShukanTalent> shukanTalent) {
    this.shukanTalent = shukanTalent;
    return this;
  }

  public ShukanTalentJohoBFF addShukanTalentItem(ShukanTalent shukanTalentItem) {
    if (this.shukanTalent == null) {
      this.shukanTalent = new ArrayList<>();
    }
    this.shukanTalent.add(shukanTalentItem);
    return this;
  }

  /**
   * １週間においてのタレントごとの情報
   * @return shukanTalent
  */
  @Valid 
  @Schema(name = "shukanTalent", description = "１週間においてのタレントごとの情報", required = false)
  public List<ShukanTalent> getShukanTalent() {
    return shukanTalent;
  }

  public void setShukanTalent(List<ShukanTalent> shukanTalent) {
    this.shukanTalent = shukanTalent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShukanTalentJohoBFF shukanTalentJohoBFF = (ShukanTalentJohoBFF) o;
    return Objects.equals(this.shukanTalent, shukanTalentJohoBFF.shukanTalent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shukanTalent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShukanTalentJohoBFF {\n");
    sb.append("    shukanTalent: ").append(toIndentedString(shukanTalent)).append("\n");
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


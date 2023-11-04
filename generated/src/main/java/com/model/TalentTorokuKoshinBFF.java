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
 * 登録または更新したタレントマスタ情報
 */

@Schema(name = "talentTorokuKoshinBFF", description = "登録または更新したタレントマスタ情報")
@JsonTypeName("talentTorokuKoshinBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-04T23:34:19.826482+09:00[Asia/Tokyo]")
public class TalentTorokuKoshinBFF {

  @JsonProperty("mTalent")
  @Valid
  private List<MTalent> mTalent = null;

  public TalentTorokuKoshinBFF mTalent(List<MTalent> mTalent) {
    this.mTalent = mTalent;
    return this;
  }

  public TalentTorokuKoshinBFF addMTalentItem(MTalent mTalentItem) {
    if (this.mTalent == null) {
      this.mTalent = new ArrayList<>();
    }
    this.mTalent.add(mTalentItem);
    return this;
  }

  /**
   * タレントマスタDTO
   * @return mTalent
  */
  @Valid 
  @Schema(name = "mTalent", description = "タレントマスタDTO", required = false)
  public List<MTalent> getmTalent() {
    return mTalent;
  }

  public void setmTalent(List<MTalent> mTalent) {
    this.mTalent = mTalent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TalentTorokuKoshinBFF talentTorokuKoshinBFF = (TalentTorokuKoshinBFF) o;
    return Objects.equals(this.mTalent, talentTorokuKoshinBFF.mTalent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mTalent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TalentTorokuKoshinBFF {\n");
    sb.append("    mTalent: ").append(toIndentedString(mTalent)).append("\n");
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


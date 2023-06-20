package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 年月に対応する週の開始終了日付の情報
 */

@Schema(name = "ShukanTalentJoho", description = "年月に対応する週の開始終了日付の情報")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-13T16:01:11.890061+09:00[Asia/Tokyo]")
public class ShukanTalentJoho {

  @JsonProperty("mTalent")
  @Valid
  private List<MTalent> mTalent = null;

  @JsonProperty("tOnAirKanri")
  @Valid
  private List<TOnAirKanri> tOnAirKanri = null;

  @JsonProperty("mProgram")
  @Valid
  private List<MProgram> mProgram = null;

  public ShukanTalentJoho mTalent(List<MTalent> mTalent) {
    this.mTalent = mTalent;
    return this;
  }

  public ShukanTalentJoho addMTalentItem(MTalent mTalentItem) {
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

  public ShukanTalentJoho tOnAirKanri(List<TOnAirKanri> tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
    return this;
  }

  public ShukanTalentJoho addTOnAirKanriItem(TOnAirKanri tOnAirKanriItem) {
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

  public ShukanTalentJoho mProgram(List<MProgram> mProgram) {
    this.mProgram = mProgram;
    return this;
  }

  public ShukanTalentJoho addMProgramItem(MProgram mProgramItem) {
    if (this.mProgram == null) {
      this.mProgram = new ArrayList<>();
    }
    this.mProgram.add(mProgramItem);
    return this;
  }

  /**
   * 番組マスタDTO
   * @return mProgram
  */
  @Valid 
  @Schema(name = "mProgram", description = "番組マスタDTO", required = false)
  public List<MProgram> getmProgram() {
    return mProgram;
  }

  public void setmProgram(List<MProgram> mProgram) {
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
    ShukanTalentJoho ShukanTalentJoho = (ShukanTalentJoho) o;
    return Objects.equals(this.mTalent, ShukanTalentJoho.mTalent) &&
        Objects.equals(this.tOnAirKanri, ShukanTalentJoho.tOnAirKanri) &&
        Objects.equals(this.mProgram, ShukanTalentJoho.mProgram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mTalent, tOnAirKanri, mProgram);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShukanTalentJoho {\n");
    sb.append("    mTalent: ").append(toIndentedString(mTalent)).append("\n");
    sb.append("    tOnAirKanri: ").append(toIndentedString(tOnAirKanri)).append("\n");
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


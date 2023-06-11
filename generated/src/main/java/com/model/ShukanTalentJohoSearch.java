package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 年月に対応する週の開始終了日付の情報
 */

@Schema(name = "ShukanTalentJohoSearch", description = "年月に対応する週の開始終了日付の情報")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T16:51:08.111744+09:00[Asia/Tokyo]")
public class ShukanTalentJohoSearch {

  @JsonProperty("mNentsukiShuKanri")
  private MTalent mNentsukiShuKanri;

  @JsonProperty("tOnAirKanri")
  private TOnAirKanri tOnAirKanri;

  @JsonProperty("mProgram")
  private MProgram mProgram;

  public ShukanTalentJohoSearch mNentsukiShuKanri(MTalent mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
    return this;
  }

  /**
   * Get mNentsukiShuKanri
   * @return mNentsukiShuKanri
  */
  @Valid 
  @Schema(name = "mNentsukiShuKanri", required = false)
  public MTalent getmNentsukiShuKanri() {
    return mNentsukiShuKanri;
  }

  public void setmNentsukiShuKanri(MTalent mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
  }

  public ShukanTalentJohoSearch tOnAirKanri(TOnAirKanri tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
    return this;
  }

  /**
   * Get tOnAirKanri
   * @return tOnAirKanri
  */
  @Valid 
  @Schema(name = "tOnAirKanri", required = false)
  public TOnAirKanri gettOnAirKanri() {
    return tOnAirKanri;
  }

  public void settOnAirKanri(TOnAirKanri tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
  }

  public ShukanTalentJohoSearch mProgram(MProgram mProgram) {
    this.mProgram = mProgram;
    return this;
  }

  /**
   * Get mProgram
   * @return mProgram
  */
  @Valid 
  @Schema(name = "mProgram", required = false)
  public MProgram getmProgram() {
    return mProgram;
  }

  public void setmProgram(MProgram mProgram) {
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
    ShukanTalentJohoSearch shukanTalentJohoSearch = (ShukanTalentJohoSearch) o;
    return Objects.equals(this.mNentsukiShuKanri, shukanTalentJohoSearch.mNentsukiShuKanri) &&
        Objects.equals(this.tOnAirKanri, shukanTalentJohoSearch.tOnAirKanri) &&
        Objects.equals(this.mProgram, shukanTalentJohoSearch.mProgram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mNentsukiShuKanri, tOnAirKanri, mProgram);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShukanTalentJohoSearch {\n");
    sb.append("    mNentsukiShuKanri: ").append(toIndentedString(mNentsukiShuKanri)).append("\n");
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


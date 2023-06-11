package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * 年月に対応する週の開始終了日付の情報
 */

@Schema(name = "yearMonthWeekStartEndJoho", description = "年月に対応する週の開始終了日付の情報")
@JsonTypeName("yearMonthWeekStartEndJoho")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-11T12:06:20.247335+09:00[Asia/Tokyo]")
public class YearMonthWeekStartEndJoho {

  @JsonProperty("mNentsukiShuKanri")
  private MNentsukiShuKanri mNentsukiShuKanri;

  public YearMonthWeekStartEndJoho mNentsukiShuKanri(MNentsukiShuKanri mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
    return this;
  }

  /**
   * Get mNentsukiShuKanri
   * @return mNentsukiShuKanri
  */
  @Valid 
  @Schema(name = "mNentsukiShuKanri", required = false)
  public MNentsukiShuKanri getmNentsukiShuKanri() {
    return mNentsukiShuKanri;
  }

  public void setmNentsukiShuKanri(MNentsukiShuKanri mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    YearMonthWeekStartEndJoho yearMonthWeekStartEndJoho = (YearMonthWeekStartEndJoho) o;
    return Objects.equals(this.mNentsukiShuKanri, yearMonthWeekStartEndJoho.mNentsukiShuKanri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mNentsukiShuKanri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class YearMonthWeekStartEndJoho {\n");
    sb.append("    mNentsukiShuKanri: ").append(toIndentedString(mNentsukiShuKanri)).append("\n");
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


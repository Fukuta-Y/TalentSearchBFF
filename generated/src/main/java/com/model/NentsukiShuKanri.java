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
 * 登録または更新した年月週管理マスタDTOの情報
 */

@Schema(name = "nentsukiShuKanri", description = "登録または更新した年月週管理マスタDTOの情報")
@JsonTypeName("nentsukiShuKanri")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T20:20:08.575223+09:00[Asia/Tokyo]")
public class NentsukiShuKanri {

  @JsonProperty("mNentsukiShuKanri")
  @Valid
  private List<MNentsukiShuKanri> mNentsukiShuKanri = null;

  public NentsukiShuKanri mNentsukiShuKanri(List<MNentsukiShuKanri> mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
    return this;
  }

  public NentsukiShuKanri addMNentsukiShuKanriItem(MNentsukiShuKanri mNentsukiShuKanriItem) {
    if (this.mNentsukiShuKanri == null) {
      this.mNentsukiShuKanri = new ArrayList<>();
    }
    this.mNentsukiShuKanri.add(mNentsukiShuKanriItem);
    return this;
  }

  /**
   * 年月週管理マスタDTO
   * @return mNentsukiShuKanri
  */
  @Valid 
  @Schema(name = "mNentsukiShuKanri", description = "年月週管理マスタDTO", required = false)
  public List<MNentsukiShuKanri> getmNentsukiShuKanri() {
    return mNentsukiShuKanri;
  }

  public void setmNentsukiShuKanri(List<MNentsukiShuKanri> mNentsukiShuKanri) {
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
    NentsukiShuKanri nentsukiShuKanri = (NentsukiShuKanri) o;
    return Objects.equals(this.mNentsukiShuKanri, nentsukiShuKanri.mNentsukiShuKanri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mNentsukiShuKanri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NentsukiShuKanri {\n");
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


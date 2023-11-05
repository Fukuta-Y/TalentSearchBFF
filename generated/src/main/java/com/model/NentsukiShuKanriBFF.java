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

@Schema(name = "nentsukiShuKanriBFF", description = "登録または更新した年月週管理マスタDTOの情報")
@JsonTypeName("nentsukiShuKanriBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-05T13:58:17.544014+09:00[Asia/Tokyo]")
public class NentsukiShuKanriBFF {

  @JsonProperty("mNentsukiShuKanri")
  @Valid
  private List<MNentsukiShuKanri> mNentsukiShuKanri = null;

  public NentsukiShuKanriBFF mNentsukiShuKanri(List<MNentsukiShuKanri> mNentsukiShuKanri) {
    this.mNentsukiShuKanri = mNentsukiShuKanri;
    return this;
  }

  public NentsukiShuKanriBFF addMNentsukiShuKanriItem(MNentsukiShuKanri mNentsukiShuKanriItem) {
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
    NentsukiShuKanriBFF nentsukiShuKanriBFF = (NentsukiShuKanriBFF) o;
    return Objects.equals(this.mNentsukiShuKanri, nentsukiShuKanriBFF.mNentsukiShuKanri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mNentsukiShuKanri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NentsukiShuKanriBFF {\n");
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


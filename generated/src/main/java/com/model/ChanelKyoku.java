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
 * チャンネル局マスタ
 */

@Schema(name = "chanelKyoku", description = "チャンネル局マスタ")
@JsonTypeName("chanelKyoku")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-02T20:26:56.071860+09:00[Asia/Tokyo]")
public class ChanelKyoku {

  @JsonProperty("mChanelKyoku")
  @Valid
  private List<MChanelKyoku> mChanelKyoku = null;

  public ChanelKyoku mChanelKyoku(List<MChanelKyoku> mChanelKyoku) {
    this.mChanelKyoku = mChanelKyoku;
    return this;
  }

  public ChanelKyoku addMChanelKyokuItem(MChanelKyoku mChanelKyokuItem) {
    if (this.mChanelKyoku == null) {
      this.mChanelKyoku = new ArrayList<>();
    }
    this.mChanelKyoku.add(mChanelKyokuItem);
    return this;
  }

  /**
   * チャンネル局マスタDTO
   * @return mChanelKyoku
  */
  @Valid 
  @Schema(name = "mChanelKyoku", description = "チャンネル局マスタDTO", required = false)
  public List<MChanelKyoku> getmChanelKyoku() {
    return mChanelKyoku;
  }

  public void setmChanelKyoku(List<MChanelKyoku> mChanelKyoku) {
    this.mChanelKyoku = mChanelKyoku;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChanelKyoku chanelKyoku = (ChanelKyoku) o;
    return Objects.equals(this.mChanelKyoku, chanelKyoku.mChanelKyoku);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mChanelKyoku);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChanelKyoku {\n");
    sb.append("    mChanelKyoku: ").append(toIndentedString(mChanelKyoku)).append("\n");
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


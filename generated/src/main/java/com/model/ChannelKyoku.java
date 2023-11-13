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

@Schema(name = "channelKyoku", description = "チャンネル局マスタ")
@JsonTypeName("channelKyoku")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:38:17.040026+09:00[Asia/Tokyo]")
public class ChannelKyoku {

  @JsonProperty("mChannelKyoku")
  @Valid
  private List<MChannelKyoku> mChannelKyoku = null;

  public ChannelKyoku mChannelKyoku(List<MChannelKyoku> mChannelKyoku) {
    this.mChannelKyoku = mChannelKyoku;
    return this;
  }

  public ChannelKyoku addMChannelKyokuItem(MChannelKyoku mChannelKyokuItem) {
    if (this.mChannelKyoku == null) {
      this.mChannelKyoku = new ArrayList<>();
    }
    this.mChannelKyoku.add(mChannelKyokuItem);
    return this;
  }

  /**
   * チャンネル局マスタDTO
   * @return mChannelKyoku
  */
  @Valid 
  @Schema(name = "mChannelKyoku", description = "チャンネル局マスタDTO", required = false)
  public List<MChannelKyoku> getmChannelKyoku() {
    return mChannelKyoku;
  }

  public void setmChannelKyoku(List<MChannelKyoku> mChannelKyoku) {
    this.mChannelKyoku = mChannelKyoku;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelKyoku channelKyoku = (ChannelKyoku) o;
    return Objects.equals(this.mChannelKyoku, channelKyoku.mChannelKyoku);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mChannelKyoku);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelKyoku {\n");
    sb.append("    mChannelKyoku: ").append(toIndentedString(mChannelKyoku)).append("\n");
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


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
 * チャンネル情報
 */

@Schema(name = "chanelInfoList", description = "チャンネル情報")
@JsonTypeName("chanelInfoList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:53:51.944573+09:00[Asia/Tokyo]")
public class ChanelInfoList {

  @JsonProperty("chanelInfo")
  @Valid
  private List<ChanelInfo> chanelInfo = null;

  public ChanelInfoList chanelInfo(List<ChanelInfo> chanelInfo) {
    this.chanelInfo = chanelInfo;
    return this;
  }

  public ChanelInfoList addChanelInfoItem(ChanelInfo chanelInfoItem) {
    if (this.chanelInfo == null) {
      this.chanelInfo = new ArrayList<>();
    }
    this.chanelInfo.add(chanelInfoItem);
    return this;
  }

  /**
   * チャンネル情報リスト
   * @return chanelInfo
  */
  @Valid 
  @Schema(name = "chanelInfo", description = "チャンネル情報リスト", required = false)
  public List<ChanelInfo> getChanelInfo() {
    return chanelInfo;
  }

  public void setChanelInfo(List<ChanelInfo> chanelInfo) {
    this.chanelInfo = chanelInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChanelInfoList chanelInfoList = (ChanelInfoList) o;
    return Objects.equals(this.chanelInfo, chanelInfoList.chanelInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chanelInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChanelInfoList {\n");
    sb.append("    chanelInfo: ").append(toIndentedString(chanelInfo)).append("\n");
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


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

@Schema(name = "channelInfoList", description = "チャンネル情報")
@JsonTypeName("channelInfoList")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:53:51.944573+09:00[Asia/Tokyo]")
public class ChannelInfoList {

  @JsonProperty("channelInfo")
  @Valid
  private List<ChannelInfo> channelInfo = null;

  public ChannelInfoList channelInfo(List<ChannelInfo> channelInfo) {
    this.channelInfo = channelInfo;
    return this;
  }

  public ChannelInfoList addChannelInfoItem(ChannelInfo channelInfoItem) {
    if (this.channelInfo == null) {
      this.channelInfo = new ArrayList<>();
    }
    this.channelInfo.add(channelInfoItem);
    return this;
  }

  /**
   * チャンネル情報リスト
   * @return channelInfo
  */
  @Valid 
  @Schema(name = "channelInfo", description = "チャンネル情報リスト", required = false)
  public List<ChannelInfo> getChannelInfo() {
    return channelInfo;
  }

  public void setChannelInfo(List<ChannelInfo> channelInfo) {
    this.channelInfo = channelInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelInfoList channelInfoList = (ChannelInfoList) o;
    return Objects.equals(this.channelInfo, channelInfoList.channelInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelInfoList {\n");
    sb.append("    channelInfo: ").append(toIndentedString(channelInfo)).append("\n");
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


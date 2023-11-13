package com.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

/**
 * チャンネル情報
 */

@Schema(name = "channelInfo", description = "チャンネル情報")
@JsonTypeName("channelInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:53:51.944573+09:00[Asia/Tokyo]")
public class ChannelInfo {

  @JsonProperty("channelId")
  private Integer channelId;

  @JsonProperty("channelName")
  private String channelName;

  public ChannelInfo channelId(Integer channelId) {
    this.channelId = channelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 9
   * @return channelId
  */
  @Min(0) @Max(9) 
  @Schema(name = "channelId", description = "チャンネルID", required = false)
  public Integer getChannelId() {
    return channelId;
  }

  public void setChannelId(Integer channelId) {
    this.channelId = channelId;
  }

  public ChannelInfo channelName(String channelName) {
    this.channelName = channelName;
    return this;
  }

  /**
   * チャンネル名
   * @return channelName
  */
  @Size(max = 30) 
  @Schema(name = "channelName", description = "チャンネル名", required = false)
  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelInfo channelInfo = (ChannelInfo) o;
    return Objects.equals(this.channelId, channelInfo.channelId) &&
        Objects.equals(this.channelName, channelInfo.channelName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelId, channelName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelInfo {\n");
    sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
    sb.append("    channelName: ").append(toIndentedString(channelName)).append("\n");
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


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

@Schema(name = "chanelInfo", description = "チャンネル情報")
@JsonTypeName("chanelInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:53:51.944573+09:00[Asia/Tokyo]")
public class ChanelInfo {

  @JsonProperty("chanelId")
  private Integer chanelId;

  @JsonProperty("chanelName")
  private String chanelName;

  public ChanelInfo chanelId(Integer chanelId) {
    this.chanelId = chanelId;
    return this;
  }

  /**
   * チャンネルID
   * minimum: 0
   * maximum: 9
   * @return chanelId
  */
  @Min(0) @Max(9) 
  @Schema(name = "chanelId", description = "チャンネルID", required = false)
  public Integer getChanelId() {
    return chanelId;
  }

  public void setChanelId(Integer chanelId) {
    this.chanelId = chanelId;
  }

  public ChanelInfo chanelName(String chanelName) {
    this.chanelName = chanelName;
    return this;
  }

  /**
   * チャンネル名
   * @return chanelName
  */
  @Size(max = 30) 
  @Schema(name = "chanelName", description = "チャンネル名", required = false)
  public String getChanelName() {
    return chanelName;
  }

  public void setChanelName(String chanelName) {
    this.chanelName = chanelName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChanelInfo chanelInfo = (ChanelInfo) o;
    return Objects.equals(this.chanelId, chanelInfo.chanelId) &&
        Objects.equals(this.chanelName, chanelInfo.chanelName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chanelId, chanelName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChanelInfo {\n");
    sb.append("    chanelId: ").append(toIndentedString(chanelId)).append("\n");
    sb.append("    chanelName: ").append(toIndentedString(chanelName)).append("\n");
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


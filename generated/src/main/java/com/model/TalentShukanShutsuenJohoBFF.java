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
 * タレントにおいての１週間ごとの情報のリスト
 */

@Schema(name = "talentShukanShutsuenJohoBFF", description = "タレントにおいての１週間ごとの情報のリスト")
@JsonTypeName("talentShukanShutsuenJohoBFF")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-06T12:16:11.803169+09:00[Asia/Tokyo]")
public class TalentShukanShutsuenJohoBFF {

  @JsonProperty("talentShukanShutsuen")
  @Valid
  private List<TalentShukanShutsuen> talentShukanShutsuen = null;

  public TalentShukanShutsuenJohoBFF talentShukanShutsuen(List<TalentShukanShutsuen> talentShukanShutsuen) {
    this.talentShukanShutsuen = talentShukanShutsuen;
    return this;
  }

  public TalentShukanShutsuenJohoBFF addTalentShukanShutsuenItem(TalentShukanShutsuen talentShukanShutsuenItem) {
    if (this.talentShukanShutsuen == null) {
      this.talentShukanShutsuen = new ArrayList<>();
    }
    this.talentShukanShutsuen.add(talentShukanShutsuenItem);
    return this;
  }

  /**
   * タレントにおいての１週間ごとの情報
   * @return talentShukanShutsuen
  */
  @Valid 
  @Schema(name = "talentShukanShutsuen", description = "タレントにおいての１週間ごとの情報", required = false)
  public List<TalentShukanShutsuen> getTalentShukanShutsuen() {
    return talentShukanShutsuen;
  }

  public void setTalentShukanShutsuen(List<TalentShukanShutsuen> talentShukanShutsuen) {
    this.talentShukanShutsuen = talentShukanShutsuen;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TalentShukanShutsuenJohoBFF talentShukanShutsuenJohoBFF = (TalentShukanShutsuenJohoBFF) o;
    return Objects.equals(this.talentShukanShutsuen, talentShukanShutsuenJohoBFF.talentShukanShutsuen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(talentShukanShutsuen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TalentShukanShutsuenJohoBFF {\n");
    sb.append("    talentShukanShutsuen: ").append(toIndentedString(talentShukanShutsuen)).append("\n");
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


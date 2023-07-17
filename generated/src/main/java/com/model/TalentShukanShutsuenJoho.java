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
 * タレントにおいての１週間ごとの情報
 */

@Schema(name = "talentShukanShutsuenJoho", description = "タレントにおいての１週間ごとの情報")
@JsonTypeName("talentShukanShutsuenJoho")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-14T11:35:39.107245+09:00[Asia/Tokyo]")
public class TalentShukanShutsuenJoho {

  @JsonProperty("tOnAirKanri")
  @Valid
  private List<TOnAirKanri> tOnAirKanri = null;

  @JsonProperty("mTalent")
  @Valid
  private List<MTalent> mTalent = null;

  @JsonProperty("mProgram")
  @Valid
  private List<MProgram> mProgram = null;

  @JsonProperty("mChanelKyoku")
  @Valid
  private List<MChanelKyoku> mChanelKyoku = null;

  @JsonProperty("mKbnGenre")
  @Valid
  private List<MKbnGenre> mKbnGenre = null;

  public TalentShukanShutsuenJoho tOnAirKanri(List<TOnAirKanri> tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
    return this;
  }

  public TalentShukanShutsuenJoho addTOnAirKanriItem(TOnAirKanri tOnAirKanriItem) {
    if (this.tOnAirKanri == null) {
      this.tOnAirKanri = new ArrayList<>();
    }
    this.tOnAirKanri.add(tOnAirKanriItem);
    return this;
  }

  /**
   * オンエア管理テーブルDTO
   * @return tOnAirKanri
  */
  @Valid 
  @Schema(name = "tOnAirKanri", description = "オンエア管理テーブルDTO", required = false)
  public List<TOnAirKanri> gettOnAirKanri() {
    return tOnAirKanri;
  }

  public void settOnAirKanri(List<TOnAirKanri> tOnAirKanri) {
    this.tOnAirKanri = tOnAirKanri;
  }

  public TalentShukanShutsuenJoho mTalent(List<MTalent> mTalent) {
    this.mTalent = mTalent;
    return this;
  }

  public TalentShukanShutsuenJoho addMTalentItem(MTalent mTalentItem) {
    if (this.mTalent == null) {
      this.mTalent = new ArrayList<>();
    }
    this.mTalent.add(mTalentItem);
    return this;
  }

  /**
   * タレントマスタDTO
   * @return mTalent
  */
  @Valid 
  @Schema(name = "mTalent", description = "タレントマスタDTO", required = false)
  public List<MTalent> getmTalent() {
    return mTalent;
  }

  public void setmTalent(List<MTalent> mTalent) {
    this.mTalent = mTalent;
  }

  public TalentShukanShutsuenJoho mProgram(List<MProgram> mProgram) {
    this.mProgram = mProgram;
    return this;
  }

  public TalentShukanShutsuenJoho addMProgramItem(MProgram mProgramItem) {
    if (this.mProgram == null) {
      this.mProgram = new ArrayList<>();
    }
    this.mProgram.add(mProgramItem);
    return this;
  }

  /**
   * 番組マスタDTO
   * @return mProgram
  */
  @Valid 
  @Schema(name = "mProgram", description = "番組マスタDTO", required = false)
  public List<MProgram> getmProgram() {
    return mProgram;
  }

  public void setmProgram(List<MProgram> mProgram) {
    this.mProgram = mProgram;
  }

  public TalentShukanShutsuenJoho mChanelKyoku(List<MChanelKyoku> mChanelKyoku) {
    this.mChanelKyoku = mChanelKyoku;
    return this;
  }

  public TalentShukanShutsuenJoho addMChanelKyokuItem(MChanelKyoku mChanelKyokuItem) {
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

  public TalentShukanShutsuenJoho mKbnGenre(List<MKbnGenre> mKbnGenre) {
    this.mKbnGenre = mKbnGenre;
    return this;
  }

  public TalentShukanShutsuenJoho addMKbnGenreItem(MKbnGenre mKbnGenreItem) {
    if (this.mKbnGenre == null) {
      this.mKbnGenre = new ArrayList<>();
    }
    this.mKbnGenre.add(mKbnGenreItem);
    return this;
  }

  /**
   * 区分ジャンルマスタDTO
   * @return mKbnGenre
  */
  @Valid 
  @Schema(name = "mKbnGenre", description = "区分ジャンルマスタDTO", required = false)
  public List<MKbnGenre> getmKbnGenre() {
    return mKbnGenre;
  }

  public void setmKbnGenre(List<MKbnGenre> mKbnGenre) {
    this.mKbnGenre = mKbnGenre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TalentShukanShutsuenJoho talentShukanShutsuenJoho = (TalentShukanShutsuenJoho) o;
    return Objects.equals(this.tOnAirKanri, talentShukanShutsuenJoho.tOnAirKanri) &&
        Objects.equals(this.mTalent, talentShukanShutsuenJoho.mTalent) &&
        Objects.equals(this.mProgram, talentShukanShutsuenJoho.mProgram) &&
        Objects.equals(this.mChanelKyoku, talentShukanShutsuenJoho.mChanelKyoku) &&
        Objects.equals(this.mKbnGenre, talentShukanShutsuenJoho.mKbnGenre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tOnAirKanri, mTalent, mProgram, mChanelKyoku, mKbnGenre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TalentShukanShutsuenJoho {\n");
    sb.append("    tOnAirKanri: ").append(toIndentedString(tOnAirKanri)).append("\n");
    sb.append("    mTalent: ").append(toIndentedString(mTalent)).append("\n");
    sb.append("    mProgram: ").append(toIndentedString(mProgram)).append("\n");
    sb.append("    mChanelKyoku: ").append(toIndentedString(mChanelKyoku)).append("\n");
    sb.append("    mKbnGenre: ").append(toIndentedString(mKbnGenre)).append("\n");
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


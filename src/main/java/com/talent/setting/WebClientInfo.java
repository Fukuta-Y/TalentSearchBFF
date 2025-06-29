package com.talent.setting;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.ChannelKyoku;
import com.model.KbnMasterInfo;
import com.model.MNentsukiShuKanri;
import com.model.MProgram;
import com.model.MProgramList;
import com.model.MTalent;
import com.model.NentsukiShuKanri;
import com.model.OnAirKanriList;
import com.model.OnAirKanriRefList;
import com.model.ProgramInfoList;
import com.model.ProgramShutsuenList;
import com.model.ProgramTorokuKoshinBFF;
import com.model.ShukanTalentJoho;
import com.model.TOnAirKanri;
import com.model.TalentList;
import com.model.TalentShukanShutsuenJoho;
import com.model.TalentTorokuKoshinBFF;
import com.model.YearMonthWeekStartEndJoho;

import reactor.core.publisher.Mono;

@Service
public class WebClientInfo {

    public WebClient webClient;

    public WebClientInfo(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://talentsearchbe.onrender.com/").build();
    }

    /**
     * BE「週間タレント別情報検索」へ接続の設定
     *
     * @param nentsuki　年月
     * @param shu　週
     * @param talentName　タレント名
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ShukanTalentJoho getShukanTalentJoho(Integer nentsuki, Integer shu, String talentName) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/shukanTalentJoho")
                        .queryParam("nentsuki", nentsuki)
                        .queryParam("shu", shu)
                        .queryParam("talentName", talentName)
                        .build())
                .retrieve()
                .bodyToMono(ShukanTalentJoho.class).block();
    }

    /**
     * BE「タレント週間出演情報検索」へ接続の設定
     *
     * @param nentsuki　年月
     * @param shu　週
     * @param talentId　タレントID
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public TalentShukanShutsuenJoho getTalentShukanShutsuenJoho(Integer nentsuki, Integer shu, String talentId) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/talentShukanShutsuenJoho")
                        .queryParam("nentsuki", nentsuki)
                        .queryParam("shu", shu)
                        .queryParam("talentId", talentId)
                        .build())
                .retrieve()
                .bodyToMono(TalentShukanShutsuenJoho.class).block();
    }

    /**
     * BE「年月週の開始終了日付検索」へ接続の設定
     *
     * @param nentsuki　年月
     * @param shu　週
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public YearMonthWeekStartEndJoho getYearMonthWeekStartEnd(Integer nentsuki, Integer shu) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/yearMonthWeekStartEnd")
                        .queryParam("nentsuki", nentsuki)
                        .queryParam("shu", shu)
                        .build())
                .retrieve()
                .bodyToMono(YearMonthWeekStartEndJoho.class).block();
    }

    /**
     * BE「番組出演者検索」へ接続の設定
     *
     * @param programId　プログラムID
     * @param onAirDay　オンエア日
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ProgramShutsuenList getProgramShutsuen(String programId, String onAirDay) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/programShutsuen")
                        .queryParam("programId", programId)
                        .queryParam("onAirDay", onAirDay)
                        .build())
                .retrieve()
                .bodyToMono(ProgramShutsuenList.class).block();
    }
    
    /**
     * BE「番組マスタ検索」へ接続の設定
     *
     * @param programId　番組ID
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public MProgramList getProgramInfo(String programId) {
       return webClient.get()
               .uri(uriBuilder -> uriBuilder
                       .path("/programInfo/{programId}")
                       .build(programId))
               .retrieve()
               .bodyToMono(MProgramList.class).block();
    }
    
    /**
     * BE「区分マスタ検索」へ接続の設定
     *
     * @param genreIds　ジャンルID 【複数】
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public KbnMasterInfo getKbnMaster(String genreIds) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/kbnMaster/{genreIds}")
                        .build(genreIds))
                .retrieve()
                .bodyToMono(KbnMasterInfo.class).block();
    }
    /**
     * BE「チャンネル局マスタ検索」へ接続の設定
     *
     * @param channelIds　チャンネルID 【複数】
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ChannelKyoku getMChannelKyoku(String channelIds) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/channelKyoku/{channelIds}")
                        .build(channelIds))
                .retrieve()
                .bodyToMono(ChannelKyoku.class).block();
    }
    /**
     * BE「番組登録・更新」へ接続の設定
     *
     * @param mProgram　番組マスタDTO
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ProgramTorokuKoshinBFF postProgramTorokuKoshin(MProgram mProgram) {
        return this.webClient.post()
	    		.uri("/programTorokuKoshin")
	    	    .body(Mono.just(mProgram), MProgram.class)
	    	    .accept(MediaType.APPLICATION_JSON)
	    	    .retrieve()
	    	    .bodyToMono(ProgramTorokuKoshinBFF.class).block();
    }
    /**
     * BE「タレントマスタ検索」へ接続の設定
     *
     * @param talentId　タレントID
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public TalentList getTalentMaster(String talentId) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/talentMaster/{talentId}")
                        .build(talentId))
                .retrieve()
                .bodyToMono(TalentList.class).block();
    }
    /**
     * BE「タレント登録・更新」へ接続の設定
     *
     * @param mTalent タレントマスタDTO
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public TalentTorokuKoshinBFF postTalentTorokuKoshin(MTalent mTalent) {
        return this.webClient.post()
	    		.uri("/talentTorokuKoshin")
	    	    .body(Mono.just(mTalent), MTalent.class)
	    	    .accept(MediaType.APPLICATION_JSON)
	    	    .retrieve()
	    	    .bodyToMono(TalentTorokuKoshinBFF.class).block();
    }
    /**
     * BE「年月週管理登録・更新」へ接続の設定
     *
     * @param mNentsukiShuKanri 年月週管理マスタDTO
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public NentsukiShuKanri postNentsukiShuKanri(MNentsukiShuKanri mNentsukiShuKanri) {
        return this.webClient.post()
	    		.uri("/nentsukiShuKanri")
	    	    .body(Mono.just(mNentsukiShuKanri), MNentsukiShuKanri.class)
	    	    .accept(MediaType.APPLICATION_JSON)
	    	    .retrieve()
	    	    .bodyToMono(NentsukiShuKanri.class).block();
    }
    /**
     * BE「オンエア管理テーブル検索」へ接続の設定
     *
     * @param id ID
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public OnAirKanriList getOnAirKanri(String id) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/onAirKanri/{id}")
                        .build(id))
                .retrieve()
                .bodyToMono(OnAirKanriList.class).block();
    }
    /**
     * BE「年月週管理マスタ検索」へ接続の設定
     *
     * @param 無
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public NentsukiShuKanri getNentsukiShuKanri() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/nentsukiShuKanri")
                        .build())
                .retrieve()
                .bodyToMono(NentsukiShuKanri.class).block();
    }
    /**
     * BE「オンエア管理登録・更新」へ接続の設定
     *
     * @param tOnAirKanri オンエア管理テーブルDTO
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public OnAirKanriList postOnAirKanri(TOnAirKanri tOnAirKanri) {
        return this.webClient.post()
	    		.uri("/onAirKanri")
	    	    .body(Mono.just(tOnAirKanri), TOnAirKanri.class)
	    	    .accept(MediaType.APPLICATION_JSON)
	    	    .retrieve()
	    	    .bodyToMono(OnAirKanriList.class).block();
    }
    /**
     * BE「オンエア管理参照検索」へ接続の設定
     *
	 * @param id　ID
	 * @param onAirDay オンエア日
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public OnAirKanriRefList getOnAirKanriRef(String id, String onAirDay) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
		                .path("/onAirKanriRef")
                        .queryParam("id", id)
                        .queryParam("onAirDay", onAirDay)
                        .build())
                .retrieve()
                .bodyToMono(OnAirKanriRefList.class).block();
    }
    /**
     * BE「年月週管理参照検索」へ接続の設定
     *
	 * @param nentsuki 年月
	 * @param shu 週
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public NentsukiShuKanri getNentsukiShuKanriRef(Integer nentsuki, Integer shu) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
		                .path("/nentsukiShuKanriRef")
                        .queryParam("nentsuki", nentsuki)
                        .queryParam("shu", shu)
                        .build())
                .retrieve()
                .bodyToMono(NentsukiShuKanri.class).block();
    }
    /**
     * BE「番組参照検索」へ接続の設定
     *
	 * @param programId 番組ID
	 * @param programName 番組名
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ProgramInfoList getProgramRef(String programId, String programName) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
		                .path("/programRef")
                        .queryParam("programId", programId)
                        .queryParam("programName", programName)
                        .build())
                .retrieve()
                .bodyToMono(ProgramInfoList.class).block();
    }
    /**
     * BE「タレント参照検索」へ接続の設定
     *
	 * @param talentId タレントID
	 * @param talentName タレント名
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public TalentList getTalentRef(String talentId, String talentName) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
		                .path("/talentRef")
                        .queryParam("talentId", talentId)
                        .queryParam("talentName", talentName)
                        .build())
                .retrieve()
                .bodyToMono(TalentList.class).block();
    }
}
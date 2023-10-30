package com.talent.setting;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.MKbnGenre;
import com.model.MProgram;
import com.model.ProgramShutsuenList;
import com.model.ShukanTalentJoho;
import com.model.TalentShukanShutsuenJoho;
import com.model.YearMonthWeekStartEndJoho;

@Service
public class WebClientInfo {

    public WebClient webClient;

    public WebClientInfo(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
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
     * @param onairDay　オンエア日
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public ProgramShutsuenList getProgramShutsuen(String programId, String onairDay) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/programShutsuen")
                        .queryParam("programId", programId)
                        .queryParam("onairDay", onairDay)
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
    public MProgram getProgramInfo(String programId) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/programInfo/{programId}")
                        .build(programId))
                .retrieve()
                .bodyToMono(MProgram.class).block();
    }
    
    /**
     * BE「区分マスタ検索」へ接続の設定
     *
     * @param nentsuki　ジャンルID 【複数】
     * @return　遷移情報を設定したWebClientの内容を返す
     */
    public MKbnGenre getKbnMaster(String genreIds) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/kbnMaster/{genreIds}")
                        .build(genreIds))
                .retrieve()
                .bodyToMono(MKbnGenre.class).block();
    }
}
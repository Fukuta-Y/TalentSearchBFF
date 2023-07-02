package com.talent.setting;

import com.model.ShukanTalentJoho;
import com.model.YearMonthWeekStartEndJoho;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientInfo {

    public WebClient webClient;

    public WebClientInfo(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    // BE「週間タレント別情報検索」へ接続の設定
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

    // BE「年月週の開始終了日付検索」へ接続の設定
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
}
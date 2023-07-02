package com.talent.setting;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.ShukanTalentJoho;
import com.model.YearMonthWeekStartEndJoho;

@Service
public class WebClientInfo {

    public WebClient webClient;
    
    public WebClientInfo(WebClient.Builder webClientBuilder) {
    	 this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }
    
	// BE「週間タレント別情報検索」へ接続の設定
    public ShukanTalentJoho getShukanTalentJoho(Integer nentsuki, Integer shu, String talentName) {
        return this.webClient.get()
                .uri(String.format("/shukanTalentJoho?nentsuki=%d&shu=%d&talentName=%s",nentsuki, shu, talentName))
                .retrieve()
                .bodyToMono(ShukanTalentJoho.class).block();
    }
    // BE「年月週の開始終了日付検索」へ接続の設定
    public YearMonthWeekStartEndJoho getYearMonthWeekStartEnd(Integer nentsuki, Integer shu) {
        return this.webClient.get()
                .uri(String.format("/yearMonthWeekStartEnd?nentsuki=%d&shu=%d",nentsuki, shu))
                .retrieve()
                .bodyToMono(YearMonthWeekStartEndJoho.class).block();
    }
}
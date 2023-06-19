package com.example.demo.setting;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.ShukanTalentJohoSearch;
import com.model.YearMonthWeekStartEndJoho;

@Service
public class WebClientSetting {

    public WebClient webClient;
    
    public WebClientSetting(WebClient.Builder webClientBuilder) {
    	 this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
    
	// BE「週間タレント別情報検索」へ接続の設定
    public ShukanTalentJohoSearch getShukanTalentJohoSearch(Integer targetNentsuki, Integer targetShu, String talentName) {
        return this.webClient.get()
                .uri(String.format("/api/shukanTalentJohoSearch?targetNentsuki=%d&targetShu=%d&talentName=%s",targetNentsuki, targetShu, talentName))
                .retrieve()
                .bodyToMono(ShukanTalentJohoSearch.class).block();
    }
    // BE「年月週の開始終了日付検索」へ接続の設定
    public YearMonthWeekStartEndJoho getYearMonthWeekStartEndSearch(Integer targetNentsuki, Integer targetShu) {
        return this.webClient.get()
                .uri(String.format("/api/yearMonthWeekStartEndSearch?targetNentsuki=%d&targetShu=%d",targetNentsuki, targetShu))
                .retrieve()
                .bodyToMono(YearMonthWeekStartEndJoho.class).block();
    }
}
package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import com.api.ShukanTalentJohoSearchBFFApi;
import com.model.ShukanTalentJohoSearch;
import com.model.ShukanTalentJohoSearchBFF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

@Controller
public class ShukanTalentJohoSearchBFFController implements ShukanTalentJohoSearchBFFApi{

    private final WebClient webClient;

    public ShukanTalentJohoSearchBFFController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
	
	@Override
	public ResponseEntity<ShukanTalentJohoSearchBFF> getShukanTalentJohoSearchBFF(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
		ShukanTalentJohoSearchBFF model = new ShukanTalentJohoSearchBFF();
		
		
		Mono<ShukanTalentJohoSearch> search = this.getFirstDataByWebClient(targetNentsuki, targetShu, talentName);
		
		System.out.print("respose:" + search.block());
		
		return ResponseEntity.ok(model);
	}
	

	// BEへ接続
    private Mono<ShukanTalentJohoSearch> getFirstDataByWebClient(Integer targetNentsuki, Integer targetShu, String talentName) {
        return this.webClient.get()
                .uri(String.format("/api/shukanTalentJohoSearch?targetNentsuki=%d&targetShu=%d&talentName=%s",targetNentsuki, targetShu, talentName))
                .retrieve()
                .bodyToMono(ShukanTalentJohoSearch.class);
    }
    
	
}
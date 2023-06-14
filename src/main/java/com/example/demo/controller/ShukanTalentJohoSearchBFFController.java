package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.api.ShukanTalentJohoSearchBFFApi;
import com.model.ShukanTalentJohoSearch;
import com.model.ShukanTalentJohoSearchBFF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Controller
public class ShukanTalentJohoSearchBFFController implements ShukanTalentJohoSearchBFFApi{

//	@Autowired
//	private WebTestClient webTestClient;

	
    private final RestTemplate restTempalte;
	
    
    public ShukanTalentJohoSearchBFFController() {
        this.restTempalte = new RestTemplate();
    }
    
    private ShukanTalentJohoSearch getFirstDataByRestTemplate(Integer targetNentsuki,Integer targetShu, String talentName) {
        return this.restTempalte
                .getForObject(
                String.format("http://localhost:8080/api/shukanTalentJohoSearchBFF?targetNentsuki={0}&targetShu={1}&talentName={2}",
                targetNentsuki,targetShu,talentName), ShukanTalentJohoSearch.class);
    }
	
	@Override
	public ResponseEntity<ShukanTalentJohoSearchBFF> getShukanTalentJohoSearchBFF(
			@NotNull @Min(199001) @Max(210012) @Valid Integer targetNentsuki,
			@NotNull @Min(1) @Max(5) @Valid Integer targetShu, @Size(max = 30) @Valid String talentName) {
		
//		
//		ShukanTalentJohoSearchBFF model = new ShukanTalentJohoSearchBFF();
//
//		model.setTalentId("");
//		model.setTalentName("");
//		model.setShukanShutsuenProgramHonsu(1);
//		model.setShutsuenProgramChokin("dd");
//		model.setOnAirDayChokin("");
//		model.setShuFrom("");
//		model.setShuTo("");
		
		System.out.println("URL:" + String.format("http://localhost:8080/api/shukanTalentJohoSearch?targetNentsuki=%d&targetShu=%d&talentName=%s",targetNentsuki,targetShu,talentName));
		
		ShukanTalentJohoSearch search = this.getFirstDataByRestTemplate(targetNentsuki,targetShu,talentName); // 2, 3
		
		System.out.print("Program:" + search.getmProgram());
		System.out.print("Talent:" + search.getmTalent());
		System.out.print("OnAirKanri:" + search.gettOnAirKanri());
		
		ShukanTalentJohoSearchBFF model = new ShukanTalentJohoSearchBFF();
		
		return ResponseEntity.ok(model);
	}
	

	
    
	
}
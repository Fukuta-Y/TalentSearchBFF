package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupClassDto1;
import com.example.demo.dto.GroupClassDto2;
import com.example.demo.setting.WebClientSetting;
import com.model.MProgram;
import com.model.MTalent;
import com.model.ShukanTalentJohoSearch;
import com.model.ShukanTalentJohoSearchBFF;
import com.model.TOnAirKanri;

import lombok.RequiredArgsConstructor;

/**
 * 週間タレント別情報検索 Service
 */
@Service
@RequiredArgsConstructor
public class ShukanTalentJohoSearchBFFService {

    private final WebClientSetting webClient;
    
    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
　　　* @param talentName タレント名
     * @return 検索結果
     */
    public ShukanTalentJohoSearchBFF select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	// BE「週間タレント別情報検索より取得処理
    	ShukanTalentJohoSearch model = this.webClient.getFirstDataByWebClient(targetNentsuki, targetShu, talentName);
    	
    	// BE「週間タレント別情報検索より取得処理
    	
    	// 【業務処理】

    	// (1) BE「週間タレント別情報検索」より取得したレスポンスで以下の条件でデータを絞る。
    	// （別シート_タレント出演情報検索の結合イメージ　参照）

    	// 【取得条件】
    	// 「オンエア管理テーブルDTO」を軸として、キーを突き合わせる。

      	List<TOnAirKanri> tOnAirKanriList = model.gettOnAirKanri();
      	
      	List<MTalent> mTalentList = model.getmTalent();
      	
      	List<MProgram> mProgramList = model.getmProgram();
    	

      	List<TOnAirKanri> tOnAirKanri1 = new ArrayList<TOnAirKanri>();
      	
      	List<MTalent> mTalent2 = new ArrayList<MTalent>();
      	
      	List<MProgram> Mprogram2 = new ArrayList<MProgram>();
      	
      	// 全量のオンエア管理テーブルDTOを使用
      	for(TOnAirKanri e: tOnAirKanriList) {
      		// ① オンエア管理テーブルDTO.タレントID =タレントマスタDTO. タレントID
      		for(MTalent t: mTalentList) {
	      		if(e.getTalentId().equals(t.getTalentId())) {
	      			mTalent2.add(t);
		      		tOnAirKanri1.add(e);
	      		}
      		}
      	}
      	
      	// タレントで絞ったオンエア管理テーブルDTOを使用
    	// ② オンエア管理テーブルDTO.番組ID =番組マスタDTO.番組ID
      	for(TOnAirKanri e: tOnAirKanri1) {
	  		for(MProgram p: mProgramList) {
	      		if(e.getProgramId().equals(p.getProgramId())) {
	      			Mprogram2.add(p);
	      		}
	  		}
      	}

  
	    //System.out.println("tOnAirKanri1:" + tOnAirKanri1);
	    //System.out.println("mTalent2:" + mTalent2);
	    //System.out.println("Mprogram2:" + Mprogram2);

    	// 上記で突き合わせた場合、タレント名、番号名をレスポンスに設定する。
    	// 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。
    	List<GroupClassDto1> listDto1 = new ArrayList<GroupClassDto1>();
	    for(TOnAirKanri e: tOnAirKanri1) {
	    	
	    	String talentNm = "";
	    	for(MTalent t: mTalentList) {
	    		if(t.getTalentId().equals(e.getTalentId())) {
	    			talentNm = t.getTalentName();
	    		}
	    	}
	    	
	    	String programNm= "";
	    	for(MProgram p: mProgramList) {
	    		if(p.getProgramName().equals(e.getTalentId())) {
	    			programNm = p.getProgramName();
	    		}
	    	}	
	    	
	    	GroupClassDto1 dto1 = new GroupClassDto1();
	    	dto1.setId(e.getId());
	     	dto1.setOnairDay(e.getonairDay());
	     	dto1.setTalentId(e.getTalentId());
	     	dto1.setTalentName(talentNm); // keyで抜く
	     	dto1.setProgramId(e.getProgramId());
	     	dto1.setProgramName(programNm); // keyで抜く
	     	dto1.setTargetNentsuki(e.getTargetNentsuki());
	     	dto1.setTargetShu(e.getTargetShu());
	     	listDto1.add(dto1);
	    }
      	
	    // System.out.println("listDto1:" + listDto1);


    	// (2) 絞った結果をタレントID、タレント名で集約化する。集約時に、タレントID,タレント名、週間出演番組本数のレコードの形にする。
    	// （レスポンスのベース）
	    
	    GroupClassDto2 dto2 = new GroupClassDto2();
	    
	    List<GroupClassDto2> dto2List = new ArrayList<GroupClassDto2>();

	    for(GroupClassDto1 e:listDto1) {
	    	dto2 = new GroupClassDto2();
	    	dto2.setTalentId(e.getTalentId());
	    	dto2.setTalentName(e.getTalentName());
	    	dto2.setTargetNentsuki(e.getTargetNentsuki());
	    	dto2.setTargetShu(e.getTargetShu());
		    // 設定
		    dto2List.add(dto2);
	    }
	    //System.out.println("dto2List:" + dto2List);
	    
	    Map<GroupClassDto2, Long> countMap = dto2List.stream().collect(
	    	    Collectors.groupingBy(
	    	        Function.identity(),
	    	        Collectors.counting()));
	    
	    List<GroupClassDto2> dto2List2 = new ArrayList<GroupClassDto2>();
	    countMap.forEach((k, v) -> {
	    	GroupClassDto2 dtoHonsu = new GroupClassDto2();
	    	dtoHonsu.setTalentId(k.getTalentId());
	    	dtoHonsu.setTalentName(k.getTalentName());
	    	dtoHonsu.setShukanShutsuenHonsu(v);
	    	dtoHonsu.setTargetNentsuki(k.getTargetNentsuki());
	    	dtoHonsu.setTargetShu(k.getTargetShu());
		    // 設定
	    	dto2List2.add(dtoHonsu);
	    });
	    
	    System.out.println("dto2List2:" + dto2List2);
	    
    	// (3)　(1)よりタレントIDをキーとして取得して、オンエア日でソートして、最も近いオンエア日の日付の行だけを取得する。
    	// 取得後、タレントID、出演番組（直近）【番組名】、オンエア日（直近）【オンエア日】のレコードの形にする。
	    
	    
	    

    	// (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。

    	// (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
    	// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
    	// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定

    	// (6) (4) + (5)を組み合わせて、レスポンスの形にする。
    	ShukanTalentJohoSearchBFF response = new ShukanTalentJohoSearchBFF();
    	response.setTalentId(model.getmTalent().get(0).getTalentId());
    	
		// responseの返却
        return response;
    }
}
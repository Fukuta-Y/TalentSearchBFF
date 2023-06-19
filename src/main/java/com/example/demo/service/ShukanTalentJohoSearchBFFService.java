package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupClassDto1;
import com.example.demo.dto.GroupClassDto2;
import com.example.demo.dto.GroupClassDto3;
import com.example.demo.dto.GroupClassDto4;
import com.example.demo.setting.OnAirComparator;
import com.example.demo.setting.WebClientSetting;
import com.model.MProgram;
import com.model.MTalent;
import com.model.ShukanTalentJohoSearch;
import com.model.ShukanTalentJohoSearchBFF;
import com.model.TOnAirKanri;
import com.model.YearMonthWeekStartEndJoho;

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
    	ShukanTalentJohoSearch model = this.webClient.getShukanTalentJohoSearch(targetNentsuki, targetShu, talentName);
    	
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
	    		if(p.getProgramId().equals(e.getProgramId())) {
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
	    
    	// (3)　(1)よりタレントIDをキーとして取得して、オンエア日でソートして、最も近いオンエア日の日付の行だけを取得する。
    	// 取得後、タレントID、出演番組（直近）【番組名】、オンエア日（直近）【オンエア日】のレコードの形にする。
	   List<String> talentList = new ArrayList<String>();
	   // タレントIDの一覧のリスト
	   for(GroupClassDto2 e:dto2List2) {
	    	talentList.add(e.getTalentId());
	    }
	   List<GroupClassDto3> dto3List = new ArrayList<GroupClassDto3>();
	   List<GroupClassDto1> dto1List = new ArrayList<GroupClassDto1>();
	   for(String talentID:talentList) {
		   dto1List = new ArrayList<GroupClassDto1>();
		   for(GroupClassDto1 e:listDto1) {
			   if(e.getTalentId().equals(talentID)) {
				   dto1List.add(e);
			   }
		    }
		   // 
		   if(dto1List != null) {
			   //オンエア日でソート
			   Collections.sort(dto1List, new OnAirComparator());
   
			   // 最終的に表示するものだけ追加
			   GroupClassDto1 dto1tmp = dto1List.get(0);
			   GroupClassDto3 dto3 = new GroupClassDto3();
			   dto3.setOnairDay(dto1tmp.getOnairDay());
			   dto3.setProgramName(dto1tmp.getProgramName());
			   dto3.setTalentId(dto1tmp.getTalentId());
			   dto3.setTalentName(dto1tmp.getTalentName());
			   dto3List.add(dto3);
		   }
	   }
	   
    	// (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。
	    GroupClassDto4 dto4 = new GroupClassDto4();
	    List<GroupClassDto4> dto4List = new ArrayList<GroupClassDto4>();
	   
	   // dto2List2とdto3Listをマージ
	   for(GroupClassDto2 k:dto2List2) {
		   for(GroupClassDto3 v:dto3List) {
		    	if(k.getTalentId().equals(v.getTalentId())) {
		 		   dto4 = new GroupClassDto4();
		 		   dto4.setTalentId(k.getTalentId());
		 		   dto4.setTalentName(k.getTalentName());
		 		   dto4.setShukanShutsuenHonsu(k.getShukanShutsuenHonsu());
		 		   dto4.setProgramName(v.getProgramName());
		 		   dto4.setOnairDay(v.getOnairDay());
		 		   dto4List.add(dto4);
		 		   break;
		    	}
		    }
	    }

    	// (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
    	// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
    	// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
	   YearMonthWeekStartEndJoho yyyymmModel = this.webClient.getYearMonthWeekStartEndSearch(targetNentsuki, targetShu);

    	// (6) (4) + (5)を組み合わせて、レスポンスの形にする。
    	ShukanTalentJohoSearchBFF response = new ShukanTalentJohoSearchBFF();
    	response.setTalentId(model.getmTalent().get(0).getTalentId());
    	
		// responseの返却
        return response;
    }
}
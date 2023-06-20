package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.controller.helper.ShukanTalentJohoSearchBffHelper;
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
    private final ShukanTalentJohoSearchBffHelper helper;
    
    /**
     * 週間タレント別情報検索
　　　* @param targetNentsuki 対象年月
　　　* @param targetShu 対象週
　　　* @param talentName タレント名
     * @return 検索結果
     */
    public List<ShukanTalentJohoSearchBFF> select(Integer targetNentsuki, Integer targetShu, String talentName) {
    	
    	List<ShukanTalentJohoSearchBFF> response = new ArrayList<ShukanTalentJohoSearchBFF>();
    	ShukanTalentJohoSearchBFF bffModel = new ShukanTalentJohoSearchBFF();
    	
    	// BE「週間タレント別情報検索より取得処理
    	ShukanTalentJohoSearch model = this.webClient.getShukanTalentJohoSearch(targetNentsuki, targetShu, talentName);
    	
    	// (1) BE「週間タレント別情報検索」より取得したレスポンスで以下の条件でデータを絞る。
    	// （別シート_タレント出演情報検索の結合イメージ　参照）
      	List<TOnAirKanri> tOnAirKanriList = model.gettOnAirKanri();
      	
      	List<MTalent> mTalentList = model.getmTalent();
      	
      	List<MProgram> mProgramList = model.getmProgram();

      	List<TOnAirKanri> tOnAirKanri1 = new ArrayList<TOnAirKanri>();
      	
      	List<MTalent> mTalent2 = new ArrayList<MTalent>();
      	
      	List<MProgram> Mprogram2 = new ArrayList<MProgram>();
      	
      	// 以下はオンエア管理が設定されている場合のみ対応
      	if (tOnAirKanriList == null) {
            response.add(bffModel);
            return response;
      	}
      	
    	// 【取得条件】
    	// 「オンエア管理テーブルDTO」を軸として、キーを突き合わせる。
      	// 全量のオンエア管理テーブルDTOを使用
      	for(TOnAirKanri kanri: tOnAirKanriList) {
      		// ① オンエア管理テーブルDTO.タレントID =タレントマスタDTO. タレントID
      		for(MTalent talent: mTalentList) {
	      		if(kanri.getTalentId().equals(talent.getTalentId())) {
	      			mTalent2.add(talent);
		      		tOnAirKanri1.add(kanri);
	      		}
      		}
      	}
      	
      	// タレントで絞ったオンエア管理テーブルDTOを使用
    	// ② オンエア管理テーブルDTO.番組ID =番組マスタDTO.番組ID
      	for(TOnAirKanri kanri: tOnAirKanri1) {
	  		for(MProgram pgm: mProgramList) {
	      		if(kanri.getProgramId().equals(pgm.getProgramId())) {
	      			Mprogram2.add(pgm);
	      		}
	  		}
      	}

    	// 上記で突き合わせた場合、タレント名、番号名をレスポンスに設定する。
    	// 突き合わせができなかった、「オンエア管理テーブルDTO」の行については名称系を未設定とする。
    	List<GroupClassDto1> listDto1 = new ArrayList<GroupClassDto1>();
	    for(TOnAirKanri kanri: tOnAirKanri1) {
	    	
	    	String talentNm = "";
	    	for(MTalent talent: mTalentList) {
	    		if(talent.getTalentId().equals(kanri.getTalentId())) {
	    			talentNm = talent.getTalentName();
	    		}
	    	}
	    	
	    	String programNm= "";
	    	for(MProgram pgm: mProgramList) {
	    		if(pgm.getProgramId().equals(kanri.getProgramId())) {
	    			programNm = pgm.getProgramName();
	    		}
	    	}	
	    	
	    	// GroupClassDto1へ変換して設定
	     	listDto1.add(helper.toDto1(kanri, talentNm, programNm));
	    }

    	// (2) 絞った結果をタレントID、タレント名で集約化する。集約時に、タレントID,タレント名、週間出演番組本数のレコードの形にする。
    	// （レスポンスのベース）
	    List<GroupClassDto2> dto2List = new ArrayList<GroupClassDto2>();

	    for(GroupClassDto1 dto1:listDto1) {
	    	// GroupClassDto2へ変換して設定
		    dto2List.add(helper.toDto2(dto1));
	    }

	    // クラス単位での件数を取得
	    Map<GroupClassDto2, Long> countMap = dto2List.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    
	    List<GroupClassDto2> dto2List2 = new ArrayList<GroupClassDto2>();
	    countMap.forEach((dto2, honsu) -> {
	    	// GroupClassDto2の本数へ変換して設定
	    	dto2List2.add(helper.toHonsuDto2(dto2, honsu));
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
		   for(GroupClassDto1 dto1:listDto1) {
			   if(dto1.getTalentId().equals(talentID)) {
				   dto1List.add(dto1);
			   }
		    }
		   // 
		   if(dto1List != null) {
			   //オンエア日でソート
			   Collections.sort(dto1List, new OnAirComparator());
			   // 最終的に表示するものだけ追加
			   dto3List.add(helper.toDto3(dto1List.get(0))); 
		   }
	   }
	   
    	// (4) (2)に対して、(3)を組み合わせて、レスポンスの形にする。
	    List<GroupClassDto4> dto4List = new ArrayList<GroupClassDto4>();
	   
	   // dto2List2とdto3Listをマージ
	   for(GroupClassDto2 dto2:dto2List2) {
		   for(GroupClassDto3 dto3:dto3List) {
		    	if(dto2.getTalentId().equals(dto3.getTalentId())) {
		 		   dto4List.add(helper.toDto4(dto2, dto3));
		 		   break;
		    	}
		    }
	    }

    	// (5)BE「年月週の開始終了日付検索」より取得したレスポンスを以下のように設定する。
    	// ・対象週(FROM)へ、年月週管理マスタDTO .週の開始日（日曜日）を設定
    	// ・対象週(TO)へ、年月週管理マスタDTO .週の終了日（土曜日）を設定
	   YearMonthWeekStartEndJoho joho = this.webClient.getYearMonthWeekStartEndSearch(targetNentsuki, targetShu);

    	// (6) (4) + (5)を組み合わせて、レスポンスの形にする。
	   for(GroupClassDto4 dto4:dto4List) {
	       response.add(helper.toResponse(dto4, Math.toIntExact(dto4.getShukanShutsuenHonsu()), joho.getmNentsukiShuKanri()));
		}

		// responseの返却
		return response;
    }
}
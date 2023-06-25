package com.talent.setting;


import java.util.Comparator;

import com.model.ShukanTalentJohoBFF;

public class TalentIdComparator implements Comparator<ShukanTalentJohoBFF> {

	@Override
	public int compare(ShukanTalentJohoBFF joho1, ShukanTalentJohoBFF joho2) {
		return Integer.parseInt(joho1.getTalentId()) < Integer.parseInt(joho2.getTalentId()) ? -1 : 1;

		// REVIEW: 純粋な方が見やすいかな・・。
		//  Integer talentId1 = Integer.parseInt(joho1.getTalentId());
		//    Integer talentId2 = Integer.parseInt(joho2.getTalentId());
		//
		//    return talentId1.compareTo(talentId2);
	}
}
package com.talent.setting;


import java.util.Comparator;

import com.model.ShukanTalentJohoBFF;

public class TalentIdComparator implements Comparator<ShukanTalentJohoBFF> {

	@Override
	public int compare(ShukanTalentJohoBFF p1, ShukanTalentJohoBFF p2) {
		return Integer.parseInt(p1.getTalentId()) < Integer.parseInt(p2.getTalentId()) ? -1 : 1;
	}
}
package com.talent.setting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.talent.dto.GroupClassDto1;

public class OnAirComparator implements Comparator<GroupClassDto1> {

    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(GroupClassDto1 a, GroupClassDto1 b) {
    	
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = null;
		try {
			date1 = sdFormat.parse(a.getOnairDay());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        Date date2 = null;
		try {
			date2 = sdFormat.parse(b.getOnairDay());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        return date1.compareTo(date2);
    }
}
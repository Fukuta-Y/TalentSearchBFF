package com.talent.setting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.talent.service.dto.GroupClassDto1;


public class OnAirComparator implements Comparator<GroupClassDto1> {

    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(GroupClassDto1 data1, GroupClassDto1 data2) {
    	
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = null;
        Date date2 = null;
		try {
			date1 = sdFormat.parse(data1.getOnairDay());
			date2 = sdFormat.parse(data2.getOnairDay());
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return date1.compareTo(date2);
    }

    // 関数型で書き換えた方法
//    public final Comparator<GroupClassDto1> onAirComparator = (data1, data2) -> {
//        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date1 = null;
//        Date date2 = null;
//        try {
//            date1 = sdFormat.parse(data1.getOnairDay());
//            date2 = sdFormat.parse(data2.getOnairDay());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return date1.compareTo(date2);
//    };

// 　　これがComparatorの意味です。
//    Comparator<Integer> comparator = (num1, num2) -> {
//        if (num1 < num2) {
//            return -1;
//        } else if (num1.equals(num2)) {
//            return 0;
//        } else {
//            return 1;
//        }
//    };
}
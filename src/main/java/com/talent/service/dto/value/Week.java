package com.talent.service.dto.value;

// バリデーションチェック
public record Week (int week) {
	public Week (int week) {
		this.week = week;
	}
}
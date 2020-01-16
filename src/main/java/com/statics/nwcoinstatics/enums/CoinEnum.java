package com.statics.nwcoinstatics.enums;

public enum CoinEnum {
	
	BTC("BTC"),
	
	USDT("USD");
	
	private String value;

	private CoinEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	

}

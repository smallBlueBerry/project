package com.statics.nwcoinstatics.enums;

public enum ExchangeEnum {
	
	OK("ok");
	
	private String value;

	private ExchangeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	

}

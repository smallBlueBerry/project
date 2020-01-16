package com.statics.nwcoinstatics.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeleBuyRes {
	
	private BigDecimal  buy_num;
	
	private BigDecimal sell_num;
	
	private BigDecimal type;
	
	private Date time;

}

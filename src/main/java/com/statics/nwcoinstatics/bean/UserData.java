package com.statics.nwcoinstatics.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**   
* @Description: 获取用户信息
* @version: v1.0.0
* @author: linan
* @date: Sep 23, 2019 11:25:54 AM 
*/
@AllArgsConstructor
@Data
public class UserData {
	
	/** 产品名称 **/
	private String product_name;
	
	/** 当前权益 **/
	private String current_interest;
	
	/** 已实现权益 **/
	private String realized_interest;
	
	/** 当日收益 **/
	private String profit_day;
	
	/** 综合年化 **/
	private String multiple_profit;
	
	/** NAV **/
	private String nav;
	
	/** Daily Return **/
	private String daily_return;
	
	/** 计价单位 **/
	private String unit_name;
	
	/** 创建时间 **/
	private String create_time;

}

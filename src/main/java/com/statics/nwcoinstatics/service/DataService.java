package com.statics.nwcoinstatics.service;

import java.util.Date;

import com.statics.nwcoinstatics.bean.UserCoinResponse;

public interface DataService {
	
	/**   
	* @Description: 添加用户总资产信息
	* @author: linan
	* @date: Sep 23, 2019 1:41:12 PM 
	*/
	public void addUserCoin(Date date);
	
	/**   
	* @Description: 获取用户总资产信息
	* @author: linan
	* @date: Dec 10, 2019 4:17:29 PM 
	*/
	public UserCoinResponse getUserCoin(int page, int size, String startTime, String endTime, String productName);
	
}

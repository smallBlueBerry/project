package com.statics.nwcoinstatics.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**   
* @Description: 返回用户列表结果
* @version: v1.0.0
* @author: linan
* @date: Dec 11, 2019 10:46:33 AM 
*/
@AllArgsConstructor
@Data
public class UserCoinResponse {
	
	private int total_num;
	
	private List<UserData> assets_list;

}

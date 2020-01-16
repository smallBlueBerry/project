package com.statics.nwcoinstatics.utils;

import java.util.ArrayList;
import java.util.List;

import com.statics.nwcoinstatics.bean.UserData;

public class ParamsUtils {
	
	public static List<UserData> turnUserEntity(List<Object[]> list){
		List<UserData> userlist = new ArrayList<UserData>();
		if (list.size() > 0) {
			for (Object[] user:list) {
				UserData userData = new UserData(user[0].toString(), user[1].toString(), user[2].toString(), user[3].toString(), user[4].toString(),
						user[5].toString(), user[6].toString(), user[7].toString(), user[8].toString());
				userlist.add(userData);
			}
		}
		return userlist;
	}

}

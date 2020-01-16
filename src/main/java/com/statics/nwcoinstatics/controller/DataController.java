package com.statics.nwcoinstatics.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.statics.nwcoinstatics.bean.ApiResponse;
import com.statics.nwcoinstatics.bean.UserCoinResponse;
import com.statics.nwcoinstatics.enums.ResponseCodeEnum;
import com.statics.nwcoinstatics.service.DataService;

@RestController
public class DataController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private DataService dataService;
	
	@PostMapping("/nw/user/coin")
	public ApiResponse addUserAssets() {
		LOGGER.info("all user OK coin assests");
		dataService.addUserCoin(new Date());
		return new ApiResponse<>(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMessage(),null);
	}
	
	@GetMapping("/nw/user/coin")
	public ApiResponse<UserCoinResponse> showUserAssets(@RequestParam int page, @RequestParam int size, @RequestParam String begin_time,@RequestParam String end_time, @RequestParam String product_name) {
		LOGGER.info("show user all coin assests");
		UserCoinResponse res = dataService.getUserCoin(page, size, begin_time, end_time, product_name);
		return new ApiResponse<>(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMessage(),res);
	}
	

}

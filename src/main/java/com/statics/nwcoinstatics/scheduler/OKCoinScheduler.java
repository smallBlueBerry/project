package com.statics.nwcoinstatics.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.ApiResponse;
import com.statics.nwcoinstatics.bean.SeleBuyRes;
import com.statics.nwcoinstatics.enums.ResponseCodeEnum;
import com.statics.nwcoinstatics.service.CoinService;
import com.statics.nwcoinstatics.utils.DateUtils;

@Component
public class OKCoinScheduler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OKCoinScheduler.class);
	
	@Autowired
	private CoinService coinService;
	
	@Scheduled(cron = "0/1 * * * * ?")
	public ApiResponse<SeleBuyRes> getUsersSellBuy() {
		Date date = new Date();
		LOGGER.info("**********getUsersSellBuy**********" + DateUtils.timeToString(date, 3));
		return new ApiResponse<>(ResponseCodeEnum.SUCCESS.getCode(),ResponseCodeEnum.SUCCESS.getMessage(),coinService.getNowRes(DateUtils.timeToString(date, 3))); 
	}

}

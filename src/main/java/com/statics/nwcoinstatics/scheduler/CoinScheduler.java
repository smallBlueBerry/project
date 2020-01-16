package com.statics.nwcoinstatics.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.service.CoinService;
import com.statics.nwcoinstatics.service.DataService;
import com.statics.nwcoinstatics.utils.DateUtils;

@Component
public class CoinScheduler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoinScheduler.class);
	
	@Autowired
	private DataService dataService;
	
	
	@Scheduled(cron = "0 0/1 * * * ?")
	public void addProductFund() {
		Date date = new Date();
		LOGGER.info("**********addProductFund**********" + DateUtils.timeToString(date, 3));
		//dataService.addUserCoin(date);
	}
	

}

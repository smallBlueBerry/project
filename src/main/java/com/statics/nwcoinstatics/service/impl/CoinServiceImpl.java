package com.statics.nwcoinstatics.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statics.nwcoinstatics.api.SpotProductAPI;
import com.statics.nwcoinstatics.bean.APIConfiguration;
import com.statics.nwcoinstatics.bean.SeleBuyRes;
import com.statics.nwcoinstatics.bean.SellBuyCoin;
import com.statics.nwcoinstatics.bean.Trade;
import com.statics.nwcoinstatics.client.APIClient;
import com.statics.nwcoinstatics.enums.I18nEnum;
import com.statics.nwcoinstatics.repository.SellBuyCoinRepository;
import com.statics.nwcoinstatics.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoinServiceImpl.class);
	
	@Autowired
	private SellBuyCoinRepository sellBuyCoinRepository;
	
	final APIConfiguration config = new APIConfiguration();
	
	private Set<Trade> resultList = new LinkedHashSet<>();
	
	private BigDecimal tradeId = BigDecimal.ZERO;
	
	private int index = 0;
	
	@Override
	public SeleBuyRes getNowRes(String date) {
		LOGGER.info("**********getNowRes***********");
		config.setEndpoint("https://www.okex.me/");
        config.setApiKey("5d05ad8c-69a0-428f-b107-93fd74dfd074");
        config.setSecretKey("BAFF7728C249793D7826C7B2C4148E2D");
        config.setPassphrase("199410x");
        config.setPrint(true);
        config.setI18n(I18nEnum.SIMPLIFIED_CHINESE);
        
        APIClient client = new APIClient(config);
        
        //获取账户总资产
        SpotProductAPI spotProductAPI = client.createService(SpotProductAPI.class);
        List<Trade> trades = client.executeSync(spotProductAPI.getTrades("btc-usdt", null, null, "60"));
        resultList.addAll(trades);
        index++;
        BigDecimal sellNum = BigDecimal.ZERO;
        BigDecimal buyNum = BigDecimal.ZERO;
        BigDecimal disNum = BigDecimal.ZERO;
        
        if (index == 60) {
        	for (Trade trade:trades) {
            	if ("buy".equals(trade.getSide())) {
            		buyNum = buyNum.add(new BigDecimal(trade.getSize()));
            	} else {
            		sellNum = sellNum.add(new BigDecimal(trade.getSize()));
            	}
            }
        	index = 0;
        	resultList.clear();
        	disNum = buyNum.subtract(sellNum);
        	sellBuyCoinRepository.save(new SellBuyCoin(buyNum.toString(), sellNum.toString(), disNum.toString(), date));
        }
        
        System.out.println(buyNum+", "+sellNum+", "+disNum+", " + ",列表大小：" + resultList.size() + "," + date);
        
		return new SeleBuyRes(buyNum, sellNum, disNum, new Date());
	}

}

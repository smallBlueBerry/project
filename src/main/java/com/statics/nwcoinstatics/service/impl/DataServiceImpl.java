package com.statics.nwcoinstatics.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.statics.nwcoinstatics.api.AccountAPI;
import com.statics.nwcoinstatics.bean.APIConfiguration;
import com.statics.nwcoinstatics.bean.ExchangeData;
import com.statics.nwcoinstatics.bean.FundData;
import com.statics.nwcoinstatics.bean.ProductData;
import com.statics.nwcoinstatics.bean.UserCoinResponse;
import com.statics.nwcoinstatics.bean.UserData;
import com.statics.nwcoinstatics.client.APIClient;
import com.statics.nwcoinstatics.constant.Constant;
import com.statics.nwcoinstatics.enums.ExchangeEnum;
import com.statics.nwcoinstatics.enums.I18nEnum;
import com.statics.nwcoinstatics.exception.ServiceException;
import com.statics.nwcoinstatics.repository.ExchangeRepository;
import com.statics.nwcoinstatics.repository.FundRepository;
import com.statics.nwcoinstatics.repository.ProductRepository;
import com.statics.nwcoinstatics.repository.UnitRepository;
import com.statics.nwcoinstatics.service.DataService;
import com.statics.nwcoinstatics.utils.DateUtils;
import com.statics.nwcoinstatics.utils.ParamsUtils;

@Service
public class DataServiceImpl implements DataService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceImpl.class);
	
	@Autowired
	private FundRepository fundRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private UnitRepository unitRepository;

	/** 添加用户总资产信息 **/
	@Override
	public void addUserCoin(Date date) {
		try {
			
			List<ProductData> products = productRepository.findAll();
			
			BigDecimal totalAssets = BigDecimal.ZERO;
			
			if (products.size() > 0) {
				for (ProductData product:products) {
					String exchangeId = product.getExchange_id();
					String type = unitRepository.findById(product.getUnit_id()).getName();
					if (exchangeId.indexOf(",") == -1) {
						ExchangeData exchange = exchangeRepository.findById(Integer.parseInt(exchangeId));
						if (ExchangeEnum.OK.getValue().equals(exchange.getName())) totalAssets = getOkAssests(type, exchange);
					} else {
						for (String id:exchangeId.split(",")) {
							ExchangeData exchange = exchangeRepository.findById(Integer.parseInt(id));
							if (ExchangeEnum.OK.getValue().equals(exchange.getName())) totalAssets = totalAssets.add(getOkAssests(type, exchange));
						}
					}
					BigDecimal assets = new BigDecimal(product.getAssets()).setScale(2, BigDecimal.ROUND_HALF_UP);
					//插入库
					FundData fund_yesterday = fundRepository.findByDateAndProduct(product.getId(), DateUtils.getYesterdday() + " 00:00:00");
					if (fund_yesterday != null) {
						//当日收益（字段）账户资产 - 昨日00:00账户资产 绿色表示正，红色表示负
						BigDecimal profit_day = totalAssets.subtract(new BigDecimal(fund_yesterday.getCurrent_interest()));
						
						//综合年化（字段）(收益/已实现权益)/天数*365
						BigDecimal multiple_profit = profit_day.divide(new BigDecimal(product.getAssets())).divide(new BigDecimal(DateUtils.getDays(product.getStart_time()))).multiply(new BigDecimal(365));
						
						//NAV  (当前权益 / 已实现权益) 
						BigDecimal nav = totalAssets.divide(new BigDecimal(product.getAssets()));
						
						//Daily Return  ((NAV / 昨日NAV) - 1 ) * 100% 绿色表示正，红色表示负
						BigDecimal daily_return = (nav.divide(new BigDecimal(fund_yesterday.getNav())).subtract(new BigDecimal(1))).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

						FundData fund = new FundData(product.getId(), date, totalAssets.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), assets.toString(), profit_day.setScale(2, BigDecimal.ROUND_HALF_UP).toString(),
								multiple_profit.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), nav.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), daily_return+"%", product.getUnit_id());
						fundRepository.save(fund);
					} else {
						FundData fund = new FundData(product.getId(), date, totalAssets.setScale(2, BigDecimal.ROUND_HALF_UP).toString(), assets.toString(), "0", "0", "0", "0%", product.getUnit_id());
						fundRepository.save(fund);
					}
					
				}
			}
	        
		}  catch (Exception e) {
			LOGGER.error(Constant.USER_ADD_COIN_MSG, e);
			throw new ServiceException(Constant.USER_ADD_COIN_CODE, Constant.USER_ADD_COIN_MSG);
		}
	}
	
	private BigDecimal getOkAssests(String type, ExchangeData exchange) {
		final APIConfiguration config = new APIConfiguration();
		config.setEndpoint(exchange.getUrl());
        config.setApiKey(exchange.getApi_key());
        config.setSecretKey(exchange.getSecret_key());
        config.setPassphrase(exchange.getPass_phrase());
        config.setPrint(true);
        config.setI18n(I18nEnum.SIMPLIFIED_CHINESE);
        
        APIClient client = new APIClient(config);
        
        //获取账户总资产
        AccountAPI accountAPI = client.createService(AccountAPI.class);
        JSONObject allBalance = client.executeSync(accountAPI.getAllCurrencies(type));
        
        BigDecimal totalAssets = new BigDecimal(allBalance.getString("balance"));
        
        System.out.println("totalAssets:"+totalAssets);
        
        return totalAssets;
	}

	/** 获取用户总资产信息 **/
	@Override
	public UserCoinResponse getUserCoin(int page, int size, String startTime, String endTime, String productName) {
		LOGGER.info("**********getUserCoin***********");
		try {
			List<Object[]> userCoinList = fundRepository.findUserCoinList((page-1)*size, size, startTime, endTime, productName);
			List<UserData> userDataList = ParamsUtils.turnUserEntity(userCoinList);
			UserCoinResponse responseVo = new UserCoinResponse(fundRepository.findUserCoinCount(startTime, endTime, productName), userDataList);
			return responseVo;
		} catch (Exception e) {
			LOGGER.error(Constant.USER_GET_COIN_MSG, e);
			throw new ServiceException(Constant.USER_GET_COIN_CODE, Constant.USER_GET_COIN_MSG);
		}
	}

	
}

package com.statics.nwcoinstatics.api;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.statics.nwcoinstatics.bean.Currency;
import com.statics.nwcoinstatics.bean.Ledger;
import com.statics.nwcoinstatics.bean.Wallet;
import com.statics.nwcoinstatics.bean.WithdrawFee;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Account api
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/07/04 20:51
 */
public interface AccountAPI {


    @POST("/api/account/v3/transfer")
    Call<JSONObject> transfer(@Body JSONObject jsonObject);


    @POST("/api/account/v3/withdrawal")
    Call<JSONObject> withdraw(@Body JSONObject jsonObject);

    @GET("/api/account/v3/currencies")
    Call<List<Currency>> getCurrencies();

    @GET("/api/account/v3/ledger")
    Call<List<Ledger>> getLedger(@Query("txn_type") Integer type, @Query("currency") String currency,
                                 @Query("before") Integer before, @Query("after") Integer after, @Query("limit") int limit);

    @GET("/api/account/v3/wallet")
    Call<List<Wallet>> getWallet();

    @GET("/api/account/v3/wallet/{currency}")
    Call<List<Wallet>> getWallet(@Path("currency") String currency);

    @GET("/api/account/v3/deposit/address")
    Call<JSONArray> getDepositAddress(@Query("currency") String currency);

    @GET("/api/account/v3/withdrawal/fee")
    Call<List<WithdrawFee>> getWithdrawFee(@Query("currency") String currency);

    @GET("/api/account/v3/onhold")
    Call<JSONArray> getOnHold(@Query("currency") String currency);

    @POST("/api/account/v3/lock")
    Call<JSONObject> lock(@Body JSONObject jsonObject);

    @POST("/api/account/v3/unlock")
    Call<JSONObject> unlock(@Body JSONObject jsonObject);

    @GET("/api/account/v3/deposit/history")
    Call<JSONArray> getDepositHistory();

    @GET("/api/account/v3/deposit/history/{currency}")
    Call<JSONArray> getDepositHistory(@Path("currency") String currency);
    
    @GET("/api/account/v3/asset-valuation")
    Call<JSONObject> getAllCurrencies(@Query("valuation_currency") String currency);
}

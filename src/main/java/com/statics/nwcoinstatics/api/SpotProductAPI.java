package com.statics.nwcoinstatics.api;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;

import com.statics.nwcoinstatics.bean.KlineDto;
import com.statics.nwcoinstatics.bean.Product;
import com.statics.nwcoinstatics.bean.Ticker;
import com.statics.nwcoinstatics.bean.Trade;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpotProductAPI {

    @GET("/api/spot/v3/instruments")
    Call<List<Product>> getProducts();

    @GET("/api/spot/v3/instruments/{instrument_id}/book")
    Call<Book> bookProductsByProductId(@Path("instrument_id") String product,
                                       @Query("size") String size,
                                       @Query("depth") BigDecimal depth);

    @GET("/api/spot/v3/instruments/ticker")
    Call<List<Ticker>> getTickers();

    @GET("/api/spot/v3/instruments/{instrument_id}/ticker")
    Call<Ticker> getTickerByProductId(@Path("instrument_id") String product);


    @GET("/api/spot/v3/instruments/{instrument_id}/trades")
    Call<List<Trade>> getTrades(@Path("instrument_id") String product,
                                @Query("before") String before,
                                @Query("after") String after,
                                @Query("limit") String limit);

    @GET("/api/spot/v3/instruments/{instrument_id}/candles")
    Call<List<KlineDto>> getCandles(@Path("instrument_id") String product,
                                    @Query("granularity") String type,
                                    @Query("start") String start,
                                    @Query("end") String end);

    @GET("/api/spot/v3/instruments/{instrument_id}/candles")
    Call<List<String[]>> getCandles_1(@Path("instrument_id") String product,
                                      @Query("granularity") String type,
                                      @Query("start") String start,
                                      @Query("end") String end);

}

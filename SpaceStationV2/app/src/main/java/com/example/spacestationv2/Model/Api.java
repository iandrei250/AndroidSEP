package com.example.spacestationv2.Model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("datas/GetDataList")
    Call<List<CO2>> getCo2(@Query("room") String room,
                           @Query("type")String type);
    @GET("datas/GetDataList")
    Call<List<Humidity>> getHumidity(@Query("room") String room,
                           @Query("type")String type);
    @GET("datas/GetDataList")
    Call<List<Temperature>> getTemperature(@Query("room") String room,
                           @Query("type")String type);

}
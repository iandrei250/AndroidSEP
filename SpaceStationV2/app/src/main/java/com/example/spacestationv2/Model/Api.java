package com.example.spacestationv2.Model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("data/GetData?date=2020-05-26 11:54:27.6153964&type=CO2")
    Call<CO2> getCo2();
}
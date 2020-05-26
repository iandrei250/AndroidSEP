package com.example.spacestationv2.Model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("data/GetData")
    Call<List<Co2V>> getCo2(@Query("date") LocalDate date,
                              @Query("type") String type);
}
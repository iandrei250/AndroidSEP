package com.example.spacestationv2.Model;

import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class RepositoryHumidity {

    private Gson gson;
    private Api api;
    private LocalDateTime myDateObj;
    private static RepositoryHumidity humidityInstance;

    public static RepositoryHumidity getInstanceHumidity() {
        if (humidityInstance == null) {
            humidityInstance = new RepositoryHumidity();
        }
        return humidityInstance;
    }

    public RepositoryHumidity() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();


    }

    public MutableLiveData<List<Humidity>> getList(String room, String type) {
        final MutableLiveData<List<Humidity>> humidityData = new MutableLiveData<>();
        api.getHumidity(room, type).enqueue(new Callback<List<Humidity>>() {
            @Override
            public void onResponse(Call<List<Humidity>> call, Response<List<Humidity>> response) {
                Log.d("HumidityFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    humidityData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Humidity>> call, Throwable t) {

                System.out.println(t.getMessage());

                //  view.setText("error " + t.toString() + "\n" + call.request().toString());
            }
        });
        return humidityData;

    }
}









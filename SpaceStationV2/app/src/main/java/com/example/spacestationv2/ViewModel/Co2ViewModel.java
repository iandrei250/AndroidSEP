package com.example.spacestationv2.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.Model.Co2222;
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.R;
import com.example.spacestationv2.View.Co2Fragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class Co2ViewModel extends ViewModel {
     private Repository repository;
     private LiveData<List<Co2222>> allCo2;
     private Gson gson;
     private Api api;
     private LocalDateTime myDateObj;
     private TextView view;
    public Co2ViewModel() {

        repository= Repository.getInstance();
        view = (TextView) view.findViewById(R.id.retrofit_fragmentco2);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        // OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();
        // myDateObj=LocalDate.parse("2020-05-06");
        System.out.println("WORKSSSSSSSSSS?");
    }
    public LiveData<List<CO2>>getList(){
        return repository.getCo2();
    }
    public void updateList()
    {
        repository.GetCo2();
    }

/*
    public void insert(Co2222 co2222) { repository.insertCo2(co2222); }
    public void update(Co2222 co2222)
    {
        repository.updateCo2(co2222);
    }
    public void delete(Co2222 co2222)
    {
        repository.deleteCo2(co2222);
    }
    public void deleteAllCo2()
    {
        repository.deleteAllCo2();
    }
    /*public LiveData<List<Co2222>> getAllCo2()
    {
        return allCo2;
    }
*/


}

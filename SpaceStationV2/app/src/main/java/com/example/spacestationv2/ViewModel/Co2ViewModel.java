package com.example.spacestationv2.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.R;
import com.example.spacestationv2.View.Co2Fragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;

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
    private MutableLiveData<List<CO2>> mutableLiveData;
    private Gson gson;
    private Api api;
    private LocalDateTime myDateObj;

    public Co2ViewModel() {
        //  repository= Repository.getInstance();
    }

    public void init()
    {
        if (mutableLiveData!=null)
        {
            return;
        }
        repository = Repository.getInstance();
        mutableLiveData = repository.getList("toilet","CO2");
    }
    public LiveData<List<CO2>> getCo2Repo()
    {
        return mutableLiveData;
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

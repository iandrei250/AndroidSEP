package com.example.spacestationv2.Model;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

public class RepositoryTemperature {

    private Gson gson;
    private Api api;
    private LocalDateTime myDateObj;
    private static RepositoryTemperature temperatureInstance;

    public static RepositoryTemperature getInstanceTemperature() {
        if (temperatureInstance == null) {
            temperatureInstance = new RepositoryTemperature();
        }
        return temperatureInstance;
    }

    public RepositoryTemperature() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();

    }

    public MutableLiveData<List<Temperature>> getList(String room, String type) {
        final MutableLiveData<List<Temperature>> temperatureData = new MutableLiveData<>();
        api.getTemperature(room, type).enqueue(new Callback<List<Temperature>>() {
            @Override
            public void onResponse(Call<List<Temperature>> call, Response<List<Temperature>> response) {
                Log.d("HumidityFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    temperatureData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Temperature>> call, Throwable t) {

                System.out.println(t.getMessage());
            }
        });
        return temperatureData;
    }
}









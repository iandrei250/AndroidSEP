package com.example.spacestationv2.View;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.R;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.time.LocalDate;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class Co2Fragment extends Fragment {

    private Gson gson;
    public LocalDate myDateObj;
    private Api api;
    private View rootView;
    private TextView view;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
       // OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        gson=new Gson();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();

        rootView = inflater.inflate(R.layout.fragment_co2, container, false);

        view = (TextView)rootView.findViewById(R.id.retrofit_fragmentco2);
        api = retro.create(Api.class);
        myDateObj = LocalDate.of(2020,05,20);
        myDateObj=LocalDate.parse("2020-05-20");
         System.out.println("WORKSSSSSSSSSS?");

        GetCo2();
        return rootView;


    }

    private void GetCo2()
    {
        Call<CO2> call = api.getCo2();
        System.out.println("C'MON MAN?");


        call.enqueue(new Callback<CO2>() {
            @Override
            public void onResponse(Call<CO2> call, Response<CO2> response) {
                System.out.println("WORKS??");
                System.out.println("WORKS??");
                Log.d("Co2Fragment", "Status Code = " + response.code());
                System.out.println("WORKS??");
                if (!response.isSuccessful()) {
                    view.setText("Code: " + response.code());
                    return;
                }
                System.out.println("NOW WORKSSSS??");
                String momo = response.body() + "}";
                try {

                    CO2 post = gson.fromJson(momo, CO2.class);

                String content = "";
                content += "CO2ID: " + post.getCO2ID() + "\n";
                content += "CO2_value: " + post.getCO2_value() + "\n";
                content += "Date: " + post.getDate() + "\n\n";

                view.append(content);

                }
                catch (IllegalStateException | JsonSyntaxException exception)
                {
                    exception.printStackTrace();
                }
        }

            @Override
            public void onFailure(Call<CO2> call, Throwable t) {

             view.setText("error " + t.toString()+"\n"+ call.request().toString());
            }
        });
    }


}

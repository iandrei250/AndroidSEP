package com.example.spacestationv2.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.Co2;
import com.example.spacestationv2.Model.Co2V;
import com.example.spacestationv2.R;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.time.LocalDate;

public class Co2Fragment extends Fragment {

    private LocalDate myDateObj;
    private Api api;
    private View rootView;
    private TextView view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retro = new Retrofit.Builder().baseUrl("https://localhost:5001/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        rootView = inflater.inflate(R.layout.fragment_co2, container, false);

        view = (TextView)rootView.findViewById(R.id.retrofit_fragmentco2);
        api = retro.create(Api.class);
        myDateObj = LocalDate.now();

        GetCo2();

        return rootView;

    }

    private void GetCo2()
    {
        Call<List<Co2V>> call = api.getCo2(myDateObj, "CO2");
        call.enqueue(new Callback<List<Co2V>>() {
            @Override
            public void onResponse(Call<List<Co2V>> call, Response<List<Co2V>> response) {

                if(!response.isSuccessful())
                {
                    view.setText("Code: " + response.code());
                    return;
                }

                List<Co2V> posts = response.body();

                for(Co2V post : posts )
                {
                    String content = "";
                    content+= "CO2ID: " + post.getCO2ID() + "\n";
                    content+="CO2_value: " + post.getCO2_value() + "\n";
                    content+="Date: " + post.getDate() + "\n\n";

                    view.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Co2V>> call, Throwable t) {

                view.setText(t.getMessage());
            }
        });
    }


}

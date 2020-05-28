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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.Co2ViewModel;
import com.example.spacestationv2.ViewModel.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class Co2Fragment extends Fragment {

    private Gson gson;
    public LocalDateTime myDateObj;
    private Api api;
    private View rootView;
    private TextView view;
    private Co2ViewModel viewModel;
    private Repository repository;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       Co2ViewModel Co2 = new ViewModelProvider(this).get(Co2ViewModel.class);
    //  viewModel= new Co2ViewModel(Co2.getApplication());
        viewModel.getList();
        viewModel.getList().observe(this, new Observer<List<CO2>>() {
            @Override
            public void onChanged(List<CO2> co2s) {
                if(!co2s.isEmpty())
                {
               view.setText("");
               for(CO2 co22:co2s)
               {
                   view.append(co22.getCO2ID()+ "\n");
               }
                }
            }
        });

        rootView = inflater.inflate(R.layout.fragment_co2, container, false);
        return rootView;

    }

    }




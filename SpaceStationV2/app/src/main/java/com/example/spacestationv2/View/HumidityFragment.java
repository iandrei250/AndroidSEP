package com.example.spacestationv2.View;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.Model.RecycleAdapter;
import com.example.spacestationv2.Model.RecycleHumidity;
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.Model.RepositoryHumidity;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.Co2ViewModel;
import com.example.spacestationv2.ViewModel.HumidityViewModel;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.List;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HumidityFragment extends Fragment {


    private HumidityViewModel humidityViewModel;
    private RepositoryHumidity repositoryHumidity;
    private RecyclerView recyclerView;
    private RecycleHumidity adapterHumidity;
    private LayoutInflater inflater;
    private List<Humidity> humidityList;
    private RecyclerView.LayoutManager layoutManager;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_humidity, container, false);

                        humidityViewModel = ViewModelProviders.of(this).get(HumidityViewModel.class);
                        humidityViewModel.init();
                        humidityViewModel.getHumidityRepo().observe(this, new Observer<List<Humidity>>() {
                            @Override
                            public void onChanged(List<Humidity> humidities) {

                                adapterHumidity.setHumidityList(humidities);
                            }


                        });

                        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        adapterHumidity = new RecycleHumidity(getContext(),humidityList );
                        recyclerView.setAdapter(adapterHumidity);

                        return rootView;
                    }
    }







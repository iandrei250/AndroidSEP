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

import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.Model.RecycleHumidity;
import com.example.spacestationv2.Model.RecycleTemperature;
import com.example.spacestationv2.Model.RepositoryHumidity;
import com.example.spacestationv2.Model.RepositoryTemperature;
import com.example.spacestationv2.Model.Temperature;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.HumidityViewModel;
import com.example.spacestationv2.ViewModel.TemperatureViewModel;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class TemperatureFragment extends Fragment {

    private View rootView;
    private TextView view;
    private TemperatureViewModel temperatureViewModel;
    private RepositoryTemperature repositoryHumidity;
    private RecyclerView recyclerView;
    private RecycleTemperature adapterTemperature;
    private LayoutInflater inflater;
    private List<Temperature> temperatureList;
    private RecyclerView.LayoutManager layoutManager;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temperature, container, false);

        temperatureViewModel = ViewModelProviders.of(this).get(TemperatureViewModel.class);
        temperatureViewModel.init();
        temperatureViewModel.getTemperatureRepo().observe(this, new Observer<List<Temperature>>() {
            @Override
            public void onChanged(List<Temperature> temperatures) {

                adapterTemperature.setTemperatureList(temperatures);
            }


        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapterTemperature = new RecycleTemperature(getContext(),temperatureList);
        recyclerView.setAdapter(adapterTemperature);

        return rootView;
    }
}


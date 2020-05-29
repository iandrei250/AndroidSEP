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
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.Co2ViewModel;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.ViewModelProviders;

public class Co2Fragment extends Fragment {

    private Gson gson;
    public LocalDateTime myDateObj;
    private Api api;
    private View rootView;
    private TextView view;
    private Co2ViewModel co2ViewModel;
    private Repository repository;
    private ArrayList<CO2> co2ArrayList = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_co2, container, false);
        view=rootView.findViewById(R.id.retrofit_Fragmentco2);
        co2ViewModel= ViewModelProviders.of(this).get(Co2ViewModel.class);
        co2ViewModel.init();
        co2ViewModel.getCo2Repo().observe(this, new Observer<List<CO2>>() {
            @Override
            public void onChanged(List<CO2> co2s) {
                if (!co2s.isEmpty()) {
                    view.setText("");
                    for (CO2 n : co2s) {
                        String content = "";
                        content += "CO2ID: " + n.getCO2ID() + "\n";
                        content += "CO2_value: " + n.getCO2_value() + "\n";
                        content += "Date: " + n.getDate() + "\n";
                        view.append(content);
                    }
                } else {
                    view.setText("Empty");
                }
            }
        }
        );

        return rootView;

    }

    }





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
import com.example.spacestationv2.Model.RecycleAdapter;
import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.Co2ViewModel;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Co2Fragment extends Fragment {


    private Co2ViewModel co2ViewModel;
    private Repository repository;
    private List<CO2> co2ArrayList;
    private RecyclerView recyclerView;
    private LayoutInflater inflater;
    private RecycleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_co2, container, false);


        co2ViewModel = ViewModelProviders.of(this).get(Co2ViewModel.class);
        co2ViewModel.init();
        co2ViewModel.getCo2Repo().observe(this, new Observer<List<CO2>>() {
            @Override
            public void onChanged(List<CO2> co2s) {

                adapter.setCo2List(co2s);


            }


        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleAdapter(getContext(), co2ArrayList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}





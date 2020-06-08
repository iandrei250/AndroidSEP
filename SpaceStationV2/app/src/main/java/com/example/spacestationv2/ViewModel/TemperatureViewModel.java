package com.example.spacestationv2.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacestationv2.Model.RepositoryTemperature;
import com.example.spacestationv2.Model.Temperature;

import java.util.List;


public class TemperatureViewModel extends ViewModel {
    private RepositoryTemperature repositoryTemperature;
    private MutableLiveData<List<Temperature>> mutableLiveData;


    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        repositoryTemperature = RepositoryTemperature.getInstanceTemperature();
        mutableLiveData = repositoryTemperature.getList("toilet", "Temperature");
    }

    public LiveData<List<Temperature>> getTemperatureRepo() {
        return mutableLiveData;
    }
}
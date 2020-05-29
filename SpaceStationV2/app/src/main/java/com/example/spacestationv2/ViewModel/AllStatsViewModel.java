package com.example.spacestationv2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.spacestationv2.Model.Repository;

import java.util.List;

public class AllStatsViewModel extends AndroidViewModel {
     private Repository repository;

    public AllStatsViewModel(@NonNull Application application) {
        super(application);
       // allCo2 = repository.getAllCo2();
    }
/*
    public void insert(Co2222 co2222)
    {
        repository.insertCo2(co2222);
    }
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
    public LiveData<List<Co2222>> getAllCo2()
    {
        return allCo2;
    }
    */

}

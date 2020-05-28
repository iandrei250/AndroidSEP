package com.example.spacestationv2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spacestationv2.Model.Repository;
import com.example.spacestationv2.Model.Temperature;

import java.util.List;

public class TemperatureViewModel extends AndroidViewModel {
     private Repository repository;
     private LiveData<List<Temperature>> allTemp;

    public TemperatureViewModel(@NonNull Application application) {
        super(application);
        //allTemp = repository.getAllTemp();
    }
/*
    public void insert(Temperature temperature)
    {
        repository.insertTemp(temperature);
    }
    public void update(Temperature temperature)
    {
        repository.updateTemp(temperature);;
    }
    public void delete(Temperature temperature)
    {
        repository.deleteTemp(temperature);
    }
    public void deleteAllHum()
    {
        repository.deleteAllTemp();
    }
    public LiveData<List<Temperature>> getAllTemp()
    {
        return allTemp;
    }

 */
}

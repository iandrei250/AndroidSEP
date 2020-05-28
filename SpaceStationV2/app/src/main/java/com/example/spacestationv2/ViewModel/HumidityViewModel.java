package com.example.spacestationv2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.Model.Repository;

import java.util.List;

public class HumidityViewModel extends AndroidViewModel {
     private Repository repository;
     private LiveData<List<Humidity>> allHumidity;

    public HumidityViewModel(@NonNull Application application) {
        super(application);
     //   allHumidity = repository.getAllHum();
    }
/*
    public void insert(Humidity humidity)
    {
        repository.insertHum(humidity);
    }
    public void update(Humidity humidity)
    {
        repository.updateHum(humidity);
    }
    public void delete(Humidity humidity)
    {
        repository.deleteAllHum();
    }
    public void deleteAllHumidity()
    {
        repository.deleteAllHum();
    }
    public LiveData<List<Humidity>> getAllCo2()
    {
        return allHumidity;
    }

 */
}

package com.example.spacestationv2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spacestationv2.Co2;
import com.example.spacestationv2.Repository;

import java.util.List;

public class Co2ViewModel extends AndroidViewModel {
     private Repository repository;
     private LiveData<List<Co2>> allCo2;

    public Co2ViewModel(@NonNull Application application) {
        super(application);
        allCo2 = repository.getAllCo2();
    }

    public void insert(Co2 co2)
    {

        repository.insertCo2(co2);
    }
    public void update(Co2 co2)
    {
        repository.updateCo2(co2);
    }
    public void delete(Co2 co2)
    {
        repository.deleteCo2(co2);
    }
    public void deleteAllCo2()
    {
        repository.deleteAllCo2();
    }
    public LiveData<List<Co2>> getAllCo2()
    {
        return allCo2;
    }
}

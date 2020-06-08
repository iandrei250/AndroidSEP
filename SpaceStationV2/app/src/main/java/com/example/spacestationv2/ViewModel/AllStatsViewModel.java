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

}

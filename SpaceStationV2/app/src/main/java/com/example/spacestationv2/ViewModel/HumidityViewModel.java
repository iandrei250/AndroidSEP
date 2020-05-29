package com.example.spacestationv2.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.Model.RepositoryHumidity;
import java.util.List;

public class HumidityViewModel extends ViewModel {

    private RepositoryHumidity repositoryHumidity;
    private MutableLiveData<List<Humidity>> mutableLiveData;


    public void init()
    {
        if (mutableLiveData!=null)
        {
            return;
        }
        repositoryHumidity = RepositoryHumidity.getInstanceHumidity();
        mutableLiveData = repositoryHumidity.getList("toilet","Humidity");
    }
    public LiveData<List<Humidity>> getHumidityRepo()
    {
        return mutableLiveData;
    }
    }
package com.example.spacestationv2.Model;

import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class Repository {


    private Gson gson;
    private Api api;
    private LocalDateTime myDateObj;
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Repository() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://10.0.2.2:5001/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();
    }

    public MutableLiveData<List<CO2>> getList(String room, String type) {
        final MutableLiveData<List<CO2>> co2Data = new MutableLiveData<>();
        api.getCo2(room, type).enqueue(new Callback<List<CO2>>() {
            @Override
            public void onResponse(Call<List<CO2>> call, Response<List<CO2>> response) {
                Log.d("Co2Fragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    co2Data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CO2>> call, Throwable t) {

                System.out.println(t.getMessage());

                //  view.setText("error " + t.toString() + "\n" + call.request().toString());
            }
        });
        return co2Data;
    }
    /*
    public LiveData<List<CO2>> getCo2()
    {
        return List;
    }
    public void setCo2(MutableLiveData<List<CO2>> setCo2)
    {
        this.List=setCo2;
    }
    public void retrieveCo2(List<CO2> listCo2) {

        Call<List<CO2>> call = api.getCo2("toilet", "CO2");
        System.out.println("C'MON MAN?");

        call.enqueue(new Callback<List<CO2>>() {
            @Override
            public void onResponse(Call<List<CO2>> call, Response<List<CO2>> response) {
                Log.d("Co2Fragment", "Status Code = " + response.code());
                if (!response.isSuccessful()) {
                   co2Data
                }
                try {

                    // String work = response.body();
                    MutableLiveData<List<CO2>> listOfCo2 = new MutableLiveData<>();
                    listOfCo2.setValue(response.body());
                    setCo2(listOfCo2);
                    for (CO2 post : listOfCo2) {
                        String content = "";
                        content += "CO2ID: " + post.getCO2ID() + "\n";
                        content += "CO2_value: " + post.getCO2_value() + "\n";
                        content += "Date: " + post.getDate() + "\n";

                        view.append(content);
                    }


                } catch (IllegalStateException | JsonSyntaxException exception) {
                    exception.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<List<CO2>> call, Throwable t) {

                view.setText("error " + t.toString() + "\n" + call.request().toString());
            }
        });
    }

     */
}



/*
        Database database = Database.getInstance(application);
        co2Dao = database.co2Dao();
        allCo2=co2Dao.getAllCo2();

        humidityDao = database.humidityDao();
        allHumidity=humidityDao.getAllHumidity();

        temperatureDao = database.temperatureDao();
        allTemperature=temperatureDao.getAllTemperature();
    }

    //CO2 methods
    public void insertCo2(Co2222 co2222)
    {
        new InsertCo2AsyncTask(co2Dao).execute(co2222);
    }

    public void updateCo2(Co2222 co2222)
    {
       new UpdateCo2AsyncTask(co2Dao).execute(co2222);
    }

    public void deleteCo2(Co2222 co2222)
    {
        new DeleteCo2AsyncTask(co2Dao).execute(co2222);
    }

    public void deleteAllCo2()
    {
       new DeleteAllCo2AsyncTask(co2Dao).execute();
    }

    public LiveData<List<Co2222>>getAllCo2()
    {
        return allCo2;
    }

    private static class InsertCo2AsyncTask extends AsyncTask<Co2222,Void,Void>
    {
        private Co2Dao co2Dao;

        private InsertCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2222... co2222s) {
            co2Dao.insertCo2(co2222s[0]);
            return null;
        }
    }

    private static class UpdateCo2AsyncTask extends AsyncTask<Co2222,Void,Void>
    {
        private Co2Dao co2Dao;

        private UpdateCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2222... co2222s) {
            co2Dao.updateCo2(co2222s[0]);
            return null;
        }
    }

    private static class DeleteCo2AsyncTask extends AsyncTask<Co2222,Void,Void>
    {
        private Co2Dao co2Dao;

        private DeleteCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2222... co2222s) {
            co2Dao.deleteCo2(co2222s[0]);
            return null;
        }
    }

    private static class DeleteAllCo2AsyncTask extends AsyncTask<Co2222,Void,Void>
    {
        private Co2Dao co2Dao;

        private DeleteAllCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2222... co2222s) {
            co2Dao.deleteAllCo2();
            return null;
        }
    }


     //Temperature methods
     public void insertTemp(Temperature temperature)
     {
         new InsertTempAsyncTask(temperatureDao).execute(temperature);
     }

    public void updateTemp(Temperature temperature)
    {
        new UpdateTempAsyncTask(temperatureDao).execute(temperature);
    }

    public void deleteTemp(Temperature temperature)
    {
        new DeleteTempAsyncTask(temperatureDao).execute(temperature);
    }

    public void deleteAllTemp()
    {
        new DeleteAllTempAsyncTask(temperatureDao).execute();
    }

    public LiveData<List<Temperature>>getAllTemp()
    {
        return allTemperature;
    }

    private static class InsertTempAsyncTask extends AsyncTask<Temperature,Void,Void>
    {
        private TemperatureDao temperatureDao;

        private InsertTempAsyncTask(TemperatureDao temperatureDao)
        {
            this.temperatureDao=temperatureDao;
        }

        @Override
        protected Void doInBackground(Temperature... temperatures) {
            temperatureDao.insertTemp(temperatures[0]);
            return null;
        }
    }

    private static class UpdateTempAsyncTask extends AsyncTask<Temperature,Void,Void>
    {
        private TemperatureDao temperatureDao;

        private UpdateTempAsyncTask(TemperatureDao temperatureDao)
        {
            this.temperatureDao=temperatureDao;
        }

        @Override
        protected Void doInBackground(Temperature... temperatures) {
            temperatureDao.updateTemp(temperatures[0]);
            return null;
        }
    }

    private static class DeleteTempAsyncTask extends AsyncTask<Temperature,Void,Void>
    {
        private TemperatureDao temperatureDao;

        private DeleteTempAsyncTask(TemperatureDao temperatureDao)
        {
            this.temperatureDao=temperatureDao;
        }

        @Override
        protected Void doInBackground(Temperature... temperatures) {
            temperatureDao.deleteTemp(temperatures[0]);
            return null;
        }
    }

    private static class DeleteAllTempAsyncTask extends AsyncTask<Temperature,Void,Void>
    {
        private TemperatureDao temperatureDao;

        private DeleteAllTempAsyncTask(TemperatureDao temperatureDao)
        {
            this.temperatureDao=temperatureDao;
        }

        @Override
        protected Void doInBackground(Temperature... temperatures) {
            temperatureDao.deleteAllTemperature();
            return null;
        }
    }

    //Humidity methods

    public void insertHum(Humidity humidity)
    {
        new InsertHumAsyncTask(humidityDao).execute(humidity);
    }

    public void updateHum(Humidity humidity)
    {
        new UpdateHumAsyncTask(humidityDao).execute(humidity);
    }

    public void deleteHum(Humidity humidity)
    {
        new DeleteHumAsyncTask(humidityDao).execute(humidity);
    }

    public void deleteAllHum()
    {
        new DeleteAllHumAsyncTask(humidityDao).execute();
    }

    public LiveData<List<Humidity>>getAllHum()
    {
        return allHumidity;
    }
    private static class InsertHumAsyncTask extends AsyncTask<Humidity,Void,Void>
    {
        private HumidityDao humidityDao;

        private InsertHumAsyncTask(HumidityDao humidityDao)
        {
            this.humidityDao=humidityDao;
        }

        @Override
        protected Void doInBackground(Humidity... humidities) {
            humidityDao.insertHum(humidities[0]);
            return null;
        }
    }
    private static class UpdateHumAsyncTask extends AsyncTask<Humidity,Void,Void>
    {
        private HumidityDao humidityDao;

        private UpdateHumAsyncTask(HumidityDao humidityDao)
        {
            this.humidityDao=humidityDao;
        }

        @Override
        protected Void doInBackground(Humidity... humidities) {
            humidityDao.updateHum(humidities[0]);
            return null;
        }
    }
    private static class DeleteHumAsyncTask extends AsyncTask<Humidity,Void,Void>
    {
        private HumidityDao humidityDao;

        private DeleteHumAsyncTask(HumidityDao humidityDao)
        {
            this.humidityDao=humidityDao;
        }

        @Override
        protected Void doInBackground(Humidity... humidities) {
            humidityDao.deleteHum(humidities[0]);
            return null;
        }
    }
    private static class DeleteAllHumAsyncTask extends AsyncTask<Humidity,Void,Void>
    {
        private HumidityDao humidityDao;

        private DeleteAllHumAsyncTask(HumidityDao humidityDao)
        {
            this.humidityDao=humidityDao;
        }

        @Override
        protected Void doInBackground(Humidity... humidities) {
            humidityDao.deleteAllHumidity();
            return null;
        }
    }
*/


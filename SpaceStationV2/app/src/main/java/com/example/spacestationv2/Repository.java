package com.example.spacestationv2;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class Repository {
    private Co2Dao co2Dao;
    private LiveData<List<Co2>> allCo2;

    private HumidityDao humidityDao;
    private LiveData<List<Humidity>> allHumidity;

    private TemperatureDao temperatureDao;
    private LiveData<List<Temperature>> allTemperature;

    public Repository(Application application)
    {
        Database database = Database.getInstance(application);
        co2Dao = database.co2Dao();
        allCo2=co2Dao.getAllCo2();

        humidityDao = database.humidityDao();
        allHumidity=humidityDao.getAllHumidity();

        temperatureDao = database.temperatureDao();
        allTemperature=temperatureDao.getAllTemperature();
    }

    //CO2 methods
    public void insertCo2(Co2 co2)
    {
        new InsertCo2AsyncTask(co2Dao).execute(co2);
    }

    public void updateCo2(Co2 co2)
    {
       new UpdateCo2AsyncTask(co2Dao).execute(co2);
    }

    public void deleteCo2(Co2 co2)
    {
        new DeleteCo2AsyncTask(co2Dao).execute(co2);
    }

    public void deleteAllCo2()
    {
       new DeleteAllCo2AsyncTask(co2Dao).execute();
    }

    public LiveData<List<Co2>>getAllCo2()
    {
        return allCo2;
    }

    private static class InsertCo2AsyncTask extends AsyncTask<Co2,Void,Void>
    {
        private Co2Dao co2Dao;

        private InsertCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2... co2s) {
            co2Dao.insertCo2(co2s[0]);
            return null;
        }
    }

    private static class UpdateCo2AsyncTask extends AsyncTask<Co2,Void,Void>
    {
        private Co2Dao co2Dao;

        private UpdateCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2... co2s) {
            co2Dao.updateCo2(co2s[0]);
            return null;
        }
    }

    private static class DeleteCo2AsyncTask extends AsyncTask<Co2,Void,Void>
    {
        private Co2Dao co2Dao;

        private DeleteCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2... co2s) {
            co2Dao.deleteCo2(co2s[0]);
            return null;
        }
    }

    private static class DeleteAllCo2AsyncTask extends AsyncTask<Co2,Void,Void>
    {
        private Co2Dao co2Dao;

        private DeleteAllCo2AsyncTask(Co2Dao co2Dao)
        {
            this.co2Dao=co2Dao;
        }

        @Override
        protected Void doInBackground(Co2... co2s) {
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

}

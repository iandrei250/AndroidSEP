package com.example.spacestationv2.Model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {Co2.class,Humidity.class, Temperature.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract Co2Dao co2Dao();
    public abstract HumidityDao humidityDao();
    public abstract TemperatureDao temperatureDao();

    public static synchronized Database getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),Database.class,"allStats_database")
                    .fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private Co2Dao co2Dao;

        private PopulateDbAsyncTask(Database db)
        {
            co2Dao=db.co2Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            co2Dao.insertCo2(new Co2(23,45));
            co2Dao.insertCo2(new Co2(50,199));
            co2Dao.insertCo2(new Co2(69,214));
            return null;
        }
    }
}

package com.example.spacestationv2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HumidityDao {

    @Insert
    void insertHum(Humidity humidity);

    @Update
    void updateHum(Humidity humidity);

    @Delete
    void deleteHum(Humidity humidity);

    @Query("DELETE FROM humidity_table")
    void deleteAllHumidity();

    @Query("SELECT * FROM humidity_table")
    LiveData<List<Humidity>> getAllHumidity();
}

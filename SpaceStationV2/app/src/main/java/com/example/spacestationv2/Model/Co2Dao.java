package com.example.spacestationv2.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Co2Dao {

    @Insert
    void insertCo2(Co2222 co2222);

    @Update
    void updateCo2(Co2222 co2222);

    @Delete
    void deleteCo2(Co2222 co2222);

    @Query("DELETE FROM co2_table")
    void deleteAllCo2();

    @Query("SELECT * FROM co2_table")
    LiveData<List<Co2222>> getAllCo2();
}

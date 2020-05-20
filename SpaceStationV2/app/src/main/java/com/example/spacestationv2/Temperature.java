package com.example.spacestationv2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "temperature_table")
public class Temperature {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int TempQuantityToday;

    private int TempQuantityYesterday;

    public Temperature(int TempQuantityToday, int TempQuantityYesterday) {
        this.TempQuantityToday = TempQuantityToday;
        this.TempQuantityYesterday = TempQuantityYesterday;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTempQuantityToday() {
        return TempQuantityToday;
    }

    public int getTempQuantityYesterday() {
        return TempQuantityYesterday;

    }
}

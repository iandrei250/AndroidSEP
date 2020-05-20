package com.example.spacestationv2.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "humidity_table")
public class Humidity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int HumQuantityToday;

    private int HumQuantityYesterday;

    public Humidity(int HumQuantityToday, int HumQuantityYesterday) {
        this.HumQuantityToday = HumQuantityToday;
        this.HumQuantityYesterday = HumQuantityYesterday;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getHumQuantityToday() {
        return HumQuantityToday;
    }

    public int getHumQuantityYesterday() {
        return HumQuantityYesterday;

    }
}

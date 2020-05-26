package com.example.spacestationv2.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "co2_table")
public class Co2 {
    @PrimaryKey(autoGenerate = true)
    private int id;


    private int CO2ID;

    private float CO2_value;



    public int getCO2ID() {
        return CO2ID;
    }

    public float getCO2_value() {
        return CO2_value;
    }


    private int Co2QuantityToday;

    private int Co2QuantityYesterday;

    public Co2(int Co2QuantityToday, int Co2QuantityYesterday) {
        this.Co2QuantityToday = Co2QuantityToday;
        this.Co2QuantityYesterday = Co2QuantityYesterday;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCo2QuantityToday() {
        return Co2QuantityToday;
    }

    public int getCo2QuantityYesterday() {
        return Co2QuantityYesterday;

    }

    public void setCO2ID(int CO2ID) {
        this.CO2ID = CO2ID;
    }

    public void setCO2_value(float CO2_value) {
        this.CO2_value = CO2_value;
    }


}

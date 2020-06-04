package com.example.spacestationv2.Model;

import java.time.LocalDate;
import java.util.Date;

public class CO2 {
    public CO2(int CO2ID, float CO2_value, java.util.Date date) {
        this.CO2ID = CO2ID;
        this.CO2_value = CO2_value;
        Date = date;
    }

    public int CO2ID;

    public float CO2_value;

    public Date Date;


    public int getCO2ID() {
        return CO2ID;
    }


    public float getCO2_value() {
        return CO2_value;
    }

    public Date getDate() {
        return Date;
    }
}

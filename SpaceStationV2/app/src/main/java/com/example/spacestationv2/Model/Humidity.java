package com.example.spacestationv2.Model;


import java.util.Date;


public class Humidity {
    public Humidity(int HUM_ID, float HUM_value) {
        this.HUM_ID = HUM_ID;
        this.HUM_value = HUM_value;
    }

    public int HUM_ID;
    public float HUM_value;
    public Date Date;

    public int getHUM_ID() {
        return HUM_ID;
    }

    public float getHUM_value() {
        return HUM_value;
    }

    public Date getDate() {
        return Date;
    }
}
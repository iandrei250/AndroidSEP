package com.example.spacestationv2.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


public class Humidity {

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
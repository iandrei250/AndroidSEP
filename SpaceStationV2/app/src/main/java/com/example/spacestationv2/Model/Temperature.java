package com.example.spacestationv2.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


public class Temperature {


    public int TEMP_ID;
    public float TEMP_value;
    public Date Date;

    public int getTEMP_ID() {
        return TEMP_ID;
    }

    public float getTEMP_value() {
        return TEMP_value;
    }

    public Date getDate() {
        return Date;
    }
}



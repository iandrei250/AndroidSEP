package com.example.spacestationv2.Model;

import java.io.Serializable;
import java.util.Date;

public class Servo implements Serializable {
    private int SERV_ID;
    private boolean Spinning;
    private Date Date;

    public Servo(int SERV_ID, boolean Spinning, Date Date) {
        this.SERV_ID = SERV_ID;
        this.Spinning = Spinning;
        this.Date = Date;
    }

    public int getSERV_ID() {
        return SERV_ID;
    }

    public boolean getSpinning() {
        return Spinning;
    }

    public Date getDate() {
        return Date;
    }


}
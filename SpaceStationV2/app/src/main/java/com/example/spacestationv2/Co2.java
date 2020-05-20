package com.example.spacestationv2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "co2_table")
public class Co2 {
    @PrimaryKey(autoGenerate = true)
    private int id;

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
}

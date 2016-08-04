package com.teamnexters.ming.entity.id;

import java.io.Serializable;

/**
 * Created by limjuhyun on 7/31/16.
 */

public class wateringId implements Serializable {
    private static final long serialVersionUID = 1L;
    private int date;
    private String water;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
}

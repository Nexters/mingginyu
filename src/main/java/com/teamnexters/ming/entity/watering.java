package com.teamnexters.ming.entity;

import com.teamnexters.ming.entity.id.wateringId;

import javax.persistence.*;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Entity
@Table(name="room")
@IdClass(wateringId.class)
public class watering {

    @Id
    @Column
    private int date;

    @Id
    @Column
    private String water;

    @Column
    private float mos;

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

    public float getMos() {
        return mos;
    }

    public void setMos(float mos) {
        this.mos = mos;
    }
}

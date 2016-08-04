package com.teamnexters.ming.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Entity
@Table(name="room")
public class room {

    @Id
    @Column
    private String datetime;

    @Column
    private float temp;

    @Column
    private float mos;
    
    @Column
    private String mos_level;

    @Column
    private String temp_level;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getMos() {
        return mos;
    }

    public void setMos(float mos) {
        this.mos = mos;
    }

    public String getMos_level() {
        return mos_level;
    }

    public void setMos_level(String mos_level) {
        this.mos_level = mos_level;
    }

    public String getTemp_level() {
        return temp_level;
    }

    public void setTemp_level(String temp_level) {
        this.temp_level = temp_level;
    }
}

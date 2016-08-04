package com.teamnexters.ming.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by limjuhyun on 7/31/16.
 */
@Entity
@Table(name="env")
public class env {

    @Id
    @Column
    private String envkey;


    @Column
    private String envvalue;

    public String getEnvkey() {
        return envkey;
    }

    public void setEnvkey(String envkey) {
        this.envkey = envkey;
    }

    public String getEnvvalue() {
        return envvalue;
    }

    public void setEnvvalue(String envvalue) {
        this.envvalue = envvalue;
    }
}

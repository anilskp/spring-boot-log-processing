package com.askp.springbootlogprocessing;


import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.UUID;




@Table
public class Firewallevent {
    @PrimaryKey
    private UUID id;
    private String eventime;
    private String device;
    private String loginid;
    private String message;


    public Firewallevent() {
        id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }

    public Firewallevent(String eventime, String device, String loginid, String message) {
        this.eventime = eventime;
        this.device = device;
        this.loginid = loginid;
        this.message = message;

    }

    public String getEventime() {
        return eventime;
    }

    public String getDevice() {
        return device;
    }

    public String getLoginid() {
        return loginid;
    }

    public String getMessage() {
        return message;
    }

    //public void setEventime(String eventime) {
    //    this.eventime = eventime;
    //}

    public void setEventime(String eventime) {
        this.eventime = eventime;
    }
    public void setDevice(String device) {
        this.device = device;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}

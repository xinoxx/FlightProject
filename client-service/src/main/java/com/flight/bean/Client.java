package com.flight.bean;

import java.io.Serializable;

public class Client implements Serializable {

    private String cid ;
    private String pwd ;

    public Client(){}

    public Client(String cid, String pwd) {
        this.cid = cid;
        this.pwd = pwd;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}

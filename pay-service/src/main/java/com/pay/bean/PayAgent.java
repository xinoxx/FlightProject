package com.pay.bean;

import java.io.Serializable;

public class PayAgent implements Serializable {

    private String cid ;
    private String pwd ;
    private double balance ;

    public PayAgent() {}

    public PayAgent(String cid, String pwd, double balance) {
        this.cid = cid;
        this.pwd = pwd;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

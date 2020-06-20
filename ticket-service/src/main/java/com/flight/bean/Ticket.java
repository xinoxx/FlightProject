package com.flight.bean;

import java.io.Serializable;

public class Ticket implements Serializable {

    private String tid;
    private double price ;
    private String date ;
    private String arrdate ;
    private int num ;
    private String departure ;
    private String destination ;
    private String aname ;

    public Ticket(){}

    public Ticket(String tid, double price, String date, String arrdate, int num, String departure, String destination , String aname) {
        this.tid = tid;
        this.price = price;
        this.date = date;
        this.arrdate = arrdate;
        this.num = num;
        this.departure = departure;
        this.destination = destination;
        this.aname = aname ;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArrdate() {
        return arrdate;
    }

    public void setArrdate(String arrdate) {
        this.arrdate = arrdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}

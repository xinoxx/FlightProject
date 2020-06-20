package com.flight.service;

import com.pay.bean.PayAgent;

public interface PaymentService {

    public void add(String cid , String pwd ) ;
    public PayAgent find(String cid ) ;
    public void modify(String cid , double balance ) ;
}

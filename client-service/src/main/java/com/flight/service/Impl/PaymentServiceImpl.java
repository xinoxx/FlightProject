package com.flight.service.Impl;

import com.flight.service.PaymentService;
import com.pay.bean.PayAgent;
import com.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PayService payService ;

    @Override
    public void add(String cid, String pwd) {
        payService.addClient(cid,pwd);
    }

    @Override
    public PayAgent find(String cid) {
        return payService.findClient(cid);
    }

    @Override
    public void modify(String cid, double balance) {
        payService.modifyBalance(cid,balance);
    }
}

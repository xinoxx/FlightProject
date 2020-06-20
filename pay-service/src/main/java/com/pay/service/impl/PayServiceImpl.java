package com.pay.service.impl;

import com.pay.bean.PayAgent;
import com.pay.dao.PayDao;
import com.pay.service.PayService;

public class PayServiceImpl implements PayService {
    public void addClient(String cid, String pwd) {

        PayDao payDao = new PayDao() ;
        payDao.addClient(cid,pwd);
        System.out.println("支付提供商：添加用户");
    }

    public PayAgent findClient(String cid) {

        PayDao payDao = new PayDao() ;
        PayAgent payAgent = payDao.findByCid(cid) ;
        System.out.println("支付提供商：查找用户");
        return payAgent;
    }

    public void modifyBalance(String cid, double balance) {

        PayDao payDao = new PayDao() ;
        payDao.modifyBalance(cid,balance);
        System.out.println("支付提供商：修改账户余额");
    }
}

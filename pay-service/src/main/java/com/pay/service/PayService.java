package com.pay.service;

import com.pay.bean.PayAgent;

public interface PayService {

    //添加用户
    public void addClient(String cid , String pwd ) ;
    //查询用户
    public PayAgent findClient(String cid ) ;
    //修改账户余额
    public void modifyBalance(String cid , double balance ) ;
}

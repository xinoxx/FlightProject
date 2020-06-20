package com.flight.service;

import com.flight.bean.Ticket;

import java.util.List;

public interface OrderService {

    //初始化订单
    public List<Ticket> initOrder() ;
    //查询机票：BY地点
    public List<Ticket> findByLocation(String departure , String destination ) ;
    //查询机票：BY tid
    public Ticket findByTid(String tid) ;
    //票数减一
    public void reduceNum(String tid) ;
    //三参数查找
    public List<Ticket> findByT( String date , String departure , String destination ) ;
}

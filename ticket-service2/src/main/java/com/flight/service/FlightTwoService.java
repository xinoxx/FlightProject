package com.flight.service;


import com.flight.bean.Ticket;

import java.util.List;

/**
 * 机票服务
 * @author yxy
 *
 */
public interface FlightTwoService {

    /**
     * 返回全部的机票信息
     * @return
     */
    public List<Ticket> getTicketList() ;
    //查询机票 通过始发地和目的地
    public List<Ticket> findByDe( String departure , String destination ) ;
    //查找单张机票
    public Ticket findByTid( String tid ) ;
    //票数减一
    public void modifyNum( String tid ) ;
    //三参数查找
    public List<Ticket> findByThree( String date , String departure , String destination ) ;
}

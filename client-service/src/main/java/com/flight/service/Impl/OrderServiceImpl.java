package com.flight.service.Impl;


import com.flight.bean.Ticket;
import com.flight.service.FlightService;
import com.flight.service.FlightTwoService;
import com.flight.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    FlightService flightService ;
    @Autowired
    FlightTwoService flightTwoService ;

    @Override
    public List<Ticket> initOrder() {
        List<Ticket> ticketList = flightService.getTicketList() ;
        List<Ticket> ticketList1 = flightTwoService.getTicketList() ;
        ticketList.addAll(ticketList1) ;
        //System.out.println(ticketList);
        return ticketList;
    }

    @Override
    public List<Ticket> findByLocation(String departure , String destination ) {
        List<Ticket> ticketList = flightService.findByDe(departure,destination) ;
        List<Ticket> ticketList1 = flightTwoService.findByDe(departure, destination) ;
        ticketList.addAll(ticketList1) ;
        return ticketList;
    }

    @Override
    public Ticket findByTid(String tid) {
        Ticket ticket = flightService.findByTid(tid) ;
        if( ticket == null ){
            ticket = flightTwoService.findByTid(tid) ;
        }
        return ticket ;
    }

    @Override
    public void reduceNum(String tid) {
        flightService.modifyNum(tid);
        flightTwoService.modifyNum(tid);
    }

    @Override
    public List<Ticket> findByT(String date, String departure, String destination) {
        List<Ticket> ticketList = flightService.findByThree(date, departure, destination) ;
        List<Ticket> ticketList1 = flightTwoService.findByThree(date, departure, destination) ;
        ticketList.addAll(ticketList1) ;
        return ticketList ;
    }

}

package com.flight.service.impl;


import com.flight.bean.Ticket;
import com.flight.service.FlightTwoService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1、将服务提供者注册到注册中心（暴露服务）
 *    （1 导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 *    （2 配置服务提供者
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */

public class FlightTwoServiceImpl implements FlightTwoService {

    private List<Ticket> ticketList = new ArrayList<Ticket>();
    public List<Ticket> getTicketList() {

        if( ticketList.size() == 0 ) {
            //偷懒不写数据库。。。
            addTicket(1, 8, "GZ", "SZ", 800, 80, "2020-06-15 ");
            addTicket(9, 16, "SZ", "BJ", 1000, 40, "2020-06-16");
            addTicket(17, 24, "GY", "SH", 600, 60, "2020-06-18 ");
        }
        System.out.println("获取全部的航班列表");
        return ticketList ;
    }

    public List<Ticket> findByDe( String departure , String destination ){
        if( ticketList.size() == 0 ) {
            ticketList = getTicketList();
        }
        List<Ticket> ticketList1 = new ArrayList<>();
        for( Ticket ticket1 : ticketList ){
            if( ticket1.getDeparture().equals(departure) && ticket1.getDestination().equals(destination)){
                ticketList1.add(ticket1) ;
            }
        }
        System.out.println("通过地点查询，获取列表:" + departure + " " + destination );
        System.out.println(ticketList1);
        return ticketList1 ;
    }

    @Override
    public Ticket findByTid(String tid) {
        if( ticketList.size() == 0 ) {
            ticketList = getTicketList();
        }
        Ticket ticket = new Ticket() ;
        for( Ticket ticket1 : ticketList){
            if( ticket1.getTid().equals(tid)){
                ticket = ticket1 ;
                break ;
            }
        }
        return ticket ;
    }

    @Override
    public void modifyNum(String tid) {
        if( ticketList.size() == 0 ) {
            ticketList = getTicketList();
        }
        for( Ticket ticket1 : ticketList){
            if( ticket1.getTid().equals(tid)){
                int num = ticket1.getNum() ;
                ticket1.setNum(num-1) ;
                break ;
            }
        }
    }

    @Override
    public List<Ticket> findByThree(String date, String departure, String destination) {
        if( ticketList.size() == 0 ) {
            ticketList = getTicketList();
        }
        List<Ticket> ticketList1 = new ArrayList<>() ;
        System.out.println("date:" + date + " " + departure + " " + destination );
        for( Ticket ticket : ticketList ){
            String d = ticket.getDate().substring(0,10) ;
            System.out.println("时间：" + d + " " + date );
            if( d.equals(date) && ticket.getDeparture().equals(departure) && ticket.getDestination().equals(destination )){
                System.out.println("就没相同的？我不信");
                ticketList1.add(ticket) ;
            }
        }
        System.out.println("findByThree" + ticketList1 + " size " + ticketList1.size() );
        return ticketList1;
    }

    private void addTicket(int fi , int en , String departure , String destination , double price , int num , String day ){
        String id = "000" ;
        String hour = "06" ;
        for( int i = fi ; i <= en ; i++ ){
            String tid = id + Integer.toString(i) ;
            String date = day + hour + ":00" ;
            int h = Integer.parseInt(hour) ;
            h += 2 ;
            String arrdate = day ;
            if( h < 10 ) {
                arrdate += "0" + Integer.toString(h) ;
                hour = "0" + Integer.toString(h) ;
            }else{
                arrdate += Integer.toString(h) ;
                hour = Integer.toString(h) ;
            }
            arrdate += ":00" ;
            Ticket ticket = new Ticket(tid,price,date,arrdate,num,departure,destination,"FLIGHT-B") ;
            //System.out.println(date + " " + arrdate);
            ticketList.add(ticket) ;
        }
    }
}

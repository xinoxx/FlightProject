package com.flight;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

    private String PATH = "" ;
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml") ;
        context.start();
        /*FlightService flightService = new FlightServiceImpl() ;
        flightService.getTicketList() ;*/
        System.out.println("hello world");
        System.in.read() ;
    }
}

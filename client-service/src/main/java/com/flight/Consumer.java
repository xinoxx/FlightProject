package com.flight;

import com.flight.service.OrderService;
import com.flight.service.PaymentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {

    public static ClassPathXmlApplicationContext applicationContext ;
    public static PaymentService paymentService ;
    public static OrderService orderService ;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml") ;
        OrderService orderService = applicationContext.getBean(OrderService.class) ;
        orderService.initOrder();
        System.in.read() ;
    }

    public static void connect(){
        System.out.println("远程连接注册中心");
        applicationContext = new ClassPathXmlApplicationContext("consumer.xml") ;
        paymentService = applicationContext.getBean(PaymentService.class);
        orderService = applicationContext.getBean(OrderService.class) ;
    }
}

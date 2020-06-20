package com.pay;

import com.pay.bean.PayAgent;
import com.pay.service.PayService;
import com.pay.service.impl.PayServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml") ;
        context.start();
        /*PayService payService = new PayServiceImpl() ;
        PayAgent pay = new PayAgent() ;
        pay = payService.findClient("yxy") ;
        System.out.println("测试查询功能:"+pay.getPwd());
        payService.addClient("yxy1" , "yxy");
        payService.modifyBalance("yxy" , 500);*/
        System.in.read() ;
    }
}

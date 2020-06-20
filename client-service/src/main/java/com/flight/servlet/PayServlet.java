package com.flight.servlet;

import com.flight.Consumer;
import com.flight.bean.Ticket;
import com.pay.bean.PayAgent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String tid = request.getParameter("tid") ;
        Ticket ticket = new Ticket() ;
        //获取ticket信息 票数减一 账户余额扣钱
        ticket = Consumer.orderService.findByTid(tid) ;

        //是否购买成功消息提示
        String result = "" ;
        HttpSession session = request.getSession() ;
        String cid = (String)session.getAttribute("cid") ;
        PayAgent pay = Consumer.paymentService.find(cid) ;
        double balance = pay.getBalance() ;
        if( balance >= ticket.getPrice() ){
            Consumer.orderService.reduceNum(tid);
            balance -= ticket.getPrice() ;
            Consumer.paymentService.modify(cid,balance);
            result = "支付成功！余额为：" + balance ;

        }else{
            result = "支付失败，余额不足！" ;
        }

        request.setAttribute("result" , result );
        request.setAttribute("ticket" , ticket );
        request.getRequestDispatcher("showPayResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}

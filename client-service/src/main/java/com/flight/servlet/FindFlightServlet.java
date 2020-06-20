package com.flight.servlet;

import com.flight.Consumer;
import com.flight.bean.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindFlightServlet")
public class FindFlightServlet extends HttpServlet {

    @SuppressWarnings("resource")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String departure = request.getParameter("departure") ;
        String destination = request.getParameter("destination") ;
        String date = request.getParameter("date") ;

        List<Ticket> ticketList = new ArrayList<>() ;
        //showFlightInfo.jsp查询按钮获取机票信息
        if( date.equals("searchFlight")){

            //两个提供商的机票都要查
            System.out.println("远程连接，获取查找到的航班信息");
            ticketList = Consumer.orderService.findByLocation(departure,destination) ;
            System.out.println(ticketList);
        }
        //showFlightInfo.jsp订票按钮
        else if(date.equals("flightList")){
            String tid = request.getParameter("tid") ;
            Ticket ticket = new Ticket() ;
            //获取该票信息
            ticket = Consumer.orderService.findByTid(tid) ;

            request.setAttribute("ticket" , ticket );
            request.getRequestDispatcher("showOrder.jsp").forward(request,response);
        }
        //orderFlight.jsp提交按钮获取机票信息
        else{
            //以这三个参数为主，调取TicketDao查询机票信息，返回List
            System.out.println(date);
            System.out.println("远程连接，获取通过三个值查找航班信息");
            ticketList = Consumer.orderService.findByT(date,departure,destination) ;
            System.out.println(ticketList);
        }

        request.setAttribute("ticketList" , ticketList ) ;
        request.getRequestDispatcher("showFlightInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}

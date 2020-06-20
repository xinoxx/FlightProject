package com.flight.servlet;

import com.flight.Consumer;
import com.flight.bean.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SortServlet")
public class SortServlet extends HttpServlet {

    @SuppressWarnings("resource")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String type = request.getParameter("type") ;

        List<Ticket> ticketList = Consumer.orderService.initOrder() ;

        if( type.equals("time")){
            System.out.println("时间排序");
        }else if( type.equals("num")){
            System.out.println("数量排序");
            ticketList.sort(new Comparator<Ticket>() {
                @Override
                public int compare(Ticket o1, Ticket o2) {
                    Integer i1 = o1.getNum() ;
                    Integer i2 = o2.getNum() ;
                    return i2.compareTo(i1) ;
                }
            });
        }

        request.setAttribute("ticketList" , ticketList );
        request.getRequestDispatcher("showFlightInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

}

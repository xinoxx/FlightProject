package com.flight.servlet;

import com.flight.Consumer;
import com.flight.bean.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowFlightServlet")
public class ShowFlightServlet extends HttpServlet {

    @SuppressWarnings("resource")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Ticket> ticketList = Consumer.orderService.initOrder() ;
        request.setAttribute("ticketList" , ticketList );
        request.getRequestDispatcher("showFlightInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}

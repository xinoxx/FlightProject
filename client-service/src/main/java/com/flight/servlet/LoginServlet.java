package com.flight.servlet;

import com.flight.Consumer;
import com.flight.bean.Client;
import com.flight.dao.ClientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @SuppressWarnings("resource")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;

        String cid = request.getParameter("cid") ;
        String pwd = request.getParameter("pwd") ;
        System.out.println("获取表单数据，当前用户：" + cid + " 密码：" + pwd );

        ClientDao clientDao = new ClientDao() ;
        Client client = clientDao.findClientByCid(cid) ;
        System.out.println("查找本地数据库");

        //存入session
        HttpSession session = request.getSession() ;
        if( client.getPwd()==null){

            //将新用户添加至数据库
            clientDao.addClient(cid,pwd);
            System.out.println("添加新用户");

            //自动给新用户创建支付账户 初始金额1000元
            //访问注册中心
            Consumer.connect();

            System.out.println("远程连接，连接支付提供商，添加用户");
            Consumer.paymentService.add(cid,pwd);
            System.out.println("添加Pay新用户");

            session.setAttribute("cid" , cid );
            session.setAttribute("pwd" , pwd );
            out.println("<script>alert('您是新用户，自动注册成功！');window.location.href='mainPage.jsp'</script>");
        }else if( client.getPwd().equals(pwd)) {

            //访问注册中心
            Consumer.connect();

            session.setAttribute("cid" , cid );
            session.setAttribute("pwd" , pwd );
            out.println("<script>alert('登录成功！欢迎您！');window.location.href='mainPage.jsp'</script>");
        }else{
            out.println("<script>alert('密码错误！登录失败！');window.location.href='login.jsp'</script>");
        }
        System.out.println("连接数据库，获得数据库的用户密码：" + client.getPwd());
        //request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);

    }
}

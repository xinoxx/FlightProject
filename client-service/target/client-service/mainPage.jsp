<%--
  Created by IntelliJ IDEA.
  User: llmz
  Date: 2020/6/15
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>mainPage</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="message frame">
    <div class="login-head">
        <h1>FIGHT</h1>
    </div>
    <form class="form" >
        <button class="button-submit" type="button" style="margin-left: 12%;" onclick="window.location.href='/showFlightInfo'">查看航班信息</button>
        <button class="button-submit" type="button" style="margin-left: 15%;" onclick="window.location.href='orderFlight.jsp'">填写订单信息</button>
        <div class="clear">  </div>
    </form>
</div>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: llmz
  Date: 2020/6/15
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>showOrder</title>
    <meta charset="utf-8">
    <title>main</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="message frame1">
    <div class="login-head">
        <h1>订单信息</h1>
    </div>
    <form action="/payTicket" method="post" class="form">
        <li class="form-li">
            <div class="show_text">
                乘客：${sessionScope.cid}
            </div>
        </li>
        <li class="form-li">
            <div class="show_text">
                始发地：${ticket.departure}
            </div>
        </li>
        <li class="form-li">
            <div class="show_text">
                目的地：${ticket.destination}
            </div>
        </li>
        <li class="form-li">
            <div class="show_text">
                出发时间：${ticket.date}
            </div>
        </li>
        <li class="form-li">
            <div class="show_text">
                预计到达时间：${ticket.arrdate}
            </div>
        </li>
        <li class="form-li">
            <div class="show_text">
                价格：${ticket.price}元
            </div>
        </li>
        <div class="submit" >
            <input type="hidden" name="tid" value="${ticket.tid}">
            <input type="submit" value="支付" >
            <h4><a href="/showFlightInfo">返回</a></h4>
            <div class="clear">  </div>
        </div>

    </form>
</div>
</body>
</html>

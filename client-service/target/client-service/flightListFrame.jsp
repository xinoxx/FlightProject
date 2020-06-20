<%@ page import="com.sun.javaws.IconUtil" %><%--
  Created by IntelliJ IDEA.
  User: llmz
  Date: 2020/6/16
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>listIframe</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form action="/findFlight" method="post" class="form">
    <c:forEach items="${ticketList}" var="ticket">
        <li class="form-li">
            <div class="show_text1">
                ◆始发地：${ticket.departure}&emsp;◆目的地：${ticket.destination}&emsp;◆出发时间：${ticket.date}&emsp;◆票价：${ticket.price}元&emsp;◆数量：${ticket.num}&emsp;◆提供商：${ticket.aname}
                <input type="hidden" name="date" value="flightList" >
                <input type="hidden" name="tid" value="${ticket.tid}" >
                <button type="submit" class="button-submit1" style="float: right;">订票</button>
            </div>
        </li>
    </c:forEach>

    <div class="submit">
        <h4><a href="#" style="float: right;">回到顶部</a></h4>
    </div>
</form>
</body>
</html>

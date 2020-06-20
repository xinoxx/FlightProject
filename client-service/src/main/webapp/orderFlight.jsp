<%--
  Created by IntelliJ IDEA.
  User: llmz
  Date: 2020/6/15
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>orderFlight</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div class="message frame">
    <div class="login-head">
        <h1>填写信息&emsp;&emsp;始发地&nbsp;-&nbsp;目的地&nbsp;-&nbsp;出发日期</h1>
    </div>
    <form action="/findFlight" method="post" class="form">
        <li class="form-li">
            <input type="text" class="input-text" name="departure" value="输入始发地" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入始发地';}" >
        </li >
        <div class="clear"> </div>
        <li class="form-li">
            <input type="text" class="input-text" name="destination" value="输入目的地" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入目的地';}">
        </li>

        <li class="form-li">
            <input type="date" class="input-text" name="date" value="2020-06-19" >
        </li>
        <div class="clear"> </div>
        <div class="submit" >
            <input type="submit" value="提交" >
            <h4><a href="mainPage.jsp">回到主页</a></h4>
            <div class="clear">  </div>
        </div>

    </form>
</div>
</body>
</html>

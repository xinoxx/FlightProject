<%--
  Created by IntelliJ IDEA.
  User: llmz
  Date: 2020/6/14
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flight-Login</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>Flight-Login</h1>
        </div>
        <form action="/login" method="post" class="form">
            <li class="form-li">
                <input type="text" class="input-text" name="cid" value="Username"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'username';}"><a class=" icon user"></a>
            </li>
            <div class="clear"> </div>
            <li class="form-li">
                <input type="password" name="pwd" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}"> <a class="icon lock"></a>
            </li>
            <div class="clear"> </div>
            <div class="submit">
                <input type="submit" value="登录/注册" >
                <div class="clear">  </div>
            </div>

        </form>
    </div>
</div>
</div>
<div class="clear"> </div>
<!--- footer --->
<div class="footer">
    <p>Flight &copy; 2020.06</p>
</div>
</body>
</html>

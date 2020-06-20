<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>test</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	</head>
	
	<%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" type="text/javascript">
		/*选择排序在iframe跳转不同的网页*/
		function option_url(opt){
			var url = opt.options[opt.selectedIndex].value ;
			if( url != "" ){
				open(url,'iframe-flight') ;
				/* opt.selectedIndex = 0 ; */
				opt.blur() ;
				/* document.getElementById("select")[opt.selectedIndex].selected=true ; */
			}
		}
		
		/*设置iframe高度自适应*/
		function setIframeHeight(iframe){
			if( iframe ){
				var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
				if( iframeWin.document.body ){
					iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight ;
				}
			}
		}
		
		window.onload = function(){
			setIframeHeight(document.getElementById('iframe') ) ;
		};

	</script>--%>

	<script>
		function sele(sobj){
			if( sobj.selectedIndex == 0 )
				document.all.select.options[0].selected=true ;
			var url = sobj.options[sobj.selectedIndex].value;
			if( url!=""){
				open(url , '_self') ;
				sobj.blur() ;
			}
		}
	</script>
	
	<body>
		<div class="message frame2">
			<div class="login-head">
				<a href="mainPage.jsp" class="icon1" style="margin-left: 2%;"></a>
				<h1>FIGHT INFO</h1>
				<br /><br />
				<form action="/findFlight" method="post" >
					<li style="list-style: none;">
					&emsp;
					<font class="font-text">查询机票</font>&emsp;
					<input type="text" name="departure" value="输入起始地" class="input-style" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入始发地';}"/>&emsp;
					<input type="text" name="destination" value="输入目的地" class="input-style" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入目的地';}">&emsp;
						<input type="hidden" name="date" value="searchFlight">
						<button type="submit" class="button-submit2">查询</button>
					</li>
					<li style="list-style: none;">
						&emsp;
						<font class="font-text">排序方式</font>&emsp;
						<select name="select" class="selet-style" onchange=sele(this)  >
							<option value="http://localhost:8080//sort?type=time" >时间递增</option>
							<option value="http://localhost:8080//sort?type=num" >票数递减</option>
						</select>
					</li>
				</form>

			</div>

			<form action="/findFlight" method="post" class="form" id="form">
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

			<%--<iframe  width="100%"  scrolling="no" src="flightListFrame.jsp?ticketList=哈哈" name="iframe-flight" id="iframe" onload="setIframeHeight(this)"></iframe>--%>
		</div>
	</body>

</html>

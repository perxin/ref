<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Ref</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	contextPath = '<%=request.getContextPath()%>';
</script>
<link href="<%=request.getContextPath()%>/media/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/media/css/ring/ring.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/media/css/custom/custom.css" rel='stylesheet' type='text/css' />
<script src="<%=request.getContextPath()%>/media/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/media/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/media/js/ring/chat.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/media/js/ring/ring.js"></script>
</head>
<body>
<div class="app app-header-fixed" id="app">
	<jsp:include page="../navbar.jsp" />

<div class="panel-chat-div">
<div class="chat-div">
	<div class="panel panel-default">
		<div class="panel-heading">小ring</div>
		<div data-role="content" id="convo" data-from="Sonu Joshi">
			<div class="chat-msg-list" id="chatList">
				<ul id="res" class="chat-thread">
					<li style="display: none;"></li>
					<li>Hello!我是小ring ~_~</li>
				</ul>
			</div>
			<textarea id="info" class="chat-textarea"></textarea>
			<br />
			<div class="btn-group chat-send-div">
				<button id="chat-send" type="button"
					class="chat-send-btn btn btn-default dropdown-toggle"
					onclick="doSubmit();">
					发送
					<!-- <span class="caret"></span> -->
				</button>
			</div>
		</div>
	</div>
	</div>
	</div>

	<!--start-footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-main">
				<div class="col-md-4 footer-left">
					<!-- <span class="glyphicon glyphicon-map-marker map-marker"
						aria-hidden="true"></span> -->
					<p>
						<span>IC</span>
					</p>
				</div>
				<div class="col-md-4 footer-left">
					<!-- <span class="glyphicon glyphicon-phone map-marker"
						aria-hidden="true"></span>
					<p> </p> -->
				</div>
				<div class="col-md-4 footer-left">
					<p class="footer-class">
						<a href="#" target="_blank" title="联系我们">联系我们</a><br> 
						<a href="#" target="_blank" title="联系我们">pengxin1021@foxmail.com</a>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				var defaults = {
					containerID : 'toTop', // fading element id
					containerHoverID : 'toTopHover', // fading element hover id
					scrollSpeed : 1200,
					easingType : 'linear'
				};

			});
		</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;">
			<span id="toTopHover" style="opacity: 1;"> </span>
		</a>
	</div>
	<!--end-footer-->
</body>
</html>
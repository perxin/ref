<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>IC</title>
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
<script src="<%=request.getContextPath()%>/media/js/user/user.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navigation navbar-brand" style="margin-left: 55px;"
					href="#">IC</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
				</ul>
				
				<%String name = (String)session.getAttribute("name");
					if(name == null){
						%>
							<ul class="nav navbar-nav navbar-right">
								<li class="nav-login-regist"><a href="<%=request.getContextPath()%>/login">登录 <span class="sr-only">(current)</span></a></li>
								<li class="nav-login-regist"><a href="<%=request.getContextPath()%>/regist">注册 <span class="sr-only">(current)</span></a></li>
							</ul>
						<% 
					}else{
						%>
							<ul class="nav navbar-nav navbar-right">
								<li class="nav-login-regist nar-btn"><a href="#">
						<%
								out.print(name);
						%>
								<div class="list-group list">
									<a href="#" class="list-group-item" id="signOut">退出</a>
								</div>
								<span class="sr-only">(current)</span></a></li>
							</ul>
						<%
					}
				%>
			</div>
			<!-- /.navbar-collapse -->
			<%-- <c:if test="${empty userBind}">
				<div class="collapse navbar-collapse nav-btn-right nav-login-regist" >
					<ul class="nav navbar-nav">
						<li class="active"><a href="<%=request.getContextPath()%>/regist">注册 <span class="sr-only">(current)</span></a></li>
					</ul>
				</div>
				<div class="collapse navbar-collapse nav-btn-right nav-login-regist" >
					<ul class="nav navbar-nav">
						<li class="active"><a href="<%=request.getContextPath()%>/login">登录 <span class="sr-only">(current)</span></a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty userBind && not empty userBind.name}">
				${userBind.name}
			</c:if> --%>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="row search-row">
		<div class="col-lg-6 search-div">
			<form action="" method="get" role="search">
				<div class="input-group">
					<input name="searchkey" type="text" class="form-control search-input" placeholder="Search for..."> 
					<input name="sort" type="hidden" value=""> 
					<span class="input-group-btn">
						<button id="submitsearch" class="btn btn-default search-input" type="submit">search</button>
					</span>
				</div>
			</form>
		</div>
	</div>
	
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
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<script type="text/javascript">
	contextPath = '<%=request.getContextPath()%>';
</script>

<link href="<%=request.getContextPath()%>/media/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/media/css/user/login.css" rel="stylesheet" media="screen" type="text/css" />
<script src="<%=request.getContextPath()%>/media/js/user/user.js" type="text/javascript"></script>
</head>

<body class="login-page">
	<div class="login-form">
		<div class="login-content">
			<div class="form-login-error">
				<h3>Invalid login</h3>
				<p>
					Enter <strong>demo</strong>/<strong>demo</strong> as login and
					password.
				</p>
			</div>
			<form id="regist-form" action="<%=request.getContextPath()%>/user/register" role="form" method="post" onsubmit="return false;">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-user"></i>
						</div> 
						<input type="text" class="form-control" placeholder="Name" name="name" id="name">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-key"></i>
						</div>
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Password" autocomplete="off" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-key"></i>
						</div>
						<input type="password" class="form-control" name="passwordConfirm"
							id="passwordConfirm" placeholder="ConfirmPassword" autocomplete="off" />
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block btn-login">
						<i class="fa fa-sign-in"></i> Register
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

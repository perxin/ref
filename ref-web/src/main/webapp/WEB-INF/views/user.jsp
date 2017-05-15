<%@ page language="java" import="com.ref.model.user.User" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.ref.model.user.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>阅读论坛</title>
    <meta name="description" content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/animate.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/simple-line-icons.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/app.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/custom/custom.css" type="text/css" />
    <script type="application/javascript" src="<%=request.getContextPath()%>/media/js/user/custom.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/media/js/edit.js"></script>
</head>
<body>
<div class="app app-header-fixed" id="app">
    <jsp:include page="navbar.jsp" />

    <hr style="margin: 1px;">
    <!-- content -->
    <div class="app-content navbar-collapse">
        <div class="app-content-body fade-in-up content" style="width: 80%;">
            <!-- COPY the content from "tpl/" -->
            <div class="padder">
                <% User user = (User) request.getAttribute("user");
                    int totalIntegral = (int) request.getAttribute("totalIntegral");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                %>
                <div class="list-group" style="margin-top: 30px">
                    <a href="#" class="list-group-item active">
                        个人信息
                    </a>
                    <a href="#" class="list-group-item">用户名：<% out.print(user.getName());%></a>
                    <a href="#" class="list-group-item">总积分：<% out.print(totalIntegral);%></a>
                    <a href="#" class="list-group-item">用户ID：<% out.print(user.getId());%></a>
                    <a href="#" class="list-group-item">用户等级：<% out.print(totalIntegral / 100 + 1);%></a>
                    <a href="#" class="list-group-item">注册日期：<% out.print(sdf.format(user.getCreateDate()));%></a>
                    <a href="<%=request.getContextPath()%>/integral?pageNum=1&pageSize=10" class="list-group-item" style="color: deepskyblue;">查看我的积分记录</a>
                    <a href="<%=request.getContextPath()%>/note/notePage?userId=<% out.print(user.getId());%>" class="list-group-item" style="color: deepskyblue;">查看我的文章</a>
                </div>
            </div>
            <!-- /content -->

            <jsp:include page="footer.jsp" />
</body>
</html>
<%@ page language="java" import="com.ref.form.note.NoteAllForm" pageEncoding="utf-8"%>
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

    <!-- content -->
    <div class="app-content navbar-collapse">
        <div ui-butterbar></div>
        <a href class="off-screen-toggle hide" data-toggle="class:off-screen" data-target=".app-aside" ></a>
        <div class="app-content-body fade-in-up content" style="width: 80%;">
            <!-- COPY the content from "tpl/" -->
            <div class="padder">
                <% NoteAllForm note = (NoteAllForm) request.getAttribute("noteAllForm"); %>
                <div class="panel panel-warning">
                    <div class="panel-heading note">
                        <% out.print(note.getName());%>
                        <%--<button onclick="noteEdit(<%out.print(note.getId());%>)" type="button" class="btn btn-info edit-edit" aria-haspopup="true" aria-expanded="false">编辑</button>--%>
                    </div>
                    <ul class="list-group">
                        <%--<li class="list-group-item"><% out.print(note.getCreateDate());%></li>--%>
                        <li class="list-group-item">描述：<% out.print(note.getDescription());%></li>
                    </ul>
                    <div class="panel-body">
                        <% out.print(note.getContent());%>
                    </div>
                </div>
            </div>
            <!-- /content -->

            <jsp:include page="footer.jsp" />
</body>
</html>
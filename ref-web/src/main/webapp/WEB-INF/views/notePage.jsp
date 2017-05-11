<%@ page language="java" import="com.ref.form.note.NoteAllForm" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="java.util.List" %>
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
                <div class="panel panel-warning note-content" style="height: 120px;">
                    <div class="search">
                        <div class="input-group">
                            <input id="note-title-search" type="input" class="form-control" placeholder="输入文章标题搜索" aria-describedby="basic-addon2">
                            <span class="input-group-addon" id="basic-addon2" onclick="searchNote(1);">搜索</span>
                        </div>
                    </div>
                </div>
                <% PageInfo<NoteAllForm> pageInfo = (PageInfo) request.getAttribute("page"); %>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>文章</th>
                        <th>作者</th>
                        <th>浏览数</th>
                        <th>点赞数</th>
                        <th>评论数</th>
                        <th>创建日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        List<NoteAllForm> list = pageInfo.getList();
                        for (NoteAllForm note : list) {
                    %>
                    <tr>
                        <td><a href="<%=request.getContextPath()%>/note?id=<% out.print(note.getId());%> " style="color: #00a2d4"><% out.print(note.getName());%></a></td>
                        <td><% out.print(note.getUserName());%></td>
                        <td><% out.print(note.getViews());%></td>
                        <td><% out.print(note.getPraiseNumber());%></td>
                        <td><% out.print(note.getComments());%></td>
                        <td><% out.print(sdf.format(note.getCreateDate()));%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <%
                            int[] num = pageInfo.getNavigatepageNums();
                            for (int i = 0; i < num.length; i ++) {
                        %>
                        <li><a href="javascript:void(0);" onclick="searchNote(<%out.print(num[i]);%>);"><%out.print(num[i]);%></a></li>
                        <%
                            }
                        %>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <!-- /content -->

            <jsp:include page="footer.jsp" />
</body>
</html>
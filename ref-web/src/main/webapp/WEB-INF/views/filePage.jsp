<%@ page language="java" import="com.ref.model.user.IntegralRecord" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ref.model.system.File" %>
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
                <% PageInfo<File> pageInfo = (PageInfo) request.getAttribute("page"); %>
                <table class="table table-bordered table-striped" style="margin-top: 30px;">
                    <thead>
                    <tr>
                        <th>文件名</th>
                        <th>文件大小</th>
                        <th>上传人</th>
                        <th>上传时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        List<File> list = pageInfo.getList();
                        for (File record : list) {
                    %>
                    <tr>
                        <td style="color: #00b7ee"><a href="<%=request.getContextPath()%>/download?id=<% out.print(record.getId());%>"  ><% out.print(record.getFileName());%></a></td>
                        <td><% out.print(record.getFileSize());%></td>
                        <td>
                            <% out.print(record.getUserName());%>
                        </td>
                        <td><% out.print(sdf.format(record.getCreateDate()));%></td>
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
                        <li><a href="javascript:void(0);" onclick="integralPage(<%out.print(num[i]);%>);"><%out.print(num[i]);%></a></li>
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
                <div class="list-group" style="margin-top: 30px">
                    <form id="uploadFileForm" <%--action="<%=request.getContextPath()%>/upload"--%> <%--method="post" enctype="multipart/form-data"--%>>
                        <input type="file" name="file" />
                        <input type="button" value="上传文件" onclick="uploadFile()"/>
                    </form>
                </div>
            </div>
            <!-- /content -->

            <jsp:include page="footer.jsp" />
</body>
</html>
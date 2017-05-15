<%@ page language="java" import="com.ref.form.note.NoteAllForm" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <!-- content -->
    <div class="app-content navbar-collapse">
        <div ui-butterbar></div>
        <a href class="off-screen-toggle hide" data-toggle="class:off-screen" data-target=".app-aside" ></a>
        <div class="app-content-body fade-in-up content" style="width: 80%;">
            <!-- COPY the content from "tpl/" -->
            <div class="padder">
                <% NoteAllForm note = (NoteAllForm) request.getAttribute("noteAllForm"); %>
                <div class="panel panel-warning note-content">
                    <div class="panel-heading note">
                        <% out.print(note.getName());%>
                        <%--<button onclick="noteEdit(<%out.print(note.getId());%>)" type="button" class="btn btn-info edit-edit" aria-haspopup="true" aria-expanded="false">编辑</button>--%>
                        <a href class="text-muted m-xs right">
                            <%
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                out.print(sdf.format(note.getUpdateDate()));
                            %>
                        </a>
                    </div>
                    <ul class="list-group">
                        <%--<li class="list-group-item"><% out.print(note.getCreateDate());%></li>--%>
                        <li class="list-group-item">描述：<% if (note.getDescription() != null) out.print(note.getDescription());%></li>
                    </ul>
                    <div class="panel-body">
                        <% out.print(note.getContent());%>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <ul class="nav nav-pills nav-sm">
                                <li style="float: right"><a href class="text-muted m-xs"><i class="icon-eyeglasses"></i> <% out.print(note.getViews());%> </a></li>
                                <li style="float: right"><a href class="text-muted m-xs"><i class="icon-fire"></i> <% out.print(note.getPraiseNumber());%> </a></li>
                                <li style="float: right"><a href class="text-muted m-xs"><i class="icon-note"></i> <% out.print(note.getComments());%> </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <%
                    if (note.getCommentList() != null) {
                        for (int i = 0; i < note.getCommentList().size(); i ++) {
                %>
                          <div class="streamline b-l b-info m-l-lg m-b padder-v">
                            <div>
                                <div class="m-l-lg">
                                    <div class="m-b-xs">
                                        <a href class="h4"><%out.print(note.getCommentList().get(i).getUserName());%></a>
                                        <span class="text-muted m-l-sm pull-right">
                                            <% out.print(sdf.format(note.getCommentList().get(i).getCreateDate()));%>
                                        </span>
                                    </div>
                                    <div class="m-b">
                                        <div><%out.print(note.getCommentList().get(i).getContent());%></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                <%        }
                    }
                %>
                <div class="panel panel-default m-t-md m-b-n-sm pos-rlt">
                    <form id="comment-submit">
                        <input id="note-id" name="noteId" type="hidden" value="<% out.print(note.getId());%>"/>
                        <input name="type" type="hidden" value="0"/>
                        <textarea id="comment-content" name="content" class="form-control no-border" rows="3" placeholder="Your comment..."></textarea>
                    </form>
                    <div class="panel-footer bg-light lter">
                        <button class="btn btn-info pull-right btn-sm" style="margin-bottom: 10px;" onclick="commentSubmit()">Comment</button>
                        <ul class="nav nav-pills nav-sm">
                            <li></li>
                            <li></li>
                            <li></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /content -->

            <jsp:include page="footer.jsp" />
</body>
</html>
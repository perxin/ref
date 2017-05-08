<%@ page language="java" pageEncoding="utf-8"%>
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
</head>
<body onload="getNotePage('page')">
  <div class="app app-header-fixed" id="app">
    <jsp:include page="navbar.jsp" />

    <!-- content -->
    <div class="app-content navbar-collapse">
      <div ui-butterbar></div>
      <a href class="off-screen-toggle hide" data-toggle="class:off-screen" data-target=".app-aside" ></a>
      <div class="app-content-body fade-in-up content">
        <!-- COPY the content from "tpl/" -->
          <div class="hbox hbox-auto-xs hbox-auto-sm">
            <div class="col">
              <div style="background:url(<%=request.getContextPath()%>/media/image/c4.jpg) center center; background-size:cover">
                <div class="wrapper-lg bg-white-opacity">
                  <div class="row m-t">
                    <div class="col-sm-7">
                      <a href class="thumb-lg pull-left m-r">
                        <img src="<%=request.getContextPath()%>/media/image/b5.jpg" class="img-circle">
                      </a>
                      <div class="clear m-b">
                        <div class="m-b m-t-sm">
                          <span class="h3 text-black">You can either travel or read,but either your body or soul must be on the way</span>
                          <!-- <small class="m-l">London, UK</small> -->
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="wrapper bg-white b-b">
                <ul class="nav nav-pills nav-sm">
                  <li class="active"><a href="javascript:void(0);" onclick="getNotePage('page')">全部文章</a></li>
                  <li><a href="javascript:void(0);" onclick="getNotePage('page_hot')">热门文章</a></li>
                  <li><a href="javascript:void(0);" onclick="getNotePage('page_new')">最新文章</a></li>
                </ul>
              </div>
              <div class="padder">
                <div class="list-group" id="page-data">
                </div>
              </div>
        <!-- PASTE above -->
      </div>
    </div>
    <!-- /content -->

    <jsp:include page="footer.jsp" />
</body>
</html>
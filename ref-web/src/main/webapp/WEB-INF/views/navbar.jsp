<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- navbar -->
<script type="text/javascript">
    contextPath = '<%=request.getContextPath()%>';
</script>
<div class="app-header navbar bg-white-only">

    <!-- navbar collapse -->
    <div class="collapse pos-rlt navbar-collapse bg-white-only">
        <!-- link and dropdown -->
        <ul class="nav navbar-nav hidden-sm nar">
            <li class="dropdown pos-stc">
                <a href="<%=request.getContextPath()%>/home" class="dropdown-toggle nar-logo">
                    <span>阅读论坛</span>
                </a>
            </li>
            <li class="dropdown pos-stc">
                <a href="<%=request.getContextPath()%>/home" class="dropdown-toggle">
                    <span>首页</span>
                </a>
            </li>
            <li class="dropdown pos-stc">
                <a href="javascript:void(0);" class="dropdown-toggle" onclick="isSignIn('edit')">
                    <span>写文章</span>
                </a>
            </li>
            <li class="dropdown pos-stc">
                <a href="<%=request.getContextPath()%>/note/notePage" class="dropdown-toggle">
                    <span>阅读文章</span>
                </a>
            </li>
            <li class="dropdown pos-stc">
                <a href="<%=request.getContextPath()%>/file" class="dropdown-toggle">
                    <span>共享资源</span>
                </a>
            </li>
            <%--<li class="dropdown pos-stc">
                <a href="javascript:void(0);" class="dropdown-toggle" onclick="isSignIn('ring')">
                    <span>闲聊</span>
                </a>
            </li>--%>
            <%--<li class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                    <i class="fa fa-fw fa-plus visible-xs-inline-block"></i>
                    <span translate="header.navbar.new.NEW">New</span> <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#" translate="header.navbar.new.PROJECT">Projects</a></li>
                    <li>
                        <a href>
                            <span class="badge bg-info pull-right">5</span>
                            <span translate="header.navbar.new.TASK">Task</span>
                        </a>
                    </li>
                    <li><a href translate="header.navbar.new.USER">User</a></li>
                    <li class="divider"></li>
                    <li>
                        <a href>
                            <span class="badge bg-danger pull-right">4</span>
                            <span translate="header.navbar.new.EMAIL">Email</span>
                        </a>
                    </li>
                </ul>
            </li>--%>
        </ul>
        <!-- / link and dropdown -->

        <!-- search form -->
        <%--<form class="navbar-form navbar-form-sm navbar-left shift" ui-shift="prependTo" data-target=".navbar-collapse" role="search" ng-controller="TypeaheadDemoCtrl">
            <div class="form-group">
                <div class="input-group">
                    <input type="text" ng-model="selected" typeahead="state for state in states | filter:$viewValue | limitTo:8" class="form-control input-sm bg-light no-border rounded padder" placeholder="Search projects...">
                    <span class="input-group-btn">
                <button type="submit" class="btn btn-sm bg-light rounded"><i class="fa fasearch-"></i></button>
              </span>
                </div>
            </div>
        </form>--%>
        <!-- / search form -->

        <%String name = (String)session.getAttribute("name");
            if(name == null){
        %>
        <div class="wrapper bg-white b-b navbar-right">
            <ul class="nav nav-pills nav-sm">
                <li class="active"><a href="<%=request.getContextPath()%>/sign">登录</a></li>
            </ul>
        </div>
        <%
        }else{
        %>
        <!-- nabar right -->
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                    <i class="icon-bell fa-fw"></i>
                    <span class="visible-xs-inline">Notifications</span>
                    <span class="badge badge-sm up bg-danger pull-right-xs">2</span>
                </a>
                <!-- dropdown -->
                <div class="dropdown-menu w-xl animated fadeInUp">
                    <div class="panel bg-white">
                        <div class="panel-heading b-light bg-light">
                            <strong>You have <span>2</span> notifications</strong>
                        </div>
                        <div class="list-group">
                            <a href class="media list-group-item">
                    <span class="pull-left thumb-sm">
                      <img src="<%=request.getContextPath()%>/media/image/a3.jpg" alt="..." class="img-circle">
                    </span>
                                <span class="media-body block m-b-none">
                      Use awesome animate.css<br>
                      <small class="text-muted">10 minutes ago</small>
                    </span>
                            </a>
                            <a href class="media list-group-item">
                    <span class="media-body block m-b-none">
                      1.0 initial released<br>
                      <small class="text-muted">1 hour ago</small>
                    </span>
                            </a>
                        </div>
                        <div class="panel-footer text-sm">
                            <a href class="pull-right"><i class="fa fa-cog"></i></a>
                            <a href="#notes" data-toggle="class:show animated fadeInRight">See all the notifications</a>
                        </div>
                    </div>
                </div>
                <!-- / dropdown -->
            </li>
            <li class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle clear" data-toggle="dropdown">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="<%=request.getContextPath()%>/media/image/ii.jpg" alt="...">
                <i class="on md b-white bottom"></i>
              </span>
                    <span class="hidden-sm hidden-md">
                <%
                    out.print(name);
                %>
              </span> <b class="caret"></b>
                    <input type="hidden" id="isSignIn" value="<%out.print(name);%>">
                </a>
                <!-- dropdown -->
                <ul class="dropdown-menu animated fadeInRight w">
                    <%--<li class="wrapper b-b m-b-sm bg-light m-t-n-xs">
                        <div>
                            <p>300mb of 500mb used</p>
                        </div>
                        <progressbar value="60" class="progress-xs m-b-none bg-white"></progressbar>
                    </li>--%>
                    <li>
                        <a href="<%=request.getContextPath()%>/user">
                            <%--<span class="badge bg-danger pull-right">30%</span>--%>
                            <span>个人信息</span>
                        </a>
                    </li>
                    <%--<li>
                        <a ui-sref="app.page.profile">Profile</a>
                    </li>
                    <li>
                        <a ui-sref="app.docs">
                            <span class="label bg-info pull-right">new</span>
                            Help
                        </a>
                    </li>--%>
                    <li class="divider"></li>
                    <li>
                        <a href="<%=request.getContextPath()%>/sign_out">Logout</a>
                    </li>
                </ul>
                <!-- / dropdown -->
            </li>
        </ul>
        <!-- / navbar right -->
        <%
            }
        %>

    </div>
    <!-- / navbar collapse -->
</div>
<!-- / navbar -->

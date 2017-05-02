<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>阅读论坛</title>
    <script type="text/javascript">
        contextPath = '<%=request.getContextPath()%>';
    </script>
    <meta name="description"
          content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/app.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/custom/custom.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/login.css" type="text/css"/>
</head>
<body>
<div class="app app-header-fixed" id="app">
    <!-- navbar -->
    <div class="app-header navbar bg-white-only">
        <!-- navbar collapse -->
        <div class="collapse pos-rlt navbar-collapse bg-white-only">
            <!-- link and dropdown -->
            <ul class="nav navbar-nav hidden-sm nar">
                <li class="dropdown pos-stc">
                    <a href="<%=request.getContextPath()%>/home" data-toggle="dropdown"
                       class="dropdown-toggle nar-logo">
                        <span>阅读论坛</span>
                    </a>
                </li>
                <li class="dropdown pos-stc">
                    <a href="<%=request.getContextPath()%>/home" data-toggle="dropdown" class="dropdown-toggle">
                        <span>首页</span>
                    </a>
                </li>
            </ul>
            <!-- / link and dropdown -->
        </div>
        <!-- / navbar collapse -->
    </div>
    <!-- / navbar -->

    <!-- content -->
    <div class="app-content">
        <div ui-butterbar></div>
        <a href class="off-screen-toggle hide" data-toggle="class:off-screen" data-target=".app-aside"></a>
        <div class="app-content-body fade-in-up content" style="background-color: #f0f3f4">
            <!-- COPY the content from "tpl/" -->
            <div class="hbox hbox-auto-xs hbox-auto-sm">
                <div class="col">
                    <div class="wrapper bg-white b-b" style="background-color: #f0f3f4">
                        <ul class="nav nav-pills nav-sm">
                            <li><a href>要么读书,要么旅行,身体和灵魂,总要有一个在路上。</a></li>
                        </ul>
                    </div>
                    <div class="padder">
                        <div class="login" style="margin-top:50px;">
                            <div class="header">
                                <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin"
                                                                   href="javascript:void(0);" tabindex="7">快速登录</a>
                                    <a class="switch_btn" id="switch_login" href="javascript:void(0);"
                                       tabindex="8">快速注册</a>
                                    <div class="switch_bottom" id="switch_bottom"
                                         style="position: absolute; width: 64px; left: 0px;"></div>
                                </div>
                            </div>
                            <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
                                <!--登录-->
                                <div class="web_login" id="web_login">
                                    <div class="login-box">
                                        <div class="login_form">
                                            <form action="<%=request.getContextPath()%>/sign_in" name="loginform"
                                                  accept-charset="utf-8" id="login_form" class="loginForm"
                                                  method="post">
                                                <div id="sign_in_message"></div>
                                                <div class="uinArea" id="uinArea">
                                                    <label class="input-tips" for="u">帐号：</label>
                                                    <div class="inputOuter" id="uArea">
                                                        <input type="text" id="u" name="name" class="inputstyle"/>
                                                    </div>
                                                </div>
                                                <div class="pwdArea" id="pwdArea">
                                                    <label class="input-tips" for="p">密码：</label>
                                                    <div class="inputOuter" id="pArea">
                                                        <input type="password" id="p" name="password"
                                                               class="inputstyle"/>
                                                    </div>
                                                </div>
                                                <div style="padding-left:50px;margin-top:20px;">
                                                    <input type="button" id="sign_in" value="登 录" style="width:150px;"
                                                           class="button_blue" onclick="signIn()"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!--登录end-->
                            </div>

                            <!--注册-->
                            <div class="qlogin" id="qlogin" style="display: none; ">
                                <div class="web_login">
                                    <form name="form2" id="regUser" accept-charset="utf-8"
                                          action="<%=request.getContextPath()%>/sign_up" method="post">
                                        <ul class="reg_form" id="reg-ul">
                                            <li>
                                                <div id="userCue"></div>
                                                <label for="user" class="input-tips2">用户名：</label>
                                                <div class="inputOuter2">
                                                    <input type="text" id="user" name="name" maxlength="16"
                                                           class="inputstyle2"/>
                                                </div>
                                            </li>
                                            <li>
                                                <label for="passwd" class="input-tips2">密码：</label>
                                                <div class="inputOuter2">
                                                    <input type="password" id="passwd" name="password" maxlength="16"
                                                           class="inputstyle2"/>
                                                </div>
                                            </li>
                                            <li>
                                                <label for="passwd2" class="input-tips2">确认密码：</label>
                                                <div class="inputOuter2">
                                                    <input type="password" id="passwd2" name="" maxlength="16"
                                                           class="inputstyle2"/>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="inputArea">
                                                    <input type="button" id="sign_up" onclick="signUp()"
                                                           style="margin-top:10px;margin-left:85px;" class="button_blue"
                                                           value="同意协议并注册"/>
                                                    <a href="#" class="zcxy" target="_blank">注册协议</a>
                                                </div>
                                            </li>
                                            <div class="cl"></div>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                            <!--注册end-->
                        </div>
                    </div>
                </div>
            </div>
            <!-- PASTE above -->
        </div>
    </div>
    <!-- /content -->

    <!-- footer -->
    <div class="app-footer wrapper b-t bg-light">
        <span class="pull-right">1.0.0 <a href="#app" class="m-l-sm text-muted"><i class="fa fa-long-arrow-up"></i></a></span>
        @2017 <a href="<%=request.getContextPath()%>/home" target="_blank" title="阅读论坛">阅读论坛</a>
    </div>
    <!-- / footer -->
</div>
<!-- jQuery -->
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/jquery.min.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/bootstrap.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/login.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/jquery.js"></script>
</body>
</html>
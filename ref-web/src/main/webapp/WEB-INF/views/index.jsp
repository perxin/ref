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
</head>
<body>
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
                  <li class="active"><a href>Stream</a></li>
                  <li><a href>Profile</a></li>
                  <li><a href>Messages</a></li>
                </ul>
              </div>
              <div class="padder">
                <div class="streamline b-l b-info m-l-lg m-b padder-v">
                  <div>
                    <a class="pull-left thumb-sm avatar m-l-n-md">
                      <img src="<%=request.getContextPath()%>/media/image/a9.jpg" class="img-circle" alt="...">
                    </a>
                    <div class="m-l-lg">
                      <div class="m-b-xs">
                        <a href class="h4">perxin</a>
                        <span class="text-muted m-l-sm pull-right">
                          Just now
                        </span>
                      </div>
                      <div class="m-b">
                        <div>Lorem ipsum dolor sit amet, consecteter adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. ullamcorper sodales nisi nec adipiscing elit. Morbi id neque quam. Aliquam sollicitudin </div>
                        <div class="m-t-sm">
                          <a href class="text-muted m-xs"><i class="icon-action-redo"></i></a>
                          <a href class="text-muted m-xs"><i class="icon-star"></i></a>
                          <a href class="text-muted m-xs"><i class="icon-refresh"></i> 13</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- .comment-reply -->
                  <div class="m-l-lg">
                    <a class="pull-left thumb-sm avatar">
                      <img src="<%=request.getContextPath()%>/media/image/a5.jpg" alt="...">
                    </a>
                    <div class="m-l-xxl panel b-a">
                      <div class="panel-heading pos-rlt">
                        <span class="arrow left pull-up"></span>
                        <span class="text-muted m-l-sm pull-right">
                          10m ago
                        </span>
                        <a href>Mika Sam</a>
                        Report this comment is helpful
                      </div>
                    </div>
                  </div>
                  <!-- / .comment-reply -->
                  <div>
                    <a class="pull-left thumb-sm avatar m-l-n-md">
                      <img src="<%=request.getContextPath()%>/media/image/a3.jpg" alt="...">
                    </a>
                    <div class="m-l-lg m-b-lg panel b-a bg-light lt">
                      <div class="panel-heading pos-rlt b-light">
                        <span class="arrow arrow-light left"></span>
                        <a href>By me</a>
                        <span class="text-muted m-l-sm pull-right">
                          1h ago
                        </span>
                      </div>
                      <div class="panel-body">
                        <div>This comment was posted by you.</div>
                      </div>
                    </div>
                  </div>
                  <div>
                    <a class="pull-left thumb-sm avatar m-l-n-md">
                      <img src="<%=request.getContextPath()%>/media/image/a3.jpg" class="img-circle" alt="...">
                    </a>
                    <div class="m-l-lg m-b-lg">
                      <div class="m-b-xs">
                        <a href class="h4">Jessica</a>
                        <span class="text-muted m-l-sm pull-right">
                          3h ago
                        </span>
                      </div>
                      <div class="m-b">
                        <div class="m-b">Cecteter adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. ullamcorper sodales nisi nec adipiscing elit. Morbi id neque quam. Aliquam sollicitudin </div>
                        <img src="<%=request.getContextPath()%>/media/image/c5.jpg" class="b b-a wrapper-xs bg-white img-responsive">
                        <div class="m-t-sm">
                          <a href class="text-muted m-xs"><i class="icon-action-redo"></i></a>
                          <a href class="text-muted m-xs"><i class="icon-star"></i></a>
                          <a href class="text-muted m-xs"><i class="icon-refresh"></i> 13</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div>
                    <a class="pull-left thumb-sm avatar m-l-n-md">
                      <img src="<%=request.getContextPath()%>/media/image/a3.jpg" class="img-circle" alt="...">
                    </a>
                    <div class="m-l-lg m-b-lg">
                      <div class="m-b-xs">
                        <a href class="h4">Fisio</a>
                        <span class="text-muted m-l-sm pull-right">
                          4h ago
                        </span>
                      </div>
                      <div>
                        <div class="m-b">Diam nonummy nibh euismod tincidunt ut laoreet. ullamcorper sodales nisi nec adipiscing elit. Morbi id neque quam. Aliquam sollicitudin </div>
                        <div class="panel panel-default m-t-md m-b-n-sm pos-rlt">
                          <form>
                            <textarea class="form-control no-border" rows="3" placeholder="Your comment..."></textarea>
                          </form>
                          <div class="panel-footer bg-light lter">
                            <button class="btn btn-info pull-right btn-sm">Comment</button>
                            <ul class="nav nav-pills nav-sm">
                              <li><a href><i class="fa fa-camera text-muted"></i></a></li>
                              <li><a href><i class="fa fa-video-camera text-muted"></i></a></li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div>
                    <a class="pull-left thumb-sm avatar m-l-n-md">
                      <img src="<%=request.getContextPath()%>/media/image/a3.jpg" alt="...">
                    </a>
                    <div class="m-l-lg panel b-a">
                      <div class="panel-heading pos-rlt b-b b-light">
                        <span class="arrow left"></span>
                        <a href>Peter</a>
                        <label class="label bg-light m-l-xs">VIP</label>
                        <span class="text-muted m-l-sm pull-right">
                          9h ago
                        </span>
                      </div>
                      <div class="panel-body">
                        <blockquote>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                          <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
                        </blockquote>
                        <div>Lorem ipsum dolor sit amet, consecteter adipiscing elit...</div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- aaa -->
              </div>
            </div>
        <!-- PASTE above -->
      </div>
    </div>
    <!-- /content -->

    <!-- aside right -->
    <div class="app-aside-right pos-fix no-padder w-md w-auto-xs bg-white b-l animated fadeInRight hide">
      <div class="vbox">
        <div class="wrapper b-b b-t b-light m-b">
          <a href class="pull-right text-muted text-md" data-toggle="class:show" data-target=".app-aside-right"><i class="icon-close"></i></a>
          Chat
        </div>
        <div class="row-row">
          <div class="cell">
            <div class="cell-inner padder">
              <!-- chat list -->
              <div class="m-b">
                <a href class="pull-left thumb-xs avatar"><img src="<%=request.getContextPath()%>/media/image/a3.jpg" alt="..."></a>
                <div class="clear">
                  <div class="pos-rlt wrapper-sm b b-light r m-l-sm">
                    <span class="arrow left pull-up"></span>
                    <p class="m-b-none">Hi John, What's up...</p>
                  </div>
                  <small class="text-muted m-l-sm"><i class="fa fa-ok text-success"></i> 2 minutes ago</small>
                </div>
              </div>
              <div class="m-b">
                <a href class="pull-right thumb-xs avatar"><img src="<%=request.getContextPath()%>/media/image/a3.jpg" class="img-circle" alt="..."></a>
                <div class="clear">
                  <div class="pos-rlt wrapper-sm bg-light r m-r-sm">
                    <span class="arrow right pull-up arrow-light"></span>
                    <p class="m-b-none">Lorem ipsum dolor :)</p>
                  </div>
                  <small class="text-muted">1 minutes ago</small>
                </div>
              </div>
              <div class="m-b">
                <a href class="pull-left thumb-xs avatar"><img src="<%=request.getContextPath()%>/media/image/a3.jpg" alt="..."></a>
                <div class="clear">
                  <div class="pos-rlt wrapper-sm b b-light r m-l-sm">
                    <span class="arrow left pull-up"></span>
                    <p class="m-b-none">Great!</p>
                  </div>
                  <small class="text-muted m-l-sm"><i class="fa fa-ok text-success"></i>Just Now</small>
                </div>
              </div>
              <!-- / chat list -->
            </div>
          </div>
        </div>
        <div class="wrapper m-t b-t b-light">
          <form class="m-b-none">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Say something">
              <span class="input-group-btn">
                <button class="btn btn-default" type="button">SEND</button>
              </span>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- / aside right -->
        <jsp:include page="footer.jsp" />
</body>
</html>
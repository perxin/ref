<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/custom.css" type="text/css" />
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
            <a href="#" data-toggle="dropdown" class="dropdown-toggle nar-logo">
              <span>阅读论坛</span> 
            </a>
          </li>
          <li class="dropdown pos-stc">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">
              <span>首页</span> 
            </a>
          </li>
          <li class="dropdown">
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
          </li>
        </ul>
        <!-- / link and dropdown -->

        <!-- search form -->
        <form class="navbar-form navbar-form-sm navbar-left shift" ui-shift="prependTo" data-target=".navbar-collapse" role="search" ng-controller="TypeaheadDemoCtrl">
          <div class="form-group">
            <div class="input-group">
              <input type="text" ng-model="selected" typeahead="state for state in states | filter:$viewValue | limitTo:8" class="form-control input-sm bg-light no-border rounded padder" placeholder="Search projects...">
              <span class="input-group-btn">
                <button type="submit" class="btn btn-sm bg-light rounded"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </div>
        </form>
        <!-- / search form -->

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
                      <img src="../../../../../../../front/rf/app/img/a0.jpg" alt="..." class="img-circle">
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
                <img src="../../../../../../../front/rf/app/img/a0.jpg" alt="...">
                <i class="on md b-white bottom"></i>
              </span>
              <span class="hidden-sm hidden-md">John.Smith</span> <b class="caret"></b>
            </a>
            <!-- dropdown -->
            <ul class="dropdown-menu animated fadeInRight w">
              <li class="wrapper b-b m-b-sm bg-light m-t-n-xs">
                <div>
                  <p>300mb of 500mb used</p>
                </div>
                <progressbar value="60" class="progress-xs m-b-none bg-white"></progressbar>
              </li>
              <li>
                <a href>
                  <span class="badge bg-danger pull-right">30%</span>
                  <span>Settings</span>
                </a>
              </li>
              <li>
                <a ui-sref="app.page.profile">Profile</a>
              </li>
              <li>
                <a ui-sref="app.docs">
                  <span class="label bg-info pull-right">new</span>
                  Help
                </a>
              </li>
              <li class="divider"></li>
              <li>
                <a ui-sref="access.signin">Logout</a>
              </li>
            </ul>
            <!-- / dropdown -->
          </li>
        </ul>
        <!-- / navbar right -->

      </div>
      <!-- / navbar collapse -->
    </div>
    <!-- / navbar -->

    <!-- content -->
    <div class="app-content">
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
                        <img src="../../../../../../../front/rf/app/img/b5.jpg" class="img-circle">
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
                      <img src="../../../../../../../front/rf/app/img/a9.jpg" class="img-circle" alt="...">
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
                      <img src="../../../../../../../front/rf/app/img/a5.jpg" alt="...">
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
                      <img src="../../../../../../../front/rf/app/img/a3.jpg" alt="...">
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
                      <img src="../../../../../../../front/rf/app/img/a6.jpg" class="img-circle" alt="...">
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
                        <img src="../../../../../../../front/rf/app/img/c5.jpg" class="b b-a wrapper-xs bg-white img-responsive">
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
                      <img src="../../../../../../../front/rf/app/img/a4.jpg" class="img-circle" alt="...">
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
                      <img src="../../../../../../../front/rf/app/img/a2.jpg" alt="...">
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
            <!-- <div class="col w-lg bg-light lter b-l bg-auto">
              <div class="wrapper">
                <div class="">
                  <h4 class="m-t-xs m-b-xs">Who to follow</h4>
                  <ul class="list-group no-bg no-borders pull-in">
                    <li class="list-group-item">
                      <a herf class="pull-left thumb-sm avatar m-r">
                        <img src="img/a4.jpg" alt="..." class="img-circle">
                        <i class="on b-white bottom"></i>
                      </a>
                      <div class="clear">
                        <div><a href>Chris Fox</a></div>
                        <small class="text-muted">Designer, Blogger</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <a herf class="pull-left thumb-sm avatar m-r">
                        <img src="img/a5.jpg" alt="..." class="img-circle">
                        <i class="on b-white bottom"></i>
                      </a>
                      <div class="clear">
                        <div><a href>Mogen Polish</a></div>
                        <small class="text-muted">Writter, Mag Editor</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <a herf class="pull-left thumb-sm avatar m-r">
                        <img src="img/a6.jpg" alt="..." class="img-circle">
                        <i class="busy b-white bottom"></i>
                      </a>
                      <div class="clear">
                        <div><a href>Joge Lucky</a></div>
                        <small class="text-muted">Art director, Movie Cut</small>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <a herf class="pull-left thumb-sm avatar m-r">
                        <img src="img/a7.jpg" alt="..." class="img-circle">
                        <i class="away b-white bottom"></i>
                      </a>
                      <div class="clear">
                        <div><a href>Folisise Chosielie</a></div>
                        <small class="text-muted">Musician, Player</small>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="panel b-a">
                  <h4 class="font-thin padder">Latest Tweets</h4>
                  <ul class="list-group">
                    <li class="list-group-item">
                        <p>Wellcome <a href class="text-info">@Drew Wllon</a> and play this web application template, have fun1 </p>
                        <small class="block text-muted"><i class="fa fa-fw fa-clock-o"></i> 2 minuts ago</small>
                    </li>
                    <li class="list-group-item">
                        <p>Morbi nec <a href class="text-info">@Jonathan George</a> nunc condimentum ipsum dolor sit amet, consectetur</p>
                        <small class="block text-muted"><i class="fa fa-fw fa-clock-o"></i> 1 hour ago</small>
                    </li>
                    <li class="list-group-item">                     
                        <p><a href class="text-info">@Josh Long</a> Vestibulum ullamcorper sodales nisi nec adipiscing elit. Morbi id neque quam. Aliquam sollicitudin venenatis</p>
                        <small class="block text-muted"><i class="fa fa-fw fa-clock-o"></i> 2 hours ago</small>
                    </li>
                  </ul>
                </div>
                <div class="panel b-light clearfix">
                  <div class="panel-body">
                    <a href class="thumb pull-left m-r">
                      <img src="img/a0.jpg" class="img-circle">
                    </a>
                    <div class="clear">
                      <a href class="text-info">@Mike Mcalidek <i class="fa fa-twitter"></i></a>
                      <small class="block text-muted">2,415 followers / 225 tweets</small>
                      <a href class="btn btn-xs btn-success m-t-xs">Follow</a>
                    </div>
                  </div>
                </div>
              </div>
            </div> -->
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
                <a href class="pull-left thumb-xs avatar"><img src="../../../../../../../front/rf/app/img/a2.jpg" alt="..."></a>
                <div class="clear">
                  <div class="pos-rlt wrapper-sm b b-light r m-l-sm">
                    <span class="arrow left pull-up"></span>
                    <p class="m-b-none">Hi John, What's up...</p>
                  </div>
                  <small class="text-muted m-l-sm"><i class="fa fa-ok text-success"></i> 2 minutes ago</small>
                </div>
              </div>
              <div class="m-b">
                <a href class="pull-right thumb-xs avatar"><img src="../../../../../../../front/rf/app/img/a3.jpg" class="img-circle" alt="..."></a>
                <div class="clear">
                  <div class="pos-rlt wrapper-sm bg-light r m-r-sm">
                    <span class="arrow right pull-up arrow-light"></span>
                    <p class="m-b-none">Lorem ipsum dolor :)</p>
                  </div>
                  <small class="text-muted">1 minutes ago</small>
                </div>
              </div>
              <div class="m-b">
                <a href class="pull-left thumb-xs avatar"><img src="../../../../../../../front/rf/app/img/a2.jpg" alt="..."></a>
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

    <!-- footer -->
    <div class="app-footer wrapper b-t bg-light">
      <span class="pull-right">1.0.0 <a href="#app" class="m-l-sm text-muted"><i class="fa fa-long-arrow-up"></i></a></span>
      @2017 <a href="http://www.cssmoban.com/" target="_blank" title="阅读论坛">阅读论坛</a> 
    </div>
    <!-- / footer -->
  </div>
  <!-- jQuery -->
  <script src="../../../../../../../front/rf/app/vendor/jquery/jquery.min.js"></script>
  <script src="../../../../../../../front/rf/app/vendor/jquery/bootstrap.js"></script>
  <script type="text/javascript">
    +function ($) {
      $(function(){
        // class
        $(document).on('click', '[data-toggle^="class"]', function(e){
          e && e.preventDefault();
          console.log('abc');
          var $this = $(e.target), $class , $target, $tmp, $classes, $targets;
          !$this.data('toggle') && ($this = $this.closest('[data-toggle^="class"]'));
          $class = $this.data()['toggle'];
          $target = $this.data('target') || $this.attr('href');
          $class && ($tmp = $class.split(':')[1]) && ($classes = $tmp.split(','));
          $target && ($targets = $target.split(','));
          $classes && $classes.length && $.each($targets, function( index, value ) {
            if ( $classes[index].indexOf( '*' ) !== -1 ) {
              var patt = new RegExp( '\\s' + 
                  $classes[index].
                    replace( /\*/g, '[A-Za-z0-9-_]+' ).
                    split( ' ' ).
                    join( '\\s|\\s' ) + 
                  '\\s', 'g' );
              $($this).each( function ( i, it ) {
                var cn = ' ' + it.className + ' ';
                while ( patt.test( cn ) ) {
                  cn = cn.replace( patt, ' ' );
                }
                it.className = $.trim( cn );
              });
            }
            ($targets[index] !='#') && $($targets[index]).toggleClass($classes[index]) || $this.toggleClass($classes[index]);
          });
          $this.toggleClass('active');
        });

        // collapse nav
        $(document).on('click', 'nav a', function (e) {
          var $this = $(e.target), $active;
          $this.is('a') || ($this = $this.closest('a'));
          
          $active = $this.parent().siblings( ".active" );
          $active && $active.toggleClass('active').find('> ul:visible').slideUp(200);
          
          ($this.parent().hasClass('active') && $this.next().slideUp(200)) || $this.next().slideDown(200);
          $this.parent().toggleClass('active');
          
          $this.next().is('ul') && e.preventDefault();

          setTimeout(function(){ $(document).trigger('updateNav'); }, 300);      
        });
      });
    }(jQuery);
  </script>
</body>
</html>
<%--
  auth: meishiqiang
  Date: 2021/1/27  11:30
  新星幼儿园后台管理系统- recruitManage_page
  招聘信息管理 一级目录 recruit-manage
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="招聘信息管理">
    <meta name="author" content="meishiqiang">
    <%--    <meta name="keyword" content="教师, 新星幼儿园, 新星, 幼儿园, 招聘管理, manage">--%>
    <link rel="shortcut icon" href="img/ico/favicon32.ico">

    <title>新星-招聘信息管理</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">

    <!--right slidebar-->
    <link href="css/slidebars.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />



    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<section id="container" >
    <!--header start-->
    <header class="header white-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="index.html" class="logo">NEW<span>STAR</span></a>
        <!--logo end-->
        <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
            <ul class="nav top-menu">
                <!-- settings start -->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="fa fa-tasks"></i>
                        <span class="badge bg-success">6</span>
                    </a>
                    <ul class="dropdown-menu extended tasks-bar">
                        <div class="notify-arrow notify-arrow-green"></div>
                        <li>
                            <p class="green">You have 6 pending tasks</p>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Dashboard v1.3</div>
                                    <div class="percent">40%</div>
                                </div>
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                        <span class="sr-only">40% Complete (success)</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Database Update</div>
                                    <div class="percent">60%</div>
                                </div>
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                        <span class="sr-only">60% Complete (warning)</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Iphone Development</div>
                                    <div class="percent">87%</div>
                                </div>
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 87%">
                                        <span class="sr-only">87% Complete</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Mobile App</div>
                                    <div class="percent">33%</div>
                                </div>
                                <div class="progress progress-striped">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 33%">
                                        <span class="sr-only">33% Complete (danger)</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="task-info">
                                    <div class="desc">Dashboard v1.3</div>
                                    <div class="percent">45%</div>
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                                        <span class="sr-only">45% Complete</span>
                                    </div>
                                </div>

                            </a>
                        </li>
                        <li class="external">
                            <a href="#">See All Tasks</a>
                        </li>
                    </ul>
                </li>
                <!-- settings end -->
                <!-- inbox dropdown start-->
                <li id="header_inbox_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="fa fa-envelope-o"></i>
                        <span class="badge bg-important">5</span>
                    </a>
                    <ul class="dropdown-menu extended inbox">
                        <div class="notify-arrow notify-arrow-red"></div>
                        <li>
                            <p class="red">You have 5 new messages</p>
                        </li>
                        <li>
                            <a href="#">
                                <span class="photo"><img alt="avatar" src="./img/avatar-mini.jpg"></span>
                                <span class="subject">
                                    <span class="from">Jonathan Smith</span>
                                    <span class="time">Just now</span>
                                    </span>
                                <span class="message">
                                        Hello, this is an example msg.
                                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="photo"><img alt="avatar" src="./img/avatar-mini2.jpg"></span>
                                <span class="subject">
                                    <span class="from">Jhon Doe</span>
                                    <span class="time">10 mins</span>
                                    </span>
                                <span class="message">
                                     Hi, Jhon Doe Bhai how are you ?
                                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="photo"><img alt="avatar" src="./img/avatar-mini3.jpg"></span>
                                <span class="subject">
                                    <span class="from">Jason Stathum</span>
                                    <span class="time">3 hrs</span>
                                    </span>
                                <span class="message">
                                        This is awesome dashboard.
                                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="photo"><img alt="avatar" src="./img/avatar-mini4.jpg"></span>
                                <span class="subject">
                                    <span class="from">Jondi Rose</span>
                                    <span class="time">Just now</span>
                                    </span>
                                <span class="message">
                                        Hello, this is metrolab
                                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">See all messages</a>
                        </li>
                    </ul>
                </li>
                <!-- inbox dropdown end -->
                <!-- notification dropdown start-->
                <li id="header_notification_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="fa fa-bell-o"></i>
                        <span class="badge bg-warning">7</span>
                    </a>
                    <ul class="dropdown-menu extended notification">
                        <div class="notify-arrow notify-arrow-yellow"></div>
                        <li>
                            <p class="yellow">You have 7 new notifications</p>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                Server #3 overloaded.
                                <span class="small italic">34 mins</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-warning"><i class="fa fa-bell"></i></span>
                                Server #10 not respoding.
                                <span class="small italic">1 Hours</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                Database overloaded 24%.
                                <span class="small italic">4 hrs</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-success"><i class="fa fa-plus"></i></span>
                                New user registered.
                                <span class="small italic">Just now</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-info"><i class="fa fa-bullhorn"></i></span>
                                Application error.
                                <span class="small italic">10 mins</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">See all notifications</a>
                        </li>
                    </ul>
                </li>
                <!-- notification dropdown end -->
            </ul>
            <!--  notification end -->
        </div>
        <div class="top-nav ">
            <!--search & user info start-->
            <ul class="nav pull-right top-menu">
                <li>
                    <input type="text" class="form-control search" placeholder="Search">
                </li>
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <img alt="" src="img/avatar1_small.jpg">
                        <span class="username">Jhon Doue</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                        <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                        <li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li>
                        <li><a href="login.html"><i class="fa fa-key"></i> Log Out</a></li>
                    </ul>
                </li>
                <li class="sb-toggle-right">
                    <i class="fa  fa-align-right"></i>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!--search & user info end-->
        </div>
    </header>
    <!--header end-->
    <!--sidebar start-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- 侧边栏菜单 start-->
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="index.html">
                        <i class="fa fa-university"></i>
                        <span>新星</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-laptop"></i>
                        <span>recruit-manage</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="boxed_page.html">招聘管理</a></li>
                        <li><a  href="horizontal_menu.html">留言管理</a></li>
                        <li><a  href="header-color.html">简历管理</a></li>
                    </ul>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-book"></i>
                        <span>用户中心</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="general.html">General</a></li>
                        <li><a  href="buttons.html">Buttons</a></li>
                        <li><a  href="modal.html">Modal</a></li>
                        <li><a  href="toastr.html">Toastr Notifications</a></li>
                        <li><a  href="widget.html">Widget</a></li>
                        <li><a  href="slider.html">Slider</a></li>
                        <li><a  href="nestable.html">Nestable</a></li>
                        <li><a  href="font_awesome.html">Font Awesome</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-glass"></i>
                        <span>Extra</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="blank.html">Blank Page</a></li>
                        <li><a  href="sidebar_closed.html">Sidebar Closed</a></li>
                        <li><a  href="people_directory.html">People Directory</a></li>
                        <li><a  href="coming_soon.html">Coming Soon</a></li>
                        <li><a  href="lock_screen.html">Lock Screen</a></li>
                        <li><a  href="profile.html">Profile</a></li>
                        <li><a  href="invoice.html">Invoice</a></li>
                        <li><a  href="project_list.html">Project List</a></li>
                        <li><a  href="project_details.html">Project Details</a></li>
                        <li><a  href="search_result.html">Search Result</a></li>
                        <li><a  href="pricing_table.html">Pricing Table</a></li>
                        <li><a  href="faq.html">FAQ</a></li>
                        <li><a  href="fb_wall.html">FB Wall</a></li>
                        <li><a  href="404.html">404 Error</a></li>
                        <li><a  href="500.html">500 Error</a></li>
                    </ul>
                </li>
                <!--multi level menu end-->

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <!--gai start-->
            <div class="row state-overview">
                <%--新增用户--%>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol terques">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="value">
                            <h1 class="count">
                                0
                            </h1>
                            <p>新增 用户</p>
                        </div>
                    </section>
                </div>
                <%--新增招聘信息--%>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol red">
                            <i class="fa fa-tags"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count2">
                                0
                            </h1>
                            <p>新增 招聘</p>
                        </div>
                    </section>
                </div>
                <%--简历投递信息--%>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol yellow">
                            <i class="fa fa-shopping-cart"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count3">
                                0
                            </h1>
                            <p>简历 投递</p>
                        </div>
                    </section>
                </div>
                <%--空白-待补--%>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol blue">
                            <i class="fa fa-bar-chart-o"></i>
                        </div>
                        <div class="value">
                            <h1 class=" count4">
                                0
                            </h1>
                            <p>Blank Leave</p>
                        </div>
                    </section>
                </div>
            </div>
            <!--state overview end-->
            <div class="row">
                <div class="col-lg-4">
                    <!--用户信息 start-->
                    <section class="panel">
                        <div class="panel-body">
                            <a href="#" class="task-thumb">
                                <img src="img/avatar1.jpg" alt="头像">
                            </a>
                            <div class="task-thumb-details">
                                <h1><a href="#">梅士强</a></h1>
                                <p>java 开发工程师</p>
                            </div>
                        </div>
                        <table class="table table-hover personal-task">
                            <tbody>
                            <tr>
                                <td>
                                    <i class=" fa fa-tasks"></i>
                                </td>
                                <td>任务</td>
                                <td> 02</td>
                            </tr>
                            <tr>
                                <td>
                                    <i class="fa fa-exclamation-triangle"></i>
                                </td>
                                <td>留言</td>
                                <td> 14</td>
                            </tr>
                            </tbody>
                        </table>
                    </section>
                    <!--用户信息 end-->
                </div>
                <div class="col-lg-8">
                    <!--招聘进度 start-->
                    <section class="panel">
                        <div class="panel-body progress-panel">
                            <div class="task-progress">
                                <h1>招聘 进度</h1>
                            </div>
                        </div>
                        <table class="table table-hover personal-task">
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>
                                    门卫（郑州-南三环）
                                </td>
                                <td>
                                    <span class="badge bg-important">75%</span>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>
                                    门卫（郑州南三环）
                                </td>
                                <td>
                                    <span class="badge bg-success">43%</span>
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>
                                    门卫（郑州南三环）
                                </td>
                                <td>
                                    <span class="badge bg-info">67%</span>
                                </td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>
                                    门卫（郑州南三环）
                                </td>
                                <td>
                                    <span class="badge bg-warning">30%</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </section>
                    <!--招聘进度 end-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <!--timeline start-->
                    <section class="panel">
                        <div class="panel-body">
                            <div class="text-center mbot30">
                                <h3 class="timeline-title">Timeline</h3>
                                <p class="t-info">This is a project timeline</p>
                            </div>

                            <div class="timeline">
                                <article class="timeline-item">
                                    <div class="timeline-desk">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <span class="arrow"></span>
                                                <span class="timeline-icon red"></span>
                                                <span class="timeline-date">08:25 am</span>
                                                <h1 class="red">12 July | Sunday</h1>
                                                <p>Lorem ipsum dolor sit amet consiquest dio</p>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                                <article class="timeline-item alt">
                                    <div class="timeline-desk">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <span class="arrow-alt"></span>
                                                <span class="timeline-icon green"></span>
                                                <span class="timeline-date">10:00 am</span>
                                                <h1 class="green">10 July | Wednesday</h1>
                                                <p><a href="#">Jonathan Smith</a> added new milestone <span><a href="#" class="green">ERP</a></span></p>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                                <article class="timeline-item">
                                    <div class="timeline-desk">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <span class="arrow"></span>
                                                <span class="timeline-icon blue"></span>
                                                <span class="timeline-date">11:35 am</span>
                                                <h1 class="blue">05 July | Monday</h1>
                                                <p><a href="#">Anjelina Joli</a> added new album <span><a href="#" class="blue">PARTY TIME</a></span></p>
                                                <div class="album">
                                                    <a href="#">
                                                        <img alt="" src="img/sm-img-1.jpg">
                                                    </a>
                                                    <a href="#">
                                                        <img alt="" src="img/sm-img-2.jpg">
                                                    </a>
                                                    <a href="#">
                                                        <img alt="" src="img/sm-img-3.jpg">
                                                    </a>
                                                    <a href="#">
                                                        <img alt="" src="img/sm-img-1.jpg">
                                                    </a>
                                                    <a href="#">
                                                        <img alt="" src="img/sm-img-2.jpg">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                                <article class="timeline-item alt">
                                    <div class="timeline-desk">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <span class="arrow-alt"></span>
                                                <span class="timeline-icon purple"></span>
                                                <span class="timeline-date">3:20 pm</span>
                                                <h1 class="purple">29 June | Saturday</h1>
                                                <p>Lorem ipsum dolor sit amet consiquest dio</p>
                                                <div class="notification">
                                                    <i class=" fa fa-exclamation-sign"></i> New task added for <a href="#">Denial Collins</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                                <article class="timeline-item">
                                    <div class="timeline-desk">
                                        <div class="panel">
                                            <div class="panel-body">
                                                <span class="arrow"></span>
                                                <span class="timeline-icon light-green"></span>
                                                <span class="timeline-date">07:49 pm</span>
                                                <h1 class="light-green">10 June | Friday</h1>
                                                <p><a href="#">Jonatha Smith</a> added new milestone <span><a href="#" class="light-green">prank</a></span> Lorem ipsum dolor sit amet consiquest dio</p>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                            </div>

                            <div class="clearfix">&nbsp;</div>
                        </div>
                    </section>
                    <!--timeline end-->
                </div>
                <div class="col-lg-4">
                    <!--revenue start-->
                    <section class="panel">
                        <div class="revenue-head">
                              <span>
                                  <i class="fa fa-bar-chart-o"></i>
                              </span>
                            <h3>Revenue</h3>
                            <span class="rev-combo pull-right">
                                 June 2013
                              </span>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6 col-sm-6 text-center">
                                    <div class="easy-pie-chart">
                                        <div class="percentage" data-percent="35"><span>35</span>%</div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-sm-6">
                                    <div class="chart-info chart-position">
                                        <span class="increase"></span>
                                        <span>Revenue Increase</span>
                                    </div>
                                    <div class="chart-info">
                                        <span class="decrease"></span>
                                        <span>Revenue Decrease</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer revenue-foot">
                            <ul>
                                <li class="first active">
                                    <a href="javascript:;">
                                        <i class="fa fa-bullseye"></i>
                                        Graphical
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class=" fa fa-th-large"></i>
                                        Tabular
                                    </a>
                                </li>
                                <li class="last">
                                    <a href="javascript:;">
                                        <i class=" fa fa-align-justify"></i>
                                        Listing
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </section>
                    <!--revenue end-->
                    <!--features carousel start-->
                    <section class="panel">
                        <div class="flat-carousal">
                            <div id="owl-demo" class="owl-carousel owl-theme">
                                <div class="item">
                                    <h1>Flatlab is new model of admin dashboard for happy use</h1>
                                    <div class="text-center">
                                        <a href="javascript:;" class="view-all">View All</a>
                                    </div>
                                </div>
                                <div class="item">
                                    <h1>Fully responsive and build with Bootstrap 3.0</h1>
                                    <div class="text-center">
                                        <a href="javascript:;" class="view-all">View All</a>
                                    </div>
                                </div>
                                <div class="item">
                                    <h1>Responsive Frontend is free if you get this.</h1>
                                    <div class="text-center">
                                        <a href="javascript:;" class="view-all">View All</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <ul class="ft-link">
                                <li class="active">
                                    <a href="javascript:;">
                                        <i class="fa fa-bars"></i>
                                        Sales
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class=" fa fa-calendar-o"></i>
                                        promo
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class=" fa fa-camera"></i>
                                        photo
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class=" fa fa-circle"></i>
                                        other
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </section>
                    <!--features carousel end-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <!--latest product info start-->
                    <section class="panel post-wrap pro-box">
                        <aside>
                            <div class="post-info">
                                <span class="arrow-pro right"></span>
                                <div class="panel-body">
                                    <h1><strong>popular</strong> <br> Brand of this week</h1>
                                    <div class="desk yellow">
                                        <h3>Dimond Ring</h3>
                                        <p>Lorem ipsum dolor set amet lorem ipsum dolor set amet ipsum dolor set amet</p>
                                    </div>
                                    <div class="post-btn">
                                        <a href="javascript:;">
                                            <i class="fa fa-chevron-circle-left"></i>
                                        </a>
                                        <a href="javascript:;">
                                            <i class="fa fa-chevron-circle-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </aside>
                        <aside class="post-highlight yellow v-align">
                            <div class="panel-body text-center">
                                <div class="pro-thumb">
                                    <img src="img/ring.jpg" alt="">
                                </div>
                            </div>
                        </aside>
                    </section>
                    <!--latest product info end-->
                    <!--twitter feedback start-->
                    <section class="panel post-wrap pro-box">
                        <aside class="post-highlight terques v-align">
                            <div class="panel-body">
                                <h2>Flatlab is new model of admin dashboard <a href="javascript:;"> http://demo.com/</a> 4 days ago  by jonathan smith</h2>
                            </div>
                        </aside>
                        <aside>
                            <div class="post-info">
                                <span class="arrow-pro left"></span>
                                <div class="panel-body">
                                    <div class="text-center twite">
                                        <h1>Twitter Feed</h1>
                                    </div>

                                    <footer class="social-footer">
                                        <ul>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-facebook"></i>
                                                </a>
                                            </li>
                                            <li class="active">
                                                <a href="#">
                                                    <i class="fa fa-twitter"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-google-plus"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-pinterest"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </footer>
                                </div>
                            </div>
                        </aside>
                    </section>
                    <!--twitter feedback end-->
                </div>
                <div class="col-lg-4">
                    <div class="row">
                        <div class="col-xs-6">
                            <!--pie chart start-->
                            <section class="panel">
                                <div class="panel-body">
                                    <div class="chart">
                                        <div id="pie-chart" ></div>
                                    </div>
                                </div>
                                <footer class="pie-foot">
                                    Free: 260GB
                                </footer>
                            </section>
                            <!--pie chart start-->
                        </div>
                        <div class="col-xs-6">
                            <!--follower start-->
                            <section class="panel">
                                <div class="follower">
                                    <div class="panel-body">
                                        <h4>Jonathan Smith</h4>
                                        <div class="follow-ava">
                                            <img src="img/follower-avatar.jpg" alt="">
                                        </div>
                                    </div>
                                </div>

                                <footer class="follower-foot">
                                    <ul>
                                        <li>
                                            <h5>2789</h5>
                                            <p>Follower</p>
                                        </li>
                                        <li>
                                            <h5>270</h5>
                                            <p>Following</p>
                                        </li>
                                    </ul>
                                </footer>
                            </section>
                            <!--follower end-->
                        </div>
                    </div>
                    <!--weather statement start-->
                    <section class="panel">
                        <div class="weather-bg">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <i class="fa fa-cloud"></i>
                                        California
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="degree">
                                            24°
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <footer class="weather-category">
                            <ul>
                                <li class="active">
                                    <h5>humidity</h5>
                                    56%
                                </li>
                                <li>
                                    <h5>precip</h5>
                                    1.50 in
                                </li>
                                <li>
                                    <h5>winds</h5>
                                    10 mph
                                </li>
                            </ul>
                        </footer>

                    </section>
                    <!--weather statement end-->
                </div>
            </div>

        </section>
    </section>
    <!--main content end-->

    <!-- Right Slidebar start -->
    <div class="sb-slidebar sb-right sb-style-overlay">
        <h5 class="side-title">Online Customers</h5>
        <ul class="quick-chat-list">
            <li class="online">
                <div class="media">
                    <a href="#" class="pull-left media-thumb">
                        <img alt="" src="img/chat-avatar2.jpg" class="media-object">
                    </a>
                    <div class="media-body">
                        <strong>John Doe</strong>
                        <small>Dream Land, AU</small>
                    </div>
                </div><!-- media -->
            </li>
            <li class="online">
                <div class="media">
                    <a href="#" class="pull-left media-thumb">
                        <img alt="" src="img/chat-avatar.jpg" class="media-object">
                    </a>
                    <div class="media-body">
                        <div class="media-status">
                            <span class=" badge bg-important">3</span>
                        </div>
                        <strong>Jonathan Smith</strong>
                        <small>United States</small>
                    </div>
                </div><!-- media -->
            </li>

            <li class="online">
                <div class="media">
                    <a href="#" class="pull-left media-thumb">
                        <img alt="" src="img/pro-ac-1.png" class="media-object">
                    </a>
                    <div class="media-body">
                        <div class="media-status">
                            <span class=" badge bg-success">5</span>
                        </div>
                        <strong>Jane Doe</strong>
                        <small>ABC, USA</small>
                    </div>
                </div><!-- media -->
            </li>
            <li class="online">
                <div class="media">
                    <a href="#" class="pull-left media-thumb">
                        <img alt="" src="img/avatar1.jpg" class="media-object">
                    </a>
                    <div class="media-body">
                        <strong>Anjelina Joli</strong>
                        <small>Fockland, UK</small>
                    </div>
                </div><!-- media -->
            </li>
            <li class="online">
                <div class="media">
                    <a href="#" class="pull-left media-thumb">
                        <img alt="" src="img/mail-avatar.jpg" class="media-object">
                    </a>
                    <div class="media-body">
                        <div class="media-status">
                            <span class=" badge bg-warning">7</span>
                        </div>
                        <strong>Mr Tasi</strong>
                        <small>Dream Land, USA</small>
                    </div>
                </div><!-- media -->
            </li>
        </ul>
        <h5 class="side-title"> pending Task</h5>
        <ul class="p-task tasks-bar">
            <li>
                <a href="#">
                    <div class="task-info">
                        <div class="desc">Dashboard v1.3</div>
                        <div class="percent">40%</div>
                    </div>
                    <div class="progress progress-striped">
                        <div style="width: 40%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success">
                            <span class="sr-only">40% Complete (success)</span>
                        </div>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="task-info">
                        <div class="desc">Database Update</div>
                        <div class="percent">60%</div>
                    </div>
                    <div class="progress progress-striped">
                        <div style="width: 60%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="60" role="progressbar" class="progress-bar progress-bar-warning">
                            <span class="sr-only">60% Complete (warning)</span>
                        </div>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="task-info">
                        <div class="desc">Iphone Development</div>
                        <div class="percent">87%</div>
                    </div>
                    <div class="progress progress-striped">
                        <div style="width: 87%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="20" role="progressbar" class="progress-bar progress-bar-info">
                            <span class="sr-only">87% Complete</span>
                        </div>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="task-info">
                        <div class="desc">Mobile App</div>
                        <div class="percent">33%</div>
                    </div>
                    <div class="progress progress-striped">
                        <div style="width: 33%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="80" role="progressbar" class="progress-bar progress-bar-danger">
                            <span class="sr-only">33% Complete (danger)</span>
                        </div>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="task-info">
                        <div class="desc">Dashboard v1.3</div>
                        <div class="percent">45%</div>
                    </div>
                    <div class="progress progress-striped active">
                        <div style="width: 45%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="45" role="progressbar" class="progress-bar">
                            <span class="sr-only">45% Complete</span>
                        </div>
                    </div>

                </a>
            </li>
            <li class="external">
                <a href="#">See All Tasks</a>
            </li>
        </ul>
    </div>
    <!-- Right Slidebar end -->

    <!--footer start-->
    <footer class="site-footer">
        <div class="text-center">
            2021 &copy; 新星幼儿园网（New Star）.
            <a href="#" class="go-top">
                <i class="fa fa-angle-up"></i>
            </a>
        </div>
    </footer>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="js/jquery.sparkline.js" type="text/javascript"></script>
<script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="js/owl.carousel.js" ></script>
<script src="js/jquery.customSelect.min.js" ></script>
<script src="js/respond.min.js" ></script>

<!--right slidebar-->
<script src="js/slidebars.min.js"></script>

<!--common script for all pages-->
<script src="js/common-scripts.js"></script>

<!--script for this page-->
<script src="js/sparkline-chart.js"></script>
<script src="js/easy-pie-chart.js"></script>
<script src="js/count.js"></script>

<script>

    //owl carousel

    $(document).ready(function() {
        $("#owl-demo").owlCarousel({
            navigation : true,
            slideSpeed : 300,
            paginationSpeed : 400,
            singleItem : true,
            autoPlay:true

        });
    });

    //custom select box

    $(function(){
        $('select.styled').customSelect();
    });

    $(window).on("resize",function(){
        var owl = $("#owl-demo").data("owlCarousel");
        owl.reinit();
    });

</script>

</body>
</html>
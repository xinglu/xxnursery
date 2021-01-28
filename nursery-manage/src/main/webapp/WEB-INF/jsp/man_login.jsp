<%--
  登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/ico/favicon32.ico">
    <title>登录-Login</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!-- external css -->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="/manage/login.do">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="User Name" autofocus>
            <input type="password" class="form-control" placeholder="Password">
            <label class="checkbox">
                <input type="checkbox" value="记住密码" name="remember-pass"> 记住密码
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> 忘记密码?</a>

                </span>
            </label>
            <button class="btn btn-lg btn-login btn-block" type="submit">Sign in</button>
            <p>or you can sign in via social network</p>
        </div>
        <div class="login-social-link">
            <a href="index.html" class="facebook">
                <i class="fa fa-facebook"></i>
                Facebook
            </a>
            <a href="index.html" class="twitter">
                <i class="fa fa-twitter"></i>
                Twitter
            </a>
        </div>
        <div class="registration">
            Don't have an account yet?
            <a class="" href="registration.html">
                Create an account
            </a>
        </div>
    </form>

</div>

<!-- js 文件 -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

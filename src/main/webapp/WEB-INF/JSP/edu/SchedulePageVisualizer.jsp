<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Education - Schedule</title>

        <!-- Bootstrap -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/main.css" rel="stylesheet">
        <link href="/css/swiper.min.css" rel="stylesheet">
        <link href="/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="/css/edu.css">
        <link rel="stylesheet" href="/css/posts-template.css">
        <link rel="stylesheet" href="/css/photoswipe.css">
        <link rel="stylesheet" href="/css/default-skin/default-skin.css">
        <link rel="stylesheet" href="/css/gallery.css">
        <%--<!-- Bootstrap -->--%>
        <%--<link href="../../../css/bootstrap.min.css" rel="stylesheet">--%>
        <%--<link href="../../../css/main.css" rel="stylesheet">--%>
        <%--<link href="../../../css/swiper.min.css" rel="stylesheet">--%>
        <%--<link href="../../../css/all.css" rel="stylesheet">--%>
        <%--<link rel="stylesheet" href="../../../css/edu.css">--%>
        <%--<link rel="stylesheet" href="../../../css/posts-template.css">--%>
        <%--<link rel="stylesheet" href="../../../css/photoswipe.css">--%>
        <%--<link rel="stylesheet" href="../../../css/default-skin/default-skin.css">--%>
        <%--<link rel="stylesheet" href="../../../css/gallery.css">--%>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>



    <body id="body">
        <header>
            <nav id="myNavbar" class="navbar navbar-default navbar-fixed-top  container-fluid" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html">LAWN</a>
                        <a class="myacc visible-xs" href="login.html">
                            <i class="fas fa-user-circle"></i>
                        </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="nav navbar-nav navbar-right container-fluid">
                            <li class="">
                                <a data-toggle="tabs" href="index.html">
                                    <i class="fas fa-home"></i>
                                    Home</a>
                            </li>
                            <li class="active">
                                <a data-toggle="tabs" href="edu_schedule.html">
                                    <i class="fas fa-graduation-cap"></i>
                                    Education</a>
                            </li>
                            <li class="">
                                <a data-toggle="tabs" href="community.html">
                                    <i class="fas fa-users"></i>
                                    Community</a>
                            </li>
                            <li class="">
                                <a data-toggle="tabs" href="album.html">
                                    <i class="fas fa-images"></i>
                                    Album</a>
                            </li>
                            <li class="hidden-xs">
                                <a data-toggle="tabs" href="login.html">
                                    <i class="fas fa-user-circle"></i>
                                    Sign In</a>
                            </li>
                            <li class="dropdown ">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-cog"></i>
                                    Settings
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">My account</a></li>
                                    <li><a href="#">My organizations</a></li>
                                    <li><a href="#">Liked posts</a></li>
                                    <li><a href="#">My posts</a></li>
                                    <li><a href="#">Tickets</a></li>
                                    <li><a href="#">Add</a></li>
                                    <li><a href="#">FAQ</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <section class="tabsection container">
            <ul class="nav nav-tabs">
                <li class="active first"><a   href="edu_schedule.html">Schedule</a></li>
                <li><a href="/edu/hw">Homework</a></li>
                <li><a href="/edu/lib">Recources</a></li>
            </ul>
        </section>

        <div class="tab-content">
            <%--schedule--%>
            <%@include file="ScheduleVisualizer.jsp" %>
            <%--end schdule--%>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/css/jquery.min.js"></script>
        <script src="/css/swiper.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/css/bootstrap.min.js" type="text/javascript"></script>
        <!-- <script src="slick/slick.min.js"></script>    -->
        <script src="/css/main.js" type="text/javascript"></script>

        <!-- Core JS file -->
        <script src="/css/photoswipe.min.js"></script>

        <!-- UI JS file -->
        <script src="/css/photoswipe-ui-default.min.js"></script>
        <!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->

        <%--<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->--%>
        <%--<script src="../css/jquery.min.js"></script>--%>
        <%--<script src="../css/swiper.min.js"></script>--%>
        <%--<!-- Include all compiled plugins (below), or include individual files as needed -->--%>
        <%--<script src="../css/bootstrap.min.js" type="text/javascript"></script>--%>
        <%--<!-- <script src="slick/slick.min.js"></script>    -->--%>
        <%--<script src="../css/main.js" type="text/javascript"></script>--%>

        <%--<!-- Core JS file -->--%>
        <%--<script src="../css/photoswipe.min.js"></script>--%>

        <%--<!-- UI JS file -->--%>
        <%--<script src="../css/photoswipe-ui-default.min.js"></script>--%>
        <%--<!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->--%>

        <%--${pageContext.request.contextPath}--%>
    </body>
</html>
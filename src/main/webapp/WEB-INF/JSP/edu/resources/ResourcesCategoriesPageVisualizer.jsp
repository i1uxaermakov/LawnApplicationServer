<%@ page import="java.util.Objects" %>
<%@ page import="account.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: ilya_ermakov
  Date: 29/07/2018
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Resources - LAWN</title>

    <%--favicons begin--%>
    <link rel="apple-touch-icon" sizes="180x180" href="/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon/favicon-16x16.png">
    <link rel="manifest" href="/favicon/site.webmanifest">
    <link rel="mask-icon" href="/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <%--favicons end--%>

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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="body">
    <%--begin header--%>
    <%request.setAttribute("ActiveNavBarSection", "education");%>
    <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
    <%--end header--%>

    <section class="tabsection container">
        <ul class="nav nav-tabs">
            <li class="first"><a   href="/edu/sc">Schedule</a></li>
            <li><a href="/edu/hw">Homework</a></li>
            <li class="active"><a href="/edu/lib">Resources</a></li>
            <%
                User user = (User) request.getSession().getAttribute("User");
                if(user.getPrivileges().contains("teacher")) {%>
                    <li class=" plusSign" style="float: right;">
                        <a href="/edu/lib/add/files" style="color: #69a03c;font-size: 1.8em;padding-top: 0;padding-bottom: 0px;" title="Add resources!">+</a>
                    </li>
            <%  }
            %>
        </ul>
    </section>
    <%
        Long lvl = (Long) request.getAttribute("lvl");
        if(Objects.isNull(lvl)) {
            lvl = new Long(4);
        }
    %>

    <section class="blocks container-fluid" id="resources">
        <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd">
            <div class="redditstyle">
                <div class="dropdown">
                    <button class="dropdown-toggle" type="button" data-toggle="dropdown"> <%=(lvl==0)?"Common":"Level "+lvl%>
                        <span class="caret"></span></button>

                    <ul class="dropdown-menu">
                        <li class="<%=(lvl.equals(1))?"active":""%>"><a href="/edu/lib?lvl=1">Level 1</a></li>
                        <li class="<%=(lvl.equals(2))?"active":""%>"><a href="/edu/lib?lvl=2">Level 2</a></li>
                        <li class="<%=(lvl.equals(3))?"active":""%>"><a href="/edu/lib?lvl=3">Level 3</a></li>
                        <li class="<%=(lvl.equals(4))?"active":""%>"><a href="/edu/lib?lvl=3">Common</a></li>
                        <%-- data-toggle="tab" a--%>
                    </ul>

                </div>
                <a href="/files/fav"> <button class="">Favourite files</button> </a>
            </div>

            <div class="tab-content" >
                <div class="collapse in buttoncol fade tab-pane active in">
                    <%@include file="ResourcesCategoriesVisualizer.jsp" %>
                </div>

            </div>

        </div>
    </section>
    <!-- foooter -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/js/main.js" type="text/javascript"></script>

    <script src="/js/resources.js" type="text/javascript"></script>
    <!-- Core JS file -->

    <script src="/js/like.js" type="text/javascript"></script>

    <script src="/js/photoswipe.min.js"></script>

    <!-- UI JS file -->
    <script src="/js/photoswipe-ui-default.min.js"></script>
    <script type="text/javascript">
        function removeWarn () {
            $('.warn').remove();
        }
    </script>
    <!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->
    </body>

</html>

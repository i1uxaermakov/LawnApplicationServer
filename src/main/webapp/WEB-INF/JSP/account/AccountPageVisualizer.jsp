<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Education - Homework</title>

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
    <style>
        form input{
            margin-bottom: 5px;
        }
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .accountPageButton {
            border: 1px #80808082 solid;
            background: white;
        }
    </style>
</head>

<body id="body">
    <%--begin header--%>
    <%request.setAttribute("ActiveNavBarSection", "authorisation");%>
    <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
    <%--end header--%>

    <section style="margin-top:50px">
        <%@include file="/WEB-INF/JSP/account/AccountPageContentVisualizer.jsp"%>
    </section>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/js/main.js" type="text/javascript"></script>
    <script src="/js/edu.js"></script>
    <script src="/js/photoswipe.min.js"></script>
    <script src="/js/photoswipe-ui-default.min.js"></script>
</body>

</html>


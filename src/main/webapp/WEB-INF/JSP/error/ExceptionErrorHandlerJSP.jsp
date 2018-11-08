<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Lawn</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/swiper.min.css" rel="stylesheet">
    <link href="css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="css/posts-template.css">
    <link rel="stylesheet" href="css/photoswipe.css">
    <link rel="stylesheet" href="css/default-skin/default-skin.css">
    <link rel="stylesheet" href="css/events.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->



    <!-- Put this script tag to the <head> of your page -->
    <!-- Put this div tag to the place, where the Poll block will be -->
    <style type="text/css">

        .whiteBox{
            margin-top: 150px;
            background: white;
            padding: 50px 20px 30px 20px;
        }
        h1{

            font-size: 3em;
            font-weight: 600;
            color: #78993e;

        }
    </style>


</head>

    <body>
        <%--begin header--%>
        <%request.setAttribute("ActiveNavBarSection", "error");%>
        <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
        <%--end header--%>

        <%
            Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
            if (servletName == null) {
                servletName = "Unknown";
            }
            String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
            if (requestUri == null) {
                requestUri = "Unknown";
            }

            if(statusCode == 500) {%>
                <section class="sectionafterheader container">

                    <div class="whiteBox">
                        <h1 class="text-center">Server-side Error(Exception) Occurred</h1>
                        <p class="text-center">
                            Servlet Name: <%=servletName%> <br>
                            Exception Name: <%=throwable.getClass().getName()%> <br>
                            Requested URI: <%=requestUri%> <br>
                            Exception Message: <%=throwable.getMessage()%> <br>
                        </p>
                    </div>

                </section>
            <%}
            else {%>
                <section class="sectionafterheader container">

                    <div class="whiteBox">
                        <h1 class="text-center">Error <%=statusCode%></h1>
                        <p class="text-center">
                            <strong>Error Details</strong>
                            <%
                                if(statusCode==403) {%>
                                    У вас нет разрешения использовать запрошенный ресурс. Обратитесь к разработчикам, если такого быть не должно.
                                <%}
                                else if(statusCode == 404) {%>
                                    Запрошенный вами ресурс недоступен или не существует.
                                <%}
                                else {%>
                                    Во время обработки вашего запроса произошла ошибка.<br>
                            Requested URI: <%=requestUri%>
                                <%}
                            %>
                        </p>
                    </div>

                </section>
            <%}
        %>
        <a href="/edu/sc"><button>Перейти на страницу Расписания</button></a>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/css/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/css/bootstrap.min.js" type="text/javascript"></script>
        <!-- <script src="slick/slick.min.js"></script>    -->
        <script src="/css/main.js" type="text/javascript"></script>
        <!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->
    </body>
</html>

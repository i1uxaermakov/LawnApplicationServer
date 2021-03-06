<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Schedule - LAWN</title>

        <!--favicons begin-->
        <link rel="apple-touch-icon" sizes="180x180" href="/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/favicon/favicon-16x16.png">
        <link rel="manifest" href="/favicon/site.webmanifest">
        <link rel="mask-icon" href="/favicon/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <!--favicons end-->

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
        <%--begin header--%>
        <%request.setAttribute("ActiveNavBarSection", "education");%>
        <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
        <%--end header--%>

        <div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="pswp__bg"></div>
            <div class="pswp__scroll-wrap">
                <div class="pswp__container">
                    <div class="pswp__item"></div>
                    <div class="pswp__item"></div>
                    <div class="pswp__item"></div>
                </div>
                <div class="pswp__ui pswp__ui--hidden">
                    <div class="pswp__top-bar">
                        <div class="pswp__counter"></div>
                        <button class="pswp__button pswp__button--close" title="Close (Esc)"></button>
                        <button class="pswp__button pswp__button--share" title="Share"></button>
                        <button class="pswp__button pswp__button--fs" title="Toggle fullscreen"></button>
                        <button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>

                        <div class="pswp__preloader">
                            <div class="pswp__preloader__icn">
                                <div class="pswp__preloader__cut">
                                    <div class="pswp__preloader__donut"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
                        <div class="pswp__share-tooltip"></div>
                    </div>

                    <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)"></button>
                    <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)"></button>

                    <div class="pswp__caption">
                        <div class="pswp__caption__center"></div>
                    </div>
                </div>
            </div>
        </div>

        <section class="tabsection container">
            <ul class="nav nav-tabs">
                <li class="active first"><a   href="/edu/sc">Schedule</a></li>
                <li><a href="/edu/hw">Homework</a></li>
                <li><a href="/edu/lib">Resources</a></li>
            </ul>
        </section>

        <div class="tab-content">
            <%--schedule--%>
            <%@include file="ScheduleVisualizer.jsp" %>
            <%--end schdule--%>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/js/jquery.min.js"></script>
        <script src="/js/swiper.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- <script src="slick/slick.min.js"></script>    -->
        <script src="/js/main.js" type="text/javascript"></script>
        <script src="/js/like.js" type="text/javascript"></script>

        <!-- Core JS file -->
        <script src="/js/photoswipe.min.js"></script>
        <script src="/js/schedule.js"></script>

        <!-- UI JS file -->
        <script src="/js/photoswipe-ui-default.min.js"></script>
        <!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->
        <script type="text/javascript">
            function removeWarn () {
                $('.warn').remove();
            }
        </script>

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
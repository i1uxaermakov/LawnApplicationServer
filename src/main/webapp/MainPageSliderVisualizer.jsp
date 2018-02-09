<%@ page import="model.entities.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entities.Tag" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta namex§="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>LAWN - Main Page</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">

        <!--     <link rel="stylesheet" href="slick/slick.css">
            <link rel="stylesheet" href="slick/slick-theme.css">
          -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.0/css/swiper.min.css">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
<body>
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
                    <img src="" alt="">
                    <a class="navbar-brand" href="#">LAWN</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="nav navbar-nav navbar-right container-fluid">
                        <li class="">
                            <a href="#">NEWS</a>
                        </li>
                        <li class="">
                            <a href="#">EVENTS</a>
                        </li>
                        <li class="">
                            <a href="#">ALBUM</a>
                        </li>
                        <li class="">
                            <a href="#">EDU</a>
                        </li>
                        <li class="">
                            <a href="#">LOG IN</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <section class="firstsec container-fluid">
        <div class="slideritself ">
            <!-- Slider main container -->
            <div class="swiper-container">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper">
                    <!-- Slides -->
                    <div class="swiper-slide">
                        <div class="swiper-slide-content">
                            <h1><a href="">Album Header</a></h1>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="swiper-slide-content">
                            <h1><a href="">Album Header</a></h1>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="swiper-slide-content">
                            <h1><a href="">Album Header</a></h1>
                        </div>
                    </div>
                </div>
                <div class="swiper-pagination swiper-pagination-bullets swiper-pagination-white ">
                </div>
                <!-- <div class="swiper-button-prev hidden-xs" id=""></div>
                <div class="swiper-button-next hidden-xs" id=""></div> -->

                <!-- If we need scrollbar -->
                <div class="swiper-scrollbar"></div>
            </div>
            <!-- If we need pagination -->


            <!-- If we need navigation buttons -->

        </div>
        </div>
    </section>

    <section class="eventssection container-fluid">
        <h1 class="text-center eventshead">Lyceum Events</h1>

        <div class="events row">


            <div class="col-sm-6 col-xs-12 col-md-6 col-lg-3 rel">
                <img src="img/event1.jpg" alt="" id="img1" class="eventimg">
                <span class="eventdate visible-sm visible-xs">30.24.23</span>
                <div class="textevent text-center visible-sm visible-xs">
                    <span class="headerevent">Event Header - 11.11.11</span>
                </div>
                <div class="comphover" id="comphover1">
            <span class="bigtext">
              Meeting Imam
            </span>
                    <br>
                    <span>
              30.02.20!8
            </span>
                </div>
            </div>


            <div class="col-sm-6 col-xs-12 col-md-6 col-lg-3 rel">
                <img src="img/event1.jpg" alt="" id="img2" class="eventimg">
                <span class="eventdate visible-sm visible-xs">30.24.23</span>
                <div class="textevent text-center visible-sm visible-xs">
                    <span class="headerevent">Event Header - 11.11.11</span>
                </div>
                <div class="comphover" id="comphover2">
            <span class="bigtext">
              Meeting Imam
            </span>
                    <br>
                    <span>
              30.02.20!8
            </span>
                </div>
            </div>

            <div class="col-sm-6 col-xs-12 col-md-6 col-lg-3 rel">
                <img src="img/event1.jpg" alt="" id="img3" class="eventimg">
                <span class="eventdate visible-sm visible-xs">30.24.23</span>
                <div class="textevent text-center visible-sm visible-xs">
                    <span class="headerevent">Event Header - 11.11.11</span>
                </div>
                <div class="comphover" id="comphover3">
            <span class="bigtext">
              Meeting Imam
            </span>
                    <br>
                    <span>
              30.02.20!8
            </span>
                </div>
            </div>
            <div class="col-sm-6 col-xs-12 col-md-6 col-lg-3 rel">
                <img src="img/event1.jpg" alt="" id="img4" class="eventimg">
                <span class="eventdate visible-sm visible-xs">30.24.23</span>
                <div class="textevent text-center visible-sm visible-xs">
                    <span class="headerevent">Event Header - 11.11.11</span>
                </div>
                <div class="comphover" id="comphover4">
            <span class="bigtext">
              Meeting Imam
            </span>
                    <br>
                    <span>
              30.02.20!8
            </span>
                </div>
            </div>
        </div>
    </section>

    <section class="newssection container-fluid">
        <div class="feed">
            <h1 class="text-center">Feed</h1>
        </div>
        <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3  ">

            <%
                List<Post> postList = (List<Post>) request.getAttribute("postList");

                for(Post post: postList) {
            %>

            <div class="news" width="100%">
                <div class="newsbegin col-xs-12">
                    <div class="l1">
                        <a href="#">
                            <img src="img/imam.jpg" alt="">
                        </a>
                    </div>
                    <div class="l2">
                        <span><%=post.getAuthorName()%></span>
                        <br>
                        <span><%=post.getPublishDate()%></span>
                        <br>
                        <%for(Tag tag: post.getTags()) {%>
                            <a href="#" class=""> <span class="tag"><%=tag.getName()%></span></a>
                        <%
                            }
                        %>
                        <%--<a href="#" class=""><span class="tag">tag1</span></a>--%>
                        <%--<a href="#" class=""><span class="tag">tag1</span></a>--%>
                        <%--<a href="#" class=""><span class="tag">tag1</span></a>--%>
                        <%--<a href="#" class=""><span class="tag">tag1</span></a>--%>
                    </div>
                </div>
                <div class="text">
                    <%=post.getPostText() %>
                    <a href="#" class="seemore">See more...</a>
                </div>
                <div class="row">
                    <div class="img">
                        <img src="image.png" alt="" class="imagenews col-lg-10 col-lg-offset-1 col-xs-12">
                    </div>
                </div>
            </div>
             <%
                }
             %>

        </div>
    </section>
    <footer class="container">
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>© 2018 LAWN, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
    </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.0/js/swiper.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/js/main.js" type="text/javascript"></script>
    </body>
</html>
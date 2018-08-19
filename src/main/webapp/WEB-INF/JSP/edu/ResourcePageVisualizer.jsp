<%--
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
    <title>Education - Resources</title>

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
        <li class=" first"><a  href="edu_schedule.html">Schedule</a></li>
        <li><a href="edu_homework.html">Homework</a></li>
        <li class="active"><a href="edu_resources.html">Recources</a></li>
    </ul>
</section>



<section class="blocks container-fluid" id="resources">
    <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd">
        <div class="redditstyle">
            <div class="dropdown">
                <button class="dropdown-toggle" type="button" data-toggle="dropdown">level
                    <span class="caret"></span></button>

                <ul class="dropdown-menu nav nav-tabs">
                    <li class="active"><a  data-toggle="tab" href="#levelfirst">Level 1</a></li>
                    <li class=""><a data-toggle="tab" href="#levelsecond">Level 2</a></li>
                    <li class=""><a data-toggle="tab" href="#">Level 3</a></li>
                </ul>

            </div>
            <button class="">favourite</button>
        </div>

        <div class="tab-content" >
            <div class="collapse in buttoncol fade tab-pane active in" id="levelfirst">
                <a class="btn btn-primary btn-lg btn-block accord1" href="#history"  role="button" data-toggle="modal" data-target="#exampleModalLong">History</a>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3 class="modal-title" id="exampleModalLongTitle">Resources</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="uploaded-files-hw">
                                    <a href="#"><i class="far fa-file-word fa-4x"></i>
                                        <span class="about-hw-file">Title: Человек и Общество.
                                        <br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span>
                                        <span class="filefav"><i class="far fa-star"></i></span>
                                    </a>
                                </div>
                                <div class="uploaded-files-hw">
                                    <a href="#"><i class="far fa-file-word fa-4x"></i>
                                        <span class="about-hw-file">Title: Человек и Общество.
                                        <br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                                </div>
                                <div class="uploaded-files-hw">
                                    <a href="#"><i class="far fa-file-word fa-4x"></i>
                                        <span class="about-hw-file">Title: Человек и Общество.
                                        <br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                                </div>
                                <div class="uploaded-files-hw">
                                    <a href="#"><i class="far fa-file-word fa-4x"></i>
                                        <span class="about-hw-file">Title: Человек и Общество.
                                        <br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#english" role="button">English</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Algebra</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Geometry</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Chemistry</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Biology</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Physics</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Law</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">IT</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Uzbek</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Russian</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Literature</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">НДП</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Religion</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Aesthetics</a>
            </div>


            <div class="collapse in buttoncol fade tab-pane" id="levelsecond">
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Literature</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">НДП</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Religion</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Aesthetics</a>
            </div>

            <div class="collapse in buttoncol fade tab-pane" id="levelthird">
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Literature</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">НДП</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Religion</a>
                <a class="btn btn-primary btn-lg btn-block accord1"  href="#maths" role="button">Aesthetics</a>
            </div>
        </div>

    </div>
</section>
<!-- foooter -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/css/jquery.min.js"></script>
<script src="/css/swiper.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap.min.js" type="text/javascript"></script>
<!-- <script src="slick/slick.min.js"></script>    -->
<script src="/css/main.js" type="text/javascript"></script>

<!-- Core JS file -->

<script src="/css/edu.js"></script>
<script src="/css/like.js"> </script>

<script src="/css/photoswipe.min.js"></script>

<!-- UI JS file -->
<script src="/css/photoswipe-ui-default.min.js"></script>
<!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->
</body>

</html>
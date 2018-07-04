<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Education</title>

    <!-- Bootstrap -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/main.css" rel="stylesheet">
    <link href="../../../css/swiper.min.css" rel="stylesheet">
    <link href="../../../css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../css/edu.css">
    <link rel="stylesheet" href="../../../css/posts-template.css">
    <link rel="stylesheet" href="../../../css/photoswipe.css">
    <link rel="stylesheet" href="../../../css/default-skin/default-skin.css">
    <link rel="stylesheet" href="../../../css/gallery.css">

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
                <img src="http://localhost:8080/" alt="">
                <a class="navbar-brand" href="../index.html">LAWN</a>
                <a class="myacc visible-xs" href="Account"><i class="fas fa-user-circle"></i></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="nav navbar-nav navbar-right container-fluid">
                    <li class="">
                        <a data-toggle="tabs" href="../index.html">
                            <i class="fas fa-home"></i>
                            Home</a>
                    </li>
                    <li class="active">
                        <a data-toggle="tabs" href="edu.html">
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
                        <a data-toggle="tabs" href="http://localhost:8080/#">
                            <i class="fas fa-user-circle"></i>
                            Sign In</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>







<section class="tabsection container">
    <ul class="nav nav-tabs">
        <li class="active first"><a data-toggle="tab" href="#schedule">Schedule</a></li>
        <li><a data-toggle="tab" href="#homework">Homework</a></li>
        <li><a data-toggle="tab" href="#resources">Recources</a></li>
    </ul>
</section>



<div class="tab-content">
    <%--schedule--%>
    <%@include file="ScheduleVisualizer.jsp" %>


    <!--Homework-->
    <section class="blocks hw container-fluid tab-pane fade" id="homework">
        <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd">
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Monday" role="button" aria-expanded="true">Monday | April 22</a>
            </div>
            <div class="collapse in buttoncol" id="Monday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 14 мая 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 7 мая 2018 14:00</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="twophotosrow photos row">
                        <div class="my-gallery" itemscope itemtype="">



                            <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                                <!-- <div class="wrapperThumb"> -->

                                <a href="../imgs/eduex1.jpg" itemprop="contentUrl" data-size="635x353">

                                    <img src="../imgs/eduex1.jpg" itemprop="thumbnail" alt="Image description" />

                                </a>
                                <!-- </div> -->
                                <figcaption itemprop="caption description">Image caption 3</figcaption>
                            </figure>

                            <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                                <a href="../imgs/eduex1.jpg" itemprop="contentUrl" data-size="640x640">
                                    <img src="../imgs/eduex1.jpg" itemprop="thumbnail" alt="Image description" />
                                </a>
                                <figcaption itemprop="caption description">Image caption 4</figcaption>
                            </figure>
                        </div>





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

                                    <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)">
                                    </button>

                                    <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)">
                                    </button>

                                    <div class="pswp__caption">
                                        <div class="pswp__caption__center"></div>
                                    </div>

                                </div>

                            </div>

                        </div>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">Russian - Lyubov Anatolyevna</span>
                            <br>
                            <span class="item-date">Deadline: 20 апреля 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 23 апреля 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Прочитать правила с приложенного документа, законспектировать.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Правило Буравчика.<br>Size: 13Mb<br>Uploaded: 2 апреля 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">Physics - Dilbar Sultanovna</span>
                            <br>
                            <span class="item-date">Deadline: 14 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 13 мая 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Создать большой адронный коллайдер из подручных средств по инструкции в файле. Используя ускоритель частиц, доказать существование Бозона Хиггса.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Адронный Коллайдер для чайников.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
            </div>
            <!--                Tuesday-->
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Tuesday" role="button">Tuesday | April 23</a>
            </div>
            <div class="collapse buttoncol" id="Tuesday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">Human & Society - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
            </div>
            <!--                Wednesday-->
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Wednesday" role="button">Wednesday | April 24</a>
            </div>
            <div class="collapse buttoncol" id="Wednesday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
            </div>
            <!--                Thursday-->
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Thursday" role="button">Thursday | April 25</a>
            </div>
            <div class="collapse buttoncol" id="Thursday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
            </div>
            <!--                Friday-->
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Friday" role="button">Friday | April 26</a>
            </div>
            <div class="collapse buttoncol" id="Friday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>

            </div>
            <!--                Saturday-->
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#Saturday" role="button">Saturday | April 27</a>
            </div>
            <div class="collapse buttoncol" id="Saturday">
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-word fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-pdf fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
                <div class="news">
                    <div class="newsbegin">
                        <div class="l2-homework">
                            <span class="post-publishers-name">History - Ramis Sattarov</span>
                            <br>
                            <span class="item-date">Deadline: 20 марта 2018 21:09</span> <br>
                            <span class="item-date">Uploaded: 20 марта 2018 21:09</span>
                        </div>
                    </div>
                    <div class="text">
                        Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-powerpoint fa-4x"></i>
                            <span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                    <div class="uploaded-files-hw">
                        <a href="#"><i class="far fa-file-image fa-4x"></i>
                            <span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>
                    </div>
                </div>
            </div>
        </div>
    </section>







    <section class="blocks hw container-fluid tab-pane fade" id="resources">
        <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd">
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#levelfirst" role="button" aria-expanded="true">Level 1</a>
            </div>
            <div class="collapse buttoncol" id="levelfirst">
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#history" role="button" data-toggle="modal" data-target="#exampleModalLong">History</a>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">H/w</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                </button>
                            </div>
                            <div class="modal-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex provident quos consectetur deserunt, veritatis temporibus blanditiis! Ipsum impedit adipisci corporis ut, fugiat cum magni tempora commodi eveniet, sed excepturi ratione cupiditate quos distinctio in harum a. At saepe nesciunt voluptate tempora harum ipsum assumenda optio eveniet, laboriosam consequuntur vitae fugit obcaecati nihil id temporibus soluta, facilis repellat necessitatibus molestiae. Modi aliquam repudiandae magnam, veritatis corporis unde? Id tempore saepe neque atque minima corrupti obcaecati eius ipsa quaerat voluptate reprehenderit voluptates omnis assumenda cum deserunt, sapiente, voluptatem accusantium quo ipsam odit numquam sit, nulla molestiae fuga. Numquam aperiam ea deserunt! Ea autem incidunt debitis culpa corporis voluptatem aspernatur totam consectetur voluptatibus odit molestias ab ad, officiis ipsa numquam id aliquid eos et magni commodi laboriosam vitae! Quaerat quae at, debitis odio cum? Ad nulla maiores amet consequuntur alias nihil reprehenderit est possimus, sapiente ratione facere odio rem quaerat autem impedit excepturi corporis. Error labore quisquam assumenda, et sapiente eos hic omnis culpa nulla placeat repudiandae ea consectetur quod dolorem alias dolores laborum tempora numquam magni itaque, veritatis, ipsum unde veniam quibusdam. Corrupti eos libero excepturi quia rem iure veniam odio dolore odit, cumque, sapiente ut, repellat placeat. Sapiente laboriosam sunt magni.
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#english" role="button">English</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Algebra</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Geometry</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Chemistry</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Biology</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Physics</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Law</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">IT</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Uzbek</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Russian</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Literature</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">НДП</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Religion</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Aesthetics</a>
            </div>


            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#levelsecond" role="button" aria-expanded="true">Level 2</a>
            </div>
            <div class="collapse buttoncol" id="levelsecond">
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#history" role="button">History</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#english" role="button">English</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Algebra</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Geometry</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Chemistry</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Biology</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Physics</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Law</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">IT</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Uzbek</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Russian</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Literature</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">НДП</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Religion</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Aesthetics</a>
            </div>
            <div>
                <a class="btn btn-primary btn-lg btn-block accord" id="accord1" data-toggle="collapse" href="#levelthird" role="button" aria-expanded="true">Level 3</a>
            </div>
            <div class="collapse buttoncol" id="levelthird">
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#english" role="button">English</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Algebra</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Geometry</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">IT</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Uzbek</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Russian</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;RUG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Native Language &#40;UZG&#41;</a>
                <a class="btn btn-primary btn-lg btn-block" id="accord1" href="#maths" role="button">Literature</a>
            </div>
        </div>
    </section>
</div>

<!-- foooter -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../css/jquery.min.js"></script>
<script src="../css/swiper.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../css/bootstrap.min.js" type="text/javascript"></script>
<!-- <script src="slick/slick.min.js"></script>    -->
<script src="../css/main.js" type="text/javascript"></script>

<!-- Core JS file -->
<script src="../css/photoswipe.min.js"></script>

<!-- UI JS file -->
<script src="../css/photoswipe-ui-default.min.js"></script>
<!--<a href="https://ru.freepik.com/free-vector/_801555.htm">Разработано через Freepik</a>-->
</body>

</html>

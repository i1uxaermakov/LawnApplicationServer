<%@ page import="sections.feed.posts.entities.Post" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post post = (Post) request.getAttribute("post");
%>






<!DOCTYPE html>
<html lang="ru-en">

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
    <link rel="stylesheet" href="css/gallery.css">
    <link rel="stylesheet" href="css/polls.css">
    <link rel="stylesheet" href="css/modal.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->



    <!-- Put this script tag to the <head> of your page -->
    <!-- Put this div tag to the place, where the Poll block will be -->


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
                <a class="navbar-brand" href="index.html">LAWN</a>
                <a class="myacc visible-xs" href="login.html">
                    <i class="fas fa-user-circle"></i>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="nav navbar-nav navbar-right container-fluid">
                    <li class="active">
                        <a data-toggle="tabs" href="index.html">
                            <i class="fas fa-home"></i>
                            Home</a>
                    </li>
                    <li class="">
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











<section class="newssection container-fluid">
<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 padd newsmargin">
    <div class="news" width="100%">
        <div class="newsbegin col-xs-12">
            <div class="l1">
                <a href="#<%--<%=post.getAuthorId%>--%>" target="_blanc">
                    <img src="imgs/un.jpg" alt="avatar">
                </a>
            </div>
            <div class="l2">
                <%
                    if(post.getOrganizationName()==null)
                    {
                %>
                <span><a href="#<%--<%=post.getAuthorId%>--%>" target="_blanc" class="post-publishers-name"><%=post.getAuthorName()%></a></span>

                <%}
                else{
                %>

                <span><a href="#<%--<%=post.getAuthorId%>--%>" target="_blanc" class="post-publishers-name"><%=post.getOrganizationName()%> - <%=post.getAuthorName()%></a></span>

                <%}%>

                <br>
                <span class="item-date"> <%=(new SimpleDateFormat("MMM dd, HH:ss")).format(post.getPublishDate()) %> </span>

            </div>
            <div class="dropdown ellipse">
                        <span class="" data-toggle="dropdown">
                        <i class="fas fa-ellipsis-v"></i>
                    </span>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li><a href="#">Complain</a></li>
                    <li><a href="#">Edit</a></li>
                    <li><a href="#">Delete</a></li>
                </ul>
            </div>
        </div>
        <div class="text">
            <%=post.getPostContent()%>
        </div>



        <%--private PostAlbum album;--%>



        <%if(post.getAlbum().getAlbumPhotos().size()==1) {%>
        <div class="row onephotorow">
            <div class="my-gallery" itemscope itemtype="">
                <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                    <a href="imgs/unn.jpg" itemprop="contentUrl" data-size="640x640">

                        <img src="imgs/unn.jpg" itemprop="thumbnail" alt="Image description" />

                    </a>
                    <figcaption itemprop="caption description">Image caption 3</figcaption>
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
                        <button class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)"></button>
                        <button class="pswp__button pswp__button--arrow--right" title="Next (arrow right)"></button>
                        <div class="pswp__caption">
                            <div class="pswp__caption__center"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <%
        }
        else if(post.getAlbum().getAlbumPhotos().size()==2){
        %>

        <div class="row twophotosrow">
            <div class="my-gallery" itemscope itemtype="">



                <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                    <!-- <div class="wrapperThumb"> -->

                    <a href="imgs/doing.png" itemprop="contentUrl" data-size="635x353">

                        <img src="imgs/doing.png" itemprop="thumbnail" alt="Image description" />

                    </a>
                    <!-- </div> -->
                    <figcaption itemprop="caption description">Image caption 3</figcaption>
                </figure>

                <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                    <a href="imgs/sv.png" itemprop="contentUrl" data-size="640x640">
                        <img src="imgs/sv.png" itemprop="thumbnail" alt="Image description" />
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

        <%
            }
            else if(post.getAlbum().getAlbumPhotos().size()>2){
        %>

        <div class="begingallery row">
            <img src="imgs/gallery/photo_2018-05-09_21-54-37.jpg" alt="" class="oblojka col-sm-4 col-sm-offset-0 col-xs-10 col-xs-offset-1">
            <div class="description col-sm-8 col-xs-12">
                <h2>Basketball Championship</h2>
                <div class="misc">
                    <span class="numberofphotos"> <%=post.getAlbum().getAlbumPhotos().size()%> photos</span>
                </div>
                <p>Продолжение горячего весеннего баскетбольного турнира!</p>
            </div>
        </div>

        <%}%>
        <div class="likes">
            <button type="button" class="btn counter"><i class="far fa-heart fa-2x like"></i><span class="likeCount">1222</span></button>
            <button type="button" class="btn"><i class="fas fa-share fa-2x"></i></button>
        </div>

    </div>



</div></section>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="css/jquery.min.js"></script>
<script src="css/swiper.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="css/bootstrap.min.js" type="text/javascript"></script>
<!-- <script src="slick/slick.min.js"></script>    -->
<script src="css/main.js" type="text/javascript"></script>

<!-- Core JS file -->
<script src="css/photoswipe.min.js"></script>

<!-- UI JS file -->
<script src="css/photoswipe-ui-default.min.js"></script>
<script src="css/like.js"></script>
</body>

</html>

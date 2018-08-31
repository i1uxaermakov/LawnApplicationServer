<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Lawn</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/default-skin/default-skin.css">
    <link rel="stylesheet" href="/css/add-homework.css">
    <link rel="stylesheet" href="/css/edu.css">
    <meta charset="UTF-8">
    <title>LAWN ADDING</title>
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
                    <li class="">
                        <a data-toggle="tabs" href="index.html">
                            <i class="fas fa-home"></i>
                            Home</a>
                    </li>
                    <li class="">
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
                    <li class="hidden-xs ">
                        <a data-toggle="tabs" href="login.html">
                            <i class="fas fa-user-circle"></i>
                            Sign In</a>
                    </li>
                    <li class="dropdown active">
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


<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 add-container first padd">

    <form name="addResourcesForm" id="addResourcesForm" enctype="multipart/form-data"></form>

    <section class="addingsection">
        <h5 class="input_header">Добавление ресурсов:</h5>

        <select form="addResourcesForm"
                id="lvl_select"
                onchange="changeSelectOptionsForLevel(this)"
                style="
                    width: 100%;
                    padding: 15px 10px 10px 10px;
                    background-position: 100% 50%;
                    background-repeat: no-repeat;
                    background-size: auto 15%;
                    border-radius: 0;
                    cursor: pointer;
                    -webkit-appearance: none;
                    border: 1px solid #efefef;
                    font-size: 20px;">
            <option style="color: grey" value="" disabled selected>Click/Touch to select level.</option>
            <option value="1"> Level 1 </option>
            <option value="2"> Level 2 </option>
            <option value="3"> Level 3 </option>
        </select>

        <hr>

        <select form="addResourcesForm"
                id="category_select"
                disabled="disabled"
                style="
                    width: 100%;
                    padding: 15px 10px 10px 10px;
                    background-position: 100% 50%;
                    background-repeat: no-repeat;
                    background-size: auto 15%;
                    border-radius: 0;
                    cursor: pointer;
                    -webkit-appearance: none;
                    border: 1px solid #efefef;
                    font-size: 20px;">
            <option style="color: grey" value="" disabled selected>To choose subject please choose level.</option>
        </select>
    </section>

    <div style="display: none" id="options">
        <%@include file="AddResourceItemOptionsJSP.jsp"%>
    </div>

    <section class="addingsection">
        <div id="previewFiles">

        </div>
    </section>

    <section class="addingsection">
        <div class="icons-add">
            <label for="file-input"><i class="fas fa-paperclip"></i></label>
            <input type="file" name="files" id="file-input" multiple form="addResourcesForm"/>
            <input type="submit" form="addResourcesForm" style="float: right" multiple class="btnn btn-suc">
        </div>
    </section>

</div>


<script src="/js/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<!-- <script src="slick/slick.min.js"></script>    -->
<script src="/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/jquery.min.js" charset="utf-8" type="text/javascript"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<!-- <script src="slick/slick.min.js"></script>    -->
<script src="/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/add-resources.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

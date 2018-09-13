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
<%--begin header--%>
<%request.setAttribute("ActiveNavBarSection", "education");%>
<%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
<%--end header--%>
<section class="tabsection container">
    <ul class="nav nav-tabs">
        <li class="first"><a   href="/edu/sc">Schedule</a></li>
        <li><a href="/edu/hw">Homework</a></li>
        <li class=""><a href="/edu/lib">Recources</a></li>
        <li class="active linkToAdd" style="float: right;">
            <a href="/edu/lib/add/files" style="color: #69a03c;font-size: 1.8em;padding-top: 0;padding-bottom: 0px;" title="Add resources!">+</a>
        </li>
    </ul>
</section>

<div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 add-container firstcontainer padd">

    <form name="addResourcesForm" id="addResourcesForm" enctype="multipart/form-data"></form>

    <section class="addingsection" style="margin-top: 2px !important;">
        <h5 class="input_header">Добавление ресурсов:</h5>

        <select form="addResourcesForm"
                id="lvl_select"
                onchange="changeSelectOptionsForLevel(this)">
            <option style="color: grey" value="" disabled selected>Click/Touch to select level.</option>
            <option value="1"> Level 1 </option>
            <option value="2"> Level 2 </option>
            <option value="3"> Level 3 </option>
            <option value="4"> Common </option>
        </select>

        <hr>

        <select form="addResourcesForm"
                id="category_select"
                disabled="disabled">
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

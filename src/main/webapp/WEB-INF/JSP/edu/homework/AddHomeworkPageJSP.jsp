<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

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
                <li class="first"><a href="/edu/sc">Schedule</a></li>
                <li class=""><a href="/edu/hw">Homework</a></li>
                <li><a href="/edu/lib">Resources</a></li>
                <li class="active plusSign" style="float: right;">
                    <a href="/edu/hw/add" style="color: #69a03c;font-size: 1.8em;padding-top: 0;padding-bottom: 0px;" title="Add homework!">+</a>
                </li>

            </ul>
        </section>

        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 add-container firstcontainer padd">

            <section class="addingsection">

                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-md">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Выберите </h4>
                            </div>


                            <div class="modal-body row">
                                <%@include file="AddHomeworkForWhomJSP.jsp"%>
                            </div>


                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>

                </div>





                <h5 class="input_header">Выберите группы:</h5>
                <div class="row subject-selected" id="subject-selected">

                </div>

                <div class="add_item_block center-content" data-toggle="modal" data-target="#myModal">
                    <span class="plus-button">+</span>
                </div>




            </section>


            <form name="addHWform" id="addHWform" enctype="multipart/form-data"></form>

            <section class="addingsection">
                    <div class="adding-area">

                        <div class="col-xs-12 hw-text">

                            <textarea name="hw-content" id="hw-text" form="addHWform" autocapitalize="sentences" autocomplete="on" autocorrect="on" placeholder="Напишите" spellcheck="true" dir="auto"></textarea>
                        </div>
                    </div>
                    <div class="icons-add">
                        <label for="image-input"><i class="far fa-image"></i></label>
                        <input type="file" name="image-input" id="image-input" multiple accept="image/*" form="addHWform">


                        <label for="file-input"><i class="fas fa-paperclip"></i></label>
                        <input type="file" name="files" id="file-input" multiple form="addHWform"/>


                        <input type="submit" form="addHWform" style="float: right" multiple class="btnn btn-suc">
                    </div>



            </section>

            <section class="addingsection">
                <div id="preview" class="row">

                </div>
            </section>

            <section class="addingsection">
                <div id="previewFiles">

                </div>
            </section>
        </div>

        <p style="display: none" id="NoDescription">Напишите, пожалуйста, описание к домашнему заданию!</p>
        <p style="display: none" id="BadDate">Вы неправильно указали дату для домашнего задания! Дата должна быть в формате ДД/ММ/ГГГГ.</p>
        <p style="display: none" id="NoGroupsSpecified">Укажите, пожалуйста, для каких групп вы добавляете домашнее задание!</p>
        <p style="display: none" id="ErrorWhileSendingHW">Произошла ошибка при отправлении домашнего задания ученикам. Попробуйте, пожалуйста, позже.</p>
        <p style="display: none" id="ErrorWhileSendingHWFiles">Произошла ошибка при отправлении прикрепленных файлов или фотографий. Вы сможете отправить файлы позже в виде отдельного домашнего задания. Не отправляйте домашнее задание заново.</p>

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
    <script src="/js/add-homework.js" type="text/javascript"></script>
    </body>
</html>

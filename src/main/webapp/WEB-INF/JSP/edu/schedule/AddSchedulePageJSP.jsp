<%@ page import="sections.education.entities.LyceumGroup" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Add Schedule - LAWN</title>

        <%--favicons begin--%>
        <link rel="apple-touch-icon" sizes="180x180" href="/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/favicon/favicon-16x16.png">
        <link rel="manifest" href="/favicon/site.webmanifest">
        <link rel="mask-icon" href="/favicon/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#da532c">
        <meta name="theme-color" content="#ffffff">
        <%--favicons end--%>

        <!-- Bootstrap -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/main.css" rel="stylesheet">
        <link href="/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="/css/default-skin/default-skin.css">
        <link rel="stylesheet" href="/css/add-schedule.css">
        <link rel="stylesheet" href="/css/edu.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
        <meta charset="UTF-8">
    </head>

    <body>
        <%--begin header--%>
        <%request.setAttribute("ActiveNavBarSection", "education");%>
        <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
        <%--end header--%>

        <%
            String message = (String) request.getAttribute("message");
            if(Objects.isNull(message)) {
                List<LyceumGroup> groupList = (List<LyceumGroup>) request.getAttribute("groupList");
        %>
        <section class="addingsection first col-md-10 col-md-offset-1 tab-pane fade in active">
            <span class="dzdlya oxuenniyklass">Расписание для:</span>
            <select class="selectpicker"  data-live-search="true" id="groupSelector" onchange="getScheduleOfAnotherGroup()">
                <%  Long groupID = (Long) request.getAttribute("groupID");
                    for(LyceumGroup group: groupList) {%>
                <option value="<%=group.getId()%>" <%=(group.getId().equals(groupID))?"selected":""%>>
                    <%=group.getGroupName()%>
                </option>
                <%}%>
            </select>
        </section>

        <section class="blocks col-md-10 col-md-offset-1 tab-pane fade in active" style="margin-bottom: 30px" id="schedule">
            <%@include file="/WEB-INF/JSP/edu/schedule/AddScheduleContentVisualizer.jsp"%>
        </section>

        <%
            }
            else {%>
        <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd" style="background: white;padding: 5px;margin-top: 50px;">
            <div class="newsbegin" style="
            text-align: center;
            font-size: 20px;
            margin-bottom: 0px;
            padding-bottom: 0px;
            height:auto !important;
            background: white;
            padding: 15px;">
                <span>К сожалению, группы еще не добавлены. <br> Пока что вы не можете изменять расписание.</span>
            </div>
        </div>
        <%}


        %>



        <script src="/js/jquery.min.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- <script src="slick/slick.min.js"></script>    -->
        <script src="/js/main.js" type="text/javascript"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

        <!-- (Optional) Latest compiled and minified JavaScript translation files -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/i18n/defaults-*.min.js"></script>

        <script src="/js/add-schedule.js"></script>
    </body>
</html>

<%--<!-- modals -->--%>
<%--<div id="modal1" class="modal fade" role="dialog">--%>
<%--<div class="modal-dialog">--%>

<%--<!-- Modal content-->--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header">--%>
<%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--Add Subject--%>
<%--</div>--%>
<%--<div class="modal-body">--%>
<%--<label for="">Предмет: <br><input type="text" class="subject"></label><br>--%>
<%--<label for="">Время: <br><input type="text" class="time" placeholder="В формате 8.30-9.40"></label><br>--%>
<%--<label for="">Место: <br><input class="venue" type="text"></label><br>--%>
<%--<input type="submit" onclick="addsubject(this)">--%>
<%--</div>--%>
<%--<div class="modal-footer">--%>
<%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>
<%--</div>--%>


<%--<div id="modal2" class="modal fade" role="dialog">--%>
<%--<div class="modal-dialog ">--%>

<%--<!-- Modal content-->--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header">--%>
<%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--<h4 class="modal-title">Add Subject Info</h4>--%>
<%--</div>--%>
<%--<div class="modal-body">--%>
<%--<label for="">Предмет: <br><input type="text" class="subject" placeholder="алгбера"></label><br>--%>
<%--<label for="">Время: <br><input type="text" class="time" placeholder="В формате 8.30-9.40"></label><br>--%>
<%--<label for="">Место: <br><input type="text" class="venue" placeholder="кабинет 13"></label><br>--%>
<%--<input type="submit" onclick="addsubject(this)">--%>

<%--</div>--%>
<%--<div class="modal-footer">--%>
<%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>
<%--</div>--%>
<%--<div id="modal32" class="modal fade" role="dialog">--%>
<%--<div class="modal-dialog">--%>

<%--<!-- Modal content-->--%>
<%--<div class="modal-content">--%>
<%--<div class="modal-header">--%>
<%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--Add Subject--%>
<%--</div>--%>
<%--<div class="modal-body">--%>
<%--<label for="">Предмет: <br><input type="text" class="subject"></label><br>--%>
<%--<label for="">Время: <br><input type="text" class="time" placeholder="В формате 8.30-9.40"></label><br>--%>
<%--<label for="">Место: <br><input class="venue" type="text"></label><br>--%>
<%--<input type="submit" onclick="addsubject(this)">--%>
<%--</div>--%>
<%--<div class="modal-footer">--%>
<%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>
<%--</div>--%>
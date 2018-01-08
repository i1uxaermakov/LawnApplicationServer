<%@ page import="model.entities.wrappers.BriefNewsItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<BriefNewsItem> briefNewsItemList = (List<BriefNewsItem>) request.getAttribute("briefNewsItemList");

    for (BriefNewsItem briefNewsItem: briefNewsItemList) {

    String classNews = " ";
    if(briefNewsItem.getUrgency()!=null) {
        if (briefNewsItem.getUrgency().equals(2)) {
            classNews = "important";
        } else if (briefNewsItem.getUrgency().equals(3)) {
            classNews = "veryimportant";
        }
    }

%>
<%--important veryim--%>
<div class="news <%=classNews%>">
    <h2 class="headernews"> <%=briefNewsItem.getTitle() %></h2>
    <div class="text">
        <%=briefNewsItem.getExtract()%>
        <a href="#">See more...</a>
    </div>
    <%--<div class="row">--%>
        <%--<div class="img">--%>
            <%--<img src="image.png" alt="" class="imagenews col-lg-10 col-lg-offset-1 col-xs-12">--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="people">
        <span class="person"><a href=""><%=briefNewsItem.getSphere()%></a></span>
        <span class="time text-left" style="float: right;">5 minutes ago</span>
    </div>
</div>


<%
    }
%>
</body>
</html>

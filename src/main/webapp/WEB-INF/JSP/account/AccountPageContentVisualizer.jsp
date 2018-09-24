<%@ page import="account.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("User");
%>
<div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd" style="background: white;padding: 5px;">
    <div class="profile-info">
        <div class="imagediv text-center">
            <img src="http://31.135.214.43:8089/images/hwPhotos/28C2570A68CCBAA8865BD453BFC7FEDE_square999x999.jpg" alt="" class=""
                 style="padding: 10px;border-radius: 50%;width: 170px;">
        </div>
        <div class=" text-center" style="padding-right: 0;padding-top: 15px;padding-bottom: 25px;">
                <span style="margin: 0;font-size: 1.7em;">
                    <%=user.getFullName()%>
                </span><br>
            <span style="font-size: 1.3em;">
                    <%=user.getGroupName()%>
                </span>
        </div>

    </div>
    <a type="button" class="btn btn-lg btn-block accountPageButton" style="color: black" href="/files/fav">Favorite Files</a>
    <a type="button" class="btn btn-lg btn-block accountPageButton" style="color: black" href="/xuy">Change Password</a>
    <a type="button" class="btn btn-lg btn-block accountPageButton" style="color: black" href="/signout">Sign Out</a>
    <%--<div class="alert alert-success" role="alert" style="margin-top: 5px;margin-bottom: 0;">--%>
    <%--<h4 class="alert-heading">Contact us if</h4>--%>
    <%--<p>1. You need to sfknsflknaslfnlksanmflks</p>--%>
    <%--<hr>--%>
    <%--<p class="mb-0"><a href="http:/t.me/lawn">Telegram</a></p>--%>
    <%--</div>--%>
</div>


<%@ page import="account.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("User");
%>
<div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd" style="background: white;padding: 5px;">
    <div class="profile-info">
        <div class="imagediv text-center">
            <img src="/logo/logo-white.png" alt="" class=""
                 style="padding: 10px;border-radius: 50%;width: 170px;">
        </div>
        <div class=" text-center" style="padding-right: 0;padding-top: 15px;padding-bottom: 25px;">
                <span style="margin: 0;font-size: 1.7em;"><%=user.getFullName()%></span>
            <br>
            <span style="font-size: 1.3em;">
                    <%=user.getGroupName()%>
                </span>
        </div>

    </div>
    <a type="button" class="btn btn-lg btn-block accountPageButton" style="color: black" href="/files/fav">Favorite Files</a>
    <span type="button" class="btn btn-lg btn-block accountPageButton" style="color: black"  data-toggle="modal" data-target="#myModal">Change Password</span>
    <a type="button" class="btn btn-lg btn-block accountPageButton" style="color: black" href="/signout">Sign Out</a>
    <%--<div class="alert alert-success" role="alert" style="margin-top: 5px;margin-bottom: 0;">--%>
    <%--<h4 class="alert-heading">Contact us if</h4>--%>
    <%--<p>1. You need to sfknsflknaslfnlksanmflks</p>--%>
    <%--<hr>--%>
    <%--<p class="mb-0"><a href="http:/t.me/lawn">Telegram</a></p>--%>
    <%--</div>--%>

    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 class="modal-title">Change Password</h2>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p class="text-center">Use the form below to change your password. <br> Your password cannot be the same as your username.</p>
                            <form method="post" id="passwordForm">
                                <h4>Old password:</h4>
                                <input type="password" class="input-lg form-control" name="oldpass" id="oldpass" placeholder="Your old password" autocomplete="off">
                                <h4>New password:</h4>
                                <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="Your new password" autocomplete="off">
                                <h4>Repeat password:</h4>
                                <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat your password" autocomplete="off">

                             </form>
                        </div><!--/col-sm-6-->
                    </div><!--/row-->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" modalid="modal1" id="saveButton">Сохранить</button>
                </div>

            </div>

        </div>
    </div>



</div>


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
                    <h4 class="modal-title">Change Password</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p class="text-center">Use the form below to change your password. Your password cannot be the same as your username.</p>
                            <form method="post" id="passwordForm">
                                <input type="password" class="input-lg form-control" name="oldpass" id="oldpass" placeholder="Old Password" autocomplete="off">

                                <input type="password" class="input-lg form-control" name="password1" id="password1" placeholder="New Password" autocomplete="off">
                                <%--<div class="row">--%>
                                <%--<div class="col-sm-6">--%>
                                <%--<span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>--%>
                                <%--<span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter--%>
                                <%--</div>--%>
                                <%--<div class="col-sm-6">--%>
                                <%--<span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>--%>
                                <%--<span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <input type="password" class="input-lg form-control" name="password2" id="password2" placeholder="Repeat Password" autocomplete="off">
                                <%--<div class="row">--%>
                                <%--<div class="col-sm-12">--%>
                                <%--<span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match--%>
                                <%--</div>--%>
                                <%--</div>--%>
                             </form>
                        </div><!--/col-sm-6-->
                    </div><!--/row-->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="changePass()" modalid="modal1" id="saveButton">Сохранить</button>
                </div>

            </div>

        </div>
    </div>



</div>

<script>
    var equalPass = false;
    $("input[type=password]").keyup(function(){
        var ucase = new RegExp("[A-Z]+");
        var lcase = new RegExp("[a-z]+");
        var num = new RegExp("[0-9]+");

        if($("#password1").val() == $("#password2").val()){

         equalPass = true;

        }
//        else{
//            $("#pwmatch").removeClass("glyphicon-ok");
//            $("#pwmatch").addClass("glyphicon-remove");
//            $("#pwmatch").css("color","#FF0004");
//        }

    });

    $('#saveButton').click(function () {
       if(equalPass){

           $("#myModal").modal("hide");

       }
       else{
           alert("Passwords are not equal");
       }
    });
</script>
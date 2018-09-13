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
    <meta charset="UTF-8">
    <title>LAWN LOGIN</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Roboto:300);

        .login-page {
            width: 360px;
            padding: 8% 0 0;
            margin: auto;
            margin-top: 100px;
        }
        .form {
            position: relative;
            z-index: 1;
            background: #FFFFFF;
            max-width: 360px;
            margin: 0 auto 100px;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        .form input.textinput {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #69a03c;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
        }
        .form button:hover,.form button:active,.form button:focus {
            background: #43A047;
        }
        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }
        .form .message a {
            color: #4CAF50;
            text-decoration: none;
        }
        .form .register-form {
            display: none;
        }
        .container {
            position: relative;
            z-index: 1;
            max-width: 300px;
            margin: 0 auto;
        }
        .container:before, .container:after {
            content: "";
            display: block;
            clear: both;
        }
        .container .info {
            margin: 50px auto;
            text-align: center;
        }
        .container .info h1 {
            margin: 0 0 15px;
            padding: 0;
            font-size: 36px;
            font-weight: 300;
            color: #1a1a1a;
        }
        .container .info span {
            color: #dfead6;
            font-size: 12px;
        }
        .container .info span a {
            color: #000000;
            text-decoration: none;
        }
        .container .info span .fa {
            color: #EF3B3A;
        }
        #marg10{
            margin-bottom: 0;
        }
        div.checkbox{
            margin-top: 15px;
        }
    </style>
    <script>
        $('.message a').click(function(){
            $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        });
    </script>
</head>
    <body>
        <%--begin header--%>
        <%request.setAttribute("ActiveNavBarSection", "authorisation");%>
        <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
        <%--end header--%>

        <div class="login-page">
            <div class="form">
                <form class="login-form" action="/signin" method="post" id="SignInForm">
                    <h1 id="loginsign" style="margin-bottom: 10px;">LOG IN</h1>
                    <h5 id="warn" style="background-color: rgb(249,215,215); padding: 5px; display: none;">Username or password is incorrect. Please try again.</h5>
                    <center id="loader" style="display: none"><div class="lds-hourglass"></div></center>
                    <input class="textinput" type="text" placeholder="ID" name="login" id="login" autocomplete="off"/>
                    <input class="textinput" type="password" placeholder="Password" name="password" id="password" autocomplete="off"/>
                    <div class="checkbox text-left">
                        <label><input type="checkbox" name="rememberme" id="rememberme"> Remember me</label>
                    </div>
                    <button>SIGN IN</button>
                </form>
            </div>
        </div>


        <script src="/js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- <script src="slick/slick.min.js"></script>    -->
        <script src="/js/main.js" type="text/javascript"></script>
        <script src="/js/signin.js" type="text/javascript"></script>
    </body>
</html>

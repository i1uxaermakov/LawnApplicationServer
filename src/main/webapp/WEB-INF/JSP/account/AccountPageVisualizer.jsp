<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Account and Settings - LAWN</title>

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
    <link href="/css/swiper.min.css" rel="stylesheet">
    <link href="/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/edu.css">
    <link rel="stylesheet" href="/css/posts-template.css">
    <link rel="stylesheet" href="/css/photoswipe.css">
    <link rel="stylesheet" href="/css/default-skin/default-skin.css">
    <link rel="stylesheet" href="/css/gallery.css">
    <style>
        form input{
            margin-bottom: 5px;
        }
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .accountPageButton {
            border: 1px #80808082 solid;
            background: white;
        }
    </style>
</head>

<body id="body">
    <%--begin header--%>
    <%request.setAttribute("ActiveNavBarSection", "authorisation");%>
    <%@include file="/WEB-INF/JSP/header/HeaderVisualizerJSP.jsp"%>
    <%--end header--%>

    <section style="margin-top:50px">
        <%@include file="/WEB-INF/JSP/account/AccountPageContentVisualizer.jsp"%>
    </section>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/js/main.js" type="text/javascript"></script>
    <script src="/js/edu.js"></script>
    <script src="/js/photoswipe.min.js"></script>
    <script src="/js/photoswipe-ui-default.min.js"></script>

    <script>
        var equalPass = false;
        $("input[type=password]").keyup(function(){

            $("#password1").css("border-color","black");
            $("#password2").css("border-color","black");

            var oldpass = $('#oldpass').val();
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();

            if(oldpass!="" && password1!="" && password2!="" && password1===password2){
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
//                var oldpass = $('#oldpass').val();
//                var password1 = $("#password1").val();
//                var password2 = $("#password2").val();
                var formData = new FormData();
                formData.set('oldpass', $('#oldpass').val());
                formData.set('newpass', $('#password1').val());

                console.log($('#oldpass').val());
                console.log($('#password1').val());

                $.ajax({
                    url:  '/acc/changepassword',
                    type: 'post',
                    processData: false,
                    contentType: false,
                    enctype: 'multipart/form-data',
                    data: formData,
                    cache: false,
                    timeout: 600000,
                    //before while the request is in process, show spinner
                    success : function () {
                        // when password is changed, I invalidate current session and delete all RememberMeCookies from Database
                        // Redirect page to /signin
                    },
                    error : function () {
                        // error 403 - when oldpassword is incorrect
                        // any other error - show the response (in response there will be html page with error information)
                    }
                });



                $("#myModal").modal("hide");
            }
            else{
                $("#password1").css("border-color","red");
                $("#password2").css("border-color","red");

            }
        });
    </script>
</body>

</html>


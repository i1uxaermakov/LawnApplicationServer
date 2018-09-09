document.getElementById("SignInForm").addEventListener("submit", function(event) {
    event.preventDefault();
    $("#warn").fadeOut(200);

    var login = $("#login").val();
    console.log(login + "login");
    var password = $("#password").val();
    var rememberme = $("#rememberme").val();

    var formData = new FormData();
    formData.set("login", login);
    formData.set("password", password);
    formData.set("rememberme", rememberme);

    $.ajax({
        url:  '/signin',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        beforeSend: function() {
            $("#warn").hide();
            $("#spinner").fadeIn(100);
            $("#loginsign").css("margin-bottom:", "0px");
        },
        error: function (data,textStatus,jqXHR) {
            // $("#loginsign").css("margin-bottom:", "10px");
            $("#spinner").hide();
            $("#warn").fadeIn(100);
        },
        success: function () {
            window.location.href = "/edu";
        }
    });
});

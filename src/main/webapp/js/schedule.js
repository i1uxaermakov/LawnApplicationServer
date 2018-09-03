function showHomeworkBySubjectAddUp(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal'+subjID+'body';
    var el = document.getElementById(id);

    var formData = new FormData();
    var request = new XMLHttpRequest();

    var firstChild = el.firstElementChild;

    if(firstChild != null) {
        var date = firstChild.getAttribute('lastDate');
        if(date != null) {
            formData.set('date', date);
        }
    }

    formData.set("sid", subjID);
    formData.set("purpose","add_up");
    request.open("POST", '/edu/hw/subject', true);
    request.send(formData);

    //todo xml look functions
    request.onload = function () {
        if(request.status===200) {
            var hw = request.responseText;
            el.innerHTML = hw + el.innerHTML;
            initPhotoSwipeFromDOM('.my-gallery');
        }
        else if(request.status===401) {
            window.location.href = "/signin";
        }
        else {
            el.innerHTML =
                '<div class="news warn" onclick="showHomeworkBySubjectAddUp(this.parentElement)" style="padding-bottom: 15px; margin-bottom: 10px;">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
                        '<span >There was a problem downloading new HW. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>' +
            el.innerHTML;
        }
    };
    // request.
}

function showHomeworkBySubjectAddDown(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal' + subjID + 'body';
    var el = document.getElementById(id);
    var lastDate = $(element).attr('lastDate')




    var formData = new FormData();
    var request = new XMLHttpRequest();

    formData.set('date', lastDate);
    formData.set("sid",subjID);
    formData.set("purpose","add_down");
    request.open("POST",'/edu/hw/subject', true);
    request.send(formData);

    element.remove();
    request.onload = function () {
        if(request.status===200) {
            var hw = request.responseText;
            el.innerHTML = el.innerHTML + hw;
            initPhotoSwipeFromDOM('.my-gallery');
        }
        else if(request.status===401) {
            window.location.href = "signin";
        }
        else {
            el.innerHTML = el.innerHTML +
                '<div class="news warn" onclick="showHomeworkBySubjectAddDown(this)" ' +
                    'style="padding-bottom: 15px; margin-bottom: 10px;" ' +
                    'sID="'+ subjID +'" lastDate="'+lastDate+'">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
                        '<span >There was a problem downloading older HW. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>';
        }
    };
}
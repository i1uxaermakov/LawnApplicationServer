function showHomeworkBySubjectAddUp(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal'+subjID+'body';
    var el = document.getElementById(id);

    var formData = new FormData();
    var request = new XMLHttpRequest();

    var firstChild = el.firstElementChild;
    console.log("firstChild" + firstChild);

    if(firstChild != null) {
        var date = firstChild.getAttribute('lastDate');
        formData.set('date', date);
    }

    formData.set("sid", subjID);
    formData.set("purpose","add_up");
    request.open("POST", 'http://localhost:8080/edu/hw/subject', true);
    request.send(formData);

    request.onload = function () {
        if(request.status===200) {
            var hw = request.responseText;
            console.log(hw);
            el.innerHTML = hw + el.innerHTML;
            initPhotoSwipeFromDOM('.my-gallery');
        }
        else {
            el.innerHTML =
                '<div class="news" onclick="showHomeworkBySubjectAddUp(parent(this))" style="padding-bottom: 15px; margin-bottom: 10px;">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px; padding-bottom: 0px; height:auto !important;">' +
                        '<span >There was a problem downloading new HW. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>' +
            el.innerHTML;
        }
    };
}

function showHomeworkBySubjectAddDown(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal' + subjID + 'body';
    var el = document.getElementById(id);

    var formData = new FormData();
    var request = new XMLHttpRequest();

    formData.set('date',element.attr('lastDate'));
    formData.set("sid",subjID);
    formData.set("purpose","add_down");
    request.open("POST",'http://localhost:8080/edu/hw/subject', true);
    request.send(formData);

    el.remove();
    request.onload = function () {
        if(request.status===200) {
            var hw = request.responseText;
            el.innerHTML.append(hw);
            initPhotoSwipeFromDOM('.my-gallery');
        }
        else {
            el.innerHTML.append(
                '<div class="news" onclick="showHomeworkBySubjectAddDown(parent(this))" style="padding-bottom: 15px; margin-bottom: 10px;">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px; padding-bottom: 0px; height:auto !important;">' +
                        '<span >There was a problem downloading HW. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>');
        }
    };
}
function showHomeworkBySubjectAddUp(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal'+subjID+'body';
    var el = $("#"+id);
    loaderGif('#'+id, true, "");
    var ell = document.getElementById(id);

    var formData = new FormData();
    formData.set("sid", subjID);
    formData.set("purpose","add_up");
    var firstChild = ell.firstElementChild;
    if(firstChild != null) {
        firstChild = el.first();
        var date = firstChild.attr('lastDate');
        if(date != null) {
            formData.set('date', date);
        }
    }

    function tackleErrorAddUp() {
        loaderGif('#'+id, false);
        el.prepend(
            '<div class="news warn" onclick="showHomeworkBySubjectAddUp(this.parentElement)" style="padding-bottom: 15px; margin-bottom: 10px;">' +
            '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
            '<span >There was a problem downloading new HW. <br> Press here to try again.</span>' +
            '</div>' +
            '</div>'
        );
    }

    $.ajax({
        url:  '/edu/hw/subject',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        success: function (data,textStatus,jqXHR) {
            $('.warn').remove();
            loaderGif("#"+id, false, " ");
            el.prepend(data);
            initPhotoSwipeFromDOM('.my-gallery');
        },
        error: function (data,textStatus,jqXHR) {
            if(jqXHR.status===401) {
                window.location.href = "/signin";
            }
            else {
                tackleErrorAddUp();
            }
        }
    });
}

function showHomeworkBySubjectAddDown(element) {
    var subjID = $(element).attr("sID");
    var id = 'myModal' + subjID + 'body';
    var el = $("#"+id);
    loaderGif('#'+id, true, "");
    var lastDate = $(element).attr('lastDate');

    var formData = new FormData();

    formData.set('date', lastDate);
    formData.set("sid",subjID);
    formData.set("purpose","add_down");

    element.remove();

    function tackleErrorAddDown() {
        loaderGif('#'+id, false);

        el.append(
            '<div class="news warn" onclick="showHomeworkBySubjectAddDown(this)" ' +
            'style="padding-bottom: 15px; margin-bottom: 10px;" ' +
            'sID="'+ subjID +'" lastDate="'+lastDate+'">' +
            '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
            '<span >There was a problem downloading older HW. <br> Press here to try again.</span>' +
            '</div>' +
            '</div>'
        );
    }

    $.ajax({
        url:  '/edu/hw/subject',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        success: function (data,textStatus,jqXHR) {
            loaderGif('#'+id, false);
            el.append(data);
            initPhotoSwipeFromDOM('.my-gallery');
        },
        error: function (data,textStatus,jqXHR) {
            if(jqXHR.status===401) {
                window.location.href = "/signin";
            }
            else {
                tackleErrorAddDown();
            }
        }
    });
}
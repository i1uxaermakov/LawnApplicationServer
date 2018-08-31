function getResourceItemsByCategoryIdAddUp(element) {
    var modalId = $(element).attr('id') + "ModalBody";
    var catId = $(element).attr('catid');
    var whereToPut = document.getElementById(modalId);

    var formData = new FormData();
    var request = new XMLHttpRequest();

    var firstChild = whereToPut.firstElementChild;
    console.log("firstChild" + firstChild);

    if(firstChild != null) {
        var date = firstChild.getAttribute('date');
        if(date != null) {
            formData.set('date', date);
        }
    }

    formData.set("cid", catId);
    formData.set("purpose","add_up");
    request.open("POST", 'http://localhost:8080/edu/lib/files', true);
    request.send(formData);

    request.onload = function () {
        if(request.status===200) {
            var files = request.responseText;
            console.log(files);
            whereToPut.innerHTML = files + whereToPut.innerHTML;
            // initPhotoSwipeFromDOM('.my-gallery');
        }
        else if(request.status===401) {
            window.location.href = "/signin";
        }
        else {
            whereToPut.innerHTML =
                '<div class="news warn" onclick="getResourceItemsByCategoryIdAddUp($element)" style="padding-bottom: 15px; margin-bottom: 10px;">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
                        '<span >There was a problem downloading resource files. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>' +
                whereToPut.innerHTML;
        }
    };

}

function getResourceItemsByCategoryIdAddDown(element) {
    var catID = $(element).attr("cID");
    var id = $(element).attr('id') + "ModalBody";
    var el = document.getElementById(id);
    var lastDate = $(element).attr('lastDate')

    var formData = new FormData();
    var request = new XMLHttpRequest();

    formData.set('date', lastDate);
    formData.set("cid",catID);
    formData.set("purpose","add_down");
    request.open("POST",'http://localhost:8080/edu/lib/files', true);
    request.send(formData);

    element.remove();
    request.onload = function () {
        if(request.status===200) {
            var files = request.responseText;
            el.innerHTML = el.innerHTML + files;
            // initPhotoSwipeFromDOM('.my-gallery');
        }
        else if(request.status===401) {
            window.location.href = "signin";
        }
        else {
            el.innerHTML = el.innerHTML +
                '<div class="news" onclick="showHomeworkBySubjectAddDown(this)" ' +
                    'style="padding-bottom: 15px; margin-bottom: 10px;" ' +
                    'cID="'+ catID +'" lastDate="'+lastDate+'">' +
                    '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
                '<span >There was a problem downloading resource files. <br> Press here to try again.</span>' +
                    '</div>' +
                '</div>';
        }
    };
}
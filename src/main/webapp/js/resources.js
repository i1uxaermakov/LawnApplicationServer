function getResourceItems(element) {
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
            var hw = request.responseText;
            console.log(hw);
            el.innerHTML = hw + el.innerHTML;
            initPhotoSwipeFromDOM('.my-gallery');
        }
        else if(request.status===401) {
            window.location.href = "/signin";
        }
        else {
            el.innerHTML =
                '<div class="news" onclick="showHomeworkBySubjectAddUp(parent(this))" style="padding-bottom: 15px; margin-bottom: 10px;">' +
                '<div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0; padding-bottom: 0; height:auto !important;">' +
                '<span >There was a problem downloading new HW. <br> Press here to try again.</span>' +
                '</div>' +
                '</div>' +
                el.innerHTML;
        }
    };



}
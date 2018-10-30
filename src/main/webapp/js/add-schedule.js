var addsubject = function(e){
    var modalID = $(e).attr('modalID');
    var modalBody = $('#'+modalID+'Body');
    var modalBodyId = "#"+modalID+"Body";
    var subject = modalBody.find('input.subject').val();
    var teacher = modalBody.find('select').find('option:selected').text();
    var teacherID = modalBody.find('select').find('option:selected').val();
    var venue = modalBody.find('input.venue').val();
    var id = modalID.split('modal')[1];
    var nomerUroka = id;

    var groupId = $('#groupSelector').find('option:selected').val();

    while(nomerUroka-8>0) {
        nomerUroka-=8;
    }


    var formData = new FormData();
    formData.set('sname', subject);
    formData.set('tid', teacherID);
    formData.set('venue', venue);
    formData.set('place_on_page', id);
    formData.set('gid', groupId);

    console.log(formData);

    $.ajax({
        url:  '/edu/sc/add/item',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        beforeSend: function() {
            $(modalBodyId + " label").hide();
            console.log("beforesend")
            loaderGif(modalBodyId, true, "")
        },
        success: function () {
            console.log("success")
            $('#subject'+id).html('<div class="ordles">'+Math.ceil(nomerUroka/2)+'</div><div class="content-schedule"><h2>'+subject+'</h2><p>'+teacher+' <br> '+venue+'</p></div>');
            loaderGif(modalBodyId, false, "")
            $(modalBodyId + " label").show();
        },
        error: function() {
            loaderGif(modalBodyId, false, "")
            $(modalBodyId).append('<h4>Some kind of error occurred. Fuck yourself and refresh the page</h4>>')
        }
    });
};


var getScheduleOfAnotherGroup = function () {
    var select = $('#groupSelector');
    var selectedGroup = select.find('option:selected').val();

    console.log(selectedGroup);

    var formData = new FormData();
    formData.set('gid',selectedGroup);

    $.ajax({
        url:  '/edu/sc/add',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        beforeSend: function() {
//todo showloader
        },
        success: function (data,textStatus,jqXHR) {
            $('#schedule').empty();
            $('#schedule').html(data);
        },
        error: function (data,textStatus,jqXHR) {
            //todo lawn error alert
        }
    });
};
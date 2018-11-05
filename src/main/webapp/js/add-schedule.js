var checkifeligible = function(element){
    var idoftheelemt = $(element).attr('id');
    idoftheelemt = idoftheelemt.split('subject')[1];
    if(idoftheelemt%2==0) {
        var idofprev = idoftheelemt-1;
        if($('#subject'+idofprev).find('.ordles').length !== 0){
            $('#modal'+idoftheelemt).modal('show');
        }
    }
    else {
        $('#modal'+idoftheelemt).modal('show');
    }
};

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
    if(teacher==null || teacher==""||subject==null || subject==""||venue==null || venue=="" ) {
    alert("Not sufficient info")
    }
    else{
        nomerUroka %= 8;

        var formData = new FormData();
        formData.set('sname', subject);
        formData.set('tid', teacherID);
        formData.set('venue', venue);
        formData.set('place_on_page', id);
        formData.set('gid', groupId);

        console.log(formData);

        $.ajax({
            url: '/edu/sc/add/item',
            type: 'post',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            data: formData,
            cache: false,
            timeout: 600000,
            beforeSend: function () {
                $(modalBodyId + " label").hide();
                console.log("beforesend");
                loaderGif(modalBodyId, true, "");
            },
            success: function () {
                console.log("success");
                $('#subject' + id).html('<div class="ordles">' + Math.ceil(nomerUroka / 2) + '</div><div class="content-schedule"><h2>' + subject + '</h2><p>' + teacher + ' <br> ' + venue + '</p></div>');
                loaderGif(modalBodyId, false, "");
                $(modalBodyId + " label").show();
            },
            error: function () {
                loaderGif(modalBodyId, false, "");
                $(modalBodyId).append('<h4>Some kind of error occurred. Fuck yourself and refresh the page</h4>>')
            }
        });
    }
};


var getScheduleOfAnotherGroup = function () {
    var select = $('#groupSelector');
    var selectedGroup = select.find('option:selected').val();
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
            $('#schedule').empty();
            loaderGif('#schedule', true, " ");
        },
        success: function (data,textStatus,jqXHR) {
            loaderGif("#schedule", false, " ");
            $('#schedule').html(data);
        },
        error: function (data,textStatus,jqXHR) {
            loaderGif("#schedule", false, " ");
        }
    });
};

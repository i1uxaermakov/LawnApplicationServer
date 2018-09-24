var addsubject = function(e){
    var modalID = $(e).attr('modalID');
    var modalBody = $('#'+modalID+'Body');

    var subject = modalBody.find('input.subject').val();
    var teacher = modalBody.find('select').find('option:selected').text();
    var teacherID = modalBody.find('select').find('option:selected').val();
    var venue = modalBody.find('input.venue').val();
    var id = modalID.split('modal')[1];
    var nomerUroka = id;

    while(nomerUroka-8>0) {
        nomerUroka-=8;
    }

    $('#subject'+id).html('<div class="ordles">'+Math.ceil(nomerUroka/2)+'</div><div class="content-schedule"><h2>'+subject+'</h2><p>'+teacher+' <br> '+venue+'</p></div>');

    var formData = new FormData();
    formData.set('subj_name', subject);
    formData.set('teacherID', teacherID);
    formData.set('venue', venue);
    formData.set('place_on_page', id);

    $.ajax({
        url:  '/edu/sc/add/subject',
        type: 'post',
        processData: false,
        contentType: false,
        enctype: 'multipart/form-data',
        data: formData,
        cache: false,
        timeout: 600000,
        beforeSend: function() {
            //todo show loader
        },
        success: function () {
            //todo alertlown vse okey
        },
        error: function() {
            //todo alertLAWN
        }
    });
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
//todo showloader
        },
        success: function (data,textStatus,jqXHR) {
            $('#schedule').html(data);
        },
        error: function (data,textStatus,jqXHR) {
            //todo lawn error alert
        }
    });
};
var showLoader = function(){
    $('.firstcontainer').after('<div id="loaderDiv" class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 "></div>')
    $('#loaderDiv').css('margin-top','5px');
    $('#loaderDiv').html('<center><div class="lds-hourglass"></div></center>');

}
function dontClose(){
    window.onbeforeunload = function(e) {
        var dialogText = 'You did not finish adding';
        e.returnValue = dialogText;
        return dialogText;
    };
}
function successShow(){
    $('#loaderDiv').hide();
    $('.firstcontainer').after('<div id="successDiv" class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 "></div>')
    $('#successDiv').css('margin-top','5px');
    $('#successDiv').html('<center><div class="alert alert-success"> <strong>Success!</strong> All files uploaded. Now, you will be redirected to Resources Page.</div></center>')
    window.onbeforeunload = null;


}
function hidePageContent(){
    $('.firstcontainer').hide();
}
function changeSelectOptionsForLevel(element) {
    var lvlSelect = document.getElementById("lvl_select");
    var lvlSelectValue = lvlSelect.options[lvlSelect.selectedIndex].value;

    var categorySelect = document.getElementById("category_select");
    if(document.getElementById("category_select_"+lvlSelectValue)==null) {
        categorySelect.innerHTML = "";
        $(categorySelect).attr("disabled","disabled");
    }
    else {
        categorySelect.innerHTML = document.getElementById("category_select_" + lvlSelectValue).innerHTML;
        $(categorySelect).removeAttr("disabled");
    }
}



function previewFiles() {
    var previewFiles = document.querySelector('#previewFiles');
    var files = document.querySelector('#file-input').files;

    function readAndPreview(file) {
        //var isLongName = (file.name.length>25)?'\.\.\.':'';
        var fileHTML = '<div class="uploaded-files-hw">' +
            '<a href="#">' +
            '<i class="far fa-file fa-4x"></i>' +
            '<span class="about-hw-file">' +
            'Title: '+ file.name +
            '<br>Size: ' + getReadableFileSizeString(file.size) +
            '<br>' +
            '</span>' +
            '</a>' +
            '</div>';
        previewFiles.innerHTML = previewFiles.innerHTML + (fileHTML);
    }

    function getReadableFileSizeString(fileSizeInBytes) {
        var i = -1;
        var byteUnits = [' kB', ' MB', ' GB', ' TB', 'PB', 'EB', 'ZB', 'YB'];
        do {
            fileSizeInBytes = fileSizeInBytes / 1024;
            i++;
        } while (fileSizeInBytes > 1024);

        return Math.floor(fileSizeInBytes, 0.1).toFixed(1) + byteUnits[i];
    }

    document.getElementById("previewFiles").innerHTML = "";
    if (files) {
        // $(#preview).html="";
        [].forEach.call(files, readAndPreview);
    }
}


var fileInput = document.getElementById('file-input');
var fileList = [];

fileInput.addEventListener('change', function (evnt) {
    fileList = [];
    for(var i=0; i<fileInput.files.length; i++) {
        fileList.push(fileInput.files[i]);
    }
    previewFiles();
});
var progressId;
var submitCatcher = document.getElementById('addResourcesForm');

submitCatcher.addEventListener('submit', function (evnt) {
    dontClose();
    if(fileList.length){
        evnt.preventDefault();
        hidePageContent();
        showLoader();
        var categorySelect = document.getElementById("category_select");
        var categorySelectValue = categorySelect.options[categorySelect.selectedIndex].value;

        var howManyFilesSent=0;
        var howManyFilesAre100=0;
        var sendFile = function (file) {
            howManyFilesSent++;
            var progressId="progress"+howManyFilesSent;

            var formData = new FormData();
            var alertTrig = 0;
            formData.set('file', file, file.name);
            formData.set("catid", categorySelectValue);
            formData.set('file', file, file.name);
            $('#loaderDiv').append('<h4 style="word-break: break-all;">Uploading '+file.name+'</h4><div class="progress" id="'+progressId+'"><div class="progress-bar" role="progressbar" style="0%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">0%</div></div>')
            $.ajax({
                xhr: function () {
                    // var xhr = new window.XMLHttpRequest();
                    var xhr = $.ajaxSettings.xhr();

                    xhr.upload.onprogress = function (e) {
                        // For uploads
                        if(e.lengthComputable) {

                            var pct = Math.floor((e.loaded / e.total) * 100);

                            console.log('File sending percentage '+ pct+'\n');

                            //Visualizing fukin progress
                            $("#"+progressId+" .progress-bar").css('width', pct+"%");
                            $("#"+progressId+" .progress-bar").attr('aria-valuenow', pct);
                            $("#"+progressId+" .progress-bar").html(pct+"%");
                        }
                        //this usually happens when Content-Length isn't set
                        else {
                            $("#"+progressId+" .progress-bar").replaceWith("<h2>File is uploading, please wait</h2>");
                            console.log('Content Length not reported!');
                        }
                    };
                    return xhr;
                },
                url:  '/edu/lib/add/files',
                type: 'post',
                processData: false,
                contentType: false,
                enctype: 'multipart/form-data',
                data: formData,
                cache: false,
                timeout: 600000,
                success: function (data,textStatus,jqXHR) {

                    howManyFilesAre100++;
                    console.log("File number "+ howManyFilesAre100 +" is uploaded; its name is ", file.name)
                    if(howManyFilesAre100==howManyFilesSent){
                        isAllSuccess=true;
                        successShow();
                        setTimeout(function(){  window.location.href = "/edu/lib"}, 3000);
                    }
                },
                error: function (data,textStatus,jqXHR) {
                    if(alertTrig==0) {
                        alertLAWN("There was a problem when sending the files. Please try again and refresh the page!");
                    }
                    alertTrig++;
                    console.log(file.name + " not uploaded!" + "\n" + data, "error");
                },

            });
        };
        fileList.forEach(function (file) {
            sendFile(file, 'files');
        });
    }
});

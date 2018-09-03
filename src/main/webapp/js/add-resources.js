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

        return Math.max(fileSizeInBytes, 0.1).toFixed(1) + byteUnits[i];
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

var submitCatcher = document.getElementById('addResourcesForm');
submitCatcher.addEventListener('submit', function (evnt) {
    evnt.preventDefault();

    var categorySelect = document.getElementById("category_select");
    var categorySelectValue = categorySelect.options[categorySelect.selectedIndex].value;

    for(var i=0; i<fileList.length; i++) {

        var file = fileList[i];
        var formData = new FormData();

        formData.set('file', file, file.name);
        formData.set("catid", categorySelectValue);

        $.ajax({
            url:  '/edu/lib/add/files',
            type: 'post',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            data: formData,
            cache: false,
            success: function (data,textStatus,jqXHR) {
                alert(file.name + "yes yes")
            },
            error: function (data,textStatus,jqXHR) {
                if(jqXHR.status===401) {
                    window.location.href = "/signin";
                }
                else {
                    alert(file.name + "shiiiit");
                }
            }
        });

    }


});


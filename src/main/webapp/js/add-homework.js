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
    // $('#loaderDiv').css('margin-top','10px');
    $('#successDiv').html('<center><div class="alert alert-success"><strong>Success!</strong> You successfully added homework.  Now, you will be redirected to Homework Page. </div></center>');
    window.onbeforeunload = null;

}



var emptyPageContent = function(){
    $('.firstcontainer').hide();
}



function Utf8ArrayToStr(array) {
    var out, i, len, c;
    var char2, char3;

    out = "";
    len = array.length;
    i = 0;
    while(i < len) {
        c = array[i++];
        switch(c >> 4)
        {
            case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:

            out += String.fromCharCode(c);
            break;
            case 12: case 13:
            char2 = array[i++];
            out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
            break;
            case 14:
                char2 = array[i++];
                char3 = array[i++];
                out += String.fromCharCode(((c & 0x0F) << 12) |
                    ((char2 & 0x3F) << 6) |
                    ((char3 & 0x3F) << 0));
                break;
        }
    }

    return out;
}


var addingCounterId = 0;
var addItem  = function(e){
    addingCounterId++;
    $(e).attr("id", "hidden"+addingCounterId)
    $(e).hide();
    // counter++;
    var hwFor = $(e).attr('subjID');
    var subject = $(e).find('span').html();
    var groupandvenue = $(e).find('p').html();
    var optionsstring = $(e).attr('options');
    var optionsHTML = "";
    if(optionsstring!=undefined) {
        var optionsarray = optionsstring.split(';');

        for (var i = optionsarray.length - 1; i >= 0; i--) {
            var isFirst =  (i===optionsarray.length-1)?' selected="selected"':'';
            optionsHTML+='<option value="'+ optionsarray[i] + '"' + isFirst + '>'+optionsarray[i]+'</option>';
        }
    }
    var customDateText = "Custom Date"
    var strinnew =
        '<div class="info_about_group col-xs-6 col-lg-4">' +
        '<div class="teacher-subject-item">' +
        '<div class="left-div">' +
        '<h2>'+subject+'<div   style="float: right;font-size:  28px;position:  absolute;top: 2px;right:  12px;cursor:  pointer;font-weight:700;" onclick="deleteSubject(this)" id="minus'+addingCounterId+'">&times;</div></h2>' +
        '<p>'+groupandvenue+'</p>' +
        '</div>' +
        '<div class="date-lesson">' +
        '<select form="addHWform" id="'+ hwFor + 'select' +'" onchange="iscustomcheck(this)">'+optionsHTML+' </select>' +
        '<br>' +
        '<input form="addHWform" id="'+ hwFor + 'select' + '_custom' + '" type="text" placeholder="'+ customDateText +'" disabled="disabled">' +
        '</div>' +
        '</div>' +
        '<input form="addHWform" type="text" name="HWfor[]" style="display: none" value="'+ hwFor +'">'+
        '</div>';
    $('#subject-selected').append(strinnew);
}


var iscustomcheck = function(e){
    if($(e).find(":selected").text()=="Custom Date"){
        $(e).parent().find("input").removeAttr("disabled");
    }
    else{
        $(e).parent().find("input").attr("disabled", "disabled");
        $(e).parent().find("input").val("");
    }
}


function previewImages() {
    var preview = document.querySelector('#preview');
    var images   = document.querySelector('#image-input').files;

    function readAndPreview(file) {
        // Make sure `file.name` matches our extensions criteria
        if ( /\.(jpe?g|png|gif)$/i.test(file.name) ) {
            var reader = new FileReader();

            reader.addEventListener("load", function () {
                var image = new Image();
                var div = document.createElement("DIV");
                div.classList.add("col-xs-12");
                div.classList.add("col-md-3");
                var a = document.createElement("A");
                a.classList.add("thumbnail");
                image.height = 100;
                image.title = file.name;
                image.src = this.result;
                a.appendChild(image);
                div.appendChild(a)
                preview.appendChild(div);
            }, false);

            reader.readAsDataURL(file);
        }
    }

    document.getElementById("preview").innerHTML = "";
    if (images) {
        [].forEach.call(images, readAndPreview);
    }
}

function previewFiles() {
    var previewFiles = document.querySelector('#previewFiles');
    var files   = document.querySelector('#file-input').files;

    function readAndPreview(file) {
        var isLongName = (file.name.length>25)?'\.\.\.':'';
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


(function () {
    var submitCatcher = document.getElementById('addHWform');
    var fileInput = document.getElementById('file-input');
    var imageInput = document.getElementById('image-input');

    var fileList = [];
    var imageList = [];

    var myHWid;

    submitCatcher.addEventListener('submit', function (evnt) {
        dontClose();
        evnt.preventDefault();

        var formData = new FormData();
        var arrayHWfor = document.forms['addHWform'].elements['HWfor[]'];
        var arrayOfValuesHWfor = "";

        if(!arrayHWfor) {
            alertLAWN($('#NoGroupsSpecified').html(), 'normal');
            $('#loaderDiv').remove();
            return;
        }

        if(arrayHWfor.length == undefined) {
            arrayOfValuesHWfor = arrayHWfor.value;
            var select = document.getElementById(arrayHWfor.value + 'select');
            var selectValue = select.options[select.selectedIndex].text;
            formData.set(arrayHWfor.value + 'select', selectValue);
            if (selectValue === 'Custom Date') {
                var regexExp = new RegExp(/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/);
                var customDateInputValue = document.getElementById(arrayHWfor.value + 'select_custom');
                console.log(customDateInputValue.value);
                console.log(customDateInputValue.value.length);
                console.log(regexExp.test(customDateInputValue.value));
                if (customDateInputValue.value.length!=10 || !regexExp.test(customDateInputValue.value)) {
                    alertLAWN($('#BadDate').html(), 'normal');
                    console.log("Bad custom date");
                    return;
                }
                formData.set(arrayHWfor.value + 'select' + '_custom', customDateInputValue.value);
            }
        }
        else {
            for (var i = 0; i < arrayHWfor.length; i++) {
                var coma = ";";
                if (i === arrayHWfor.length - 1) {
                    coma = "";
                }
                arrayOfValuesHWfor = arrayOfValuesHWfor + arrayHWfor[i].value + coma;
                var select = document.getElementById(arrayHWfor[i].value + 'select');
                var selectValue = select.options[select.selectedIndex].text;
                formData.set(arrayHWfor[i].value + 'select', selectValue);
                if (selectValue === 'Custom Date') {
                    var customDateInputValue = document.getElementById(arrayHWfor[i].value + 'select_custom');
                    console.log(customDateInputValue.value);
                    var regexExp = new RegExp(/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/);
                    if (!regexExp.test(customDateInputValue.value)) {
                        alertLAWN($('#BadDate').html(), 'normal');
                        console.log("Bad custom Date!");
                        return;
                    }
                    formData.set(arrayHWfor[i].value + 'select' + '_custom', customDateInputValue.value);
                }
            }
        }
        formData.set('HWfor', arrayOfValuesHWfor);
        if(!(document.getElementById('hw-text').value)) {
            // todo fucking encoding problem - russian does not show properly
            alertLAWN($('#NoDescription').html(), 'normal');
            return;
        }
        formData.set('hw-text', document.getElementById('hw-text').value);
        emptyPageContent();
        if(fileList.length!=0 || imageList.legth!=0){
            showLoader();
        }
        $.ajax({
            xhr: function () {
                var xhr = $.ajaxSettings.xhr();

                xhr.upload.onprogress = function (e) {
                    // For uploads
                    if(e.lengthComputable) {
                        var pct = Math.floor((e.loaded / e.total) * 100);
                        console.log('Form uploading '+pct);
                    }
                    else {
                        console.log('Content Length not reported!');
                    }
                };
                return xhr;
            },
            url:  '/edu/hw/add',
            type: 'post',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            data: formData,
            cache: false,
            timeout: 600000,

            success: function (data,textStatus,jqXHR) {
                myHWid = data;
                if(fileList.length ==0 && imageList.length ==0){
                    successShow();
                    setTimeout(function(){  window.location.href = "/edu/hw"}, 3000);
                }
                else{
                    fileList.forEach(function (file) {
                        sendFile(file, 'files');
                    });

                    imageList.forEach(function(file) {
                        sendFile(file, 'photos');
                    });
                }


            },
            error: function (data,textStatus,jqXHR) {
                if(jqXHR.status===401) {
                    window.location.href = "/signin";
                }
                else {
                    alertLAWN($('#ErrorWhileSendingHW').html(), 'error');
                }
            },


        });


    });

    fileInput.addEventListener('change', function (evnt) {
        fileList = [];
        for(var i=0; i<fileInput.files.length; i++) {
            fileList.push(fileInput.files[i]);
        }
        previewFiles();
    });

    imageInput.addEventListener('change', function(e) {
        imageList = [];
        for(var i=0; i<imageInput.files.length; i++) {
            imageList.push(imageInput.files[i]);
        }
        previewImages();
    });
    var howManyFilesSent = 0;
    var howManyPhotosSent = 0;
    var howManyPhotosAre100 =0;
    var howManyFilesAre100 = 0;
    var forIdPurposesOnly = 0;
    var isAllSuccess = false;
    var sendFile = function (file, url) {
        forIdPurposesOnly++;
        if(url=='files'){howManyFilesSent++;}
        else{howManyPhotosSent++;}
        var progressId="progress"+forIdPurposesOnly;
        var formData = new FormData();
        formData.set('file', file, file.name);
        formData.set('hw_id', myHWid);
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
            url:  '/edu/hw/add/'+url,
            type: 'post',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            data: formData,
            cache: false,
            timeout: 600000,
            success: function (data,textStatus,jqXHR) {
                if(url=='photos'){

                    howManyPhotosAre100++;
                    console.log("Photos is 100", file.name)
                    if(howManyPhotosAre100==howManyPhotosSent){console.log("All attachedd photos are sent")}
                }
                else{
                    howManyFilesAre100++;
                    console.log("FILE IS 100 ", file.name)
                    if(howManyFilesAre100==howManyFilesSent){console.log("All attachedd photos are sent")}

                }


                if(howManyFilesAre100==howManyFilesSent && howManyPhotosSent==howManyPhotosAre100){
                    isAllSuccess=true;
                    successShow();
                    setTimeout(function(){  window.location.href = "/edu/hw"}, 3000);
                }
            },
            error: function (data,textStatus,jqXHR) {
                // if(jqXHR.status===401) {
                //     window.location.href = "/signin";
                // }
                // else {
                //     tackleErrorAddUp();
                // }
                alertLAWN($('#ErrorWhileSendingHWFiles').html(),"error");
                //alertLAWN(file.name + " not uploaded!" + "\n" + data, "error");
            },

        });

    };

})();

var deleteSubject = function(element){
    var minusId = $(element).attr("id").split("minus")[1];
    var idForShowing = "hidden" + minusId;
    $(element).parents(".info_about_group").remove();
    $("#"+idForShowing).show();
}

var numberOfAlertsTriggered = 0;
var alertLAWN = function(textOfAlert, typeOfAlert){
    numberOfAlertsTriggered++;
    modalID = "lawnModal"+numberOfAlertsTriggered;
    if(typeOfAlert == 'error'){
        var modalContent = '<div class="alert alert-danger" role="alert">' +
            textOfAlert +
            '</div>';
        $('.first').after('<div id=""'+modalID+'" class="modal fade" role="dialog">\n' +
            '  <div class="modal-dialog">\n' +
            '\n' +
            '    <!-- Modal content-->\n' +
            '    <div class="modal-content">\n' +
            '      <div class="modal-header">\n' +
            '        <button type="button" class="close" data-dismiss="modal">&times;</button>\n' +
            '        <h4 class="modal-title">Ошибка</h4>\n' +
            '      </div>\n' +
            '      <div class="modal-body">\n' +
            modalContent +
            '      </div>\n' +
            '      <div class="modal-footer">\n' +
            '        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\n' +
            '      </div>\n' +
            '    </div>\n' +
            '\n' +
            '  </div>\n' +
            '</div>');
        $('#'+modalID).modal('toggle');
    }
    else if(typeOfAlert == 'normal' || typeOfAlert == undefined){
        var modalContent = '<div class="alert alert-warning">\n' +
            textOfAlert +
            '\n' +
            '</div>\n';
        $('.first').after('<div id="'+modalID+'" class="modal fade" role="dialog">\n' +
            '  <div class="modal-dialog">\n' +
            '\n' +
            '    <!-- Modal content-->\n' +
            '    <div class="modal-content">\n' +
            '      <div class="modal-header">\n' +
            '        <button type="button" class="close" data-dismiss="modal">&times;</button>\n' +
            '        <h4 class="modal-title">Warning</h4>\n' +
            '      </div>\n' +
            '      <div class="modal-body">\n' +
            modalContent +
            '      </div>\n' +
            '      <div class="modal-footer">\n' +
            '        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\n' +
            '      </div>\n' +
            '    </div>\n' +
            '\n' +
            '  </div>\n' +
            '</div>');
        $('#'+modalID).modal('toggle');

    }
    else{
        console.log('Not right modal trigger, you fucktard')
    }

}

var emptyPageContent = function(){
    $('.first').empty();
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



var addItem  = function(e){
    e.remove();
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
    var strinnew =  '<div class="info_about_group col-xs-6 col-lg-4">' +
        '<div class="teacher-subject-item">' +
        '<div class="left-div">' +
        '<h2>'+subject+'</h2>' +
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
        $(e).attr("disabled","disabled");
        $(e).parent().find("input").removeAttr("disabled");
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
        evnt.preventDefault();

        var formData = new FormData();
        var arrayHWfor = document.forms['addHWform'].elements['HWfor[]'];
        var arrayOfValuesHWfor = "";

        if(!arrayHWfor) {
            alertLAWN("Добавьте тех, кому отправлять дз!", 'normal');
            return;
        }

        if(arrayHWfor.length == undefined) {
            arrayOfValuesHWfor = arrayHWfor.value;
            var select = document.getElementById(arrayHWfor.value + 'select');
            var selectValue = select.options[select.selectedIndex].text;
            formData.set(arrayHWfor.value + 'select', selectValue);
            if (selectValue === 'Custom Date') {
                var customDateInputValue = document.getElementById(arrayHWfor.value + 'select_custom');
                if (isNaN(Date.parse(customDateInputValue.value))) {
                    alertLAWN("Вы неправильно ввели дату для группы! Исправьте пожалуйста)))", "error")
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
                    var regexExp = new RegExp("^((0[1-9]|[12]\d|3[01])-(0[1-9]|1[0-2])-[12]\d{3})$");
                    if (regexExp.test(customDateInputValue.value)) {
                        alertLAWN("У предмета " + i + " по счету проблема с датой. Исправь пидор ебанный!", "error")
                        return;
                    }
                    formData.set(arrayHWfor[i].value + 'select' + '_custom', customDateInputValue.value);
                }
            }
        }
        formData.set('HWfor', arrayOfValuesHWfor);
        if(!(document.getElementById('hw-text').value)) {
            // todo fucking encoding problem - russian does not show properly
            alertLAWN("Добавьте текст к ДЗ. Ученики не поймут что делать с файлами!", "error");
            return;
        }
        formData.set('hw-text', document.getElementById('hw-text').value);
        $.ajax({
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
                alertLAWN(myHWid, "normal");
                fileList.forEach(function (file) {
                    sendFile(file, 'files');
                });

                imageList.forEach(function(file) {
                    sendFile(file, 'photos');
                });
                // emptyPageContent();
            },
            error: function (data,textStatus,jqXHR) {
                if(jqXHR.status===401) {
                    window.location.href = "/signin";
                }
                else {
                    alertLAWN(data+ " Проблема на сервере сукаааааааааа :(", "error");
                }
            },
            progress: function(e){
                if(e.lengthComputable) {
                    //calculate the percentage loaded
                    var pct = (e.loaded / e.total) * 100;

                    //log percentage loaded
                    console.log(pct);
                }
                //this usually happens when Content-Length isn't set
                else {
                    console.log('Content Length not reported!');
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

    var sendFile = function (file, url) {
        var formData = new FormData();
        formData.set('file', file, file.name);
        formData.set('hw_id', myHWid);

        $.ajax({
            url:  '/edu/hw/add/'+url,
            type: 'post',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            data: formData,
            cache: false,
            timeout: 600000,
            success: function (data,textStatus,jqXHR) {
                alertLAWN(file.name + " good good", "normal");
            },
            error: function (data,textStatus,jqXHR) {
                // if(jqXHR.status===401) {
                //     window.location.href = "/signin";
                // }
                // else {
                //     tackleErrorAddUp();
                // }
                alertLAWN(file.name + " not uploaded!" + "\n" + data, "error");
            },
            progress: function(e){
                // emptyPageContent();
                if(e.lengthComputable) {

                    var pct = (e.loaded / e.total) * 100;

                    $(".first").append(pct+'\n');
                }
                //this usually happens when Content-Length isn't set
                else {
                    console.warn('Content Length not reported!');
                }

            },
        });


    };

})();


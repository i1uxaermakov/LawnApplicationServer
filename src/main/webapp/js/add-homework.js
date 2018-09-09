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
            alert("Добавьте получателей ДЗ");
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
                    alert("Problem with first subject chosen! Wrong input in Date!")
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
                        alert("Problem with " + i + " subject chosen! Wrong input in Date!")
                        return;
                    }
                    formData.set(arrayHWfor[i].value + 'select' + '_custom', customDateInputValue.value);
                }
            }
        }
        formData.set('HWfor', arrayOfValuesHWfor);
        if(!(document.getElementById('hw-text').value)) {
            alert("Please, add description to Homework!");
            return;
        }
        formData.set('hw-text', document.getElementById('hw-text').value);

        //todo block user from clicking anywhere and make him wait for the response
        // request.onload = function () {
        //     if(request.status===200) {
        //         myHWid = request.responseText;
        //         alert(myHWid);
        //         fileList.forEach(function (file) {
        //             sendFile(file, 'files');
        //         });
        //
        //         imageList.forEach(function(file) {
        //            sendFile(file, 'photos');
        //         });
        //
        //     }
        //     else {
        //
        //     }
        // };


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
                alert(myHWid);
                fileList.forEach(function (file) {
                    sendFile(file, 'files');
                });

                imageList.forEach(function(file) {
                    sendFile(file, 'photos');
                });
            },
            error: function (data,textStatus,jqXHR) {
                if(jqXHR.status===401) {
                    window.location.href = "/signin";
                }
                else {
                    alert(data + "Some problem occurred while processing on server :(");
                }
            }
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
                alert(file.name + " good good");
            },
            error: function (data,textStatus,jqXHR) {
                // if(jqXHR.status===401) {
                //     window.location.href = "/signin";
                // }
                // else {
                //     tackleErrorAddUp();
                // }
                alert(file.name + " not uploaded!" + "\n" + data);
            }
        });
    };
})();
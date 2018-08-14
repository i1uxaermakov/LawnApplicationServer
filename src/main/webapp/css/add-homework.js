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
 	$(e).attr("disabled","disabled")
 	$(e).parent().find("input").removeAttr("disabled")
 }
}


function previewImages() {
    var preview = document.querySelector('#preview');
    var files   = document.querySelector('#images').files;

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
    if (files) {
        [].forEach.call(files, readAndPreview);
    }
}

function previewFiles() {
    var previewFiles = document.querySelector('#previewFiles');
    var files   = document.querySelector('#file-input').files;

    function readAndPreview(file) {
        var isLongName = (file.name.length>25)?'\.\.\.':'';
        var fileHTML = '<div class="uploaded-files-hw"><a href="#"><i class="far fa-file fa-4x"></i><span class="about-hw-file">Title: '+ file.name.substring(0,25) + isLongName +'<br>Size: ' + file.size + '<br></span></a></div>';
        previewFiles.innerHTML = previewFiles.innerHTML + (fileHTML);
    }

    document.getElementById("previewFiles").innerHTML = "";
    if (files) {
        // $(#preview).html="";
        [].forEach.call(files, readAndPreview);
    }
}


(function () {
    var fileCatcher = document.getElementById('addHWform');
    var fileInput = document.getElementById('file-input');

    var fileList = [];

    var myHWid;

    fileCatcher.addEventListener('submit', function (evnt) {
        evnt.preventDefault();

        var request = new XMLHttpRequest();
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
            // todo fucking encoding problem - russian does not show properly
            alert('hello'+'\xD0\x9D\xD0\xB0\xD0\xBF\xD0\xB8\xD1\x88\xD0\xB8\xD1\x82\xD0\xB5\x20\xD0\xBA\xD0\xBE\xD0\xBC\xD0\xBC\xD0\xB5\xD0\xBD\xD1\x82\xD0\xB0\xD1\x80\xD0\xB8\xD0\xB9\x20\xD0\xBA\x20\xD0\xB4\xD0\xBE\xD0\xBC\xD0\xB0\xD1\x88\xD0\xBD\xD0\xB5\xD0\xBC\xD1\x83\x20\xD0\xB7\xD0\xB0\xD0\xB4\xD0\xB0\xD0\xBD\xD0\xB8\xD1\x8E\x2E');
            return;
        }
        formData.set('hw-text', document.getElementById('hw-text').value);
        request.open("POST", 'http://localhost:8080/edu/hw/add', true);
        request.send(formData);

        //todo block user from clicking anywhere and make him wait for the response
        request.onload = function () {
            if(request.status===200) {
                myHWid = request.responseText;
                alert(myHWid);
                fileList.forEach(function (file) {
                    sendFile(file);
                });
            }
            else {
                alert(request.responseText + "Some problem occurred while processing on server :(");
            }
        };

    });

    fileInput.addEventListener('change', function (evnt) {
        for (var i = 0; i < fileInput.files.length; i++) {
            fileList.push(fileInput.files[i]);
        }
        previewFiles();
    });

    sendFile = function (file) {
        var formData = new FormData();
        var request = new XMLHttpRequest();

        formData.set('file', file, file.name);
        formData.set('hw_id', myHWid);
        request.open("POST", 'http://localhost:8080/files/edu/hw/add', true);
        request.send(formData);

        request.onload = function() {
            if(request.status===200) {
                alert(file.name + " good good");
            }
            else {
                
                alert(file.name + " not uploaded!" + "\n" + request.responseText);
            }
        }
        
    };
})();
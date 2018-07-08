(function () {
    var fileCatcher = document.getElementById('file-catcher');
    var fileInput = document.getElementById('file-input');
    var fileListDisplay = document.getElementById('file-list-display');

    var fileList = [];
    var renderFileList, sendFile;

    var myPostId;

    fileCatcher.addEventListener('submit', function (evnt) {
        evnt.preventDefault();

        var request = new XMLHttpRequest();
        var formData = new FormData();
        formData.set('postContent',document.getElementById("post-text"));
        request.open("POST", 'http://localhost:8080/add/post', false);
        request.send(formData);

        if(request.readyState===4 && request.status===200) {
            document.getElementById("pi1").innerHTML = request.responseText;
            myPostId = (JSON.parse(request.responseText)).postId;
            document.getElementById("pi").innerHTML = myPostId;
            fileList.forEach(function (file) {
                sendFile(file);
            });
        }
        else {
            alert("pizda, post ne zagrujen");
        }
    });

    fileInput.addEventListener('change', function (evnt) {
        for (var i = 0; i < fileInput.files.length; i++) {
            fileList.push(fileInput.files[i]);
        }
        renderFileList();
    });

    renderFileList = function () {
        fileListDisplay.innerHTML = '';
        fileList.forEach(function (file, index) {
            var fileDisplayEl = document.createElement('p');
            fileDisplayEl.innerHTML = (index + 1) + ': ' + file.name;
            fileListDisplay.appendChild(fileDisplayEl);
        });
    };

    sendFile = function (file) {
        var formData = new FormData();
        var request = new XMLHttpRequest();

        formData.set('file', file, file.name);
        formData.set('postId', myPostId);
        request.open("POST", 'http://localhost:8080/add/files', true);
        request.send(formData);
    };
})();
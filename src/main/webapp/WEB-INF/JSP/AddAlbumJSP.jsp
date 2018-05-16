<%--
  Created by IntelliJ IDEA.
  User: ilya_ermakov
  Date: 24/02/2018
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/addPost.css" rel="stylesheet" type="text/css">
    <script>
        function previewFiles() {
            var preview = document.querySelector('#preview');
            var files   = document.querySelector('#images').files;

            function readAndPreview(file) {
                // Make sure `file.name` matches our extensions criteria
                if ( /\.(jpe?g|png|gif)$/i.test(file.name) ) {
                    var reader = new FileReader();

                    reader.addEventListener("load", function () {
                        var image = new Image();
                        image.height = 100;
                        image.title = file.name;
                        image.src = this.result;
                        preview.appendChild( image );
                    }, false);

                    reader.readAsDataURL(file);
                }
            }
            if (files) {
                [].forEach.call(files, readAndPreview);
            }
        }
    </script>
</head>
<body>

</body>
</html>

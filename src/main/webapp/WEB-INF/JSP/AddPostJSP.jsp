<%@ page import="security.entities.User" %>
<%@ page import="model.entities.Organization" %>
<%@ page contentType="text/html" language="java" %>
<!DOCTYPE html>
<html lang="en">
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

    <%
        User user = (User) session.getAttribute("User");
    %>

    <section class="content">
        <h1 class="content__heading">Add post</h1>
        <p class="content__lede">Use this handy form to write a new post.</p>
            <form class="content__form contact-form" method="post" action="/add/post" enctype="multipart/form-data">
            <%--<div class="contact-form__input-group">--%>
                <%--<input class="contact-form__input contact-form__input--radio" id="salutation-mr" name="salutation" type="radio" value="Mr."/>--%>
                <%--<label class="contact-form__label contact-form__label--radio" for="salutation-mr">Mr.</label>--%>
                <%--<input class="contact-form__input contact-form__input--radio" id="salutation-mrs" name="salutation" type="radio" value="Mrs."/>--%>
                <%--<label class="contact-form__label contact-form__label--radio" for="salutation-mrs">Mrs.</label>--%>
                <%--<input class="contact-form__input contact-form__input--radio" id="salutation-ms" name="salutation" type="radio" value="Ms."/>--%>
                <%--<label class="contact-form__label contact-form__label--radio" for="salutation-ms">Ms.</label>--%>
            <%--</div>--%>
            <div class="contact-form__input-group">
                <label class="contact-form__label" for="title">Title</label>
                <input class="contact-form__input contact-form__input--text" id="title" name="title" type="text"/>
            </div>
            <%--<div class="contact-form__input-group">--%>
                <%--<label class="contact-form__label" for="email">Email Address</label>--%>
                <%--<input class="contact-form__input contact-form__input--email" id="email" name="email" type="email"/>--%>
            <%--</div>--%>
            <div class="contact-form__input-group">
                <label class="contact-form__label" for="author">От чьего имени вы пишете пост?</label>
                <select class="contact-form__input contact-form__input--select" id="author" name="author">
                    <%
                        String username = user.getFirstName() + " " + user.getLastName();
                    %>
                    <option><%=username%></option>
                    <%
                        for(Organization organization: user.getOrganizations()) {
                    %>
                    <option><%=organization.getName()%></option>
                    <%
                        }
                    %>
                    <option>I have a problem.</option>
                    <option>I have a general question.</option>
                </select>
            </div>
            <div class="contact-form__input-group">
                <label class="contact-form__label" for="postText">Enter a Message</label>
                <textarea class="contact-form__input contact-form__input--textarea" id="postText" name="postText" rows="6" cols="65"></textarea>
            </div>
            <div class="contact-form__input-group">
                <label class="contact-form__label" for="files">Choose files to include into post</label>
                <input type="file" multiple="true" id="files" name="files"/>
            </div>

            <div class="contact-form__input-group">
                <label class="contact-form__label" for="images">Choose images to include into post</label>
                <input type="file" multiple="true" id="images" name="photos" accept="image/*" onchange="previewFiles()"/>
                <div id="preview"></div>
            </div>


            <input name="secret" type="hidden" value="1b3a9374-1a8e-434e-90ab-21aa7b9b80e7"/>
            <button class="contact-form__button" type="submit">Send It!</button>
        </form>
    </section>

</body>
</html>


<!--private Long id;-->
<!--private String authorName;-->
<!--private String organizationName;-->
<!--private Date publishDate;-->
<!--private String title;-->
<!--private String postText;-->
<!--private String description;-->
<!--private String status;-->
<!--private Set<Photo> photos;-->
<!--private Set<Video> videos;-->
<!--private Set<File> files;-->
<!--private Set<Tag> tags;-->



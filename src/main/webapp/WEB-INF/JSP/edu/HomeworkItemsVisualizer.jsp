<%@ page import="sections.education.entities.HomeworkItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="utils.images.Photo" %>
<%@ page import="utils.files.File" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<HomeworkItem> homeworkItemList = (List<HomeworkItem>) request.getAttribute("homeworkItemList");
    Boolean addButton = (Boolean) request.getAttribute("addButton");
    SimpleDateFormat hwUploadDateFormat = new SimpleDateFormat("MMM dd yyyy, HH:ss");
    SimpleDateFormat hwDeadlineDateFormat = new SimpleDateFormat("MMM dd");

    if(homeworkItemList.size() > 0) {
        for(HomeworkItem hwi: homeworkItemList) {
    %>


            <div class="news" lastDate="<%=hwUploadDateFormat.format(hwi.getPublishDate())%>">
                <div class="newsbegin">
                    <div class="l2-homework">
                        <span class="post-publishers-name"><%=hwi.getSubjectName() + " - " + hwi.getTeacherName()%></span> <!--History - Ramis Sattarov-->
                        <br>
                        <span class="item-date">Deadline: <%=hwDeadlineDateFormat.format(hwi.getDeadlineDate())%></span> <br>
                        <span name="publishDate" class="item-date">Uploaded: <%=hwUploadDateFormat.format(hwi.getPublishDate())%></span>
                    </div>
                </div>
                <div class="text">
                    <%=hwi.getDescription()%>
                </div>
                <%
                    int size = hwi.getPhotos().size();
                    if(size != 0) {
                        if(size < 4) {
                            String num = (size==1) ? "one" : ((size==2) ? "two" : "three");%>
                <div class="<%=num%>photosrow photos row">
                    <div class="my-gallery" itemscope itemtype="">
                        <%
                            for(Photo photo: hwi.getPhotos()) {%>
                        <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                            <a href="/images/<%=photo.getThumbnailPhotoLocation()%>" itemprop="contentUrl" data-size="<%=photo.getThumbnailPhotoDimensions()%>">
                                <img src="/images/<%=photo.getSquareThumbnailPhotoLocation()%>" itemprop="thumbnail"/> <%--alt="Image description"--%>
                            </a>
                            <!-- </div> -->
                            <figcaption itemprop="caption description"> Photo by: <%=photo.getAuthor()%></figcaption>
                        </figure>
                        <%}
                        %>
                    </div>
                </div>
                <%  }
                else {%>
                <div class="attachedalbum">
                    <%--todo link to photos--%>
                    <a href="album_post_photos.html">
                        <img src="/images/<%=((Photo[])(hwi.getPhotos().toArray()))[0].getSquareThumbnailPhotoLocation()%>" alt="" class="">
                        <span class="aboutAlbum">
                                Attached Photos
                                <br>
                                <span>
                                <%=size%> photos
                                </span>
                        </span>
                    </a>
                </div>
                <%
                        }
                    }
                    for(File file: hwi.getFiles()) {%>
                <div class="uploaded-files-hw">
                    <a href="/files/download/<%=file.getSaveName()%>">
                        <i class="far fa-file fa-4x"></i>
                        <span class="about-hw-file">Title: <%=file.getOriginalName()%>
                            <br>Size: <%=file.getReadableFileSize()%>
                            <br>Uploaded: <%=hwDeadlineDateFormat.format(file.getPublishDate())%>
                        </span>
                    </a>
                </div>
                <%
                    }
                %>
            </div>
    <%
        }
        if(addButton && homeworkItemList.size()==5) {%>
            <div class="news" style="padding-bottom: 15px; margin-bottom: 10px;" onclick="showHomeworkBySubjectAddDown(this)"
                 lastDate="<%=hwUploadDateFormat.format(homeworkItemList.get(homeworkItemList.size()-1).getPublishDate())%>">
                <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                    padding-bottom: 0px; height:auto !important;">
                    <span>Press here to download old HW.</span>
                </div>
            </div>
        <%}
        else if(addButton) {%>
            <div class="news" style="padding-bottom: 15px; margin-bottom: 10px;">
                <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                                        padding-bottom: 0px; height:auto !important;">
                    <span>Fortunately, there is no more homework!</span>
                </div>
            </div>
<%
        }
    }
    else if(addButton){%>
        <div class="news" style="padding-bottom: 15px; margin-bottom: 10px;">
            <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                            padding-bottom: 0px; height:auto !important;">
                <span>Fortunately, there is no more homework!</span>
            </div>
        </div>
    <%}


%>
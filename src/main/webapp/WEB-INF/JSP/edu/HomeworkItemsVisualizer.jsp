<%@ page import="sections.education.entities.HomeworkItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="utils.images.Photo" %>
<%@ page import="utils.files.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<HomeworkItem> homeworkItemList = (List<HomeworkItem>) request.getAttribute("homeworkItemList");
    Boolean addButton = (Boolean) request.getAttribute("addButton");
    SimpleDateFormat hwUploadDateFormat = new SimpleDateFormat("MMM dd yyyy, HH:mm");
    SimpleDateFormat hwDeadlineDateFormat = new SimpleDateFormat("MMM dd");

    if(homeworkItemList.size() > 0) {
        for(HomeworkItem hwi: homeworkItemList) {
    %>


            <div class="news " lastDate="<%=hwi.getPublishDate().getTime()%>">
                <div class="newsbegin">
                    <div class="l2-homework">
                        <span class="post-publishers-name"><%=hwi.getSubjectName() + " - " + hwi.getTeacherName()%></span> <!--History - Ramis Sattarov-->
                        <br>
                        <span class="item-date">Deadline: <%=hwDeadlineDateFormat.format(hwi.getDeadlineDate())%></span> <br>
                        <span name="publishDate" class="item-date">Uploaded: <%=hwUploadDateFormat.format(hwi.getPublishDate())%></span>
                    </div>
                </div>
                <div class="text">
                    <%=hwi.getDescription().replaceAll("(\r\n|\r|\n|\n\r)", "<br>")%>
                </div>
                <%
                    List<Photo> photos = new ArrayList<>(hwi.getPhotos());
                    Collections.sort(photos);
                    int size = photos.size();
                    if(size != 0) {
                        String num = (size==1) ? "one" : ((size==2) ? "two" : "three");%>
                <div class="<%=num%>photosrow photos row">
                    <div class="my-gallery" itemscope itemtype="">
                        <%
                            for(Photo photo: photos) {%>
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
                %>

                <%



                    ArrayList<File> files = new ArrayList<>(hwi.getFiles());
                    Collections.sort(files);
                    for(File file: files) {%>
                <div class="uploaded-files-hw">
                    <a href="/files/download/<%=file.getSaveName()%>">
                        <i class="far fa-file fa-4x"></i>
                        <span class="about-hw-file" style="word-break: break-all;">Title: <%=file.getOriginalName()%>
                            <br>Size: <%=file.getReadableFileSize()%>
                            <br>Uploaded: <%=hwDeadlineDateFormat.format(file.getPublishDate())%>
                        </span>
                    </a>
                    <span class="filefav" fid="<%=file.getId()%>"><i class="far fa-star"></i></span>
                </div>
                <%
                    }
                %>
            </div>
    <%
        }
        if(addButton && homeworkItemList.size()==5) {%>
        <a  onclick="showHomeworkBySubjectAddDown(this)"
            sID="<%=homeworkItemList.get(0).getSubjectId()%>"
            lastDate="<%=homeworkItemList.get(homeworkItemList.size()-1).getPublishDate().getTime()%>">
            <div class="news" style="padding-bottom: 15px; margin-bottom: 10px;">
                    <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                        padding-bottom: 0px; height:auto !important;">
                        <span>Press here to download older HW.</span>
                    </div>
            </div>
        </a>
        <%}
    }
    else if(addButton){%>
        <div class="news warn" style="padding-bottom: 15px; margin-bottom: 10px;">
            <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                            padding-bottom: 0px; height:auto !important;">
                <span>Fortunately, there is no homework!</span>
            </div>
        </div>
    <%}


%>
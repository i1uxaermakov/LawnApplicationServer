<%@ page import="sections.education.entities.ResourceItem" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.files.File" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ResourceItem> resourceItemList = (List<ResourceItem>) request.getAttribute("resourceItemList");
    Boolean addButton = (Boolean) request.getAttribute("addButton");
    SimpleDateFormat hwUploadDateFormat = new SimpleDateFormat("MMM dd");

    if(resourceItemList.size() > 0) {
        for(ResourceItem resourceItem: resourceItemList) {
        File file = resourceItem.getFile();%>
        <div class="uploaded-files-hw">
            <a href="/files/download/<%=file.getSaveName()%>">
                <i class="far fa-file fa-4x"></i>
                <span class="about-hw-file">Title: <%=file.getOriginalName()%>
                    <br>Size: <%=file.getReadableFileSize()%>
                    <br>Uploaded on <%=hwUploadDateFormat.format(file.getPublishDate()) + " by " + file.getAuthor()%>
                </span>
            </a>
        </div>

<%
        }
    if(addButton && resourceItemList.size()==5) {%>
        <a>
            <div class="news" style="padding-bottom: 15px; margin-bottom: 10px;" onclick="showHomeworkBySubjectAddDown(this)" cID="<%=homeworkItemList.get(0).getSubjectId()%>"
                 lastDate="<%=homeworkItemList.get(homeworkItemList.size()-1).getPublishDate().getTime()%>">
                <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                                padding-bottom: 0px; height:auto !important;">
                    <span>Press here to download older HW.</span>
                </div>
            </div>
        </a>
        <%}

    }
    else {%>
        <div class="news warn" style="padding-bottom: 15px; margin-bottom: 10px;">
            <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                                    padding-bottom: 0px; height:auto !important;">
                <span>No resources left unshown.</span>
            </div>
        </div>
    <%}


%>
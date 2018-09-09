<%@ page import="utils.files.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="security.entities.User" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: ilya_ermakov
  Date: 09/09/2018
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("User");
    SimpleDateFormat hwDeadlineDateFormat = new SimpleDateFormat("MMM dd");
    ArrayList<File> files = new ArrayList<>(user.getFavouriteFiles());
    Collections.sort(files);

    if(files.size() == 0) {
        %>
<div class="news warn" style="padding: 15px; margin-bottom: 10px;">
    <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                                        padding-bottom: 0px; height:auto !important;">
        <span>You haven't added favorite files yet!</span>
    </div>
</div>
<%
    }
    for(File file: files) {%>
<div class="uploaded-files-hw">
    <a href="/files/download/<%=file.getSaveName()%>">
        <i class="far fa-file fa-4x"></i>
        <span class="about-hw-file" style="word-break: break-all;">Title: <%=file.getOriginalName()%>
            <br>Size: <%=file.getReadableFileSize()%>
            <br>Uploaded: <%=hwDeadlineDateFormat.format(file.getPublishDate())%> by <%=file.getAuthor()%>
        </span>
    </a>
    <span class="filefav" fid="<%=file.getId()%>"><i class="fas fa-star"></i></span>
</div>
<%
    }
%>

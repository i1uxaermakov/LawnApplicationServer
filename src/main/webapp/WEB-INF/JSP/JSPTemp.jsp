<%--
  Created by IntelliJ IDEA.
  User: ilya_ermakov
  Date: 21/02/2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getParameter("title")%>
    <%=request.getParameter("author")%>
    <%=request.getParameter("postText")%>

</body>
</html>

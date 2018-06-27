<%--
  Created by IntelliJ IDEA.
  User: ilya_ermakov
  Date: 26/06/2018
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String ans = null;
    System.out.println(request.getSession().getAttribute("Authorised"));
    if (new Boolean(true).equals(request.getSession().getAttribute("Authorised"))) {
        ans = "author";
    }
    else {
        ans = "no author";
    }
%>

<h1><%=ans%> </h1>

</body>
</html>
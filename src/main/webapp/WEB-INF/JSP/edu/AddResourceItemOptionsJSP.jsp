<%@ page import="sections.education.entities.SubjectResourceCategory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<SubjectResourceCategory> listForFirstLevel = (List<SubjectResourceCategory>) request.getAttribute("listForFirstLevel");
    List<SubjectResourceCategory> listForSecondLevel = (List<SubjectResourceCategory>) request.getAttribute("listForSecondLevel");
    List<SubjectResourceCategory> listForThirdLevel = (List<SubjectResourceCategory>) request.getAttribute("listForThirdLevel");
%>

<div id="category_select_1">
<%for(SubjectResourceCategory category: listForFirstLevel) {%>
    <option value="<%=category.getCategoryId()%>"> <%=category.getCategoryName()%> </option>
<%}%>
</div>

<div id="category_select_2">
<%for(SubjectResourceCategory category: listForSecondLevel) {%>
    <option value="<%=category.getCategoryId()%>"> <%=category.getCategoryName()%> </option>
<%}%>
</div>

<div id="category_select_3">
<%for(SubjectResourceCategory category: listForThirdLevel) {%>
    <option value="<%=category.getCategoryId()%>"> <%=category.getCategoryName()%> </option>
<%}%>
</div>

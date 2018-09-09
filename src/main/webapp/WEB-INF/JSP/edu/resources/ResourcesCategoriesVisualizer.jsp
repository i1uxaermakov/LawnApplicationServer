<%@ page import="java.util.List" %>
<%@ page import="sections.education.entities.SubjectResourceCategory" %>
<%
    List<SubjectResourceCategory> categories = (List<SubjectResourceCategory>) request.getAttribute("categoryList");
    for(SubjectResourceCategory category: categories) {
        %>
        <a class="btn btn-primary btn-lg btn-block accord1"
           href="#<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()%>" role="button"
           id="<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()%>"
           data-toggle="modal"
           data-target="#<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"Modal"%>"
           onclick="getResourceItemsByCategoryIdAddUp(this)"
           catid="<%=category.getCategoryId()%>"
           date="<%=category.getCreationDate().getTime()%>">
            <%=category.getCategoryName()%>
        </a>
        <!-- Modal -->
        <div class="modal fade" id="<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"Modal"%>"
             tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="removeWarn()">&times;</button>
                        <h4 class="modal-title" id="exampleModalLongTitle">Resources - <%=category.getCategoryName()%></h4>
                    </div>

                    <div class="modal-body row" id="<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"ModalBody"%>"
                         style="background: #dfead6;margin-left: 0px;margin-right: 0px;padding-left: 0px;padding-right: 0px;">

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="removeWarn()">Close</button>
                    </div>
                </div>
            </div>
        </div>
<%
    }
%>
<%--<div id="myModal<%=subjectItem.getId()%>" class="modal fade" role="dialog">--%>
    <%--<div class="modal-dialog modal-md">--%>

        <%--<!-- Modal content-->--%>
        <%--<div class="modal-content">--%>


            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                <%--<h4 class="modal-title">HW по <%=subjectItem.getName()+", "+subjectItem.getTeacherName()%></h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body row" id="myModal<%=subjectItem.getId() + "body"%>" >--%>

            <%--</div>--%>

            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal" onclick="removeWarn()">Close</button>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
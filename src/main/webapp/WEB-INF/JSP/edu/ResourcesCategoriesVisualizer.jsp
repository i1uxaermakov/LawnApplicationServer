<%@ page import="java.util.List" %>
<%@ page import="sections.education.entities.SubjectResourceCategory" %>
<%
    List<SubjectResourceCategory> categories = (List<SubjectResourceCategory>) request.getAttribute("categoryList");
    for(SubjectResourceCategory category: categories) {
        %>
        <a class="btn btn-primary btn-lg btn-block accord1"
           href="#<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()%>"role="button"
           data-toggle="modal" data-target="#<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"Modal"%>"
            onclick="getResourceItems(this)" catid="<%=category.getCategoryId()%>">
            <%=category.getCategoryName()%>
        </a>
        <!-- Modal -->
        <div class="modal fade" id="<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"Modal"%>"
             tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLongTitle">Resources - <%=category.getCategoryName()%></h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body" id="<%="category"+"-"+category.getCategoryId()+"-"+category.getCategoryName()+"ModalBody"%>">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
<%
    }
%>

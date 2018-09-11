<%@ page import="java.util.List" %>
<%@ page import="sections.education.entities.SubjectResourceCategory" %>
<%
    List<SubjectResourceCategory> categories = (List<SubjectResourceCategory>) request.getAttribute("categoryList");
    Boolean isMobile = (Boolean) request.getAttribute("mobile");
    for(SubjectResourceCategory category: categories) {
        String id = "category"+"-"+category.getCategoryId()+"-"+category.getCategoryName();
        %>
        <a class="btn btn-primary btn-lg btn-block accord1"
           role="button"
           id="<%=id%>"

           <%if(Objects.nonNull(isMobile) && !isMobile) {%>
           data-toggle="modal"
           data-target="#<%=id+"Modal"%>"
           onclick="getResourceItemsByCategoryIdAddUp(this)"
                <%}%>

           catid="<%=category.getCategoryId()%>"
           date="<%=category.getCreationDate().getTime()%>">
            <%=category.getCategoryName()%>
        </a>

        <!-- Modal -->
        <%if(Objects.nonNull(isMobile) && !isMobile) {%>
        <div class="modal fade" id="<%=id+"Modal"%>"
             tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="removeWarn()">&times;</button>
                        <h4 class="modal-title" id="exampleModalLongTitle">Resources - <%=category.getCategoryName()%></h4>
                    </div>

                    <div class="modal-body row" id="<%=id+"ModalBody"%>"
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
    }
%>

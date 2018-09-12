<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<SubjectItem> subjectItemList = (List<SubjectItem>) request.getAttribute("subjectItemList");
    Boolean isMobile = (Boolean) request.getAttribute("mobile");
    String forwhom = (String) request.getAttribute("for");
    Map<DayLecture,Set<SubjectItem> > map = new HashMap<>();
    List<DayLecture> dayLectureList = new ArrayList<>();
    for(SubjectItem subjectItem: subjectItemList) {
        for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
            if(map.containsKey(dayLecture)) {
                map.get(dayLecture).add(subjectItem);
            }
            else {
                Set<SubjectItem> set = new TreeSet<>();
                set.add(subjectItem);
                map.put(dayLecture, set);
            }
            dayLectureList.add(dayLecture);
        }
    }
    Collections.sort(dayLectureList);

    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE | MMM dd");
%>
<section class="blocks col-md-10 col-md-offset-1 tab-pane fade in active" id="schedule">
    <%
        Map<DayLecture,Integer> mapCNT = new HashMap<>();
        int cnt = 0;
        for(int i=1; i<7; i++) { %>
            <div class="blocklawn row">
                <div class="container-fluid date <%=(i==1)?"firstdate1":"firstdate"%>"><%=simpleDateFormat.format(c.getTime())%></div>
                <%
                    boolean isWide = false;
                    for(int j=cnt; j<dayLectureList.size() && dayLectureList.get(j).getDay()==i; j++) {
                        DayLecture dayLecture = dayLectureList.get(j);
                        if(mapCNT.containsKey(dayLectureList.get(j))) {
                            isWide = true;
                            break;
                        }
                        else {
                            mapCNT.put(dayLecture,new Integer(1));
                        }
                    }
                %>
                <div class="explanation <%=(isWide)?"double-pair":""%> col-xs-12"><%
                int j=cnt;
                while(j<dayLectureList.size()) {
                    DayLecture dayLecture = dayLectureList.get(j);

                    if(dayLecture.getDay()!=i) break;
                    Set<SubjectItem> subjectItems = map.get(dayLecture);
                    %>
                    <div class="urok <%=(subjectItems.size() != 1)?"centered":""%> u<%=dayLecture.getLectureOrder()%>">
                    <%
                    for(SubjectItem subjectItem: subjectItems) { %>
                        <div class="subject-item pointer"
                             sID="<%=subjectItem.getId()%>"
                            <%if(Objects.isNull(isMobile) || !isMobile) {%>
                             data-toggle="modal"
                             data-target="#myModal<%=subjectItem.getId()%>"
                             onclick="showHomeworkBySubjectAddUp(this)">
                            <%}%>
                            <a>
                                <div class="ordles"><%=dayLecture.getLectureOrder()%></div>
                                <div class="content-schedule">
                                    <h2><%=subjectItem.getName()%></h2>
                                    <p><%=("student".equals(forwhom))?subjectItem.getTeacherName():subjectItem.getGroupName()%>
                                    <br> <%=subjectItem.getLectureHall()%></p>
                                </div>
                            </a>
                        </div>


                <%      j++; cnt++;
                    }

                %></div><%
                }%>
                </div>
            </div><%
            c.add(Calendar.DATE, 1);
        }

        if(Objects.isNull(isMobile) || !isMobile) {
            for(SubjectItem subjectItem: subjectItemList) {
            %>
            <%--Modal--%>
            <div id="myModal<%=subjectItem.getId()%>" class="modal fade" role="dialog">
                <div class="modal-dialog modal-md">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="removeWarn()">&times;</button>
                            <h4 class="modal-title">HW по <%=subjectItem.getName()+", "+subjectItem.getTeacherName()%></h4>
                        </div>

                        <div class="modal-body row" id="myModal<%=subjectItem.getId() + "body"%>" style="background: #dfead6;
                            margin-left: 0px;margin-right: 0px;padding-left: 0px;padding-right: 0px;"></div>

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
</section>
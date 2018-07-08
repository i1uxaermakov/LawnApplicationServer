<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<SubjectItem> subjectItemList = (List<SubjectItem>) request.getAttribute("subjectItemList");
    String forwhom = (String) request.getAttribute("for");
    Map<DayLecture,SubjectItem> map = new HashMap<>();
    List<DayLecture> dayLectureList = new ArrayList<>();
    for(SubjectItem subjectItem: subjectItemList) {
        for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
            map.put(dayLecture,subjectItem);
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
        int cnt = 0;
        for(int i=1; i<7; i++) { %>
            <div class="block row">
                <div class="container-fluid date <%=(i==1)?"firstdate1":"firstdate"%>"><%=simpleDateFormat.format(c.getTime())%></div>
                <div class="explanation col-xs-12"><%
                for (int j=cnt; j<dayLectureList.size(); j++,cnt++) {
                    DayLecture dayLecture = dayLectureList.get(j);
                    if(dayLecture.getDay()!=i) break;
                    SubjectItem subjectItem = map.get(dayLecture);%>

                    <div class="urok u<%=dayLecture.getLectureOrder()%>">
                        <a href="http://localhost:8080/edu/hw?id=<%=subjectItem.getId()%>">
                            <div class="ordles"><%=dayLecture.getLectureOrder()%></div>
                            <div class="content-schedule">
                                <h2><%=subjectItem.getName()%></h2>
                                <p><%=(forwhom=="student")?subjectItem.getTeacherName():subjectItem.getGroupName()%>
                                <br> <%=subjectItem.getLectureHall()%></p>
                            </div>
                        </a>
                    </div>

                <%}%>
                </div>
            </div><%
            c.add(Calendar.DATE, 1);
        }
    %>
    <%--todo своя функция, где будет попап со всеми домашними заданиями по предмету + https--%>
</section>

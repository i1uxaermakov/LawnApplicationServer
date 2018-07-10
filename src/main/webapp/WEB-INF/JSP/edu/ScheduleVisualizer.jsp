<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<SubjectItem> subjectItemList = (List<SubjectItem>) request.getAttribute("subjectItemList");
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
            <div class="block row">
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
                        <div class="subject-item pointer">
                            <a href="http://localhost:8080/edu/hw?id=<%=subjectItem.getId()%>">
                                <div class="ordles"><%=dayLecture.getLectureOrder()%></div>
                                <div class="content-schedule">
                                    <h2><%=subjectItem.getName()%></h2>
                                    <p><%=(forwhom=="student")?subjectItem.getTeacherName():subjectItem.getGroupName()%>
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
    %>
    <%--todo своя функция, где будет попап со всеми домашними заданиями по предмету + https--%>
</section>

<%--<div class="block row">--%>
    <%--<div class="container-fluid date firstdate1">Monday &#124; March 26</div>--%>
    <%--<div class="explanation double-pair col-xs-12">--%>
        <%--<div class="urok u1 ">--%>
            <%--<div class=" subject-item pointer">--%>
                <%--<div class="ordles">1</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Algebra</h2>--%>
                    <%--<p>8.30 - 9.50 <br> Room#52/62</p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class=" subject-item pointer">--%>
                <%--<div class="ordles">1</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Fizra</h2>--%>
                    <%--<p>8.30 - 9.50 <br>GYM</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>


        <%--<div class="urok centered u2">--%>
            <%--<div class=" subject-item pointer">--%>
                <%--<div class="ordles">2</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Russian</h2>--%>
                    <%--<p>10.00 - 11.20 <br> Room#32</p>--%>
                <%--</div>--%>
            <%--</div>--%>

        <%--</div>--%>
        <%--<div class="urok centered u3">--%>
            <%--<div class="subject-item pointer">--%>
                <%--<div class="ordles">3</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>English-W</h2>--%>
                    <%--<p>12.10 - 13.30 <br> Room#73</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
<%--</div>--%>


<%--<div class="block row">--%>
    <%--<div class="container-fluid date firstdate">Monday &#124; March 26</div>--%>
    <%--<div class="explanation col-xs-12">--%>
        <%--<div class="urok u1">--%>
            <%--<div class="subject-item pointer">--%>
                <%--<div class="ordles">1</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Spanish</h2>--%>
                    <%--<p>8.30 - 9.50 <br> Room#27</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>


        <%--<div class="urok u2">--%>
            <%--<div class="subject-item pointer">--%>
                <%--<div class="ordles">2</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Geometry</h2>--%>
                    <%--<p>10.00 - 11.20 <br> Room#32</p>--%>
                <%--</div>--%>
            <%--</div>--%>

        <%--</div>--%>
        <%--<div class="urok u3">--%>
            <%--<div class="subject-item pointer">--%>
                <%--<div class="ordles">3</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Community</h2>--%>
                    <%--<p>12.10 - 13.30 <br> Room#73</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="urok u4">--%>
            <%--<div class="subject-item pointer">--%>
                <%--<div class="ordles">4</div>--%>
                <%--<div class="content-schedule">--%>
                    <%--<h2>Uzbek</h2>--%>
                    <%--<p>13.40 - 15.00 <br> Room#42</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
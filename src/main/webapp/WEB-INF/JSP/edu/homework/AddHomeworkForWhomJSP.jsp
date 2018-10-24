<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<SubjectItem> subjectItemList = (List<SubjectItem>) request.getAttribute("subjectItemList");
    String forwhom = (String) request.getAttribute("for");

    Calendar c = Calendar.getInstance();
    c.setFirstDayOfWeek(Calendar.MONDAY);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, EEEE");

    Set<DayLecture> dayLectureSet = null;
    List<Date> dates = new ArrayList<>();
    Calendar tempCalendar;
    for(SubjectItem subjectItem: subjectItemList) {
        StringBuilder options = new StringBuilder("Custom Date");
        dayLectureSet = subjectItem.getWhenIsSubject();

        for(DayLecture dayLecture : dayLectureSet) {
            int cnt = 0;
            tempCalendar = Calendar.getInstance();
            tempCalendar.set(Calendar.DAY_OF_WEEK, (int)(dayLecture.getDay() + 1));
            while(cnt<2 || tempCalendar.getTime().compareTo(c.getTime())==-1) {
                if(!(tempCalendar.getTime().compareTo(c.getTime())==-1)) {
                    dates.add(tempCalendar.getTime());
                    cnt++;
                }
                tempCalendar.add(Calendar.WEEK_OF_YEAR, 1);
            }
        }

        Collections.sort(dates, Collections.reverseOrder());

        for(Date date: dates) {
            options.append(";" + simpleDateFormat.format(date));
        }

        //dayLectureSet.clear();
        dates.clear();

%>
<div class="teacher-subject-item inpopup" onclick="addItem(this)" options="<%=options%>" subjID="<%=subjectItem.getId()%>">
    <span><%=subjectItem.getName()%></span>
    <p>
        <%=("student".equals(forwhom))?subjectItem.getTeacherName():subjectItem.getGroupName()%>
        <br>
        <%
            StringBuilder venues = new StringBuilder();
            for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
                venues.append(dayLecture.getVenue()+"/");
            }
        %>
        <%=venues.substring(0,venues.length()-1)%>
    </p>
</div>
<%}
%>

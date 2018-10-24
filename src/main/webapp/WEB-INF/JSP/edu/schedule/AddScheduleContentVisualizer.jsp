<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="sections.education.schedule.TeacherInfo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    class DayLectureTemp {
        private long day;
        private long lecture;

        public DayLectureTemp(long day, long lecture) {
            this.day = day;
            this.lecture = lecture;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DayLectureTemp that = (DayLectureTemp) o;

            if (day != that.day) return false;
            if (lecture != that.lecture) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = (int) (day ^ (day >>> 32));
            result = 31 * result + (int) (lecture ^ (lecture >>> 32));
            return result;
        }
    }




    List<SubjectItem> subjectItems = (List<SubjectItem>) request.getAttribute("subjectItemList");
    List<TeacherInfo> teachersList = (List<TeacherInfo>) request.getAttribute("teachersList");

    StringBuilder teachersOptionsBuilder = new StringBuilder();
    for(TeacherInfo teacherInfo: teachersList) {
        teachersOptionsBuilder.append("<option value=\"" + teacherInfo.getTeacherUserID() + "\">" + teacherInfo.getFullName() + "</option>\n");
    }

    Map<DayLectureTemp,List<SubjectItem>> dayToSubjectItemMap = new HashMap<>();
    for(SubjectItem subjectItem: subjectItems) {
        for(DayLecture dayLecture : subjectItem.getWhenIsSubject()) {
            DayLectureTemp dayLectureTemp = new DayLectureTemp(dayLecture.getDay(), dayLecture.getLectureOrder());
            if(dayToSubjectItemMap.containsKey(dayLectureTemp)) {
                dayToSubjectItemMap.get(dayLectureTemp).add(subjectItem);
            }
            else {
                ArrayList<SubjectItem> arrayList = new ArrayList<>(0);
                arrayList.add(subjectItem);
                dayToSubjectItemMap.put(dayLectureTemp,arrayList);
            }
        }
    }

    SimpleDateFormat weekDay = new SimpleDateFormat("EEEE");
    Calendar calendar = Calendar.getInstance();

    int idCounter = 1;
    for(int dayOrder=1; dayOrder<=6; dayOrder++) {
        calendar.set(Calendar.DAY_OF_WEEK, dayOrder+1);
%>
    <div class="block row">
        <div class="container-fluid date firstdate<%=(dayOrder==1)?"1":""%>"><%=weekDay.format(calendar.getTime())%> </div>
        <div class="explanation double-pair col-xs-12">
            <%
            for(int lectureOrder=1; lectureOrder<=4; lectureOrder++) {%>
                <div class="urok u1 ">
                <%
                    DayLectureTemp dayLectureTemp = new DayLectureTemp(dayOrder,lectureOrder);
                    List<SubjectItem> subjectItemListLoop = dayToSubjectItemMap.get(dayLectureTemp);
                    long length = (Objects.isNull(subjectItemListLoop))?0:subjectItemListLoop.size();
                    if(Objects.nonNull(subjectItemListLoop)) {
                        for(SubjectItem subjectItem: subjectItemListLoop) {
                            String venue = "";
                            for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
                                if(dayLecture.getLectureOrder()==lectureOrder && dayLecture.getDay()==dayOrder) {
                                    venue = dayLecture.getVenue();
                                }
                            }
                            String subjectID = "subject" + idCounter;
                            String modalID = "modal" + idCounter;
                            idCounter++;%>
                        <div class="subject-item pointer" data-toggle="modal" data-target="#<%=modalID%>" id="<%=subjectID%>">
                            <div class="ordles"><%=lectureOrder%></div>
                            <div class="content-schedule">
                                <h2><%=subjectItem.getName()%></h2>
                                <p><%=subjectItem.getTeacherName()%> <br> <%=venue%></p>
                            </div>
                        </div>
                <%
                        }
                    }

                    for(int i=0; i<2-length; i++) {
                        String subjectID = "subject" + idCounter;
                        String modalID = "modal" + idCounter;
                        idCounter++;%>
                        <div class="subject-item pointer" data-toggle="modal" data-target="#<%=modalID%>" id="<%=subjectID%>">
                            <div class="plus">+</div>
                        </div>
                    <%}
                %>
                </div>
        <%}%>
        </div>
    </div>
    <%}

    idCounter = 1;
    for(int dayOrder=1; dayOrder<=6; dayOrder++) {
        for(int lectureOrder=1; lectureOrder<=4; lectureOrder++) {
            DayLectureTemp dayLectureTemp = new DayLectureTemp(dayOrder,lectureOrder);
            List<SubjectItem> subjectItemListLoop = dayToSubjectItemMap.get(dayLectureTemp);
            long length = (Objects.isNull(subjectItemListLoop))?0:subjectItemListLoop.size();
            if(Objects.nonNull(subjectItemListLoop)) {
                for (SubjectItem subjectItem : subjectItemListLoop) {
                    //String subjectID = "subject" + idCounter;
                    String modalID = "modal" + idCounter;
                    idCounter++;

                    String venue = "";
                    for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
                        if(dayLecture.getLectureOrder()==lectureOrder && dayLecture.getDay()==dayOrder) {
                            venue = dayLecture.getVenue();
                        }
                    }
                    %>
                    <%--filled modal for adding--%>
                    <div id="<%=modalID%>" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Add Subject</h4>
                                </div>
                                <div class="modal-body" id="<%=modalID+"Body"%>">
                                    <label for="">Название предмета: <br><input type="text" class="subject" value="<%=subjectItem.getName()%>"></label><br>
                                    <label for="">Преподаватель:<br>
                                        <select>
                                        <%for(TeacherInfo teacherInfo: teachersList) {%>
                                                <option value="<%=teacherInfo.getTeacherUserID()%>"
                                                        <%=(teacherInfo.getTeacherUserID().equals(subjectItem.getTeacherId()))?"selected":""%>>
                                                    <%=teacherInfo.getFullName()%>
                                                </option>
                                        <%}%>
                                        </select>
                                    </label><br>
                                    <label for="">Место: <br> <input class="venue" type="text" value="<%=venue%>"></label><br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть без изменений</button>
                                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addsubject(this)" modalID="<%=modalID%>">Добавить предмет!</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                }
            }

            for(int i=0; i<2-length; i++) {
                //String subjectID = "subject" + idCounter;
                String modalID = "modal" + idCounter;
                idCounter++;
                %>
                <%--empty modal for adding--%>
                <div id="<%=modalID%>" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Add Subject</h4>
                            </div>
                            <div class="modal-body" id="<%=modalID+"Body"%>">
                                <label for="">Предмет: <br><input type="text" class="subject" placeholder="Как называется предмет?"></label><br>
                                <label for="">Преподаватель: <br> <select><%=teachersOptionsBuilder%></select></label><br>
                                <label for="">Место: <br> <input class="venue" type="text" placeholder="В каком кабинете?"></label><br>
                            </div>
                            <div class="modal-footer">
                                <%--<button type="button" class="btn btn-default" data-dismiss="modal" onclick="addsubject(this)">Close</button>--%>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть без изменений</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addsubject(this)" modalID="<%=modalID%>">Добавить предмет!</button>
                            </div>
                        </div>
                    </div>
                </div>
<%
            }
        }
    }
%>
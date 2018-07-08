<%@ page import="sections.education.entities.HomeworkItem" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<HomeworkItem> homeworkItemList = (List<HomeworkItem>) request.getAttribute("homeworkItemList");
    Collections.sort(homeworkItemList);
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE | MMM dd");
    SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE");
    SimpleDateFormat hwUploadDateFormat = new SimpleDateFormat("MMM dd, hh:ss");
    SimpleDateFormat hwDeadlineDateFormat = new SimpleDateFormat("MMM dd");

    List<Date> dates = new ArrayList<>();
    int howManyDates = 0;
    for(HomeworkItem homeworkItem: homeworkItemList) {
        if(!dates.contains(homeworkItem.getDeadlineDate())) {
            howManyDates++;
            dates.add(homeworkItem.getDeadlineDate());
        }
    }

    int cnt=0;
    for(int i=0; i<howManyDates; i++) {
        Date date = dates.get(i);
        String weekDay = weekDayFormat.format(date);%>
        <div>
            <a class="btn btn-primary btn-lg btn-block accord" data-toggle="collapse" href="#<%=weekDay%>"
                role="button" aria-expanded="true"> <%=dateFormat.format(date)%>
            </a>
        </div>
        <div class="collapse in buttoncol" id="<%=weekDay%>">
        <%
            for(int j=cnt; j<homeworkItemList.size(); j++,cnt++) {
                if(!homeworkItemList.get(j).getDeadlineDate().equals(date)) {
                    break;
                }
                HomeworkItem hwi = homeworkItemList.get(j);
        %>
            <div class="news">
                <div class="newsbegin">
                    <div class="l2-homework">
                        <span class="post-publishers-name"><%=hwi.getSubjectName() + " - " + hwi.getTeacherName()%>History - Ramis Sattarov</span>
                        <br>
                        <span class="item-date">Deadline: <%=hwDeadlineDateFormat.format(date)%></span> <br>
                        <span class="item-date">Uploaded: <%=hwi.getPublishDate()%></span>
                    </div>
                </div>
                <div class="text">
                    <%=hwi.getDescription()%>
                </div>
                <div class="twophotosrow photos row">
                    <div class="my-gallery" itemscope itemtype="">

                        <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                            <a href="imgs/eduex1.jpg" itemprop="contentUrl" data-size="635x353">

                                <img src="imgs/eduex1.jpg" itemprop="thumbnail"/> <%--alt="Image description"--%>

                            </a>
                            <!-- </div> -->
                            <figcaption itemprop="caption description">Image caption 3</figcaption>
                        </figure>

                        <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                            <a href="imgs/eduex1.jpg" itemprop="contentUrl" data-size="640x640">
                                <img src="imgs/eduex1.jpg" itemprop="thumbnail" alt="Image description" />
                            </a>
                            <figcaption itemprop="caption description">Image caption 4</figcaption>
                        </figure>
                    </div>
                </div>

                <%--<div class="uploaded-files-hw">--%>
                    <%--<a href="#"><i class="far fa-file-word fa-4x"></i>--%>
                        <%--<span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>--%>
                <%--</div>--%>
                <%--<div class="uploaded-files-hw">--%>
                    <%--<a href="#"><i class="far fa-file-pdf fa-4x"></i>--%>
                        <%--<span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>--%>
                <%--</div>--%>
            </div>




            <%}%>
        </div>

<%
    }
%>




<%--<div>--%>
    <%--<a class="btn btn-primary btn-lg btn-block accord"  data-toggle="collapse" href="#Monday" role="button" aria-expanded="true">Monday | April 22</a>--%>
<%--</div>--%>
<%--<div class="collapse in buttoncol" id="Monday">--%>
    <%--<div class="news">--%>
        <%--<div class="newsbegin">--%>
            <%--<div class="l2-homework">--%>
                <%--<span class="post-publishers-name">History - Ramis Sattarov</span>--%>
                <%--<br>--%>
                <%--<span class="item-date">Deadline: 14 мая 2018 21:09</span> <br>--%>
                <%--<span class="item-date">Uploaded: 7 мая 2018 14:00</span>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="text">--%>
            <%--Сделать конспект темы "Социальная независимость" с книги на странице №99. Прилагается презентация к уроку №9.--%>
        <%--</div>--%>
        <%--<div class="twophotosrow photos row">--%>
            <%--<div class="my-gallery" itemscope itemtype="">--%>



                <%--<figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">--%>
                    <%--<!-- <div class="wrapperThumb"> -->--%>

                    <%--<a href="imgs/eduex1.jpg" itemprop="contentUrl" data-size="635x353">--%>

                        <%--<img src="imgs/eduex1.jpg" itemprop="thumbnail" alt="Image description" />--%>

                    <%--</a>--%>
                    <%--<!-- </div> -->--%>
                    <%--<figcaption itemprop="caption description">Image caption 3</figcaption>--%>
                <%--</figure>--%>

                <%--<figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">--%>
                    <%--<a href="imgs/eduex1.jpg" itemprop="contentUrl" data-size="640x640">--%>
                        <%--<img src="imgs/eduex1.jpg" itemprop="thumbnail" alt="Image description" />--%>
                    <%--</a>--%>
                    <%--<figcaption itemprop="caption description">Image caption 4</figcaption>--%>
                <%--</figure>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="uploaded-files-hw">--%>
            <%--<a href="#"><i class="far fa-file-word fa-4x"></i>--%>
                <%--<span class="about-hw-file">Title: Человек и Общество.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>--%>
        <%--</div>--%>
        <%--<div class="uploaded-files-hw">--%>
            <%--<a href="#"><i class="far fa-file-pdf fa-4x"></i>--%>
                <%--<span class="about-hw-file">Title: Презентация к уроку №9<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="news">--%>
        <%--<div class="newsbegin">--%>
            <%--<div class="l2-homework">--%>
                <%--<span class="post-publishers-name">Russian - Lyubov Anatolyevna</span>--%>
                <%--<br>--%>
                <%--<span class="item-date">Deadline: 20 апреля 2018 21:09</span> <br>--%>
                <%--<span class="item-date">Uploaded: 23 апреля 2018 21:09</span>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="text">--%>
            <%--Прочитать правила с приложенного документа, законспектировать.--%>
        <%--</div>--%>
        <%--<div class="uploaded-files-hw">--%>
            <%--<a href="#"><i class="far fa-file-pdf fa-4x"></i>--%>
                <%--<span class="about-hw-file">Title: Правило Буравчика.<br>Size: 13Mb<br>Uploaded: 2 апреля 2018 21:09 </span></a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="news">--%>
        <%--<div class="newsbegin">--%>
            <%--<div class="l2-homework">--%>
                <%--<span class="post-publishers-name">Physics - Dilbar Sultanovna</span>--%>
                <%--<br>--%>
                <%--<span class="item-date">Deadline: 14 марта 2018 21:09</span> <br>--%>
                <%--<span class="item-date">Uploaded: 13 мая 2018 21:09</span>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="text">--%>
            <%--Создать большой адронный коллайдер из подручных средств по инструкции в файле. Используя ускоритель частиц, доказать существование Бозона Хиггса.--%>
        <%--</div>--%>
        <%--<div class="uploaded-files-hw">--%>
            <%--<a href="#"><i class="far fa-file-pdf fa-4x"></i>--%>
                <%--<span class="about-hw-file">Title: Адронный Коллайдер для чайников.<br>Size: 1Mb<br>Uploaded: 20 марта 2018 21:09 </span></a>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
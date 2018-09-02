<%@ page import="sections.education.entities.HomeworkItem" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page import="utils.images.Photo" %>
<%@ page import="utils.files.File" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<HomeworkItem> homeworkItemList = (List<HomeworkItem>) request.getAttribute("homeworkItemList");
    if(homeworkItemList==null || homeworkItemList.size() == 0) {
        %>
            <div class="news warn" style="padding-bottom: 15px; margin-bottom: 10px;">
                <div class="newsbegin" style="text-align: center; font-size: 20px; margin-bottom: 0px;
                                                        padding-bottom: 0px; height:auto !important;">
                    <span>Fortunately, there is no homework!</span>
                </div>
            </div>
        <%
        return;
    }

    String fDOY = (String) request.getAttribute("firstDayInYear");
    if(fDOY==null) {
        fDOY = "01-09-2018";
    }
    Calendar firstDateOfYear = Calendar.getInstance();
    try {
        firstDateOfYear.setTime((new SimpleDateFormat("dd-MM-yyyy")).parse(fDOY));
    } catch (ParseException e) {
        e.printStackTrace();
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE | MMM dd");
    SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE");
    SimpleDateFormat hwUploadDateFormat = new SimpleDateFormat("MMM dd yyyy, HH:mm");
    SimpleDateFormat hwDeadlineDateFormat = new SimpleDateFormat("MMM dd");

    Map<Integer, List<Timestamp>> weekDaysCorrelationMap = new HashMap<>();
    Map<Timestamp, List<HomeworkItem>> specificDateHomeworkItemsCorrelation = new HashMap<>();
    Collections.sort(homeworkItemList);

    for(HomeworkItem homeworkItem: homeworkItemList) {
        Timestamp deadlineDate = homeworkItem.getDeadlineDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deadlineDate);

        int key_WeekNumber = (calendar.get(Calendar.WEEK_OF_YEAR));
        if(weekDaysCorrelationMap.containsKey(key_WeekNumber)) {
            if(!weekDaysCorrelationMap.get(key_WeekNumber).contains(deadlineDate)) {
                weekDaysCorrelationMap.get(key_WeekNumber).add(deadlineDate);
            }
        }
        else {
            ArrayList<Timestamp> dateList = new ArrayList<>(0);
            dateList.add(deadlineDate);
            weekDaysCorrelationMap.put(key_WeekNumber, dateList);
        }

        if(specificDateHomeworkItemsCorrelation.containsKey(deadlineDate)) {
            specificDateHomeworkItemsCorrelation.get(deadlineDate).add(homeworkItem);
        }
        else {
            ArrayList<HomeworkItem> homeworkItemArrayList = new ArrayList<>(0);
            homeworkItemArrayList.add(homeworkItem);
            specificDateHomeworkItemsCorrelation.put(deadlineDate, homeworkItemArrayList);
        }
    }

    boolean isExpandedFirst = true;
    Calendar calendarForWeekNUmberSection = Calendar.getInstance();
    for(Integer weekNumber: weekDaysCorrelationMap.keySet()) {
        List<Timestamp> weeksDates = weekDaysCorrelationMap.get(weekNumber);
        calendarForWeekNUmberSection.setTime(weeksDates.get(0));
        calendarForWeekNUmberSection.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String beginningOfWeek = hwDeadlineDateFormat.format(calendarForWeekNUmberSection.getTime());
        calendarForWeekNUmberSection.add(Calendar.DAY_OF_YEAR, 6);
        String endOfWeek = hwDeadlineDateFormat.format(calendarForWeekNUmberSection.getTime());
        %>
            <section class="week_number">
                <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd weeknumbg">
                    <span class="flright weeknum">
                        <%=beginningOfWeek + " - " + endOfWeek%><%--, Week <%=weekNumber%>--%>
                    </span>
                </div>
            </section>

            <div class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-xs-12 col-lg-6 col-lg-offset-3 padd">
            <%
                for(Timestamp deadlineDate: weeksDates) {%>
                    <div>
                        <a class="btn btn-primary btn-lg btn-block accord accord1" data-toggle="collapse" href="#<%=weekDayFormat.format(deadlineDate)+"OfWeek"+weekNumber%>"
                           role="button" aria-expanded="<%=isExpandedFirst%>"> <%=dateFormat.format(deadlineDate)%>
                        </a>
                    </div>
                    <div class="collapse <%=(isExpandedFirst)?"in":""%> buttoncol" id="<%=weekDayFormat.format(deadlineDate)+"OfWeek"+weekNumber%>">
                    <%
                        if(isExpandedFirst) {
                            isExpandedFirst = false;
                        }
                        for(HomeworkItem hwi: specificDateHomeworkItemsCorrelation.get(deadlineDate)) {
                            %>
                                <div class="news">
                                    <div class="newsbegin">
                                        <div class="l2-homework">
                                            <span class="post-publishers-name"><%=hwi.getSubjectName() + " - " + hwi.getTeacherName()%></span> <!--History - Ramis Sattarov-->
                                            <br>
                                            <span class="item-date">Deadline: <%=hwDeadlineDateFormat.format(deadlineDate)%></span> <br>
                                            <span class="item-date">Uploaded: <%=hwUploadDateFormat.format(hwi.getPublishDate())%></span>
                                        </div>
                                    </div>
                                    <div class="text">
                                        <%=hwi.getDescription().replaceAll("(\r\n|\r|\n|\n\r)", "<br>")%>
                                    </div>
                                    <%
                                            int size = hwi.getPhotos().size();
                                            if(size != 0) {
                                                if(size < 4) {
                                                    String num = (size==1) ? "one" : ((size==2) ? "two" : "three");%>
                                                    <div class="<%=num%>photosrow photos row">
                                                        <div class="my-gallery" itemscope itemtype="">
                                                            <%
                                                                for(Photo photo: hwi.getPhotos()) {%>
                                                                    <figure itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
                                                                        <a href="/images/<%=photo.getThumbnailPhotoLocation()%>" itemprop="contentUrl" data-size="<%=photo.getThumbnailPhotoDimensions()%>">
                                                                            <img src="/images/<%=photo.getSquareThumbnailPhotoLocation()%>" itemprop="thumbnail"/> <%--alt="Image description"--%>
                                                                        </a>
                                                                        <!-- </div> -->
                                                                        <figcaption itemprop="caption description"> Photo by: <%=photo.getAuthor()%></figcaption>
                                                                    </figure>
                                                                <%}
                                                            %>
                                                        </div>
                                                    </div>
                                            <%  }
                                            else {
                                                List<Photo> photos = new ArrayList<>(hwi.getPhotos());
                                                Collections.sort(photos);
                                            %>
                                    <div class="attachedalbum">
                                        <%--todo link to photos--%>
                                        <a href="album_post_photos.html">
                                            <img src="/images/<%=photos.get(0).getSquareThumbnailPhotoLocation()%>" alt="" class="">
                                            <span class="aboutAlbum">
                                                Attached Photos
                                                <br>
                                                <span>
                                                <%=size%> photos
                                                </span>
                                            </span>
                                        </a>
                                    </div>
                                                <%
                                                }
                                            }


                                                    ArrayList<File> files = new ArrayList<>(hwi.getFiles());
                                                    Collections.sort(files);
                                                    for(File file: files) {%>
                                            <div class="uploaded-files-hw">
                                                <a href="/files/download/<%=file.getSaveName()%>">
                                                    <i class="far fa-file fa-4x"></i>
                                                    <span class="about-hw-file" style="word-break: break-all;">
                                                            Title: <%=file.getOriginalName()%>
                                                            <br>Size: <%=file.getReadableFileSize()%>
                                                            <br>Uploaded: <%=hwDeadlineDateFormat.format(file.getPublishDate())%>
                                                    </span>
                                                </a>
                                            </div>
                                    <%  }%>
                                </div>
                        <%
                        }
                    %>
                    </div>
                <%
                }
            %>
            </div>
        <%

    }
        %>
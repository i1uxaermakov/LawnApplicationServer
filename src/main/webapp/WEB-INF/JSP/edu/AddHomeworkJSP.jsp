<%@ page import="sections.education.entities.SubjectItem" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="sections.education.entities.DayLecture" %>
<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Lawn</title>

        <!-- Bootstrap -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/main.css" rel="stylesheet">
        <link href="/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="/css/default-skin/default-skin.css">
        <link rel="stylesheet" href="/css/add-homework.css">
        <link rel="stylesheet" href="/css/edu.css">
        <meta charset="UTF-8">
        <title>LAWN ADDING</title>
    </head>

    <%
        List<SubjectItem> subjectItemList = (List<SubjectItem>) request.getAttribute("subjectItemList");
        String forwhom = (String) request.getAttribute("for");

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
//        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, EEEE");
    %>

    <body>
    <%--begin header--%>
        <header>
            <nav id="myNavbar" class="navbar navbar-default navbar-fixed-top  container-fluid" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html">LAWN</a>
                        <a class="myacc visible-xs" href="login.html">
                            <i class="fas fa-user-circle"></i>
                        </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="nav navbar-nav navbar-right container-fluid">
                            <li class="">
                                <a data-toggle="tabs" href="index.html">
                                    <i class="fas fa-home"></i>
                                    Home</a>
                            </li>
                            <li class="">
                                <a data-toggle="tabs" href="edu_schedule.html">
                                    <i class="fas fa-graduation-cap"></i>
                                    Education</a>
                            </li>
                            <li class="">
                                <a data-toggle="tabs" href="community.html">
                                    <i class="fas fa-users"></i>
                                    Community</a>
                            </li>
                            <li class="">
                                <a data-toggle="tabs" href="album.html">
                                    <i class="fas fa-images"></i>
                                    Album</a>
                            </li>
                            <li class="hidden-xs ">
                                <a data-toggle="tabs" href="login.html">
                                    <i class="fas fa-user-circle"></i>
                                    Sign In</a>
                            </li>
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-cog"></i>
                                    Settings
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">My account</a></li>
                                    <li><a href="#">My organizations</a></li>
                                    <li><a href="#">Liked posts</a></li>
                                    <li><a href="#">My posts</a></li>
                                    <li><a href="#">Tickets</a></li>
                                    <li><a href="#">Add</a></li>
                                    <li><a href="#">FAQ</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <%--end header--%>


        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-xs-12 col-lg-6 col-lg-offset-3 add-container first padd">

            <section class="addingsection">

                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-md">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Выберите </h4>
                            </div>
                            <div class="modal-body row">

                                <%
                                    Set<DayLecture> dayLectureSet = null;
                                    List<Date> dates = new ArrayList<>();
                                    Calendar tempCalendar;
                                    for(SubjectItem subjectItem: subjectItemList) {
                                        StringBuilder options = new StringBuilder("Custom Date");
                                        dayLectureSet = subjectItem.getWhenIsSubject();

                                        for(DayLecture dayLecture: dayLectureSet) {
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

                                        dayLectureSet.clear();
                                        dates.clear();
                                %>
                                        <div class="teacher-subject-item inpopup" onclick="addItem(this)" options="<%=options%>" subjID="<%=subjectItem.getId()%>">
                                            <span><%=subjectItem.getName()%></span>
                                            <p>
                                                <%=("student".equals(forwhom))?subjectItem.getTeacherName():subjectItem.getGroupName()%>
                                                <br>
                                                <%=subjectItem.getLectureHall()%>
                                            </p>
                                        </div>
                                <%}


                                %>
                            </div>


                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>

                </div>





                <h5 class="input_header">Выберите группы:</h5>
                <div class="row subject-selected" id="subject-selected">

                </div>

                <div class="add_item_block center-content" data-toggle="modal" data-target="#myModal">
                    <span class="plus-button">+</span>
                </div>




            </section>


            <form name="addHWform" id="addHWform" enctype="multipart/form-data"></form>

            <section class="addingsection">
                    <div class="adding-area">

                        <div class="col-xs-12 hw-text">

                            <textarea name="hw-content" id="hw-text" form="addHWform" autocapitalize="sentences" autocomplete="on" autocorrect="on" placeholder="Напишите" spellcheck="true" dir="auto"></textarea>
                        </div>
                    </div>
                    <div class="icons-add">
                        <label for="images"><i class="far fa-image"></i></label>
                        <input type="file" name="images" id="images" multiple accept="image/*" form="addHWform" onchange="previewImages()">


                        <label for="file-input"><i class="fas fa-paperclip"></i></label>
                        <input type="file" name="files" id="file-input" multiple form="addHWform"/>




                        <input type="submit" form="addHWform" style="float: right" multiple class="btnn btn-suc">
                    </div>



            </section>

            <section class="addingsection">
                <div id="preview" class="row">

                </div>
            </section>

            <section class="addingsection">
                <div id="previewFiles">

                </div>
            </section>
        </div>


    <script src="/css/jquery.min.js"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/css/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/css/main.js" type="text/javascript" charset="utf-8"></script>
    <script src="/css/jquery.min.js" charset="utf-8" type="text/javascript"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/css/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- <script src="slick/slick.min.js"></script>    -->
    <script src="/css/main.js" type="text/javascript" charset="utf-8"></script>
    <script src="/css/add-homework.js" charset="utf-8" type="text/javascript"></script>
    </body>
</html>

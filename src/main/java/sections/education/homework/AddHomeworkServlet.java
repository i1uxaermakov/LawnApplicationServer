package sections.education.homework;

import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.DAO.ScheduleDAO;
import sections.education.entities.HomeworkItem;
import sections.education.entities.SubjectItem;
import security.entities.User;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@MultipartConfig
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        List<SubjectItem> subjectItemList = new ArrayList<>(0);

        if(user.getPrivileges().contains("teacher")) {
            subjectItemList = scheduleDAO.getSubjectItemsByTeacherId(user.getUserId());
            req.setAttribute("for", "teacher");
        }
        else {
            subjectItemList = scheduleDAO.getSubjectItemsByGroup(user.getGroupId());
            req.setAttribute("for", "student");
        }

        req.setAttribute("subjectItemList", subjectItemList);


        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/AddHomeworkJSP.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkVisualizer.jsp").include(req,resp);
        }

        hibSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        HomeworkItemDAO homeworkItemDAO = new HomeworkItemDAO();

        List<Long> list = scheduleDAO.getSubjectItemsIDsByTeacherIdAndGroupId(user.getUserId(), user.getGroupId());

        String HWfor = req.getParameter("HWfor");
        String[] HWforArray = HWfor.split(";");

        String hw_text = req.getParameter("hw-text");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, EEEE");
        SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);

        for(int i=0; i<HWforArray.length; i++) {
            HomeworkItem homeworkItem = new HomeworkItem();
            if(!list.contains(new Long(HWforArray[i]))) {
                resp.setStatus(228);
                //todo bad response
                resp.getWriter().println("Вы не можете давать задание одной или нескольким группам из выбранного списка!");
                return;
            }

            String selectDate = req.getParameter(HWforArray[i] + "select");
            boolean isCustom = false;
            if("Custom Date".equals(selectDate)) {
                selectDate = req.getParameter(HWforArray[i] + "select_custom");
                isCustom = true;
            }
            try {
                Date deadlineDate = null;
                Calendar calendar = Calendar.getInstance();
                if(isCustom) {
                    deadlineDate = newSimpleDateFormat.parse(selectDate);
                }
                else {
                    deadlineDate = simpleDateFormat.parse(selectDate);
                }
                if(deadlineDate != null) {
                    calendar.setTime(deadlineDate);
                    calendar.set(Calendar.YEAR, 2018);

                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(new Date(System.currentTimeMillis()));
                    while(calendar.get(Calendar.YEAR) < calendar1.get(Calendar.YEAR)) {
                        calendar.add(Calendar.YEAR,1);
                    }
                    if(calendar.getTime().getTime() < calendar1.getTime().getTime()) {
                        if(!(calendar.get(Calendar.DAY_OF_YEAR)==calendar1.get(Calendar.DAY_OF_YEAR))) {
                            calendar.add(Calendar.YEAR, 1);
                        }
                    }
                    homeworkItem.setDeadlineDate(calendar.getTime());
                }
                else {
                    //todo bad response
                    resp.getWriter().println("Возникла проблема с введением deadline'ов. Пожалуйста, пересмотрите.");
                    return;
                }

            } catch (ParseException e) {
                //todo bad response
                resp.getWriter().println("Возникла проблема с введением deadline'ов. Пожалуйста, пересмотрите.");
                e.printStackTrace();
            }

            SubjectItem subjectItem = scheduleDAO.getSubjectItemById(new Long(HWforArray[i]));

            homeworkItem.setAddedById(user.getUserId());
            homeworkItem.setGroupId(subjectItem.getGroupId());
            homeworkItem.setSubjectId(subjectItem.getId());
            homeworkItem.setSubjectName(subjectItem.getName());
            homeworkItem.setTeacherName(subjectItem.getTeacherName());
            homeworkItem.setTeacherId(subjectItem.getTeacherId());
            homeworkItem.setDescription(hw_text + "\n" + "Added by: " + user.getFirstName() + " " + user.getLastName());
            homeworkItem.setPublishDate(new java.sql.Date(System.currentTimeMillis()));
            homeworkItemList.add(homeworkItem);
        }

        String idealResponse = "", coma = "";
        for(int i=0; i<homeworkItemList.size(); i++) {
            Long res = homeworkItemDAO.persistHomeworkItem(homeworkItemList.get(i));
            coma = (i != homeworkItemList.size()-1)?";":"";
            idealResponse = idealResponse + res + coma;
        }
        hibSession.close();

        resp.setStatus(200);
        resp.getWriter().println(idealResponse);
        System.out.println("\n hw ID = " + idealResponse+  "\n");
    }
}
/*
    private Long hw_id;
    private Long addedById;
    private Long groupId;
    private Long subjectId;
    private String subjectName;
    private String teacherName;
    private String description;
    private Date publishDate;
    private Date deadlineDate;
    private Set<File> files;
    private AttachedAlbum hwAlbum;
 */
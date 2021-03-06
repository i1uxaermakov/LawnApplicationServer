package sections.education.schedule;

import account.DAO.UserDAO;
import account.entities.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import sections.education.DAO.LyceumGroupDAO;
import sections.education.DAO.SubjectItemDAO;
import sections.education.entities.DayLecture;
import sections.education.entities.SubjectItem;
import sections.education.homework.AddPhotosToHWServlet;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class AddSubjectItemServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AddSubjectItemServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        User user = (User) req.getSession().getAttribute("User");
        UserDAO userDAO = new UserDAO();
        LyceumGroupDAO lyceumGroupDAO = new LyceumGroupDAO();
        SubjectItemDAO subjectItemDAO = new SubjectItemDAO();

        //get groupId parameter and checking if there is such a group in the database
        String groupIdParameter = req.getParameter("gid");
        if(Objects.isNull(groupIdParameter) || !StringUtils.isNumeric(groupIdParameter)) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid GroupID provided!");
            return;
        }
        Long groupId = new Long(groupIdParameter);
        String groupName = lyceumGroupDAO.getGroupNameById(groupId);
        if(Objects.isNull(groupName)) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid GroupID provided!");
            return;
        }

        //getting subject name
        String subjectName = req.getParameter("sname");
        if(Objects.isNull(subjectName)) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Subject Name provided!");
            return;
        }

        //getting teacherId and checking if there is such a teacher in the database
        String teacherIdParameter = req.getParameter("tid");
        if(Objects.isNull(teacherIdParameter) || !StringUtils.isNumeric(teacherIdParameter)) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Teacher ID provided!");
            return;
        }
        Long teacherId = new Long(teacherIdParameter);
        List<TeacherInfo> teachers = userDAO.getAllTeachers();
        TeacherInfo chosenTeacherInfo = null;
        for(TeacherInfo teacherInfo: teachers) {
            if(teacherInfo.getTeacherUserID().equals(teacherId)) {
                chosenTeacherInfo = teacherInfo;
            }
        }
        if(Objects.isNull(chosenTeacherInfo)) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Teacher ID provided!");
            return;
        }

        //getting venue of subject
        String venue = req.getParameter("venue");
        if(Objects.isNull(venue)) {
            resp.setStatus(400);
            resp.getWriter().println("No Venue provided!");
            return;
        }

        //getting dayOrder and lectureOrder
        String onPageIdParameter = req.getParameter("place_on_page");
        if(Objects.isNull(onPageIdParameter) || !StringUtils.isNumeric(onPageIdParameter)) {
            resp.setStatus(400);
            resp.getWriter().println("No Place On Page provided!");
            return;
        }
        Long onPageId = new Long(onPageIdParameter);
        if(onPageId>48 || onPageId<0) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Place On Page provided!");
            return;
        }
        Long forSubgroupParameter = onPageId%2;
        Long dayOrder = new Long(1);
        Long lectureOrder = new Long(1);
        while(onPageId - 8 > 0) {
            onPageId -= 8;
            dayOrder++;
        }
        while(onPageId - 2 > 0) {
            lectureOrder++;
            onPageId-=2;
        }


        boolean foundSubjectOnThisDayAndLecture = false;
        SubjectItem subjectItemToRemoveDayLectureFrom = null;
        DayLecture dayLectureToRemove = null;
        List<SubjectItem> subjectItemList = subjectItemDAO.getSubjectItemsByGroup(groupId);
        for(SubjectItem subjectItem: subjectItemList) {
            if(Objects.nonNull(subjectItem.getWhenIsSubject())) {
                for(DayLecture dayLecture: subjectItem.getWhenIsSubject()) {
                    if(dayLecture.getDay().equals(dayOrder) &&
                            dayLecture.getLectureOrder().equals(lectureOrder) &&
                            dayLecture.getForSubgroup().equals(forSubgroupParameter)) {
                        foundSubjectOnThisDayAndLecture = true;
                        subjectItemToRemoveDayLectureFrom = subjectItem;
                        dayLectureToRemove = dayLecture;
                    }
                }
            }
        }
        if(foundSubjectOnThisDayAndLecture) {
//            System.out.println("remove");
            subjectItemToRemoveDayLectureFrom.getWhenIsSubject().remove(dayLectureToRemove);
            subjectItemDAO.updateSubjectItem(subjectItemToRemoveDayLectureFrom);
            logger.info("User(userID="+user.getUserId()+") deleted SubjectItem("+dayLectureToRemove.getId()+").");
        }

//        System.out.println(1);

        DayLecture dayLecture = new DayLecture();
        dayLecture.setVenue("Room " + venue);
        dayLecture.setDay(dayOrder);
        dayLecture.setLectureOrder(lectureOrder);
        dayLecture.setForSubgroup(forSubgroupParameter);
        SubjectItem existingSubjectItem = subjectItemDAO.getSubjectItemIfExistsForAdding(teacherId,subjectName,groupId);
//        System.out.println(2);
        if(Objects.nonNull(existingSubjectItem)) {
            existingSubjectItem.getWhenIsSubject().add(dayLecture);
            subjectItemDAO.updateSubjectItem(existingSubjectItem);
            logger.info("User(userID="+user.getUserId()+") updated SubjectItem("+existingSubjectItem+").");
        }
        else {
            SubjectItem newSubjectItem = new SubjectItem();
            newSubjectItem.setGroupId(groupId);
            newSubjectItem.setGroupName(groupName);
            newSubjectItem.setName(subjectName);
            newSubjectItem.setTeacherId(chosenTeacherInfo.getTeacherUserID());
            newSubjectItem.setTeacherName(chosenTeacherInfo.getFullName());

            Set<DayLecture> whenIsSubject = new HashSet<>(0);
            whenIsSubject.add(dayLecture);
            newSubjectItem.setWhenIsSubject(whenIsSubject);

            subjectItemDAO.persistSubjectItem(newSubjectItem);
            logger.info("User(userID="+user.getUserId()+") added SubjectItem("+newSubjectItem.getId()+").");
        }
        hibSession.close();
    }
}

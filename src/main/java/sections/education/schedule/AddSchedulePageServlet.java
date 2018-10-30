package sections.education.schedule;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.LyceumGroupDAO;
import sections.education.DAO.SubjectItemDAO;
import sections.education.entities.LyceumGroup;
import sections.education.entities.SubjectItem;
import account.DAO.UserDAO;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class AddSchedulePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        UserDAO userDAO = new UserDAO();
        LyceumGroupDAO lyceumGroupDAO = new LyceumGroupDAO();
        SubjectItemDAO subjectItemDAO = new SubjectItemDAO();

        List<LyceumGroup> groupList = lyceumGroupDAO.getAllLyceumGroups();

        boolean isAdditional = false;
        if(Objects.isNull(groupList) || !(groupList.size()>0) ) {
            req.setAttribute("message", "no groups");
        }
        else {
            req.setAttribute("groupList", groupList);

            Long groupID = groupList.get(0).getId();
            String groupIDparameter = req.getParameter("gid");
            if(Objects.nonNull(groupIDparameter) && StringUtils.isNumeric(groupIDparameter)) {
                groupID = new Long(groupIDparameter);
                isAdditional = true;
            }

            boolean groupIdPresenceCheck = false;
            for(LyceumGroup group: groupList) {
                if(group.getId().equals(groupID)) {
                    groupIdPresenceCheck = true;
                }
            }
            if(!groupIdPresenceCheck) {
                resp.setStatus(400);
                resp.getWriter().println("No Group with provided ID.");
                hibSession.close();
                return;
            }

            List<TeacherInfo> teachersList = userDAO.getAllTeachers();
            req.setAttribute("teachersList", teachersList);

            List<SubjectItem> subjectItemList = subjectItemDAO.getSubjectItemsByGroup(groupID);
            req.setAttribute("subjectItemList", subjectItemList);

            req.setAttribute("groupID", groupID);
        }

        hibSession.close();

        if(!isAdditional) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/AddSchedulePageJSP.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/AddScheduleContentVisualizer.jsp").include(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
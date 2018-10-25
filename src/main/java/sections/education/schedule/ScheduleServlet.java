package sections.education.schedule;

import account.entities.User;
import sections.education.DAO.SubjectItemDAO;
import sections.education.entities.SubjectItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectItemDAO subjectItemDAO = new SubjectItemDAO();
        User user = (User) req.getSession().getAttribute("User");
        List<SubjectItem> subjectItemList = null;


        if(user.getPrivileges().contains("teacher")) {
            subjectItemList = subjectItemDAO.getSubjectItemsByTeacherId(user.getUserId());
            req.setAttribute("for", "teacher");
        }
        else {
            subjectItemList = subjectItemDAO.getSubjectItemsByGroup(user.getGroupId());
            req.setAttribute("for", "student");
        }

        req.setAttribute("subjectItemList", subjectItemList);

        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/SchedulePageVisualizer.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("mobile", true);
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/ScheduleVisualizer.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

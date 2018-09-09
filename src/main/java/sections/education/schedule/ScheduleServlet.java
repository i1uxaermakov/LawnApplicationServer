package sections.education.schedule;

import security.entities.User;
import sections.education.DAO.ScheduleDAO;
import sections.education.entities.SubjectItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        User user = (User) req.getSession().getAttribute("User");
        List<SubjectItem> subjectItemList = null;


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
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/SchedulePageVisualizer.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/schedule/ScheduleVisualizer.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

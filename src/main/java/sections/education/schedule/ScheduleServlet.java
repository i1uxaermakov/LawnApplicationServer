package sections.education.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.entities.User;
import sections.education.DAO.ScheduleDAO;
import sections.education.entities.SubjectItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        User user = (User) req.getSession().getAttribute("User");
        List<SubjectItem> subjectItemList = null;
        Map<String,Object> mapResp = new HashMap<>();

        try {
            if(/*user.getPrivileges().contains("teacher")*/true) {
                subjectItemList = scheduleDAO.getSubjectItemsByTeacherId((long) 1/*user.getId()*/);
                mapResp.put("for", "teacher");
            }
            else {
                subjectItemList = scheduleDAO.getSubjectItemsByGroup((long) 1);
                mapResp.put("for", "student");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("mapResp", mapResp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

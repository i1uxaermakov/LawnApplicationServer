package sections.education.homework;



import org.apache.commons.lang3.StringUtils;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeworkItemDAO hwDAO = new HomeworkItemDAO();

        String groupId = req.getParameter("groupId");
        String subjectId = req.getParameter("subjectId");
        String lastSavedHWDate = req.getParameter("lastSavedHWDate");
        Date date = null;
        try {
            date = new Date(new SimpleDateFormat("dd-MM-yyyy").parse(lastSavedHWDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<HomeworkItem> homeworkItemList = null;
        if(StringUtils.isNumeric(subjectId)) {
            homeworkItemList = hwDAO.getHomeworkItemsBySubject(date, new Long(groupId), new Long(subjectId));
        }
        else {
            homeworkItemList = hwDAO.getHomeworkItems(date, new Long(groupId));
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

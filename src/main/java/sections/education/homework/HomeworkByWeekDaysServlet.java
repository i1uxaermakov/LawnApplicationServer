package sections.education.homework;

import org.apache.commons.io.IOUtils;
import utils.HibernateUtil;
import security.entities.User;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HomeworkByWeekDaysServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        HomeworkItemDAO hwDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);

        User user = (User) req.getSession().getAttribute("User");
        Long groupId = user.getGroupId();

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date todayWithZeroTime = new Date((formatter.parse(formatter.format(new Date(System.currentTimeMillis())))).getTime());
            if(user.getPrivileges().contains("teacher")) {
                homeworkItemList = hwDAO.getHomeworkItemsForHomeworkPageForTeacher(todayWithZeroTime, user.getUserId());
                req.setAttribute("for", "teacher");
            }
            else {
                homeworkItemList = hwDAO.getHomeworkItemsForHomeworkPageForStudent(todayWithZeroTime, groupId);
                req.setAttribute("for", "student");
            }
            req.setAttribute("homeworkItemList", homeworkItemList);
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        hibSession.close();

        String firstDayInYearDate = readFileContents("firstDayInYear.txt");
        req.setAttribute("firstDayInYear", firstDayInYearDate);


        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkPageVisualizer.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkVisualizer.jsp").include(req,resp);
        }
    }

    private String readFileContents(String path) throws IOException {
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

//    домашка может быть
//      для ученика
//          по предмету
//          вся домашка
//
//      для учителя
//          вся домашка
//          по предмету
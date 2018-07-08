package sections.education.homework;

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

public class HomeworkServletByWeekDays extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        HomeworkItemDAO hwDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);

        User user = (User) req.getAttribute("User");
        Long groupId = user.getGroupId();

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date todayWithZeroTime = (Date) formatter.parse(formatter.format(new Date(System.currentTimeMillis())));
            homeworkItemList = hwDAO.getHomeworkItems(todayWithZeroTime, groupId);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hibSession.close();


        req.setAttribute("homeworkItemList", homeworkItemList);
        if(user.getPrivileges().contains("teacher")) {
            req.setAttribute("for", "teacher");
        }
        else {
            req.setAttribute("for", "student");
        }

        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkPageVisualizer.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkVisualizer.jsp").include(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


//    домашка может быть
//      для ученика
//          по предмету
//          вся домашка
//
//      для учителя
//          вся домашка
//          по предмету
}

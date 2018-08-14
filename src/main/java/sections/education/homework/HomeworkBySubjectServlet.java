package sections.education.homework;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeworkBySubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        HomeworkItemDAO hwDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);

        String subjectId = req.getParameter("subjectId");
        if(subjectId == null || !StringUtils.isNumeric(subjectId)) {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy, hh:ss");
        String purpose = req.getParameter("purpose");
        if("add_down".equals(purpose)) {
            String dateString = req.getParameter("date");
            Date dateToCheck = new Date(System.currentTimeMillis());
            if(dateString != null) {
                try {
                    dateToCheck.setTime(simpleDateFormat.parse(dateString).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            homeworkItemList = hwDAO.getHomeworkItemsBySubject(new java.sql.Date(dateToCheck.getTime()), new Long(subjectId), purpose);
        }
        else if("add_up".equals(purpose)) {
            String dateString = req.getParameter("date");
            if(dateString == null) {
                resp.setStatus(400);
                hibSession.close();
                return;
            }

            try {
                homeworkItemList = hwDAO.getHomeworkItemsBySubject(new java.sql.Date(simpleDateFormat.parse(dateString).getTime()), new Long(subjectId), purpose);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        Collections.sort(homeworkItemList);
        Collections.reverse(homeworkItemList);
        req.getRequestDispatcher("/WEB-INF/JSP/edu/HomeworkItemsVisualizer.jsp").include(req, resp);
    }
}
/*
   js собирает айди предмета(онклик скрипт) и из аттрибутов айди предмета и по тоггл дата вытягивает первый чайлд и из него последний дз

   каждый раз когда обновляет расписание, нужно добавлять дата тоггл каждого предмета

   запросы приходят
        с компа и с сотки одинаково
            на предмет
                есть даты последнего загруженного дз - отдаю дз > присланной даты
                    purpose=add_up
                нет даты - отдаю дз < нынешней даты
                    purpose=add_down
                есть даты давно загруженной даты - отдаю дз < даты
                    purpose=add_down

*/

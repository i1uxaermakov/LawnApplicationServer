package sections.education.homework;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class HomeworkBySubjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        HomeworkItemDAO hwDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);

        String subjectId = req.getParameter("sid");

        if(Objects.isNull(subjectId)|| !(StringUtils.isNumeric(subjectId))) {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        String purpose = req.getParameter("purpose");
        req.setAttribute("addButton",true);
        if("add_up".equals(purpose)) {
            String dateString = req.getParameter("date");
            Timestamp dateToCheck = new Timestamp(System.currentTimeMillis());
            String purposeSuffix = "_to_empty";
            if(Objects.nonNull(dateString) && StringUtils.isNumeric(dateString)) {
                    dateToCheck = new Timestamp(new Long(dateString));
                    purposeSuffix = "_to_smth";
                    req.setAttribute("addButton",false);
            }
            homeworkItemList = hwDAO.getHomeworkItemsBySubjectAddUp(dateToCheck, new Long(subjectId), purpose+purposeSuffix);
        }
        else if("add_down".equals(purpose)) {
            String dateString = req.getParameter("date");
            if(dateString == null) {
                resp.setStatus(400);
                hibSession.close();
                return;
            }
            Timestamp dateToCheck = new Timestamp(new Long(dateString));
            homeworkItemList = hwDAO.getHomeworkItemsBySubjectAddDown(dateToCheck, new Long(subjectId));
        }
        else {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        req.setAttribute("homeworkItemList", homeworkItemList);
        req.getRequestDispatcher("/WEB-INF/JSP/edu/homework/HomeworkItemsVisualizerInSchedule.jsp").include(req, resp);
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
                нет даты - отдаю дз < нынешней даты, ограничение 10
                    purpose=add_up
                есть даты давно загруженной даты - отдаю дз < даты ограничение 10
                    purpose=add_down

*/

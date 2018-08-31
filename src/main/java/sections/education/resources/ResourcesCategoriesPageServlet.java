package sections.education.resources;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.SubjectCategoryDAO;
import sections.education.entities.SubjectResourceCategory;
import security.entities.User;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@MultipartConfig
public class ResourcesCategoriesPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        User user = (User) req.getSession().getAttribute("User");

        String lvl = req.getParameter("lvl");
        Long level;
        if(Objects.isNull(lvl) || !StringUtils.isNumeric(lvl)) {
            level = user.getLevel();
        }
        else {
            level = new Long(lvl);
        }

        List<SubjectResourceCategory> categoryList = new ArrayList<>(0);
        String lastSavedDate = req.getParameter("date");
        if(Objects.isNull(lastSavedDate) || !StringUtils.isNumeric(lastSavedDate)) {
            categoryList = SubjectCategoryDAO.getSubjectCategoriesByLevel(level);
        }
        else {
            categoryList = SubjectCategoryDAO.getSubjectCategoriesByLevelAndDate(level, new Date(new Long(lastSavedDate)));
        }

        hibSession.close();
        Collections.sort(categoryList);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("lvl", level);

        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/ResourcesCategoriesPageVisualizer.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/ResourcesCategoriesVisualizer.jsp").include(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

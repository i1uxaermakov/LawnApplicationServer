package sections.education.resources;

import org.hibernate.Session;
import sections.education.DAO.SubjectCategoryDAO;
import sections.education.entities.SubjectResourceCategory;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ResourcesPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();

        List<SubjectResourceCategory> categoryList =  SubjectCategoryDAO.getAllCategories();
        Collections.sort(categoryList);
        req.setAttribute("categoryList", categoryList);

//        todo visualization


        hibSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

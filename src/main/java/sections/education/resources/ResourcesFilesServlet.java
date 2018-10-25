package sections.education.resources;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.ResourceItemDAO;
import sections.education.entities.ResourceItem;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class    ResourcesFilesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();

        String categoryId = req.getParameter("cid");
        if(Objects.isNull(categoryId) || !StringUtils.isNumeric(categoryId)) {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        List<ResourceItem> resourceItemList = new ArrayList<>(0);
        ResourceItemDAO resourceItemDAO = new ResourceItemDAO();
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
            resourceItemList = resourceItemDAO.getResourceItemsByCategoryAddUp(dateToCheck, new Long(categoryId), purpose+purposeSuffix);
        }
        else if("add_down".equals(purpose)) {
            String dateString = req.getParameter("date");
            if(dateString == null) {
                resp.setStatus(400);
                hibSession.close();
                return;
            }
            Timestamp dateToCheck = new Timestamp(new Long(dateString));
            resourceItemList = resourceItemDAO.getResourceItemsByCategoryAddDown(dateToCheck, new Long(categoryId));
        }
        else {
            resp.setStatus(400);
            hibSession.close();
            return;
        }
        hibSession.close();

        req.setAttribute("resourceItemList", resourceItemList);
        req.getRequestDispatcher("/WEB-INF/JSP/edu/resources/ResourcesFilesVisualizer.jsp").include(req, resp);
    }
}

package sections.education.resources;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import sections.education.DAO.SubjectCategoryDAO;
import sections.education.entities.ResourceItem;
import sections.education.entities.SubjectResourceCategory;
import account.entities.User;
import sections.education.homework.AddPhotosToHWServlet;
import utils.HibernateUtil;
import utils.files.File;
import utils.files.FileUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
*   Maximum of request size is 250 Megabytes
*   Maximum of file size is 200 Megabytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*1024*200, maxRequestSize=1024*1024*250)
public class AddResourceItemServlet extends HttpServlet {
    //context init parameter
    private static String pathToFiles;
    //servlet init parameter
    private static String pathSuffixForResourceFiles;
    //class logger
    private static final Logger logger = LogManager.getLogger(AddResourceItemServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        pathToFiles = getServletContext().getInitParameter("pathToFiles");
        pathSuffixForResourceFiles = getInitParameter("pathSuffixForResourceFiles");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        List<SubjectResourceCategory> list = (new SubjectCategoryDAO()).getAllSubjectCategories();
        hibSession.close();

        List<SubjectResourceCategory> listForFirstLevel = new ArrayList<>(0),
                listForSecondLevel = new ArrayList<>(0),
                listForThirdLevel = new ArrayList<>(0);
        for(SubjectResourceCategory category: list) {
            if(category.getCourse()==1) {
                listForFirstLevel.add(category);
            }
            else if(category.getCourse()==2) {
                listForSecondLevel.add(category);
            }
            else {
                listForThirdLevel.add(category);
            }
        }

        req.setAttribute("listForFirstLevel",listForFirstLevel);
        req.setAttribute("listForSecondLevel",listForSecondLevel);
        req.setAttribute("listForThirdLevel",listForThirdLevel);

        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/resources/AddResourceItemPageJSP.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/resources/AddResourceItemOptionsJSP.jsp").include(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");

        String categoryId = req.getParameter("catid");
        if(Objects.isNull(categoryId) || !StringUtils.isNumeric(categoryId)) {
            resp.setStatus(400);
            return;
        }

        Part part = req.getPart("file");
        (new java.io.File(pathToFiles + java.io.File.separator + pathSuffixForResourceFiles)).mkdirs();
        File file = FileUtilities.processReceivedFileAndGetFileEntity(part, pathToFiles, pathSuffixForResourceFiles, user);
        if(file==null) {
            resp.setStatus(400);
            return;
        }

        ResourceItem resourceItem = new ResourceItem();
        resourceItem.setAddedBy(user.getFullName());
        resourceItem.setFile(file);
        resourceItem.setSubjectResourceCategoryId(new Long(categoryId));
        resourceItem.setPublishDate(file.getPublishDate());

        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        SubjectCategoryDAO subjectCategoryDAO = new SubjectCategoryDAO();
        SubjectResourceCategory category = subjectCategoryDAO.getCategoryByID(new Long(categoryId));

        if(Objects.isNull(category)) {
            resp.setStatus(400);
            hibSession.close();
            return;
        }
        else {
            category.getResourceItems().add(resourceItem);
            subjectCategoryDAO.updateSubjectResourceCategory(category);
            logger.info("User(userID="+user.getUserId()+") added ResourceItem(id="+
                    resourceItem.getResourceItemId()+") to SubjectCategory(categoryID="+categoryId+").");
        }

        hibSession.close();
    }
}

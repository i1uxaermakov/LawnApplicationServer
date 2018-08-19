package sections.education.homework;

import utils.images.Photo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import security.entities.User;
import utils.HibernateUtil;
import utils.images.ImageUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@MultipartConfig
public class AddPhotosToHWServlet extends HttpServlet {
    //context init parameter
    private static String pathToPhotos;
    //servlet init parameter
    private static String pathSuffixForHWphotos;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        User user = (User) req.getSession().getAttribute("User");
        String hwIDs = req.getParameter("hw_id");
        String[] ids = hwIDs.split(";");

        Long[] idsLong = new Long[ids.length];
        for(int i=0; i<ids.length; i++) {
            ids[i] = ids[i].trim();
            if(StringUtils.isNumeric(ids[i])) {
                idsLong[i] = new Long(ids[i]);
            }
            else {
                resp.setStatus(400);
                return;
            }
        }

        HomeworkItemDAO homeworkItemDAO = new HomeworkItemDAO();
        List<HomeworkItem> homeworkItemList = homeworkItemDAO.getHomeworkItemsForAddingFilesOrPhotos(idsLong);

        if(homeworkItemList.size()!=ids.length) {
            resp.setStatus(400);
            return;
        }

        Part part = req.getPart("file");
        (new File(pathToPhotos + File.separator + pathSuffixForHWphotos)).mkdirs();
        Photo photo = ImageUtilities.processReceivedImageAndGetPhotoEntity(part, pathToPhotos, pathSuffixForHWphotos, user);

        hibSession.beginTransaction();
        for(HomeworkItem homeworkItem: homeworkItemList) {
            if(user.getUserId().equals(homeworkItem.getAddedById())) {
                Set<Photo> set= homeworkItem.getPhotos();
                set.add(photo);
                homeworkItem.setPhotos(set);
                hibSession.update(homeworkItem);
            }
            else {
                hibSession.getTransaction().rollback();
                hibSession.close();
                resp.setStatus(400);
                return;
            }
        }
        hibSession.getTransaction().commit();
        hibSession.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToPhotos = getServletContext().getInitParameter("pathToPhotos");
        pathSuffixForHWphotos = getInitParameter("pathSuffixForHWphotos");
    }
}
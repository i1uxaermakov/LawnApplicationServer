package sections.education.homework;

import model.entities.Photo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.education.DAO.HomeworkItemDAO;
import sections.education.entities.HomeworkItem;
import sections.feed.posts.entities.AttachedAlbum;
import security.entities.User;
import utils.HibernateUtil;
import utils.images.ImageUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@MultipartConfig
public class AddPhotosToHWServlet extends HttpServlet {
    private static String pathToHWphotos;

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
        List<HomeworkItem> homeworkItemList = homeworkItemDAO.getHomeworkItemsForAddingFiles(idsLong);

        if(homeworkItemList.size()!=ids.length) {
            resp.setStatus(400);
            return;
        }

        Part part = req.getPart("image");
        Photo photo = ImageUtilities.processReceivedImageAndGetPhotoEntity(part, pathToHWphotos, user);

        hibSession.beginTransaction();
        for(HomeworkItem homeworkItem: homeworkItemList) {
            if(user.getUserId().equals(homeworkItem.getAddedById())) {
                AttachedAlbum album = homeworkItem.getHwAlbum();
                Set<Photo> set= album.getAlbumPhotos();
                set.add(photo);
                album.setAlbumPhotos(set);
                homeworkItem.setHwAlbum(album);
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
        pathToHWphotos = getInitParameter("pathToHWphotos");
    }
}

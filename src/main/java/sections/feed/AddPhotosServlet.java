package sections.feed;

import utils.images.Photo;
import org.hibernate.Session;
import security.entities.User;
import utils.HibernateUtil;
import utils.images.ImageUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
public class AddPhotosServlet extends HttpServlet {
    private String pathToImageFolder;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        User user = (User) req.getSession().getAttribute("User");
        try {
            Part part = req.getPart("image");

            Photo photo = ImageUtilities.processReceivedImageAndGetPhotoEntity(part, pathToImageFolder, "hello", user);
            if(photo == null) {
                resp.setStatus(400);
                return;
            }

            Session hibSession = HibernateUtil.getSessionFactory().openSession();
            hibSession.beginTransaction();
            hibSession.persist(photo);
            hibSession.getTransaction().commit();
            hibSession.close();
        }
        catch (IOException e) {
            resp.setStatus(400);
            e.printStackTrace();
        }


    }

    @Override
    public void init() throws ServletException {
        super.init();
        pathToImageFolder = getInitParameter("pathToImageFolder");
    }
}
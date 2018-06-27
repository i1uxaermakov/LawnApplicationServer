package sections.mediaarchive;

import model.DAO.HibernateUtil;
import model.entities.Album;
import model.entities.wrappers.BriefAlbum;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.mediaarchive.DAO.AlbumDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AlbumsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        Session session = HibernateUtil.getSessionFactory().openSession();

        String pathInfo = req.getPathInfo();
        if("".equals(pathInfo) || "/".equals(pathInfo)) {
            showAlbums();
        }
        else {
            pathInfo = pathInfo.substring(1);
            if(!(StringUtils.isNumeric(pathInfo))) {
                resp.setStatus(404);
                return;
            }
            showAlbumById(pathInfo);
        }

        session.close();
    }

    public void showAlbums() {
        AlbumDAO albumDAO = new AlbumDAO();
        Date date = new Date(System.currentTimeMillis());
        try {
            List<BriefAlbum> briefAlbums = (List<BriefAlbum>) albumDAO.getBriefAlbums(date, 15);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        if() {
//            //AJAX
//        }
//        else {
////          not ajax
//        }
    }


    public void showAlbumById(String pathInfo) {
        AlbumDAO albumDAO = new AlbumDAO();
        Album album = null;
        try {
            album = albumDAO.getAlbumById(new Long(pathInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

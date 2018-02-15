package controller;

import model.DAO.AlbumDAO;
import model.DAO.DAOImpl.AlbumDAOImpl;
import model.DAO.HibernateUtil;
import model.entities.Album;
import model.entities.wrappers.BriefAlbum;
import org.hibernate.Session;

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


        AlbumDAO albumDAO = new AlbumDAOImpl();
        Album album = null;
        try {
            album = albumDAO.getAlbumById(new Long(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.getWriter().println(album.toString());
        session.close();
    }
}

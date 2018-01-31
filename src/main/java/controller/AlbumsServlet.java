package controller;

import model.DAO.AlbumDAO;
import model.DAO.DAOImpl.AlbumDAOImpl;
import model.DAO.HibernateUtil;
import model.entities.wrappers.BriefAlbum;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AlbumsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        AlbumDAO albumDAO = new AlbumDAOImpl();
        List<BriefAlbum> briefAlbumList = (List<BriefAlbum>) albumDAO.getBriefAlbums(session, 9);

        for(BriefAlbum briefAlbum: briefAlbumList) {

        }

        session.close();
    }
}

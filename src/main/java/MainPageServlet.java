import sections.mediaarchive.AlbumDAOImpl;
import sections.feed.events.EventDAO;
import sections.feed.posts.model.DAO.DAOImpl.PostDAOImpl;
import model.DAO.HibernateUtil;
import sections.feed.posts.model.DAO.PostDAO;
import sections.feed.posts.model.entities.Post;
import model.entities.wrappers.BriefAlbum;
import model.entities.wrappers.BriefEvent;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MainPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        List<BriefAlbum> briefAlbumList = null;
        List<Post> postList = null;
        List<BriefEvent> briefEventList = null;

        AlbumDAO albumDAO = (AlbumDAO) new AlbumDAOImpl();
        PostDAO postDAO = new PostDAOImpl();
        model.DAO.EventDAO eventDAO = new EventDAO();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            briefAlbumList = (List<BriefAlbum>) albumDAO.getBriefAlbums(new Date(), 4);
            postList = (List<Post>) postDAO.getPosts(new Date(), 15, "approved  ");
            briefEventList = (List<BriefEvent>) eventDAO.getBriefEvents(new Date(), 4);
        } catch (SQLException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        finally {
            session.close();
        }

        req.setAttribute("briefAlbumList", briefAlbumList);
        req.setAttribute("postList", postList);
        req.setAttribute("briefEventList", briefEventList);

        req.getRequestDispatcher("MainPageSliderVisualizer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

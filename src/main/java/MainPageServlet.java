import sections.mediaarchive.DAO.AlbumDAO;
import sections.feed.events.EventDAO;
import sections.feed.posts.DAO.PostDAO;
import model.DAO.HibernateUtil;
import sections.feed.posts.entities.Post;
import sections.mediaarchive.entities.BriefAlbum;
import sections.feed.events.entities.BriefEvent;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Deprecated
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

        AlbumDAO albumDAO = (AlbumDAO) new AlbumDAO();
        PostDAO postDAO = new PostDAO();
        EventDAO eventDAO = new EventDAO();

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

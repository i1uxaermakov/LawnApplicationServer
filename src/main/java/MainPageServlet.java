import sections.mediaarchive.DAO.AlbumDAO;
import sections.feed.events.EventDAO;
import sections.feed.posts.DAO.PostDAO;
import utils.HibernateUtil;
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

public class MainPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/edu/sc");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

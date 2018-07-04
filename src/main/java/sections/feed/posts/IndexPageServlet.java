package sections.feed.posts;

import model.DAO.HibernateUtil;
import org.hibernate.Session;
import sections.feed.events.EventDAO;
import sections.feed.events.entities.Event;
import sections.feed.posts.DAO.PostDAO;
import sections.feed.posts.entities.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class IndexPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        PostDAO postDAO = new PostDAO();
        EventDAO eventDAO = new EventDAO();
        List<Post> postList = new ArrayList<>(0);
        List<Event> eventList = new ArrayList<>(0);

        try {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            postList = (List<Post>) postDAO.getPosts(date, 10, "approved");
            eventList = (List<Event>) eventDAO.getBriefEvents(date, 10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hibSession.close();

        req.setAttribute("postList", postList);
        req.setAttribute("eventList", eventList);
        req.getRequestDispatcher("IndexPageVisualizer.jsp").include(req,resp);
    }

}

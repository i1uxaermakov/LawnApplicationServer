package sections.feed.posts;

import model.DAO.HibernateUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        System.out.println(path);
        path = path.replace("/posts","");

        Session session = HibernateUtil.getSessionFactory().openSession();
//        NewsDAOImpl newsDAO = new NewsDAOImpl();

        if(path.equals("")) {
//            List<BriefNewsItem> briefNewsItemList = null;
//            try {
//                briefNewsItemList = (List<BriefNewsItem>) newsDAO.
//                        getBriefNewsItems(session, 20);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            PrintWriter printWriter = resp.getWriter();
//            for(BriefNewsItem briefNewsItem: briefNewsItemList) {
//                printWriter.println(briefNewsItem.toString());
//            }
        }
        else {
            path = path.replace("/","");
            if(StringUtils.isNumeric(path)) {
//                Long news_id = new Long(path);
//                NewsItem newsItem = null;
//                try {
//                    newsItem = newsDAO.getNewsItemById(session, news_id);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//                if(!(newsItem == null)) {
//                    resp.getWriter().println(newsItem.toString());
//                }
//                else {
//                    resp.getWriter().println("404 NOT FOUND");
//                    //TODO 404
//                }
            }
            else {
                //TODO 404
                //resp.getWriter().println("404 NOT FOUND");
                resp.setStatus(404);
            }

        }

        session.close();
    }
}

package controller;

import model.DAO.DAOImpl.NewsDAOImpl;
import model.DAO.HibernateUtil;
import model.entities.NewsItem;
import model.entities.wrappers.BriefNewsItem;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class NewsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        path = path.replace("news","");

        Session session = HibernateUtil.getSessionFactory().openSession();
        NewsDAOImpl newsDAO = new NewsDAOImpl();
        String purpose = req.getParameter("news_sphere");
        if(purpose == null) {
            purpose = "all";
        }

        if(path.equals("") || path.equals("/")) {
            List<BriefNewsItem> briefNewsItemList = null;
            try {
                briefNewsItemList = (List<BriefNewsItem>) newsDAO.
                        getBriefNewsItems(session, 20);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PrintWriter printWriter = resp.getWriter();
            for(BriefNewsItem briefNewsItem: briefNewsItemList) {
                printWriter.println(briefNewsItem.toString());
            }
        }
        else {
            path = path.replace("/","");
            if(StringUtils.isNumeric(path)) {
                Long news_id = new Long(path);
                NewsItem newsItem = null;
                try {
                    newsItem = newsDAO.getNewsItemById(session, news_id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(!(newsItem == null)) {
                    resp.getWriter().println(newsItem.toString());
                }
                else {
                    resp.getWriter().println("404 NOT FOUND");
                    //TODO 404
                }
            }
            else {
                //TODO 404
                resp.getWriter().println("404 NOT FOUND");
            }

        }

        session.close();
    }
}

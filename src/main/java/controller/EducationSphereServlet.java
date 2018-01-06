package controller;

import model.DAO.DAOImpl.NewsDAOImpl;
import model.entities.NewsItem;
import model.entities.wrappers.BriefNewsItem;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class EducationSphereServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();//(String)req.getAttribute("requestedURI");
        resp.getWriter().println("education");
        System.out.println(path);
        path = path.replace("/education", "");


//        lawn.com/education/news/64376

        if(path.equals("/") || path.equals("")) {
            //TODO Education Main Page
        }
        else if(path.startsWith("/news")) {
            path = path.replace("/news", "");
            NewsDAOImpl newsDAO = new NewsDAOImpl();

            if(path.equals("") || path.equals("/") ) {
                List<BriefNewsItem> briefNewsItemList = null;
                try {
                    briefNewsItemList = (List<BriefNewsItem>) newsDAO.
                            getNewsItemsExtracts("education", 20);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PrintWriter printWriter = resp.getWriter();
                for(BriefNewsItem briefNewsItem: briefNewsItemList) {
                    printWriter.println(briefNewsItem.toString());
                }

                if(req.getHeader("ExpectedType").equals("JSON")) {

                }
            }
            else {
                path = path.replace("/","");
                if(StringUtils.isNumeric(path)) {
                    Long news_id = new Long(path);
                    NewsItem newsItem = null;
                    try {
                        newsItem = newsDAO.getNewsItemById(news_id, "education");
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
        }
        else if(path.startsWith("/homework")) {
            //TODO handouts - homework
        }
        else if(path.startsWith("/timetable")) {
            //TODO timetable for PK and ordinary lessons
        }
        else if(path.startsWith("/library")) {
            //TODO library with books
        }
        else {
            //TODO NOT FOUND 404 viewer
            resp.getWriter().println("404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
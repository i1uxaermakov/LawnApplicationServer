package controller;

import model.DAO.DAOImpl.NewsDAOImpl;
import model.entities.NewsItem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/NewsServlet/*, /NewsServlet"},
//        initParams = {@WebInitParam(name="file-upload",value="/Users/ilya_ermakov/Additional/")})
public class NewsServlet extends HttpServlet {

    //private NewsDAOImpl articleDAO;
    //TODO парсер в JSON

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");//application/json
        java.io.PrintWriter out = response.getWriter();
        out.println("hi! go on! artiles servlet");

        NewsDAOImpl NewsDAO = new NewsDAOImpl();

        try {
            List<NewsItem> articles = (List) NewsDAO.getNewsItemsExtracts();
            for(NewsItem article: articles) {
                out.println(article.toString());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

//        Expression
//        request.getRequestDispatcher("WEB-INF/another-hello.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

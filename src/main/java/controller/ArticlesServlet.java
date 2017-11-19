package controller;

import model.DAO.DAOImpl.ArticleDAOImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/ArticlesServlet/*, /ArticlesServlet"},
//        initParams = {@WebInitParam(name="file-upload",value="/Users/ilya_ermakov/Additional/")})
public class ArticlesServlet extends HttpServlet {

    //private ArticleDAOImpl articleDAO;
    //TODO парсер в JSON

    @Override
    public void init() throws ServletException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");//application/json
        java.io.PrintWriter out = response.getWriter();
        out.println("hi! go on! artiles servlet");

        ArticleDAOImpl articleDAO = new ArticleDAOImpl();


//        try {
//            List<Article> articles = (List) articleDAO.getArticlesExtracts();
//
//            for(Article article: articles) {
//                out.println(article.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        request.getRequestDispatcher("WEB-INF/another-hello.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

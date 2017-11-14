package controller;

import model.DAO.DAOImpl.ArticleDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/ArticlesServlet/*, /ArticlesServlet"},
//        initParams = {@WebInitParam(name="file-upload",value="/Users/ilya_ermakov/Additional/")})
public class ArticlesServlet extends HttpServlet {

    private ArticleDAOImpl articleDAO;
    //TODO парсер в JSON

    @Override
    public void init() throws ServletException {
        articleDAO = ArticleDAOImpl.getArticleDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("hi! go on! artiles servlet");

//        if (request.getHeader("Purpose") == "extracts") {
//            try {
//                Set extracts = (Set) articleDAO.getArticlesExtracts();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//        request.getRequestDispatcher("WEB-INF/another-hello.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

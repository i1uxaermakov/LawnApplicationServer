package controller;

import model.DAO.ArticleDAO;
import model.DAO.DAOImpl.ArticleDAOImpl;
import model.entities.Article;
import model.security.Validator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/ArticlesServlet/*, /ArticlesServlet"},
//        initParams = {@WebInitParam(name="file-upload",value="/Users/ilya_ermakov/Additional/")})
public class ArticlesServlet extends HttpServlet {

    private ArticleDAOImpl articleDAO;

    @Override
    public void init() throws ServletException {
        articleDAO = ArticleDAOImpl.getArticleDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("hi! go on! artiles servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

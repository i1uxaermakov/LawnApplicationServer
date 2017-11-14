package model.DAO.DAOImpl;

import model.DAO.ArticleDAO;
import model.entities.Article;
import model.entities.Author;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;

public class ArticleDAOImpl implements ArticleDAO {

//    DataSource

    private static ArticleDAOImpl articleDAO = null;

    public static ArticleDAOImpl getArticleDAO() {
        if (articleDAO == null) {
            articleDAO = new ArticleDAOImpl();
        }
        return articleDAO;
    }

    public void addArticle(Article article) throws SQLException {

    }

    public void updateArticle(Long article_id, Article article) throws SQLException {

    }

//    System

    public Article getArticleById(Long article_id) throws SQLException {
        return null;
        //TODO сделать получение новостей по айди
    }

    public Collection getAllArticles() throws SQLException {
        return null;
    }

    public void deleteArticle(Article article) throws SQLException {

    }

    public Collection getArticlesByAuthor(Author author) throws SQLException {
        return null;
    }

    public Collection getArticlesExtracts() throws SQLException {
        return null;
        //TODO сделать получение новостей на главную страницу

    }
}

package model.DAO.DAOImpl;

import model.DAO.ArticleDAO;
import model.DAO.HibernateUtil;
import model.entities.Article;
import model.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;

public class ArticleDAOImpl implements ArticleDAO {

    private static ArticleDAOImpl articleDAO;
    private static SessionFactory sessionFactory;

    static {
        articleDAO = new ArticleDAOImpl();
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static ArticleDAOImpl getArticleDAO() {
        return articleDAO;
    }

    public void addArticle(Article article) throws SQLException {

    }

    public void updateArticle(Long article_id, Article article) throws SQLException {

    }

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
        //Session session = null;
//        try(Session session = sessionFactory.openSession()) {
//
//
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }


        //TODO сделать получение новостей на главную страницу

    }
}

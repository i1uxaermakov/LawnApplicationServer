package model.DAO.DAOImpl;

import model.DAO.ArticleDAO;
import model.DAO.HibernateUtil;
import model.entities.Article;
import model.entities.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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
//        List<Article> result = null;
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
//        criteriaQuery.from(Article.class);
//        result = session.createQuery(criteriaQuery).getResultList();
//        session.close();
//        return result;
//        //TODO сделать получение новостей на главную страницу

        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        }
        catch (Exception e) {

        }
        return null;
    }
}

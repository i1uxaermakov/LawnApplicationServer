package model.DAO;

import model.entities.Article;
import model.entities.Author;

import java.sql.SQLException;
import java.util.Collection;

public interface ArticleDAO {
    void addArticle(Article article) throws SQLException;
    void updateArticle(Long article_id, Article article) throws SQLException;
    Article getArticleById(Long article_id) throws SQLException;
    Collection getAllArticles() throws SQLException;
    void deleteArticle(Article article) throws SQLException;
    Collection getArticlesByAuthor(Author author) throws SQLException;
    Collection getArticlesExtracts() throws SQLException;
//    public Collection getBussesByRoute(Route route) throws SQLException;
}

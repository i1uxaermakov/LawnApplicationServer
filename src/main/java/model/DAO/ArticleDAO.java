package model.DAO;

import model.entities.Article;
import model.entities.Author;

import java.sql.SQLException;
import java.util.Collection;

public interface ArticleDAO {
    public void addArticle(Article article) throws SQLException;
    public void updateArticle(Long article_id, Article article) throws SQLException;
    public Article getArticleById(Long article_id) throws SQLException;
    public Collection getAllArticles() throws SQLException;
    public void deleteArticle(Article article) throws SQLException;
    public Collection getArticlesByAuthor(Author author) throws SQLException;
//    public Collection getBussesByRoute(Route route) throws SQLException;
}

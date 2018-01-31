package model.DAO;

import model.entities.NewsItem;
import model.entities.Author;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

public interface NewsDAO {
    void addNewsItem(Session session, NewsItem newsItem) throws SQLException;
    void updateNewsItem(Session session, Long newsItem_id, NewsItem newsItem) throws SQLException;
    NewsItem getNewsItemById(Session session, Long news_id) throws SQLException;
    void deleteNewsItem(Session session, NewsItem newsItem) throws SQLException;
    Collection getNewsItemsByAuthor(Session session, Author author) throws SQLException;
//    Collection getNewsItemsExtractsForMainPage() throws SQLException;

    Collection getBriefNewsItems(Session session, int maxResults) throws SQLException;

//    Collection getNewsItemsExtractsForSphere(String sphere) throws SQLException;

    Integer getTotalQuantityOfNewsItems(Session session) throws SQLException;
}

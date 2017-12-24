package model.DAO;

import model.entities.NewsItem;
import model.entities.Author;

import java.sql.SQLException;
import java.util.Collection;

public interface NewsDAO {
    void addNewsItem(NewsItem newsItem) throws SQLException;
    void updateNewsItem(Long newsItem_id, NewsItem newsItem) throws SQLException;
    NewsItem getNewsItemById(Long newsItem_id, String sphere) throws SQLException;
    Collection getAllNewsItems() throws SQLException;
    void deleteNewsItem(NewsItem newsItem) throws SQLException;
    Collection getNewsItemsByAuthor(Author author) throws SQLException;
//    Collection getNewsItemsExtractsForMainPage() throws SQLException;

    Collection getNewsItemsExtracts(String purpose, int maxResults) throws SQLException;

//    Collection getNewsItemsExtractsForSphere(String sphere) throws SQLException;

    Integer getTotalQuantityOfNewsItems() throws SQLException;
}

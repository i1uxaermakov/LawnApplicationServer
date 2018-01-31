package model.DAO.DAOImpl;

import model.DAO.NewsDAO;
import model.DAO.HibernateUtil;
import model.entities.Album_;
import model.entities.NewsItem;
import model.entities.Author;
import model.entities.NewsItem_;
import model.entities.wrappers.BriefNewsItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class NewsDAOImpl implements NewsDAO {

    @Override
    public NewsItem getNewsItemById(Session session, Long news_id) throws SQLException {
        Transaction transaction = session.beginTransaction();
        NewsItem newsItem = session.get(NewsItem.class,news_id);
        transaction.commit();
        return newsItem;
    }

    @Override
    public Collection getBriefNewsItems(Session session, int maxResults) throws SQLException {
        List<BriefNewsItem> briefNewsItemList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(BriefNewsItem.class);
        Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
        criteriaQuery.select(
                criteriaBuilder.construct(
                        BriefNewsItem.class,
                        newsItemRoot.get(NewsItem_.id),
                        newsItemRoot.get(NewsItem_.title),
                        newsItemRoot.get(NewsItem_.extract),
                        newsItemRoot.get(NewsItem_.publishDate),
                        newsItemRoot.get(NewsItem_.photoId),
                        newsItemRoot.get(NewsItem_.urgency)
                )
        );

        criteriaQuery.orderBy(criteriaBuilder.desc(newsItemRoot.get(NewsItem_.id)));
        criteriaQuery.where(criteriaBuilder.le(newsItemRoot.get(NewsItem_.id), getTotalQuantityOfNewsItems(session)));
        briefNewsItemList = session.createQuery(criteriaQuery).setMaxResults(maxResults).getResultList();

        transaction.commit();
        return briefNewsItemList;
    }

    @Override
    public Integer getTotalQuantityOfNewsItems(Session session) throws SQLException {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
        criteriaQuery.select(criteriaBuilder.count(newsItemRoot));
        Integer result = ((Long) session.createQuery(criteriaQuery).getSingleResult()).intValue();
        return result;
        //insert into news (title, extract, urgency, photoId, sphere) values('key problem', 'smth was discussed', 2, 12, 'education')
        //select count(news_.newsItem_id) from News news_;
    }

    @Override
    public void addNewsItem(Session session, NewsItem newsItem) throws SQLException {

    }

    @Override
    public void updateNewsItem(Session session, Long newsItem_id, NewsItem newsItem) throws SQLException {

    }

    @Override
    public void deleteNewsItem(Session session, NewsItem newsItem) throws SQLException {

    }

    @Override
    public Collection getNewsItemsByAuthor(Session session, Author author) throws SQLException {
        return null;
    }
}

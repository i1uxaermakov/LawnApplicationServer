package model.DAO.DAOImpl;

import model.DAO.NewsDAO;
import model.DAO.HibernateUtil;
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

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addNewsItem(NewsItem newsItem) throws SQLException {

    }

    @Override
    public void updateNewsItem(Long newsItem_id, NewsItem newsItem) throws SQLException {

    }

    @Override
    public NewsItem getNewsItemById(Long newsItem_id, String sphere) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
        criteriaQuery.select(newsItemRoot);
        criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(newsItemRoot.get(NewsItem_.id), newsItem_id)),
                criteriaBuilder.equal(newsItemRoot.get(NewsItem_.sphere),sphere)
        );

        List<NewsItem> newsItemList = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        session.close();
        if(newsItemList.isEmpty()) {
            return null;
        }
        else {
            return newsItemList.get(0);
        }
    }

    @Override
    public Collection getAllNewsItems() throws SQLException {
        return null;
    }

    @Override
    public void deleteNewsItem(NewsItem newsItem) throws SQLException {

    }

    @Override
    public Collection getNewsItemsByAuthor(Author author) throws SQLException {
        return null;
    }

//    public Collection getNewsItemsExtractsForMainPage() throws SQLException {
////        List<NewsItem> result = null;
////        Session session = sessionFactory.openSession();
////        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
////        CriteriaQuery<NewsItem> criteriaQuery = criteriaBuilder.createQuery(NewsItem.class);
////        criteriaQuery.from(NewsItem.class);
////        result = session.createQuery(criteriaQuery).getResultList();
////        session.close();
////        return result;
////        //TODO сделать получение новостей на главную страницу
//
//
////        List<NewsItem> newsItemList = null;
////        try(Session session = sessionFactory.openSession()) {
////            Transaction transaction = session.beginTransaction();
////
////            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
////            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
////            Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
////            criteriaQuery.select(newsItemRoot);
////
////            newsItemList = session.createQuery(criteriaQuery).getResultList();
////
////            transaction.commit();
////        }
////        catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return newsItemList;
//
//        List<BriefNewsItem> briefNewsItemList;
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(BriefNewsItem.class);
//        Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
//        criteriaQuery.select(
//                criteriaBuilder.construct(
//                        BriefNewsItem.class,
//                        newsItemRoot.get(NewsItem_.id),
//                        newsItemRoot.get(NewsItem_.title),
//                        newsItemRoot.get(NewsItem_.extract),
//                        newsItemRoot.get(NewsItem_.photoId),
//                        newsItemRoot.get(NewsItem_.sphere),
//                        newsItemRoot.get(NewsItem_.urgency)
//                )
//        );
//        criteriaQuery.where(criteriaBuilder.le(newsItemRoot.get(NewsItem_.id), getTotalQuantityOfNewsItems()));
//        criteriaQuery.orderBy(criteriaBuilder.desc(newsItemRoot.get("id")));
//        briefNewsItemList = session.createQuery(criteriaQuery).setMaxResults(10).getResultList();
//
//        transaction.commit();
//        session.close();
//        return briefNewsItemList;
//    }

    @Override
    public Collection getNewsItemsExtracts(String purpose, int maxResults) throws SQLException {
        List<BriefNewsItem> briefNewsItemList = null;
        Session session = sessionFactory.openSession();
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
                        newsItemRoot.get(NewsItem_.sphere),
                        newsItemRoot.get(NewsItem_.urgency)
                )
        );

        criteriaQuery.orderBy(criteriaBuilder.desc(newsItemRoot.get("id")));
        if(purpose.equals("mainpage")) {
            criteriaQuery.where(criteriaBuilder.le(newsItemRoot.get(NewsItem_.id), getTotalQuantityOfNewsItems()));
        }
        else {
            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.le(newsItemRoot.get(NewsItem_.id), getTotalQuantityOfNewsItems()),
                    criteriaBuilder.equal(newsItemRoot.get(NewsItem_.sphere), purpose)
            ));
        }
        briefNewsItemList = session.createQuery(criteriaQuery).setMaxResults(maxResults).getResultList();

        transaction.commit();
        session.close();
        return briefNewsItemList;
    }

    @Override
    public Integer getTotalQuantityOfNewsItems() throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<NewsItem> newsItemRoot = criteriaQuery.from(NewsItem.class);
        criteriaQuery.select(criteriaBuilder.count(newsItemRoot));
        Integer result = ((Long) session.createQuery(criteriaQuery).getSingleResult()).intValue();

        transaction.commit();
        session.close();
        return result;
        //insert into news (title, extract, urgency, photoId, sphere) values('key problem', 'smth was discussed', 2, 12, 'education')
        //select count(news_.newsItem_id) from News news_;
    }
}

package sections.feed.posts.model.DAO;

import model.DAO.HibernateUtil;
import sections.feed.posts.model.entities.Post;
import sections.feed.posts.model.entities.Post_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PostDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Post getPostById(Long post_id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, post_id);
        transaction.commit();
        return post;
    }

    public Collection getPosts(Date date, int maxResults, String status) throws SQLException {

        Session session = sessionFactory.getCurrentSession();
        List<Post> postList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);

        criteriaQuery.where(criteriaBuilder.lessThan(postRoot.get(Post_.publishDate), date));
        criteriaQuery.where(criteriaBuilder.equal(postRoot.get(Post_.status), status));
        criteriaQuery.orderBy(criteriaBuilder.desc(postRoot.get(Post_.publishDate)));
        postList = session.createQuery(criteriaQuery).setMaxResults(maxResults).getResultList();

        transaction.commit();

        return postList;
    }
}

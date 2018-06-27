package security.DAO;

import model.DAO.HibernateUtil;
import model.entities.RememberMeCookie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

public class RememberMeCookieDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Long getRememberMeCookieOwner(String cookieValue) throws SQLException{
        Session session = sessionFactory.getCurrentSession();
        List<RememberMeCookie> rememberMeCookieList;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(RememberMeCookie.class);
        Root<RememberMeCookie> rememberMeCookieRoot = criteriaQuery.from(RememberMeCookie.class);

        criteriaQuery.where(criteriaBuilder.equal(rememberMeCookieRoot.get("cookieValue"), cookieValue));

        rememberMeCookieList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();

        if (rememberMeCookieList == null || rememberMeCookieList.isEmpty()) {
            return null;
        } else {
            return rememberMeCookieList.get(0).getUserId();
        }
    }


    public RememberMeCookie getRememberMeCookieByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(RememberMeCookie.class);
        Root<RememberMeCookie> rememberMeCookieRoot = criteriaQuery.from(RememberMeCookie.class);

        criteriaQuery.where(criteriaBuilder.equal(rememberMeCookieRoot.get("userId"), userId));

        List<RememberMeCookie> rememberMeCookieList = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        if(!(rememberMeCookieList==null || rememberMeCookieList.isEmpty())) {
            return null;
        }
        else {
            return rememberMeCookieList.get(0);
        }
    }
}

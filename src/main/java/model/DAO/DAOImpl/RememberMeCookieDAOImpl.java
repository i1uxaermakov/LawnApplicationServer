package model.DAO.DAOImpl;

import com.sun.org.apache.regexp.internal.RE;
import model.DAO.HibernateUtil;
import model.DAO.RememberMeCookieDAO;
import model.entities.RememberMeCookie;
import model.entities.User;
import model.entities.User_;
import model.entities.wrappers.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RememberMeCookieDAOImpl implements RememberMeCookieDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public Long getRememberMeCookieOwner(String cookieValue) {
        Session session = sessionFactory.getCurrentSession();
        List<RememberMeCookie> rememberMeCookieList;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(RememberMeCookie.class);
        Root<RememberMeCookieDAO> rememberMeCookieDAORoot = criteriaQuery.from(RememberMeCookie.class);

        criteriaQuery.where(criteriaBuilder.equal(rememberMeCookieDAORoot.get("cookieValue"), cookieValue));

        rememberMeCookieList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();

        if (rememberMeCookieList == null || rememberMeCookieList.isEmpty()) {
            return null;
        } else {
            return rememberMeCookieList.get(0).getUserId();
        }
    }

    @Override
    public RememberMeCookie getRememberMeCookieByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(RememberMeCookie.class);
        Root<RememberMeCookieDAO> rememberMeCookieDAORoot = criteriaQuery.from(RememberMeCookie.class);

        criteriaQuery.where(criteriaBuilder.equal(rememberMeCookieDAORoot.get("userId"), userId));

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

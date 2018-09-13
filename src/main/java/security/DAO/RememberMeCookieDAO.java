package security.DAO;


import org.hibernate.HibernateException;
import security.entities.RememberMeCookie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import security.entities.RememberMeCookie_;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RememberMeCookieDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public RememberMeCookie getRememberMeCookieBySelector(String selector) {
        Session hibSession = null;
        Transaction transaction = null;
        List<RememberMeCookie> rememberMeCookieList = new ArrayList<>(0);

        try{
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(RememberMeCookie.class);
            Root<RememberMeCookie> rememberMeCookieRoot = criteriaQuery.from(RememberMeCookie.class);

            criteriaQuery.where(criteriaBuilder.equal(rememberMeCookieRoot.get(RememberMeCookie_.selector),selector));

            rememberMeCookieList = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }

        if(rememberMeCookieList.size()>0) {
            return rememberMeCookieList.get(0);
        }
        else {
            return null;
        }
    }


    public void persistRememberMeCookie(RememberMeCookie rememberMeCookie) {
        Session hibSession = null;
        Transaction transaction = null;

        try{
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            hibSession.persist(rememberMeCookie);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
    }


    public void deleteRememberMeCookie(RememberMeCookie rememberMeCookie) {
        Session hibSession = null;
        Transaction transaction = null;

        try{
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            hibSession.delete(rememberMeCookie);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
    }
}

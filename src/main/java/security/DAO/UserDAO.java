package security.DAO;


import org.hibernate.HibernateException;
import security.entities.User;
import security.entities.User_;
import security.entities.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) {
        Session session = null;
        List<UserLoginInfo> userLoginInfoList = new ArrayList<>(0);
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(UserLoginInfo.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery.select(
                    criteriaBuilder.construct(
                            UserLoginInfo.class,
                            userRoot.get(User_.userId),
                            userRoot.get(User_.lyceumId),
                            userRoot.get(User_.password)
                    )
            );
            criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.lyceumId), lyceumId));
            userLoginInfoList = session.createQuery(criteriaQuery).getResultList();

            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }

        if (Objects.isNull(userLoginInfoList) || userLoginInfoList.isEmpty()) {
            return null;
        } else {
            return userLoginInfoList.get(0);
        }
    }

    public static User getUserById(Long userId){
        User user = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, userId);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }

        return user;
    }

    public static void updateUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
    }
}
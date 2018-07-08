package security.DAO;


import security.entities.User;
import security.entities.User_;
import security.entities.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        List<UserLoginInfo> userLoginInfoList = null;
        Transaction transaction = session.beginTransaction();

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

        if (userLoginInfoList == null || userLoginInfoList.isEmpty()) {
            return null;
        } else {
            return userLoginInfoList.get(0);
        }
    }

    public User getUserById(Long userId) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        User user = session.get(User.class, userId);
        transaction.commit();
        return user;
    }
}
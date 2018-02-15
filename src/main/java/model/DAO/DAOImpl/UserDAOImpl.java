package model.DAO.DAOImpl;

import model.DAO.HibernateUtil;
import model.DAO.UserDAO;
import model.entities.User;
import model.entities.User_;
import model.entities.wrappers.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
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

    @Override
    public User getUserById(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        User user = session.get(User.class, userId);
        transaction.commit();
        return user;
    }
}
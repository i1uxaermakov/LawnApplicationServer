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

//    @Override
//    public UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) throws SQLException {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(UserLoginInfo.class);
//        Root<User> userRoot = criteriaQuery.from(User.class);
//        SetJoin<User, String> privilegeNode = criteriaQuery.from(User.class).join(User_.privileges);
//        criteriaQuery.select(
//                criteriaBuilder.construct(
//                        UserLoginInfo.class,
//                        privilegeNode.get(User_.userId),
//                        privilegeNode.get(User_.lyceumId),
//                        privilegeNode.get(User_.password),
//                        privilegeNode.get(User_.privileges)
//                )
//        );
//        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.lyceumId), lyceumId));
//
//        List<UserLoginInfo> userLoginInfoList = session.createQuery(criteriaQuery).getResultList();
//        transaction.commit();
//        session.close();
//        if (userLoginInfoList==null || userLoginInfoList.isEmpty()) {
//            System.out.println("nulldao");
//            return null;
//        }
//        else {
//            System.out.println("founddao");
//            return userLoginInfoList.get(0);
//        }
//    }


//    @Override
//    public User getUserByLyceumId(String lyceumId) throws SQLException {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
//
//        return null;
//    }

    @Override
    public UserLoginInfo getUserSignInfoByLyceumId(Session session, String lyceumId) throws SQLException {

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
        List<UserLoginInfo> userLoginInfoList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();

        if (userLoginInfoList == null || userLoginInfoList.isEmpty()) {
//            System.out.println("nulldao");
            return null;
        } else {
//            System.out.println("founddao");
            return userLoginInfoList.get(0);
        }
    }


}
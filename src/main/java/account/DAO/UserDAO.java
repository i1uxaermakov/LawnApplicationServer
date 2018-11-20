package account.DAO;


import account.authorization.SignOutServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import sections.education.schedule.TeacherInfo;
import account.entities.User;
import account.entities.User_;
import account.entities.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(UserDAO.class);

    public UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) {
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
            logger.error("Exception was thrown while getting User's SignIn Info by lyceumId. LyceumId="+lyceumId, e);
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

    public User getUserById(Long userId){
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
            logger.error("Exception was thrown while getting User by ID. UserID="+userId, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }

        return user;
    }

    public void updateUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while updating User. User="+user, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
    }

    public List<TeacherInfo> getAllTeachers() {
        Session hibSession = null;
        Transaction transaction = null;
        List<TeacherInfo> teacherInfoList = new ArrayList<>(0);

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(UserLoginInfo.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery.select(
                    criteriaBuilder.construct(
                            TeacherInfo.class,
                            userRoot.get(User_.userId),
                            userRoot.get(User_.firstName),
                            userRoot.get(User_.lastName),
                            userRoot.get(User_.fathersName)
                    )
            );

            criteriaQuery.where(criteriaBuilder.isMember("teacher", userRoot.get(User_.privileges)));
            criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get(User_.lastName)));
            teacherInfoList = hibSession.createQuery(criteriaQuery).getResultList();

            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting all Teachers for Adding Subjects.", e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }

        return teacherInfoList;
    }

    public void persistNewUser(User user) {
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            hibSession.save(user);
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while persisting a new User. User="+user, e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
    }
}
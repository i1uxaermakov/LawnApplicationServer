package sections.education.DAO;

import account.ChangePasswordServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.HomeworkItem;
import sections.education.entities.HomeworkItem_;
import utils.files.File;
import utils.images.Photo;

import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(HomeworkItemDAO.class);
    
    public List<HomeworkItem> getHomeworkItemsForHomeworkPageForStudent(Timestamp todayDate, Long groupId) throws SQLException {
        Session session = null;
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
            Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.greaterThanOrEqualTo(homeworkRoot.get(HomeworkItem_.deadlineDate), todayDate),
                    criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.groupId), groupId)));

            homeworkItemList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting HomeworkItems for student's HW Page! Timestamp="+
                    todayDate + "; groupID="+groupId,e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsForHomeworkPageForTeacher(Timestamp todayDate, Long userId) throws SQLException {
        Session session = null;
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
            Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.greaterThanOrEqualTo(homeworkRoot.get(HomeworkItem_.deadlineDate), todayDate),
                    criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.teacherId), userId)));

            homeworkItemList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting HomeworkItems for teacher's HW Page! Timestamp="+
                    todayDate + "; userID="+userId,e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsBySubjectAddUp(Timestamp lastSavedHWDate, Long subjectId, String purpose) {
//        purpose - add_up_to_empty
//        purpose - add_up_to_smth
        Session session = null;
        List<HomeworkItem> homeworkItemList = new ArrayList<>();
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
            Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

            if("add_up_to_empty".equals(purpose)) {
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId), subjectId),
                        criteriaBuilder.lessThan(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate)
                ));
                criteriaQuery.orderBy(criteriaBuilder.desc(homeworkRoot.get(HomeworkItem_.publishDate)));
                homeworkItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            }
            else if("add_up_to_smth".equals(purpose)){
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId), subjectId),
                        criteriaBuilder.greaterThan(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate)
                ));
                criteriaQuery.orderBy(criteriaBuilder.desc(homeworkRoot.get(HomeworkItem_.publishDate)));
                homeworkItemList = session.createQuery(criteriaQuery).getResultList();
            }
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting HomeworkItems by Subject(Add Up)! LastSavedDate="+
                    lastSavedHWDate + "; subjectID="+subjectId + "; purpose="+purpose,e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsBySubjectAddDown(Timestamp lastSavedHWDate, Long subjectId) {
        Session session = null;
        List<HomeworkItem> homeworkItemList = new ArrayList<>();
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
            Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId),subjectId),
                    criteriaBuilder.lessThan(homeworkRoot.get(HomeworkItem_.publishDate),lastSavedHWDate)
            ));
            criteriaQuery.orderBy(criteriaBuilder.desc(homeworkRoot.get(HomeworkItem_.publishDate)));

            homeworkItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting HomeworkItems by Subject(Add Down)! LastSavedDate="+
                    lastSavedHWDate + "; subjectID="+subjectId,e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemList;
    }

    public Long persistHomeworkItem(HomeworkItem homeworkItem) {
        Long homeworkItemId = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            homeworkItemId = (Long) session.save(homeworkItem);
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was throw while persisting HomeworkItem! HomeworkItem="+homeworkItem, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemId;
    }

    public List<HomeworkItem> getHomeworkItemsForAddingFilesOrPhotos(Long[] hwIDs) {
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
            Root<HomeworkItem> hwItemRoot = criteriaQuery.from(HomeworkItem.class);

            List<Predicate> predicates = new ArrayList<>(0);
            for(int i=0; i<hwIDs.length; i++) {
                predicates.add(criteriaBuilder.equal(hwItemRoot.get(HomeworkItem_.hw_id), hwIDs[i]));
            }

            criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])));
            homeworkItemList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting HomeworkItems for adding files and photos! hwIDs="+hwIDs, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return homeworkItemList;
    }

    public boolean addFileToHomeworkItemsAndUpdate(List<HomeworkItem> homeworkItems, File file, Long userID) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            for(HomeworkItem homeworkItem: homeworkItems) {
                if (userID.equals(homeworkItem.getAddedById())) {
                    homeworkItem.getFiles().add(file);
                    session.update(homeworkItem);
                } else {
                    transaction.rollback();
                    return false;
                }
            }

            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while adding File to HomeworkItems! " +
                    "HomeworkItemsList="+homeworkItems+"; File="+file + "; UserID="+userID, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return true;
    }

    public boolean addPhotoToHomeworkItemsAndUpdate(List<HomeworkItem> homeworkItems, Photo photo, Long userID) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            for(HomeworkItem homeworkItem: homeworkItems) {
                if (userID.equals(homeworkItem.getAddedById())) {
                    homeworkItem.getPhotos().add(photo);
                    session.update(homeworkItem);
                } else {
                    transaction.rollback();
                    return false;
                }
            }

            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while adding File to HomeworkItems! " +
                    "HomeworkItemsList="+homeworkItems+"; Photo="+photo + "; UserID="+userID, e);
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return true;
    }
}

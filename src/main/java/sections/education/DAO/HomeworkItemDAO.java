package sections.education.DAO;

import org.hibernate.HibernateException;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.HomeworkItem;
import sections.education.entities.HomeworkItem_;

import javax.persistence.criteria.*;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public List<HomeworkItem> getHomeworkItemsForHomeworkPageForStudent(Date todayDate, Long groupId) throws SQLException {
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
            transaction.rollback();
            e.printStackTrace();
        }

        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsForHomeworkPageForTeacher(Date todayDate, Long userId) throws SQLException {
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
            transaction.rollback();
            e.printStackTrace();
        }

        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsBySubjectAddUp(Date lastSavedHWDate, Long subjectId, String purpose) {
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
                        criteriaBuilder.lessThanOrEqualTo(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate)
                ));
                //todo sort
                homeworkItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            }
            else if("add_up_to_smth".equals(purpose)){
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId), subjectId),
                        criteriaBuilder.greaterThanOrEqualTo(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate)
                ));
                homeworkItemList = session.createQuery(criteriaQuery).getResultList();
            }
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        return homeworkItemList;
    }


    public List<HomeworkItem> getHomeworkItemsBySubjectAddDown(Date lastSavedHWDate, Long subjectId) {
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
                    criteriaBuilder.lessThanOrEqualTo(homeworkRoot.get(HomeworkItem_.publishDate),lastSavedHWDate)
            ));

            homeworkItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
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
            System.out.println("beach");
        }
        catch (HibernateException e) {
            transaction.rollback();
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
            transaction.rollback();
            e.printStackTrace();
        }

        return homeworkItemList;
    }
}

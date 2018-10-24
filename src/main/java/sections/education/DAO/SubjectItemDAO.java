package sections.education.DAO;

import org.hibernate.HibernateException;
import sections.education.entities.HomeworkItem;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.SubjectItem;
import sections.education.entities.SubjectItem_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubjectItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<SubjectItem> getSubjectItemsByGroup(Long groupId) {
        List<SubjectItem> subjectItemList = new ArrayList<>(0);
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
            Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

            criteriaQuery.where(criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.groupId), groupId));
            subjectItemList = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return  subjectItemList;
    }

    public List<SubjectItem> getSubjectItemsByTeacherId(Long teacherId) {
        List<SubjectItem> subjectItemList = new ArrayList<>(0);
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
            Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

            criteriaQuery.where(criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.teacherId), teacherId));
            subjectItemList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return  subjectItemList;
    }

    public List<Long> getSubjectItemsIDsByTeacherIdAndGroupId(Long teacherId, Long groupId) {
        List<Long> list = new ArrayList<>(0);
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
            Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

            criteriaQuery.where(criteriaBuilder.or(
                    criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.teacherId), teacherId),
                    criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.groupId), groupId)));

            criteriaQuery.select(subjectItemRoot.get(SubjectItem_.id));
            list = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return list;
    }

    public SubjectItem getSubjectItemById(Long id) {
        SubjectItem subjectItem = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            subjectItem = session.get(SubjectItem.class, id);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        return subjectItem;
    }

    public SubjectItem getSubjectItemIfExistsForAdding(Long teacherId, String subjectName, Long groupId) {
        List<SubjectItem> subjectItemList = new ArrayList<>(0);
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
            Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.teacherId), teacherId)),
                    criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.name), subjectName),
                    criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.groupId), groupId));

            subjectItemList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }

        if(Objects.isNull(subjectItemList) || subjectItemList.size()<1) {
            return null;
        }
        else {
            return subjectItemList.get(0);
        }
    }

    public void updateSubjectItem(SubjectItem subjectItem) {
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            hibSession.update(subjectItem);
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void persistSubjectItem(SubjectItem subjectItem) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(subjectItem);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}

package sections.education.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.ResourceItem;
import sections.education.entities.SubjectResourceCategory;
import sections.education.entities.SubjectResourceCategory_;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectCategoryDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(SubjectCategoryDAO.class);

    public List<SubjectResourceCategory> getSubjectCategoriesByLevel(Long level) {
        List<SubjectResourceCategory> categories = new ArrayList<>(0);
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectResourceCategory.class);
            Root<SubjectResourceCategory> subjectCategoryRoot = criteriaQuery.from(SubjectResourceCategory.class);

            criteriaQuery.where(criteriaBuilder.equal(subjectCategoryRoot.get(SubjectResourceCategory_.course),level));
            criteriaQuery.orderBy(criteriaBuilder.desc(subjectCategoryRoot.get(SubjectResourceCategory_.creationDate)));

            categories = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch(HibernateException e) {
            logger.error("Exception was thrown while getting SubjectCategories by Level. Level="+level, e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return categories;
    }

    public List<SubjectResourceCategory> getSubjectCategoriesByLevelAndDate(Long level, Timestamp lastSavedDate) {
        List<SubjectResourceCategory> categories = new ArrayList<>(0);
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectResourceCategory.class);
            Root<SubjectResourceCategory> subjectCategoryRoot = criteriaQuery.from(SubjectResourceCategory.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(subjectCategoryRoot.get(SubjectResourceCategory_.course),level),
                    criteriaBuilder.greaterThan(subjectCategoryRoot.get(SubjectResourceCategory_.creationDate),lastSavedDate)));
            criteriaQuery.orderBy(criteriaBuilder.desc(subjectCategoryRoot.get(SubjectResourceCategory_.creationDate)));

            categories = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch(HibernateException e) {
            logger.error("Exception was thrown while getting SubjectCategories By Level and Date. " +
                    "Level="+level+"; lastSavedDate="+lastSavedDate);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return categories;
    }

    public List<SubjectResourceCategory> getAllSubjectCategories() {
        List<SubjectResourceCategory> list = new ArrayList<>(0);
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectResourceCategory.class);
            Root<SubjectResourceCategory> subjectCategoryRoot = criteriaQuery.from(SubjectResourceCategory.class);

            list = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting all SubjectCategories.",e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return list;
    }

    public SubjectResourceCategory getCategoryByID(Long categoryID) {
        Session hibSession = null;
        Transaction transaction = null;
        SubjectResourceCategory category = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            category = hibSession.get(SubjectResourceCategory.class, categoryID);
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while getting SubjectCategory by ID. ID="+categoryID,e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }

        return category;
    }

    public void updateSubjectResourceCategory(SubjectResourceCategory category) {
        Session hibSession = null;
        Transaction transaction = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            hibSession.update(category);
            transaction.commit();
        }
        catch (HibernateException e) {
            logger.error("Exception was thrown while updating SubjectCategory! SubjectCategory="+category,e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
    }
}

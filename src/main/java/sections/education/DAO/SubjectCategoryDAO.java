package sections.education.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.SubjectResourceCategory;
import sections.education.entities.SubjectResourceCategory_;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectCategoryDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static List<SubjectResourceCategory> getSubjectCategoriesByLevel(Long level) {
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

            categories = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return categories;
    }

    public static List<SubjectResourceCategory> getSubjectCategoriesByLevelAndDate(Long level, Date lastSavedDate) {
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

            categories = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return categories;
    }
}

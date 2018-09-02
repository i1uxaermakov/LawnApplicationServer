package sections.education.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.ResourceItem;
import sections.education.entities.ResourceItem_;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static List<ResourceItem> getResourceItemsByCategoryAddUp(Timestamp lastSavedHWDate, Long categoryId, String purpose) {
//        purpose - add_up_to_empty
//        purpose - add_up_to_smth
        Session session = null;
        List<ResourceItem> resourceItemList = new ArrayList<>();
        Transaction transaction = null;

        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(ResourceItem.class);
            Root<ResourceItem> resourceItemRoot = criteriaQuery.from(ResourceItem.class);

            if("add_up_to_empty".equals(purpose)) {
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(resourceItemRoot.get(ResourceItem_.subjectResourceCategoryId), categoryId),
                        criteriaBuilder.lessThan(resourceItemRoot.get(ResourceItem_.publishDate), lastSavedHWDate)
                ));
                criteriaQuery.orderBy(criteriaBuilder.desc(resourceItemRoot.get(ResourceItem_.publishDate)));
                resourceItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            }
            else if("add_up_to_smth".equals(purpose)){
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(resourceItemRoot.get(ResourceItem_.subjectResourceCategoryId), categoryId),
                        criteriaBuilder.greaterThan(resourceItemRoot.get(ResourceItem_.publishDate), lastSavedHWDate)
                ));
                criteriaQuery.orderBy(criteriaBuilder.desc(resourceItemRoot.get(ResourceItem_.publishDate)));
                resourceItemList = session.createQuery(criteriaQuery).getResultList();
            }
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return resourceItemList;
    }


    public static List<ResourceItem> getResourceItemsByCategoryAddDown(Timestamp lastSavedHWDate, Long categoryId) {
        Session session = null;
        List<ResourceItem> homeworkItemList = new ArrayList<>();
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(ResourceItem.class);
            Root<ResourceItem> resourceItemRoot = criteriaQuery.from(ResourceItem.class);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(resourceItemRoot.get(ResourceItem_.subjectResourceCategoryId), categoryId),
                    criteriaBuilder.lessThan(resourceItemRoot.get(ResourceItem_.publishDate), lastSavedHWDate)
            ));
            criteriaQuery.orderBy(criteriaBuilder.desc(resourceItemRoot.get(ResourceItem_.publishDate)));

            homeworkItemList = session.createQuery(criteriaQuery).setMaxResults(5).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return homeworkItemList;
    }
}

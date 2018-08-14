package sections.education.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sections.education.entities.SubjectResourceCategory;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubjectCategoryDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static List<SubjectResourceCategory> getAllCategories() {
        Session hibSession = sessionFactory.getCurrentSession();
        List<SubjectResourceCategory> categories = new ArrayList<>(0);
        hibSession.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectResourceCategory.class);
        Root<SubjectResourceCategory> resourceCategoryRoot = criteriaQuery.from(SubjectResourceCategory.class);

        categories = (List<SubjectResourceCategory>) hibSession.createQuery(criteriaQuery).getResultList();

        hibSession.getTransaction().commit();
        return categories;
    }
}

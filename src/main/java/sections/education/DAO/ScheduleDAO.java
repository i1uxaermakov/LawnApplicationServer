package sections.education.DAO;

import model.DAO.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.SubjectItem;
import sections.education.entities.SubjectItem_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

public class ScheduleDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<SubjectItem> getSubjectItemsByGroup(Long groupId) throws SQLException {
        List<SubjectItem> subjectItemList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
        Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

        criteriaQuery.where(criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.groupId), groupId));
        subjectItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return  subjectItemList;
    }

    public List<SubjectItem> getSubjectItemsByTeacherId(Long teacherId) throws SQLException {
        List<SubjectItem> subjectItemList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SubjectItem.class);
        Root<SubjectItem> subjectItemRoot = criteriaQuery.from(SubjectItem.class);

        criteriaQuery.where(criteriaBuilder.equal(subjectItemRoot.get(SubjectItem_.teacherId), teacherId));
        subjectItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return  subjectItemList;
    }
}

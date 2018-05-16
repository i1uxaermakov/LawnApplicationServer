package sections.education.DAO;

import model.DAO.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.HomeworkItem;
import sections.education.entities.HomeworkItem_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

public class HomeworkItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<HomeworkItem> getHomeworkItems(Date lastSavedHWDate, Long groupId) {
        Session session = sessionFactory.getCurrentSession();
        List<HomeworkItem> homeworkItemList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
        Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

        criteriaQuery.where(criteriaBuilder.greaterThan(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate));
        criteriaQuery.where(criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.groupId), groupId));
        homeworkItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsBySubject(Date lastSavedHWDate, Long groupId, Long subjectId) {
        Session session = sessionFactory.getCurrentSession();
        List<HomeworkItem> homeworkItemList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
        Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

        criteriaQuery.where(criteriaBuilder.greaterThan(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate));
        criteriaQuery.where(criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.groupId), groupId));
        criteriaQuery.where(criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId), subjectId));
        homeworkItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return homeworkItemList;
    }
}

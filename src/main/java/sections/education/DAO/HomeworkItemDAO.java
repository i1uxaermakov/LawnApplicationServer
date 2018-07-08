package sections.education.DAO;

import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.HomeworkItem;
import sections.education.entities.HomeworkItem_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkItemDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<HomeworkItem> getHomeworkItems(Date todaysDate, Long groupId) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        List<HomeworkItem> homeworkItemList = new ArrayList<>(0);
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
        Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

        criteriaQuery.where(criteriaBuilder.and(
                            criteriaBuilder.greaterThanOrEqualTo(homeworkRoot.get(HomeworkItem_.deadlineDate), todaysDate),
                            criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.groupId), groupId)));

        homeworkItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return homeworkItemList;
    }

    public List<HomeworkItem> getHomeworkItemsBySubject(Date lastSavedHWDate, Long groupId, Long subjectId) throws SQLException{
        Session session = sessionFactory.getCurrentSession();
        List<HomeworkItem> homeworkItemList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(HomeworkItem.class);
        Root<HomeworkItem> homeworkRoot = criteriaQuery.from(HomeworkItem.class);

        criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.greaterThan(homeworkRoot.get(HomeworkItem_.publishDate), lastSavedHWDate),
                criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.groupId), groupId),
                criteriaBuilder.equal(homeworkRoot.get(HomeworkItem_.subjectId), subjectId)));

        homeworkItemList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return homeworkItemList;
    }
}

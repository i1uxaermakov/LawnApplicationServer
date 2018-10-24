package sections.education.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.entities.LyceumGroup;
import sections.education.entities.LyceumGroup_;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LyceumGroupDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<LyceumGroup> getAllLyceumGroups() {
        Session hibSession = null;
        Transaction transaction = null;
        List<LyceumGroup> lyceumGroups = new ArrayList<>(0);

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();

            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(LyceumGroup.class);
            Root<LyceumGroup> lyceumGroupRoot = criteriaQuery.from(LyceumGroup.class);

            criteriaQuery.orderBy(criteriaBuilder.asc(lyceumGroupRoot.get(LyceumGroup_.groupName)));
            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.notEqual(lyceumGroupRoot.get(LyceumGroup_.groupName),"Teachers"),
                    criteriaBuilder.notEqual(lyceumGroupRoot.get(LyceumGroup_.groupName),"Administration")));
            lyceumGroups = hibSession.createQuery(criteriaQuery).getResultList();

            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }

        return lyceumGroups;
    }

    public String getGroupNameById(Long groupId) {
        Session hibSession = null;
        Transaction transaction = null;
        List<String> groupNameList = null;

        try {
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();

            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(LyceumGroup.class);
            Root<LyceumGroup> lyceumGroupRoot = criteriaQuery.from(LyceumGroup.class);

            criteriaQuery.select(
                    lyceumGroupRoot.get(LyceumGroup_.groupName)
//                    criteriaBuilder.construct(
//                            LyceumGroup.class,
//                            lyceumGroupRoot.get(LyceumGroup_.groupName)
//                    )
            );
            criteriaQuery.where(criteriaBuilder.equal(lyceumGroupRoot.get(LyceumGroup_.id),groupId));

            groupNameList = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }

        if(Objects.isNull(groupNameList) || groupNameList.size()<1) {
            return null;
        }
        else {
            return groupNameList.get(0);
        }
    }
}

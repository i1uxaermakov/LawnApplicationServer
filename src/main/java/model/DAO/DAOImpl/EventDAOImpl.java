package model.DAO.DAOImpl;

import model.DAO.EventDAO;
import model.entities.Event;
import model.entities.Event_;
import model.entities.wrappers.BriefEvent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public Collection getBriefEvents(Session session, Date date, int maxResults) {
        List<BriefEvent> briefEventList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(BriefEvent.class);
        Root<Event> eventRoot = criteriaQuery.from(Event.class);
        criteriaQuery.select(
                criteriaBuilder.construct(
                        BriefEvent.class,
                        eventRoot.get(Event_.id),
                        eventRoot.get(Event_.name),
                        eventRoot.get(Event_.eventDate),
                        eventRoot.get(Event_.mainPhotoLocation)
                )
        );

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();

        criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(eventRoot.get(Event_.eventDate), date));
        criteriaQuery.orderBy(criteriaBuilder.asc(eventRoot.get(Event_.eventDate)));
        briefEventList = session.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return briefEventList;
    }

    @Override
    public Event getEventById(Session session, int event_id) {
        Transaction transaction = session.beginTransaction();
        Event event = session.load(Event.class, event_id);
        transaction.commit();
        return event;
    }
}

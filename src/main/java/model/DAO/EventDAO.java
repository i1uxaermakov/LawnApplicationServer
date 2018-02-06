package model.DAO;

import model.entities.Event;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface EventDAO {
    Collection getBriefEvents(Session session, Date date, int maxResults) throws SQLException;
    Event getEventById(Session session, int event_id);
}

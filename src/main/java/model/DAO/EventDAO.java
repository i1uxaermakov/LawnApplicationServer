package model.DAO;

import model.entities.Event;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface EventDAO {
    Collection getBriefEvents(Date date, int maxResults) throws SQLException;
    Event getEventById(int event_id);
}

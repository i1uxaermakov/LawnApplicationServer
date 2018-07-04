package sections.feed.events.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Event.class)
public class Event_ {
    public static volatile SingularAttribute<Event, Long> id;
    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, String> eventPhotoLocation;
    public static volatile SingularAttribute<Event, Date> eventDate;
    public static volatile SingularAttribute<Event, String> venue;
    public static volatile SingularAttribute<Event, Boolean> hasPassed;
    public static volatile SingularAttribute<Event, String> addedBy;
}
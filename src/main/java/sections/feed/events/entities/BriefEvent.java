package sections.feed.events.entities;

import java.sql.Timestamp;

public class BriefEvent {
    private Long id;
    private String name;
    private Timestamp eventDate;
    private String eventPhotoLocation;

    public BriefEvent(Long id, String name, Timestamp eventDate, String eventPhotoLocation) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.eventPhotoLocation = eventPhotoLocation;
    }

    public BriefEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPhotoLocation() {
        return eventPhotoLocation;
    }

    public void setEventPhotoLocation(String eventPhotoLocation) {
        this.eventPhotoLocation = eventPhotoLocation;
    }

    @Override
    public String toString() {
        return "BriefEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDate=" + eventDate +
                ", mainPhotoLocation='" + eventPhotoLocation + '\'' +
                '}';
    }
}

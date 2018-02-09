package model.entities.wrappers;

import java.util.Date;

public class BriefEvent {
    private Long id;
    private String name;
    private Date eventDate;
    private String eventPhotoLocation;

    public BriefEvent(Long id, String name, Date eventDate, String mainPhotoLocation) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.eventPhotoLocation = mainPhotoLocation;
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
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

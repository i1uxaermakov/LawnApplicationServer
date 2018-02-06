package model.entities.wrappers;

import java.util.Date;

public class BriefEvent {
    private Long id;
    private String name;
    private Date eventDate;
    private String mainPhotoLocation;

    public BriefEvent(Long id, String name, Date eventDate, String mainPhotoLocation) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.mainPhotoLocation = mainPhotoLocation;
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

    public String getMainPhotoLocation() {
        return mainPhotoLocation;
    }

    public void setMainPhotoLocation(String mainPhotoLocation) {
        this.mainPhotoLocation = mainPhotoLocation;
    }
}

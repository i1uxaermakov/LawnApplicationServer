package sections.feed.events.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Event implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String eventPhotoLocation;
    private Date eventDate;
    private String venue;
    private boolean hasPassed = false;
    private String addedBy;
//    private Set<Long> likes;


    public Event() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isHasPassed() {
        return hasPassed;
    }

    public void setHasPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getEventPhotoLocation() {
        return eventPhotoLocation;
    }

    public void setEventPhotoLocation(String eventPhotoLocation) {
        this.eventPhotoLocation = eventPhotoLocation;
    }
}

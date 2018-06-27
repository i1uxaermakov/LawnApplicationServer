package model.entities.wrappers;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

public class BriefAlbum implements Serializable{
    private Long albumId;
    private String name;
    private Timestamp eventDate;
    private String mainPhotoLocation;

    public BriefAlbum(Long albumId, String name, Date eventDate, String mainPhotoLocation) {
        this.albumId = albumId;
        this.name = name;
        this.eventDate = (Timestamp)eventDate;
        this.mainPhotoLocation = mainPhotoLocation;
    }

    public BriefAlbum() {
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
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

    public String getMainPhotoLocation() {
        return mainPhotoLocation;
    }

    public void setMainPhotoLocation(String mainPhotoLocation) {
        this.mainPhotoLocation = mainPhotoLocation;
    }
}

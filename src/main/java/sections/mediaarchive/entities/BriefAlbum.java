package sections.mediaarchive.entities;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

public class BriefAlbum implements Serializable{
    private Long albumId;
    private String name;
    private String mainPhotoLocation;
    private Date publishDate;

    public BriefAlbum(Long albumId, String name, String mainPhotoLocation, Date publishDate) {
        this.albumId = albumId;
        this.name = name;
        this.mainPhotoLocation = mainPhotoLocation;
        this.publishDate = publishDate;
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

    public String getMainPhotoLocation() {
        return mainPhotoLocation;
    }

    public void setMainPhotoLocation(String mainPhotoLocation) {
        this.mainPhotoLocation = mainPhotoLocation;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

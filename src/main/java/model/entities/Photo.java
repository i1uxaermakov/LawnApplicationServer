package model.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;
import java.util.Set;

public class Photo implements Serializable {
    private Long id;
    private String photoName;
    private String photoLocationBIG;
    private String photoLocationMEDIUM;
    private String photoLocationSMALL;
    private Date publishDate;
    private String author;
//    likes

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoLocationBIG() {
        return photoLocationBIG;
    }

    public void setPhotoLocationBIG(String photoLocationBIG) {
        this.photoLocationBIG = photoLocationBIG;
    }

    public String getPhotoLocationMEDIUM() {
        return photoLocationMEDIUM;
    }

    public void setPhotoLocationMEDIUM(String photoLocationMEDIUM) {
        this.photoLocationMEDIUM = photoLocationMEDIUM;
    }

    public String getPhotoLocationSMALL() {
        return photoLocationSMALL;
    }

    public void setPhotoLocationSMALL(String photoLocationSMALL) {
        this.photoLocationSMALL = photoLocationSMALL;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

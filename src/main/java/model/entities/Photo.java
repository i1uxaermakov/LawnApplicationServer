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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (id != null ? !id.equals(photo.id) : photo.id != null) return false;
        if (photoName != null ? !photoName.equals(photo.photoName) : photo.photoName != null) return false;
        if (photoLocationBIG != null ? !photoLocationBIG.equals(photo.photoLocationBIG) : photo.photoLocationBIG != null)
            return false;
        if (photoLocationMEDIUM != null ? !photoLocationMEDIUM.equals(photo.photoLocationMEDIUM) : photo.photoLocationMEDIUM != null)
            return false;
        if (photoLocationSMALL != null ? !photoLocationSMALL.equals(photo.photoLocationSMALL) : photo.photoLocationSMALL != null)
            return false;
        if (publishDate != null ? !publishDate.equals(photo.publishDate) : photo.publishDate != null) return false;
        return author != null ? author.equals(photo.author) : photo.author == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (photoName != null ? photoName.hashCode() : 0);
        result = 31 * result + (photoLocationBIG != null ? photoLocationBIG.hashCode() : 0);
        result = 31 * result + (photoLocationMEDIUM != null ? photoLocationMEDIUM.hashCode() : 0);
        result = 31 * result + (photoLocationSMALL != null ? photoLocationSMALL.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", photoLocationBIG='" + photoLocationBIG + '\'' +
                ", photoLocationMEDIUM='" + photoLocationMEDIUM + '\'' +
                ", photoLocationSMALL='" + photoLocationSMALL + '\'' +
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                '}';
    }
}

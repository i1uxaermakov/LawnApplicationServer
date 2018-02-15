package model.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Set;

public class Photo implements Serializable {
    private Long id;
    private String photoName;
    private String photoLocation;
    private Timestamp publishDate;
    private Long authorId;
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

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (photoName != null ? !photoName.equals(photo.photoName) : photo.photoName != null) return false;
        if (photoLocation != null ? !photoLocation.equals(photo.photoLocation) : photo.photoLocation != null)
            return false;
        if (publishDate != null ? !publishDate.equals(photo.publishDate) : photo.publishDate != null) return false;
        return authorId != null ? authorId.equals(photo.authorId) : photo.authorId == null;
    }

    @Override
    public int hashCode() {
        int result = photoName != null ? photoName.hashCode() : 0;
        result = 31 * result + (photoLocation != null ? photoLocation.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", photoLocation='" + photoLocation + '\'' +
                ", publishDate=" + publishDate +
                ", authorId=" + authorId +
                '}';
    }
}

package model.entities;

import java.io.Serializable;
import java.util.Set;

public class Photo implements Serializable {
    private Long photoId;
    private String photoName;
    private String photoLocation;
    private Long photoCategoryOrEventId;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
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

    public Long getPhotoCategoryOrEventId() {
        return photoCategoryOrEventId;
    }

    public void setPhotoCategoryOrEventId(Long photoCategoryOrEventId) {
        this.photoCategoryOrEventId = photoCategoryOrEventId;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", photoName='" + photoName + '\'' +
                ", photoLocation='" + photoLocation + '\'' +
                ", photoCategoryOrEventId=" + photoCategoryOrEventId +
                '}';
    }
}

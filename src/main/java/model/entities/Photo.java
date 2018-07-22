package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Photo implements Serializable {
    private Long id;
    private String originalPhotoLocation;
    private String thumbnailPhotoLocation;
    private String squareThumbnailPhotoLocation;
    private Timestamp publishDate;
    private String author;

    public Photo() {
    }

    public Photo(String originalPhotoLocation, String thumbnailPhotoLocation, String squareThumbnailPhotoLocation, Timestamp publishDate, String author) {
        this.originalPhotoLocation = originalPhotoLocation;
        this.thumbnailPhotoLocation = thumbnailPhotoLocation;
        this.squareThumbnailPhotoLocation = squareThumbnailPhotoLocation;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalPhotoLocation() {
        return originalPhotoLocation;
    }

    public void setOriginalPhotoLocation(String originalPhotoLocation) {
        this.originalPhotoLocation = originalPhotoLocation;
    }

    public String getThumbnailPhotoLocation() {
        return thumbnailPhotoLocation;
    }

    public void setThumbnailPhotoLocation(String thumbnailPhotoLocation) {
        this.thumbnailPhotoLocation = thumbnailPhotoLocation;
    }

    public String getSquareThumbnailPhotoLocation() {
        return squareThumbnailPhotoLocation;
    }

    public void setSquareThumbnailPhotoLocation(String squareThumbnailPhotoLocation) {
        this.squareThumbnailPhotoLocation = squareThumbnailPhotoLocation;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

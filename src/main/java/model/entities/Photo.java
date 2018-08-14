package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Photo implements Serializable {
    private Long id;
    private String originalPhotoLocation;
    private String originalPhotoDimensions;
    private String thumbnailPhotoLocation;
    private String thumbnailPhotoDimensions;
    private String squareThumbnailPhotoLocation;
    private String squarePhotoDimensions;
    private Timestamp publishDate;
    private String author;

    public Photo() {
    }

    public Photo(String originalPhotoLocation, String thumbnailPhotoLocation,
                 String squareThumbnailPhotoLocation, Timestamp publishDate, String author) {
        this.originalPhotoLocation = originalPhotoLocation;
        this.thumbnailPhotoLocation = thumbnailPhotoLocation;
        this.squareThumbnailPhotoLocation = squareThumbnailPhotoLocation;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Photo(String originalPhotoLocation, String originalPhotoDimensions,
                 String thumbnailPhotoLocation, String thumbnailPhotoDimensions,
                 String squareThumbnailPhotoLocation, String squarePhotoDimensions,
                 Timestamp publishDate, String author) {
        this.originalPhotoLocation = originalPhotoLocation;
        this.originalPhotoDimensions = originalPhotoDimensions;
        this.thumbnailPhotoLocation = thumbnailPhotoLocation;
        this.thumbnailPhotoDimensions = thumbnailPhotoDimensions;
        this.squareThumbnailPhotoLocation = squareThumbnailPhotoLocation;
        this.squarePhotoDimensions = squarePhotoDimensions;
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

    public String getOriginalPhotoDimensions() {
        return originalPhotoDimensions;
    }

    public void setOriginalPhotoDimensions(String originalPhotoDimensions) {
        this.originalPhotoDimensions = originalPhotoDimensions;
    }

    public String getThumbnailPhotoDimensions() {
        return thumbnailPhotoDimensions;
    }

    public void setThumbnailPhotoDimensions(String thumbnailPhotoDimensions) {
        this.thumbnailPhotoDimensions = thumbnailPhotoDimensions;
    }

    public String getSquarePhotoDimensions() {
        return squarePhotoDimensions;
    }

    public void setSquarePhotoDimensions(String squarePhotoDimensions) {
        this.squarePhotoDimensions = squarePhotoDimensions;
    }
}

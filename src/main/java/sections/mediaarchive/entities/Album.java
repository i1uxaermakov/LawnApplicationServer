package sections.mediaarchive.entities;

import model.entities.Photo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Album {
    private Long albumId;
    private String name;
    private String description;
    private Date publishDate;
    private String mainPhotoLocation;
    private String author;
    private Set<Photo> albumPhotos = new HashSet<>(0);

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getMainPhotoLocation() {
        return mainPhotoLocation;
    }

    public void setMainPhotoLocation(String mainPhotoLocation) {
        this.mainPhotoLocation = mainPhotoLocation;
    }

    public Set<Photo> getAlbumPhotos() {
        return albumPhotos;
    }

    public void setAlbumPhotos(Set<Photo> albumPhotos) {
        this.albumPhotos = albumPhotos;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

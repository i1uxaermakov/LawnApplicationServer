package sections.feed.posts.entities;

import model.entities.Photo;

import java.util.HashSet;
import java.util.Set;

public class AttachedAlbum {
    private Long attachedAlbumId;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);

    public AttachedAlbum() {
    }

    public Long getAttachedAlbumId() {
        return attachedAlbumId;
    }

    public void setAttachedAlbumId(Long attachedAlbumId) {
        this.attachedAlbumId = attachedAlbumId;
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

}
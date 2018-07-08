package sections.education.entities;

import model.entities.Photo;

import java.util.HashSet;
import java.util.Set;

public class HWAlbum {
    private Long hw_id;
    private HomeworkItem homeworkItem;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);

    public Long getHw_id() {
        return hw_id;
    }

    public void setHw_id(Long hw_id) {
        this.hw_id = hw_id;
    }

    public HomeworkItem getHomeworkItem() {
        return homeworkItem;
    }

    public void setHomeworkItem(HomeworkItem homeworkItem) {
        this.homeworkItem = homeworkItem;
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

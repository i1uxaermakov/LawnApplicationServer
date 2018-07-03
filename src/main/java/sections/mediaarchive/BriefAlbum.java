package sections.mediaarchive;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

public class BriefAlbum implements Serializable{
    private Long albumId;
    private String name;
    private String mainPhotoLocation;

    public BriefAlbum(Long albumId, String name, String mainPhotoLocation) {
        this.albumId = albumId;
        this.name = name;
        this.mainPhotoLocation = mainPhotoLocation;
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
}

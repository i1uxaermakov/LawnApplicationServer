package model.entities.wrappers;

import java.util.Date;

public class BriefNewsItem {
    private Long id;
    private String title;
    private String extract;
    private Date publishDate;
    private Long photoId;
    private String sphere;
    private Integer urgency;

    public BriefNewsItem(Long id, String title, String extract, Date publishDate, Long photoId, String sphere, Integer urgency) {
        this.id = id;
        this.title = title;
        this.extract = extract;
        this.publishDate = publishDate;
        this.photoId = photoId;
        this.sphere = sphere;
        this.urgency = urgency;
    }

    public BriefNewsItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "BriefNewsItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", extract='" + extract + '\'' +
                ", publishDate=" + publishDate +
                ", photoId=" + photoId +
                ", sphere='" + sphere + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}

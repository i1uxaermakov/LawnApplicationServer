package model.entities;

import java.util.Date;
import java.util.Set;

public class News {
    private Long newsId;
    private String title;
    private Date whenAdded;
    private String text;
    private Set attachedPhotos;
    private Set attachedFiles;
    private Integer urgency;

    public News() {}

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(Date whenAdded) {
        this.whenAdded = whenAdded;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set getAttachedPhotos() {
        return attachedPhotos;
    }

    public void setAttachedPhotos(Set attachedPhotos) {
        this.attachedPhotos = attachedPhotos;
    }

    public Set getAttachedFiles() {
        return attachedFiles;
    }

    public void setAttachedFiles(Set attachedFiles) {
        this.attachedFiles = attachedFiles;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }
}

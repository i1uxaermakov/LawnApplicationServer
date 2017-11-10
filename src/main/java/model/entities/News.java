package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class News implements Serializable{
    private Long newsId;
    private String title;
    private Long whoAdded;
    private Date whenAdded;
    private String text;
    private Photo photo;
    private Set attachedFiles = new HashSet();
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

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", whenAdded=" + whenAdded +
                ", text='" + text + '\'' +
                ", attachedPhotos=" + attachedPhotos +
                ", attachedFiles=" + attachedFiles +
                ", urgency=" + urgency +
                '}';
    }
}

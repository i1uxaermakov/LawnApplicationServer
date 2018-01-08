package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NewsItem implements Serializable {
    private Long id;
    private String title;
    private String extract;
    private Long authorId;
    private Date publishDate;
    private String newsItemText;
    private Long photoId;
    private String sphere;
    private Integer urgency;//edu,social,sport
//    private Set attachedFiles = new HashSet();


    public NewsItem() {
    }

    public NewsItem(Long id) {
        this.id = id;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getNewsItemText() {
        return newsItemText;
    }

    public void setNewsItemText(String newsItemText) {
        this.newsItemText = newsItemText;
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

    @Override
    public String toString() {
        return "NewsItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", extract='" + extract + '\'' +
                ", authorId=" + authorId +
                ", publishDate=" + publishDate +
                ", newsItemText='" + newsItemText + '\'' +
                ", photoId=" + photoId +
                ", sphere='" + sphere + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}

package sections.feed.posts.entities;

import utils.files.File;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class Post implements Serializable {
    private Long postId;
    private Long authorId;
    private String authorName;
    private String organizationName;
    private Timestamp publishDate;
    private String postContent;
//    private String postExcerpt;
    private String status;
    private Set<File> files;
    private AttachedAlbum album;

    public Post() {
    }

    public Post(Long postId, Long authorId, String authorName, String organizationName, Timestamp publishDate, String postContent, String status, Set<File> files, AttachedAlbum album) {
        this.postId = postId;
        this.authorId = authorId;
        this.authorName = authorName;
        this.organizationName = organizationName;
        this.publishDate = publishDate;
        this.postContent = postContent;
        this.status = status;
        this.files = files;
        this.album = album;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postText) {
        this.postContent = postText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

//    public String getPostExcerpt() {
//        return postExcerpt;
//    }
//
//    public void setPostExcerpt(String postExcerpt) {
//        this.postExcerpt = postExcerpt;
//    }


    public AttachedAlbum getAlbum() {
        return album;
    }

    public void setAlbum(AttachedAlbum album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", publishDate=" + publishDate +
                ", postContent='" + postContent + '\'' +
                ", status='" + status + '\'' +
                ", files=" + files +
                ", album=" + album +
                '}';
    }
}

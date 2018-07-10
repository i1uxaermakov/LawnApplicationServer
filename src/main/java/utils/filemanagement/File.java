package utils.filemanagement;

import sections.feed.posts.entities.Post;

import java.util.Date;

public class File {
    private Long id;
    private String name;
    private Long size;
    private String location;
    private String author;
    private Date publishDate;
    private Post post;

    public File() {
    }

    public File(Long id, String name, Long size, String location, String author, Date publishDate, Post post) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.location = location;
        this.author = author;
        this.publishDate = publishDate;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", location='" + location + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", post=" + post +
                '}';
    }
}

package utils.filemanagement;

import sections.feed.posts.entities.Post;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class File {
    private Long id;
    private String name;
    private Long size;
    private String location;
    private String author;
    private Date publishDate;
    private Set<Post> posts = new HashSet<>(0);

    public File() {
    }

    public File(String name, Long size, String location, String author, Date publishDate, Set<Post> posts) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.author = author;
        this.publishDate = publishDate;
        this.posts = posts;
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

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}

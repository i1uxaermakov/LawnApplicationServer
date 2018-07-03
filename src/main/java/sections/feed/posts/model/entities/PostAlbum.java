package sections.feed.posts.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import model.entities.Photo;
import sections.feed.posts.PostAlbumJSONSerializer;

import java.util.HashSet;
import java.util.Set;

@JsonSerialize(using = PostAlbumJSONSerializer.class)
public class PostAlbum {
    private Long postId;
    private Post post;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);

    public PostAlbum() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    @Override
    public String toString() {
        return "PostAlbum{" +
                "postId=" + postId +
                ", post=" + post +
                ", mainPhotoLocation='" + mainPhotoLocation + '\'' +
                ", albumPhotos=" + albumPhotos +
                '}';
    }
}
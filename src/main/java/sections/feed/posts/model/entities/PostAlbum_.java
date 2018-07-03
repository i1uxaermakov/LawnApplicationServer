package sections.feed.posts.model.entities;

import model.entities.Photo;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( PostAlbum.class )
public class PostAlbum_ {
    public static volatile SingularAttribute<PostAlbum,Long> id;
    public static volatile SingularAttribute<PostAlbum,Post> post;
    public static volatile SingularAttribute<PostAlbum,String> mainPhotoLocation;
    public static volatile SetAttribute<PostAlbum,Photo> albumPhotos;
}

/*private Long id;
    private Post post;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);*/
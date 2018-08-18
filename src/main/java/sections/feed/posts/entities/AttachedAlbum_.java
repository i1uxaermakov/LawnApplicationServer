package sections.feed.posts.entities;

import utils.images.Photo;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( AttachedAlbum.class )
public class AttachedAlbum_ {
    public static volatile SingularAttribute<AttachedAlbum,Long> id;
    public static volatile SingularAttribute<AttachedAlbum,Post> post;
    public static volatile SingularAttribute<AttachedAlbum,String> mainPhotoLocation;
    public static volatile SetAttribute<AttachedAlbum,Photo> albumPhotos;
}

/*private Long id;
    private Post post;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>(0);*/
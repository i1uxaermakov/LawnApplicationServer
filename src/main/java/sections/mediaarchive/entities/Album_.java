package sections.mediaarchive.entities;

import utils.images.Photo;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel( Album.class )
public class Album_ {
    public static volatile SingularAttribute<Album, Long> albumId;
    public static volatile SingularAttribute<Album, String> name;
    public static volatile SingularAttribute<Album, String> mainPhotoLocation;
    public static volatile SingularAttribute<Album, String> description;
    public static volatile SingularAttribute<Album, Date> publishDate;
    public static volatile SingularAttribute<Album, String> author;
    public static volatile SetAttribute<Album, Photo> albumPhotos;

}
/*
private Long albumId;
    private String name;
    private String description;
    private Date publishDate;
    private String mainPhotoLocation;
    private String author;
    private Set<Photo> albumPhotos = new HashSet<>(0);
 */
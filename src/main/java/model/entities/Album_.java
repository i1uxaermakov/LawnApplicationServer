package model.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel( Album.class )
public class Album_ {
    public static volatile SingularAttribute<Album, Long> albumId;
    public static volatile SingularAttribute<Album, String> name;
    public static volatile SingularAttribute<Album, String> mainPhotoLocation;
    public static volatile SingularAttribute<Album, Timestamp> eventDate;
    public static volatile SingularAttribute<Album, String> description;
    public static volatile SingularAttribute<Album, Timestamp> publishDate;
    public static volatile SetAttribute<Album, Photo> albumPhotos;

}
/*
private Long albumId;
    private String name;
    private String description;
    private Timestamp publishDate;
    private Timestamp eventDate;
    private String mainPhotoLocation;
    private Set<Photo> albumPhotos = new HashSet<>();
 */
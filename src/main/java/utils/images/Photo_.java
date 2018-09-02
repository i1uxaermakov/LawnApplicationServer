package utils.images;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import java.util.Date;

@StaticMetamodel(Photo.class)
public class Photo_ {
    public static volatile SingularAttribute<Photo,Long> id;
    public static volatile SingularAttribute<Photo,String> originalPhotoLocation;
    public static volatile SingularAttribute<Photo,String> originalPhotoDimensions;
    public static volatile SingularAttribute<Photo,String> thumbnailPhotoLocation;
    public static volatile SingularAttribute<Photo,String> thumbnailPhotoDimensions;
    public static volatile SingularAttribute<Photo,String> squareThumbnailPhotoLocation;
    public static volatile SingularAttribute<Photo,String> squarePhotoDimensions;
    public static volatile SingularAttribute<Photo,Timestamp> publishDate;
    public static volatile SingularAttribute<Photo,String> author;
}
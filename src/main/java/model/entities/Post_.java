package model.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel( Post.class )
public class Post_ {
    public static volatile SingularAttribute<Post,Long> id;
    public static volatile SingularAttribute<Post,String> authorName;
    public static volatile SingularAttribute<Post,String> organizationMame;
    public static volatile SingularAttribute<Post,Date> publishDate;
    public static volatile SingularAttribute<Post,String> title;
    public static volatile SingularAttribute<Post,String> postText;
    public static volatile SingularAttribute<Post,Long> description;
    public static volatile SingularAttribute<Post,String> status;
    public static volatile SetAttribute<Post,Tag> tags;
}

/*
    private Long id;
    private String authorName;
    private String OrganizationName;
    private Date publishDate;
    private String title;
    private String postText;
    private String postTextExtract;
//    private Set<Photo> photos;
//    private Set<Video> videos;
//    private Set<File> files;
    private Set<Tag> tags;
 */
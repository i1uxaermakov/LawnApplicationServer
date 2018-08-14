package sections.education.entities;

import sections.feed.posts.entities.AttachedAlbum;
import utils.files.File;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel( HomeworkItem.class )
public class HomeworkItem_ {
    public static volatile SingularAttribute<HomeworkItem,Long> hw_id;
    public static volatile SingularAttribute<HomeworkItem,Long> addedById;
    public static volatile SingularAttribute<HomeworkItem,Long> groupId;
    public static volatile SingularAttribute<HomeworkItem,Long> subjectId;
    public static volatile SingularAttribute<HomeworkItem,String> subjectName;
    public static volatile SingularAttribute<HomeworkItem,String> teacherName;
    public static volatile SingularAttribute<HomeworkItem,String> description;
    public static volatile SingularAttribute<HomeworkItem,Date> publishDate;
    public static volatile SingularAttribute<HomeworkItem,Date> deadlineDate;
    public static volatile SetAttribute<HomeworkItem,File> files;
    public static volatile SingularAttribute<HomeworkItem,AttachedAlbum> hwAlbum;

}
/*
    private Long hw_id;
    private Long addedById;
    private Long groupId;
    private Long subjectId;
    private String subjectName;
    private String teacherName;
    private String description;
    private Date publishDate;
    private Date deadlineDate;
    private Set<File> files;
    private AttachedAlbum hwAlbum;



*/
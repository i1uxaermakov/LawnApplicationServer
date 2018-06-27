package sections.education.entities;

import model.entities.File;
import model.entities.Photo;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel( HomeworkItem.class )
public class HomeworkItem_ {
    public static volatile SingularAttribute<HomeworkItem,Long> id;
    public static volatile SingularAttribute<HomeworkItem,Long> teacherId;
    public static volatile SingularAttribute<HomeworkItem,Long> groupId;
    public static volatile SingularAttribute<HomeworkItem,Long> subjectId;
    public static volatile SingularAttribute<HomeworkItem,Long> albumId;
    public static volatile SingularAttribute<HomeworkItem,Long> albumPhotosNumber;
    public static volatile SingularAttribute<HomeworkItem,String> subjectName;
    public static volatile SingularAttribute<HomeworkItem,String> teacherName;
    public static volatile SingularAttribute<HomeworkItem,String> description;
    public static volatile SingularAttribute<HomeworkItem,Date> publishDate;
    public static volatile SingularAttribute<HomeworkItem,Date> deadlineDate;

    public static volatile SetAttribute<HomeworkItem,File> files;
    public static volatile SetAttribute<HomeworkItem,Photo> photos;

}
/*
    private Long id;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;
    private String subjectName;
    private String teacherName;
    private String description;
    private Date publishDate;
    private Date deadlineDate;
    private Long albumId;
    private Long albumPhotosNumber;

    private List<File> files;
    private List<Photo> photos;

*/
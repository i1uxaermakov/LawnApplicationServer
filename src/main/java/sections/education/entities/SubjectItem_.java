package sections.education.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( SubjectItem.class )
public class SubjectItem_ {
    public static volatile SingularAttribute<SubjectItem,Long> id;
    public static volatile SingularAttribute<SubjectItem,String> name;
    public static volatile SingularAttribute<SubjectItem,Long> groupId;
    public static volatile SingularAttribute<SubjectItem,String> groupName;
    public static volatile SingularAttribute<SubjectItem,Long> teacherId;
    public static volatile SingularAttribute<SubjectItem,String> teacherName;
    public static volatile SingularAttribute<SubjectItem,Long> createdBy;

    public static volatile SetAttribute<SubjectItem,DayLecture> whenIsSubject;
}
/*
    private Long id;
    private String name;
    private Long groupId;
    private String groupName;
    private Long teacherId;
    private String teacherName;
    private Long createdBy;
    private Set<DayLecture> whenIsSubject= new HashSet<>(0);


 */

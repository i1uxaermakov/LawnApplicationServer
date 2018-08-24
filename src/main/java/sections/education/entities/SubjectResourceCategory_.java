package sections.education.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(SubjectResourceCategory.class)
public class SubjectResourceCategory_ {
    public static volatile SingularAttribute<SubjectResourceCategory,Long> categoryId;
    public static volatile SingularAttribute<SubjectResourceCategory,Date> creationDate;
    public static volatile SingularAttribute<SubjectResourceCategory,Long> course;
    public static volatile SingularAttribute<SubjectResourceCategory,String> categoryName;
    public static volatile SetAttribute<SubjectResourceCategory,ResourceItem> resourceItems;
}

//    private Long categoryId;
//    private Date creationDate;
//    private Long course;
//    private String categoryName;
//    private Set<ResourceItem> resourceItems = new HashSet<>(0);


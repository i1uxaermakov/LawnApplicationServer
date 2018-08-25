package sections.education.entities;

import utils.files.File;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(ResourceItem.class)
public class ResourceItem_ {
    public static volatile SingularAttribute<ResourceItem,Long> resourceItemId;
    public static volatile SingularAttribute<ResourceItem,File> file;
    public static volatile SingularAttribute<ResourceItem,Long> subjectResourceCategoryId;
    public static volatile SingularAttribute<ResourceItem,String> addedBy;
    public static volatile SingularAttribute<ResourceItem,Date> publishDate;
}
/*
    private Long resourceItemId;
    private File file;
    private Long subjectResourceCategoryId;
    private String addedBy;
    private Date publishDate;
 */

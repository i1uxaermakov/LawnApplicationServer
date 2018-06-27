package sections.education.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( DayLecture.class )
public class DayLecture_ {
    public static volatile SingularAttribute<DayLecture,Long> id;
    public static volatile SingularAttribute<DayLecture,Long> day;
    public static volatile SingularAttribute<DayLecture,Long> lectureOrder;
}
/*
    private Long id;
    private Long day;
    private Long lectureOrder;
 */
package sections.education.entities;

import account.entities.User;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LyceumGroup.class)
public class LyceumGroup_ {
    public static volatile SingularAttribute<LyceumGroup,Long> id;
    public static volatile SingularAttribute<LyceumGroup,String> groupName;
    public static volatile SingularAttribute<LyceumGroup,Long> level;
    public static volatile SetAttribute<LyceumGroup,User> students;
}

/*
    private Long id;
    private String groupName;
    private Long level;
    private Set<User> students = new HashSet<>(0);
 */
package model.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel( User.class )
public class User_ {
        public static volatile SingularAttribute<User, Long> userId;
        public static volatile SingularAttribute<User, String> lyceumId;
        public static volatile SingularAttribute<User, String> password;
        public static volatile SingularAttribute<User, String> groupName;
        public static volatile SingularAttribute<User, String> firstName;
        public static volatile SingularAttribute<User, String> lastName;
        public static volatile SingularAttribute<User, Timestamp> lastLoginDate;
        public static volatile SingularAttribute<User, Long> groupId;
        public static volatile SetAttribute<User, String> privileges;
        public static volatile SetAttribute<User,Organization> organizations;
}
/*
    private Long userId;
    private String lyceumId;
    private String password;
    private String firstName;
    private String lastName;
    private Long groupId;
    private Date lastLoginDate;
    private Set<String> privileges = new HashSet<>(0);
    private Set<Organization> organizations = new HashSet<>(0);
 */
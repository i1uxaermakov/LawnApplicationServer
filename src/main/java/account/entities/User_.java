package account.entities;

import utils.files.File;

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
        public static volatile SingularAttribute<User, String> fathersName;
        public static volatile SingularAttribute<User, Timestamp> lastLoginDate;
        public static volatile SingularAttribute<User, Long> groupId;
        public static volatile SetAttribute<User, String> privileges;
        public static volatile SetAttribute<User,File> favoriteFiles;
}
/*
    private Long userId; //internal
    private String lyceumId; //to login
    private String password; //bcrypted
    private String firstName;
    private String lastName;
    private String fathersName;
    private Long groupId;//??? do i need it
    private String groupName;
    private Long level;
    private Timestamp lastLoginDate;
    private Set<String> privileges = new HashSet<>(0);
    private Set<File> favouriteFiles = new HashSet<>(0);
 */
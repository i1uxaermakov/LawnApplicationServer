package model.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel( User.class )
public class User_ {
    public static volatile SingularAttribute<User, Long> userId;
    public static volatile SingularAttribute<User, String> lyceumId;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Date> lastLoginDate;
}


/*package model.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel( User.class )
public class User_ {
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> title;
    public static volatile SingularAttribute<User, String> extract;
    public static volatile SingularAttribute<User, Long> authorId;
    public static volatile SingularAttribute<User, Date> publishDate;
    public static volatile SingularAttribute<User, String> text;
    public static volatile SingularAttribute<User, Long> photoId;
    public static volatile SingularAttribute<User, String> sphere;
    public static volatile SingularAttribute<User, Integer> urgency;

private Long userId;
    private Long lyceumId;
    private String password;
    private String firstName;
    private String lastName;
    private Date lastLoginDate;





}*/
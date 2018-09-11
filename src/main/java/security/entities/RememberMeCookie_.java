package security.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(RememberMeCookie.class)
public class RememberMeCookie_ {
    public static volatile SingularAttribute<RememberMeCookie,Long> id;
    public static volatile SingularAttribute<RememberMeCookie,Long> userId;
    public static volatile SingularAttribute<RememberMeCookie,String> selector;
    public static volatile SingularAttribute<RememberMeCookie,String> hashedValidator;
    public static volatile SingularAttribute<RememberMeCookie,Timestamp> expiresDate;
}

/*
    private Long id;
    private Long userId;
    private String selector;
    private String hashedValidator;
    private Timestamp expiresDate;


*/
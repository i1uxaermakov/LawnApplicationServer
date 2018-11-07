package account.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(RememberMeCookie.class)
public class RememberMeCookie_ {
    public static volatile SingularAttribute<RememberMeCookie,Long> cookieID;
    public static volatile SingularAttribute<RememberMeCookie,Long> userId;
    public static volatile SingularAttribute<RememberMeCookie,String> selector;
    public static volatile SingularAttribute<RememberMeCookie,String> hashedValidator;
    public static volatile SingularAttribute<RememberMeCookie,Timestamp> expiresDate;
}

/*
    private Long cookieID;
    private Long userId;
    private String selector;
    private String hashedValidator;
    private Timestamp expiresDate;


*/
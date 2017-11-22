package model.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel( NewsItem.class )
public class NewsItem_ {
    public static volatile SingularAttribute<NewsItem, Long> id;
    public static volatile SingularAttribute<NewsItem, String> title;
    public static volatile SingularAttribute<NewsItem, String> extract;
    public static volatile SingularAttribute<NewsItem, Long> authorId;
    public static volatile SingularAttribute<NewsItem, Date> publishDate;
    public static volatile SingularAttribute<NewsItem, String> text;
    public static volatile SingularAttribute<NewsItem, Long> photoId;
    public static volatile SingularAttribute<NewsItem, String> sphere;
    public static volatile SingularAttribute<NewsItem, Integer> urgency;


}


//    private Long id;
//    private String title;
//    private String extract;
//    private Long authorId;
//    private Date publishDate;
//    private String text;
//    private Long photoId;
//    private String sphere;
//    private Integer urgency;





//@StaticMetamodel( Person.class )
//public class Person_ {
//    public static volatile SingularAttribute<Person, Long> id;
//    public static volatile SingularAttribute<Person, String> name;
//    public static volatile SingularAttribute<Person, Integer> age;
//    public static volatile SingularAttribute<Person, Address> address;
//    public static volatile SetAttribute<Person, Order> orders;
//}
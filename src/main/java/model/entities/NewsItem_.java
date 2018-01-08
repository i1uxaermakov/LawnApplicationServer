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
    public static volatile SingularAttribute<NewsItem, String> newsItemtext;
    public static volatile SingularAttribute<NewsItem, Long> photoId;
    public static volatile SingularAttribute<NewsItem, String> sphere;
    public static volatile SingularAttribute<NewsItem, Integer> urgency;
}
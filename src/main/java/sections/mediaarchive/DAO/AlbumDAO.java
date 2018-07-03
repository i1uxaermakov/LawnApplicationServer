package sections.mediaarchive.DAO;

import model.DAO.HibernateUtil;
import sections.mediaarchive.Album;
import sections.mediaarchive.Album_;
import sections.mediaarchive.BriefAlbum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AlbumDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection getBriefAlbums(Date date, int maxResults) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        List<BriefAlbum> briefAlbumList = null;
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BriefAlbum> criteriaQuery = criteriaBuilder.createQuery(BriefAlbum.class);
        Root<Album> albumRoot = criteriaQuery.from(Album.class);
        criteriaQuery.select(
                criteriaBuilder.construct(
                        BriefAlbum.class,
                        albumRoot.get(Album_.albumId),
                        albumRoot.get(Album_.name),
                        albumRoot.get(Album_.mainPhotoLocation)
                )
        );
        criteriaQuery.where(criteriaBuilder.lessThan(albumRoot.get(Album_.publishDate),date));
        criteriaQuery.orderBy(criteriaBuilder.desc(albumRoot.get(Album_.publishDate)));
        briefAlbumList = session.createQuery(criteriaQuery).setMaxResults(maxResults).getResultList();

        transaction.commit();
        return briefAlbumList;
    }

    public Album getAlbumById(Long albumId) throws SQLException {
        Album album = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        album = session.get(Album.class, albumId);
        transaction.commit();
        return album;
    }
}

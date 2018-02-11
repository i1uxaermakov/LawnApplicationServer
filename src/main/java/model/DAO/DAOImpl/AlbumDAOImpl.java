package model.DAO.DAOImpl;

import model.DAO.AlbumDAO;
import model.DAO.HibernateUtil;
import model.entities.Album;
import model.entities.Album_;
import model.entities.wrappers.BriefAlbum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AlbumDAOImpl implements AlbumDAO {
    static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public Collection getBriefAlbums(Date date, int maxResults) {
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
                        albumRoot.get(Album_.eventDate),
                        albumRoot.get(Album_.mainPhotoLocation)
                )
        );
        criteriaQuery.where(criteriaBuilder.lessThan(albumRoot.get(Album_.publishDate),date));
        criteriaQuery.orderBy(criteriaBuilder.desc(albumRoot.get(Album_.publishDate)));
        briefAlbumList = session.createQuery(criteriaQuery).setMaxResults(maxResults).getResultList();

        transaction.commit();
        return briefAlbumList;
    }

    @Override
    public Album getAlbumById(Long albumId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Album album = session.load(Album.class, albumId);
        transaction.commit();
        return album;
    }
}

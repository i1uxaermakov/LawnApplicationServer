package utils.images;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ImageDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Photo getPhotoLocationByName(String name) {
        Session hibSession = null;
        Transaction transaction = null;
        Photo photo = null;

        try{
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Photo.class);
            Root<Photo> photoRoot = criteriaQuery.from(Photo.class);

            criteriaQuery.where(criteriaBuilder.or(
                    criteriaBuilder.equal(photoRoot.get(Photo_.originalPhotoDimensions), name),
                    criteriaBuilder.equal(photoRoot.get(Photo_.thumbnailPhotoLocation), name),
                    criteriaBuilder.equal(photoRoot.get(Photo_.squareThumbnailPhotoLocation), name)
            ));

            List<Photo> list = hibSession.createQuery(criteriaQuery).getResultList();
            transaction.commit();

            if(list.size() != 0) {
                photo = list.get(0);
            }
        }
        catch(HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return photo;
    }
}

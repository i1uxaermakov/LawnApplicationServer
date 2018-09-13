package utils.files;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class FileDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public File getFileByID(Long fileID) {
        Session hibSession = null;
        Transaction transaction = null;
        File file = null;

        try{
            hibSession = sessionFactory.getCurrentSession();
            transaction = hibSession.beginTransaction();
            file = hibSession.get(File.class, new Long(fileID));
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return file;
    }
}

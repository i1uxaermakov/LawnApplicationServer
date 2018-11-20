package utils.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sections.education.schedule.AddSubjectItemServlet;
import utils.HibernateUtil;

public class FileDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger logger = LogManager.getLogger(FileDAO.class);

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
            logger.error("Exception was thrown while getting File by ID. ID=" + fileID,e);
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
        }
        return file;
    }
}

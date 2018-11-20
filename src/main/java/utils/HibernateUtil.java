package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sections.education.schedule.AddSubjectItemServlet;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            logger.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

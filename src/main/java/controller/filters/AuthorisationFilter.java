package controller.filters;

import controller.condition.AppSession;
import controller.condition.SessionController;
import model.DAO.DAOImpl.RememberMeCookieDAOImpl;
import model.DAO.HibernateUtil;
import model.DAO.RememberMeCookieDAO;
import model.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

public class AuthorisationFilter implements Filter {
    private String cookieName;
    private RememberMeCookieDAO rememberMeCookieDAO;
    private static SessionFactory sessionFactory;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        cookieName = filterConfig.getInitParameter("CookieName");
        rememberMeCookieDAO = new RememberMeCookieDAOImpl();
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        SessionController sessionController = SessionController.getSessionController();
        if(!(sessionController.isAuthorised(request.getSession(true).getId()))) {
            String cookieValue = null;
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals(cookieName)) {
                    cookieValue = cookie.getValue();
                }
            }
            if(!(cookieValue==null || cookieValue.isEmpty())) {
                Session session = sessionFactory.openSession();
                Long cookieOwner = rememberMeCookieDAO.getRememberMeCookieOwner(cookieValue);
                if(cookieOwner != null) {
                    Transaction transaction = session.getTransaction();
                    User user = session.get(User.class, cookieOwner);
                    transaction.commit();

                    AppSession appSession = new AppSession(
                            user,
                            new Timestamp(System.currentTimeMillis())
                    );
                    sessionController.addSession(request.getSession().getId(), appSession);
                    request.setAttribute("Authorised", true);
                }
                session.close();
            }
        }
        else {
            request.setAttribute("Authorised", true);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

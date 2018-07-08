package security.filters;

import security.DAO.RememberMeCookieDAO;
import utils.HibernateUtil;
import security.entities.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AuthorisationFilter implements Filter {
    private String cookieName;
    private RememberMeCookieDAO rememberMeCookieDAO;
    private static SessionFactory sessionFactory;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        cookieName = filterConfig.getInitParameter("RememberMeCookieName");
        rememberMeCookieDAO = new RememberMeCookieDAO();
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(true);

        if(!((new Boolean(true)).equals(httpSession.getAttribute("Authorised")))) {
            String cookieValue = null;
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (Cookie cookie : cookies) {
//                    System.out.println(cookie.getName());
                    if (cookie.getName().equals(cookieName)) {
                        cookieValue = cookie.getValue();
                    }
                }
            }
            if(!(cookieValue==null || cookieValue.isEmpty())) {
                Session session = sessionFactory.openSession();
                Long cookieOwner = null;

                try {
                    cookieOwner = rememberMeCookieDAO.getRememberMeCookieOwner(cookieValue);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(cookieOwner != null) {
                    Transaction transaction = session.beginTransaction();
                    User user = session.get(User.class, cookieOwner);
                    transaction.commit();

                    httpSession.setAttribute("User", user);
                    httpSession.setAttribute("Authorised", true);
                    filterChain.doFilter(servletRequest,servletResponse);
                }
                session.close();
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

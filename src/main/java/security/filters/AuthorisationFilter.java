package security.filters;

import org.apache.commons.codec.digest.DigestUtils;
import security.DAO.RememberMeCookieDAO;
import security.DAO.UserDAO;
import security.entities.RememberMeCookie;
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
import java.util.Objects;

public class AuthorisationFilter implements Filter {
    private String cookieName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        cookieName = filterConfig.getInitParameter("RememberMeCookieName");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(true);

        if(!((new Boolean(true)).equals(httpSession.getAttribute("Authorised")))) {
            String cookieValue = null;
            Cookie[] cookies = request.getCookies();
            if(Objects.nonNull(cookies)) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(cookieName)) {
                        cookieValue = cookie.getValue();
                    }
                }
            }
            if(Objects.nonNull(cookieValue) && cookieValue.length()==77) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                String selector = cookieValue.substring(0,12);
                String validator = cookieValue.substring(13,cookieValue.length());

                RememberMeCookie rememberMeCookie = RememberMeCookieDAO.getRememberMeCookieBySelector(selector);
                if(Objects.nonNull(rememberMeCookie)) {

                    if(rememberMeCookie.getHashedValidator().equals(DigestUtils.sha256Hex(validator))) {
                        User user = UserDAO.getUserById(rememberMeCookie.getUserId());
                        if(Objects.nonNull(user)) {
                            httpSession.setAttribute("User", user);
                            httpSession.setAttribute("Authorised", true);
                        }
                    }
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

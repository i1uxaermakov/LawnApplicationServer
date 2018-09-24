package account.filters;

import org.apache.commons.codec.digest.DigestUtils;
import account.DAO.RememberMeCookieDAO;
import account.DAO.UserDAO;
import account.entities.RememberMeCookie;
import utils.HibernateUtil;
import account.entities.User;
import org.hibernate.Session;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AuthorisationFilter implements Filter {
    private String cookieName;
    private List<String> pathBeginnings;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        cookieName = filterConfig.getInitParameter("RememberMeCookieName");
        String paths = filterConfig.getInitParameter("StaticFilesStringPatterns");
        String[] pathsArray = paths.split(";");
        pathBeginnings = new ArrayList<>(Arrays.asList(pathsArray));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(true);

        String requestedURI = request.getRequestURI();
        boolean isStatic = false;
        for(String path: pathBeginnings) {
            if(requestedURI.startsWith(path)) {
                isStatic = true;
            }
        }

        if(!isStatic) {
            if (!((new Boolean(true)).equals(httpSession.getAttribute("Authorised")))) {
                String cookieValue = null;
                Cookie[] cookies = request.getCookies();
                if (Objects.nonNull(cookies)) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals(cookieName)) {
                            cookieValue = cookie.getValue();
                        }
                    }
                }
                if (Objects.nonNull(cookieValue) && cookieValue.length() == 77) {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    String selector = cookieValue.substring(0, 12);
                    String validator = cookieValue.substring(13, cookieValue.length());

                    RememberMeCookieDAO cookieDAO = new RememberMeCookieDAO();
                    RememberMeCookie rememberMeCookie = cookieDAO.getRememberMeCookieBySelector(selector);
                    if (Objects.nonNull(rememberMeCookie)) {

                        if (rememberMeCookie.getHashedValidator().equals(DigestUtils.sha256Hex(validator))) {
                            UserDAO userDAO = new UserDAO();
                            User user = userDAO.getUserById(rememberMeCookie.getUserId());
                            if (Objects.nonNull(user)) {
                                httpSession.setAttribute("User", user);
                                httpSession.setAttribute("Authorised", true);
                            }
                        }
                    }
                    session.close();
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }



    @Override
    public void destroy() {

    }
}

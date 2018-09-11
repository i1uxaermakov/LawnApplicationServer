package security.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import utils.HibernateUtil;
import security.entities.RememberMeCookie;
import security.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import security.DAO.RememberMeCookieDAO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

public class SignOutServlet extends HttpServlet {
    String rememberMeCookieName;

    @Override
    public void init() throws ServletException {
        super.init();
        rememberMeCookieName = getServletContext().getInitParameter("RememberMeCookieName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if(Objects.nonNull(httpSession) && (new Boolean(true)).equals(httpSession.getAttribute("Authorised"))) {
            User user = (User) httpSession.getAttribute("User");
            Cookie[] cookies = req.getCookies();
            String cookieValue = null;
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals(rememberMeCookieName)) {
                    cookieValue = cookie.getValue();
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }

            if(Objects.nonNull(cookieValue) && cookieValue.length()==77) { //12+:+64
                Session session = HibernateUtil.getSessionFactory().openSession();
                String selector = cookieValue.substring(0,12);
                String validator = cookieValue.substring(13,cookieValue.length());

                RememberMeCookie rememberMeCookie = RememberMeCookieDAO.getRememberMeCookieBySelector(selector);
                if(Objects.nonNull(rememberMeCookie)) {
                    if(rememberMeCookie.getHashedValidator().equals(DigestUtils.sha256Hex(validator))) {
                        RememberMeCookieDAO.deleteRememberMeCookie(rememberMeCookie);
                    }
                }

                session.close();
            }
            httpSession.invalidate();
        }
        resp.sendRedirect("/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

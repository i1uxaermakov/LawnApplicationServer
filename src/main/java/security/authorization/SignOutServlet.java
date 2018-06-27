package security.authorization;

import model.DAO.HibernateUtil;
import model.entities.RememberMeCookie;
import model.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import security.DAO.RememberMeCookieDAO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    String rememberMeCookieName;

    @Override
    public void init() throws ServletException {
        super.init();
        rememberMeCookieName = getInitParameter("RememberMeCookieName");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if(httpSession != null && (new Boolean(true)).equals(httpSession.getAttribute("Authorised"))) {
            User user = (User) httpSession.getAttribute("User");
            Cookie[] cookies = req.getCookies();
            String cookieValue = null;
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals(rememberMeCookieName)) {
                    cookieValue = cookie.getValue();
                    cookie.setMaxAge(0);
                }
            }

            if(cookieValue!=null) {
                RememberMeCookieDAO rememberMeCookieDAO = new RememberMeCookieDAO();
                Session session = HibernateUtil.getSessionFactory().openSession();

                RememberMeCookie rememberMeCookie = rememberMeCookieDAO.getRememberMeCookieByUserId(user.getUserId());
                Transaction transaction = session.beginTransaction();
                session.delete(rememberMeCookie);
                transaction.commit();

                session.close();
            }
            httpSession.invalidate();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

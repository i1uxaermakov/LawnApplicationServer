package security.authorization;

import org.springframework.security.crypto.bcrypt.BCrypt;
import security.DAO.UserDAO;
import security.UpdatableBCrypt;
import utils.HibernateUtil;
import security.entities.RememberMeCookie;
import security.entities.User;
import security.entities.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Enumeration;

@MultipartConfig
public class SignInServlet extends HttpServlet {
    String rememberMeCookieName;

    @Override
    public void init() throws ServletException {
        super.init();
        rememberMeCookieName = getInitParameter("RememberMeCookieName");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((new Boolean(true)).equals(req.getSession().getAttribute("Authorised"))) {
            resp.sendRedirect("/");
        }
        else {
            resp.setStatus(401);
            req.getRequestDispatcher("/WEB-INF/JSP/authorisation/SignInPageVisualizerJSP.jsp").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkUserSignInInfo(req,resp)) {
            resp.sendRedirect("/");
        }
        else {
            resp.setStatus(401);
        }
    }
    //todo if user has multiple remembermecookies on various devices
    boolean checkUserSignInInfo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        Enumeration parameterNames = request.getParameterNames();
        String lyceumId = null, password = null, rememberme = null;
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            if(parameterName.equals("login")) {
                lyceumId = request.getParameter(parameterName);
            }
            else if(parameterName.equals("password")) {
                password = request.getParameter(parameterName);
            }
            else if(parameterName.equals("rememberme")) {
                rememberme = request.getParameter("rememberme");
            }
        }

        if(lyceumId==null || password==null || "".equals(lyceumId) || "".equals(password)) {
            response.setStatus(401);
        }
        else {
            UserDAO userDAO = new UserDAO();
            UserLoginInfo userLoginInfo = null;
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                userLoginInfo = userDAO.getUserSignInfoByLyceumId(lyceumId);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(userLoginInfo==null) {
                response.setStatus(401);
            }
            else {
                UpdatableBCrypt bCrypt = new UpdatableBCrypt(12);
                if(bCrypt.verifyHash(password, userLoginInfo.getPassword())) {
                    User user = null;

                    Transaction transaction = session.beginTransaction();
                    user = session.get(User.class, userLoginInfo.getUserId());
                    transaction.commit();

                    if("true".equals(rememberme)) {
                        String sessionId = request.getSession().getId();
                        MessageDigest md = null;
                        try {
                            md = MessageDigest.getInstance("MD5");
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                        md.update(sessionId.getBytes());
                        byte[] digest = md.digest();
                        String randomToken = DatatypeConverter.printHexBinary(digest).toUpperCase();

                        RememberMeCookie rememberMeCookie = new RememberMeCookie(user.getUserId(), httpSession.getId());
                        Cookie cookie = new Cookie(rememberMeCookieName, httpSession.getId());
                        cookie.setMaxAge(60 * 60);
                        response.addCookie(cookie);
                        Transaction transactionCookie = session.beginTransaction();
                        session.persist(rememberMeCookie);
                        transactionCookie.commit();
                    }
                    session.close();

                    httpSession.setAttribute("User", user);
                    httpSession.setAttribute("Authorised", true);
                    return true;
                } else {
                    response.setStatus(401);
                }
            }
            session.close();
        }
        return false;
    }

}

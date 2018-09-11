package security.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.hibernate.SessionFactory;
import security.DAO.RememberMeCookieDAO;
import security.DAO.UserDAO;
import security.UpdatableBCrypt;
import utils.HibernateUtil;
import security.entities.RememberMeCookie;
import security.entities.User;
import security.entities.UserLoginInfo;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

@MultipartConfig
public class SignInServlet extends HttpServlet {
    private static String rememberMeCookieName;
    private static SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        rememberMeCookieName = getServletContext().getInitParameter("RememberMeCookieName");
        sessionFactory = HibernateUtil.getSessionFactory();
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
            UserLoginInfo userLoginInfo = null;
            Session session = HibernateUtil.getSessionFactory().openSession();

            userLoginInfo = UserDAO.getUserSignInfoByLyceumId(lyceumId);

            if(userLoginInfo==null) {
                response.setStatus(401);
            }
            else {
                UpdatableBCrypt bCrypt = new UpdatableBCrypt(12);
                if(bCrypt.verifyHash(password, userLoginInfo.getPassword())) {
                    User user = UserDAO.getUserById(userLoginInfo.getUserId());
                    if("on".equals(rememberme)) {
                        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                                .withinRange('0', 'z')
                                .filteredBy(LETTERS, DIGITS)
                                .build();

                        String selector = generator.generate(12), validator = generator.generate(64);

                        RememberMeCookie rememberMeCookie = new RememberMeCookie();
                        rememberMeCookie.setUserId(user.getUserId());
                        rememberMeCookie.setExpiresDate(new Timestamp(System.currentTimeMillis() + 31556952000L)); //1 year in milliseconds
                        rememberMeCookie.setSelector(selector);
                        rememberMeCookie.setHashedValidator(DigestUtils.sha256Hex(validator));
                        RememberMeCookieDAO.persistRememberMeCookie(rememberMeCookie);

                        Cookie cookie = new Cookie(rememberMeCookieName, selector+":"+validator);
                        cookie.setMaxAge(31556952); //1 year
                        cookie.setHttpOnly(true);
                        response.addCookie(cookie);
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

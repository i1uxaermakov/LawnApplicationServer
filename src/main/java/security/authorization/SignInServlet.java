package security.authorization;

import model.DAO.DAOImpl.UserDAOImpl;
import model.DAO.HibernateUtil;
import model.DAO.UserDAO;
import model.entities.RememberMeCookie;
import model.entities.User;
import model.entities.wrappers.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

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
            req.getRequestDispatcher("/").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/signin.html").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkUserSignInInfo(req,resp)) {
            req.getRequestDispatcher("/").forward(req, resp);
        }
        else {
            resp.setStatus(400);
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
            response.setStatus(400);
        }
        else {
            UserDAO userDAO = new UserDAOImpl();
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
                if (userLoginInfo.getPassword().equals(password)) {
                    User user = null;

                    Transaction transaction = session.beginTransaction();
                    user = session.get(User.class, userLoginInfo.getUserId());
                    transaction.commit();

                    RememberMeCookie rememberMeCookie = new RememberMeCookie(user.getUserId(), httpSession.getId());
                    Cookie cookie = new Cookie(rememberMeCookieName, httpSession.getId());
                    cookie.setMaxAge(60*5);
                    response.addCookie(cookie);
                    Transaction transactionCookie = session.beginTransaction();
                    session.persist(rememberMeCookie);
                    transactionCookie.commit();

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

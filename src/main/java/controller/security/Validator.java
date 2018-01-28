package controller.security;

import controller.condition.AppSession;
import controller.condition.SessionController;
import model.DAO.DAOImpl.UserDAOImpl;
import model.DAO.HibernateUtil;
import model.DAO.UserDAO;
import model.entities.User;
import model.entities.wrappers.UserLoginInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;


public class Validator {

    private static SessionController sessionController = SessionController.getSessionController();

    boolean checkUserSignInInfo(HttpServletRequest request, HttpServletResponse response) {

        HttpSession httpSession = request.getSession(true);

//        Cookie[] cookies = null;
//        cookies = request.getCookies();

        Enumeration parameterNames = request.getParameterNames();
        String lyceumId = null, password = null;
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            if(parameterName.equals("login")) {
                lyceumId = request.getParameter(parameterName);
            }
            else if(parameterName.equals("password")) {
                password = request.getParameter(parameterName);
            }
        }

        if(lyceumId==null || password==null) {
            response.setStatus(400);
        }
        else {
            UserDAO userDAO = new UserDAOImpl();
            UserLoginInfo userLoginInfo = null;

            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                userLoginInfo = userDAO.getUserSignInfoByLyceumId(session, lyceumId);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(userLoginInfo==null) {
                response.setStatus(401);
            }
            else {
                if (userLoginInfo.getPassword().equals(password)) {
                    Transaction transaction = session.beginTransaction();
                    User user = session.load(User.class, userLoginInfo.getUserId());
                    AppSession appSession = new AppSession(
                            user,
                            new Timestamp(System.currentTimeMillis())
                    );
                    sessionController.addSession(httpSession.getId(), appSession);

                    System.out.println(appSession.toString());
                    session.close();
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

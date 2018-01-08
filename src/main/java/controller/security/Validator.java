package controller.security;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import controller.condition.AppSession;
import controller.condition.SessionController;
import model.DAO.DAOImpl.UserDAOImpl;
import model.DAO.UserDAO;
import model.entities.wrappers.UserLoginInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
//import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Random;

public class Validator {

    private static SessionController sessionController = SessionController.getSessionController();

    boolean checkUserSignInInfo(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(true);

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

//        for(Cookie cookie: cookies) {
//            if(cookie.getName().equals("login")) {
//                lyceumId = cookie.getValue();
//            }
//            else if(cookie.getName().equals("password")) {
//                password = cookie.getValue();
//            }
//        }

        if(lyceumId.equals(null) || password.equals(null)) {
            response.setStatus(400);
            return false;
//            Bad request
        }
        else {
            UserDAO userDAO = new UserDAOImpl();
            UserLoginInfo userLoginInfo = null;

            try {
                userLoginInfo = userDAO.getUserSignInfoByLyceumId(lyceumId);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(userLoginInfo==null) {
                response.setStatus(401);
                return false;
            }

            if(userLoginInfo.getPassword().equals(password)) {
//                SessionController sessionController = SessionController.getSessionController();
                AppSession appSession = new AppSession(
                        session.getId(),
                        userLoginInfo.getUserId(),
                        userLoginInfo.getPrivileges(),
                        new Timestamp(System.currentTimeMillis()));
                sessionController.addSession(appSession);

                response.addCookie(new Cookie("ss_id", session.getId()));
                return true;
            }
            else {
                response.setStatus(401);
                return false;
//                Unauthorized
            }
        }
    }

}

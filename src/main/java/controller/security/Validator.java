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
import java.sql.SQLException;
//import java.time.LocalDateTime;
import java.util.Random;

public class Validator {

    private static Validator validator;

    public static Validator getValidator() {
        if(validator.equals(null)) {
            validator = new Validator();
        }
        return validator;
    }

    void checkUserSignInInfo(HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = null;
        cookies = request.getCookies();

        String lyceumId = null, password = null;
        for(Cookie cookie: cookies) {
            if(cookie.getName().equals("login")) {
                lyceumId = cookie.getValue();
            }
            else if(cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }

        if(lyceumId.equals(null) || password.equals(null)) {
            response.setStatus(400);
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

            if(userLoginInfo.getPassword().equals(password)) {
                SessionController sessionController = SessionController.getSessionController();
                long integer = (new Random()).nextInt(10000);
                AppSession session = new AppSession(
                        request.getSession().getId(),
                        userLoginInfo.getUserId(),
                        null,
                        System.currentTimeMillis());
                sessionController.addSession(session);
                //                        (int)(new Random()).nextInt(10000),
            }
            else {
                response.setStatus(401);
//                Unauthorized
            }
        }
    }

}

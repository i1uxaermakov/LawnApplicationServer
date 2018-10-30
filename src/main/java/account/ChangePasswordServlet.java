package account;

import account.DAO.UserDAO;
import account.authorization.UpdatableBCrypt;
import account.entities.User;
import org.hibernate.Session;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/*
*   Maximum of request size is 500 Kilobytes
* */
@MultipartConfig(fileSizeThreshold=0, maxFileSize=1024*500, maxRequestSize=1024*500)
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");

        String oldPasswordParameter = req.getParameter("oldpass");
        String newPasswordParameter = req.getParameter("newpass");
        if(Objects.isNull(oldPasswordParameter) || Objects.isNull(newPasswordParameter)) {
            resp.setStatus(400);
            resp.getWriter().println("No old or new password provided!");
            return;
        }

        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt(12);
        if(updatableBCrypt.verifyHash(oldPasswordParameter, user.getPassword())) {
            user.setPassword(updatableBCrypt.hash(newPasswordParameter));
            Session hibSession = HibernateUtil.getSessionFactory().openSession();
            UserDAO userDAO = new UserDAO();
            userDAO.updateUser(user);
            hibSession.close();
        }
        else {
            resp.setStatus(403);
            resp.getWriter().println("Incorrect password!");
            return;
        }
    }
}

package utils.files;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import account.DAO.UserDAO;
import account.entities.User;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@MultipartConfig
public class FavoriteFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");

        String fileID = req.getParameter("fid");
        if(Objects.isNull(fileID) || !StringUtils.isNumeric(fileID)) {
            resp.setStatus(400);
            return;
        }
        String purpose = req.getParameter("purpose");
        if(!"add".equals(purpose) && !"del".equals(purpose)) {
            resp.setStatus(400);
            return;
        }

        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        FileDAO fileDAO = new FileDAO();
        File file = fileDAO.getFileByID(new Long(fileID));

        UserDAO userDAO = new UserDAO();
        if(Objects.nonNull(file)) {
            if(purpose.equals("add")) {
                if(user.getFavouriteFiles().contains(file)) {
                    resp.getWriter().println("File is already added to Favourites!");
                    return;
                }
                else {
                    user.getFavouriteFiles().add(file);
                    userDAO.updateUser(user);
                    resp.getWriter().println("Successfully added to favorite!");
                }
            }
            else if(purpose.equals("del")) {
                if(user.getFavouriteFiles().contains(file)) {
                    user.getFavouriteFiles().remove(file);
                    userDAO.updateUser(user);
                    resp.getWriter().println("Successfully removed from favorite!");
                }
                else {
                    resp.setStatus(400);
                    hibSession.close();
                    resp.getWriter().println("No file to delete!");
                    return;
                }
            }
        }
        else {
            resp.setStatus(400);
            resp.getWriter().println("No file with the given ID!");
            hibSession.close();
            return;
        }

        hibSession.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        req.setAttribute("lvl", user.getLevel());
        if(req.getParameter("mobile")==null) {
            req.getRequestDispatcher("/WEB-INF/JSP/files/FavoriteFilesPageVisualizer.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/files/FavoriteFileItemsVisualizer.jsp").include(req,resp);
        }
    }
}

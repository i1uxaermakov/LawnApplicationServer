package utils.files;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import security.entities.User;
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
        Transaction transaction = null;
        File file;

        try{
            transaction = hibSession.beginTransaction();
            file = hibSession.get(File.class, new Long(fileID));
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            hibSession.close();
            e.printStackTrace();
            return;
        }

        if(Objects.nonNull(file)) {
            if(purpose.equals("add")) {
                if(user.getFavouriteFiles().contains(file)) {
                    resp.getWriter().println("File is already added to Favourites!");
                    return;
                }
                else {
                    try {
                        user.getFavouriteFiles().add(file);
                        transaction = hibSession.beginTransaction();
                        hibSession.update(user);
                        transaction.commit();
                        resp.getWriter().println("Successfully added to favorite!");
                    }
                    catch (HibernateException e) {
                        transaction.rollback();
                        hibSession.close();
                        e.printStackTrace();
                    }
                }
            }
            else if(purpose.equals("del")) {
                if(user.getFavouriteFiles().contains(file)) {
                    try {
                        user.getFavouriteFiles().remove(file);
                        transaction = hibSession.beginTransaction();
                        hibSession.update(user);
                        transaction.commit();
                        resp.getWriter().println("Successfully removed from favorite!");
                    }
                    catch (HibernateException e) {
                        transaction.rollback();
                        hibSession.close();
                        e.printStackTrace();
                    }
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
            req.getRequestDispatcher("/WEB-INF/JSP/edu/FavoriteFilesPageVisualizer.jsp").include(req,resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/JSP/edu/FavoriteFileItemsVisualizer.jsp").include(req,resp);
        }
    }
}

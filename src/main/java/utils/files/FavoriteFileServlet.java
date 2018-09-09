package utils.files;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import security.entities.User;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class FavoriteFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");

        String fileID = req.getParameter("fid");
        if(Objects.isNull(fileID) || StringUtils.isNumeric(fileID)) {
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
                    resp.getWriter().write("File is already added to Favourites!");
                }
                else {
                    try {
                        user.getFavouriteFiles().add(file);
                        transaction = hibSession.beginTransaction();
                        hibSession.update(user);
                        transaction.commit();
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
                    return;
                }
            }
        }
        else {
            resp.setStatus(400);
            hibSession.close();
            return;
        }

        hibSession.close();
    }
}

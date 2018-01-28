package controller;

import controller.condition.SessionController;
import model.DAO.DAOImpl.NewsDAOImpl;
import model.DAO.HibernateUtil;
import model.entities.User;
import model.entities.wrappers.BriefNewsItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.MainPageViewer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MainPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String path = req.getRequestURI();
//        req.setAttribute("requestedURI", path);
//        System.out.println(path + " controller");
//        if(path.startsWith("/education")) {
//            req.getRequestDispatcher("/EducationSphereServlet").forward(req,resp);
//        }
//        else if(path.startsWith("/social")) {
//            req.getRequestDispatcher("/SocialSphereServlet").forward(req,resp);
//        }
//        else if(path.startsWith("/sport")) {
//            req.getRequestDispatcher("/SportSphereServlet").forward(req,resp);
//        }
//        else if(path.startsWith("/news")) {
//
//        }
//        else {
//    }
        //TODO getting information from DB and representing it (MAIN PAGE)

        PrintWriter printWriter = resp.getWriter();


//        List<BriefNewsItem> briefNewsItemList = null;
//        NewsDAOImpl newsDAO = new NewsDAOImpl();
//
//        try {
//            briefNewsItemList = (List<BriefNewsItem>) newsDAO.getNewsItemsExtracts("all", 10);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            //TODO exceptions handling
//        }
//        req.setAttribute("briefNewsItemList", briefNewsItemList);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx =  session.beginTransaction();

        User user = (User) session.load(User.class, new Long(1));
        printWriter.println(user.toString());
        printWriter.println(req.getSession(true).getId());
        printWriter.println(req.getSession().getLastAccessedTime());

        SessionController sessionController = SessionController.getSessionController();


        if(sessionController.get(req.getSession().getId()) != null) {
            printWriter.println("Authorised");
        }
        else {
            printWriter.println("unauthorised");
        }

        tx.commit();
        session.close();

        printWriter.println();


        //getServletContext().getRequestDispatcher("/myjsp").forward(req,resp);



        //resp.sendRedirect("/myjsp");
//        printWriter.println("BRIEFNEWSITEMSLIST" + "\n");
//        for(BriefNewsItem briefNewsItem: briefNewsItemList) {
//            printWriter.println(briefNewsItem.toString() + "\n\n");
//        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

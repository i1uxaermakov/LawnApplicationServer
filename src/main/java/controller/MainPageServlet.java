package controller;

import model.DAO.AlbumDAO;
import model.DAO.DAOImpl.AlbumDAOImpl;
import model.DAO.DAOImpl.NewsDAOImpl;
import model.DAO.HibernateUtil;
import model.DAO.NewsDAO;
import model.entities.wrappers.BriefAlbum;
import model.entities.wrappers.BriefNewsItem;
import org.hibernate.Session;

import javax.servlet.ServletException;
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
        PrintWriter printWriter = resp.getWriter();



        List<BriefAlbum> briefAlbumList = null;
        List<BriefNewsItem> briefNewsItemList = null;
        NewsDAO newsDAO = new NewsDAOImpl();
        AlbumDAO albumDAO = new AlbumDAOImpl();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            briefNewsItemList = (List<BriefNewsItem>) newsDAO.getBriefNewsItems(session, 10);
            briefAlbumList = (List<BriefAlbum>) albumDAO.getBriefAlbums(session, 4);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO exceptions handling
        }
        session.close();

        req.setAttribute("briefNewsItemList", briefNewsItemList);
        req.setAttribute("briefAlbumList", briefAlbumList);

//        printWriter.println("<html> <body>");
//        for (BriefNewsItem briefNewsItem: briefNewsItemList) {
////            printWriter.println(briefNewsItem.toString());
//            printWriter.println("<t1> <a href=\"/news/"+ briefNewsItem.getId() +"\">"+ briefNewsItem.getTitle() + "</a></t1><br>");
//            printWriter.println(briefNewsItem.getExtract()+"<br>");
//            printWriter.println("<br>");
//        }
//
//        printWriter.println("<br>");
//        printWriter.println("##############");
//        printWriter.println("<br>");
//
//        for (BriefAlbum briefAlbum: briefAlbumList) {
////            printWriter.println(briefAlbum.toString());
//            printWriter.println("<t1> " + briefAlbum.getName() +
//                    "</t1> <br>");
//            printWriter.println("<img src=\"" + briefAlbum.getMainPhotoLocation() +
//                    "\"><br><br>");
//        }
//
//        printWriter.println("</body> </html>");

//        Transaction tx =  session.beginTransaction();
//
//        User user = (User) session.load(User.class, new Long(1));
//        printWriter.println(user.toString());
//        printWriter.println(req.getSession(true).getId());
//        printWriter.println(req.getSession().getLastAccessedTime());
//
//        SessionController sessionController = SessionController.getSessionController();
//
//
//        if(sessionController.get(req.getSession().getId()) != null) {
//            printWriter.println("Authorised");
//        }
//        else {
//            printWriter.println("unauthorised");
//        }
//
//        tx.commit();
//        session.close();

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

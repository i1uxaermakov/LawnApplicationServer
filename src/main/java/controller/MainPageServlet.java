package controller;

import model.DAO.AlbumDAO;
import model.DAO.DAOImpl.AlbumDAOImpl;
import model.DAO.DAOImpl.EventDAOImpl;
import model.DAO.DAOImpl.PostDAOImpl;
import model.DAO.EventDAO;
import model.DAO.HibernateUtil;
import model.DAO.PostDAO;
import model.entities.Event;
import model.entities.Post;
import model.entities.wrappers.BriefAlbum;
import model.entities.wrappers.BriefEvent;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        //List<BriefAlbum> briefAlbumList = null;
        List<Post> postList = null;
        //List<BriefEvent> briefEventList = null;

        //AlbumDAO albumDAO = new AlbumDAOImpl();
        PostDAO postDAO = new PostDAOImpl();
        //EventDAO eventDAO = new EventDAOImpl();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //briefAlbumList = (List<BriefAlbum>) albumDAO.getBriefAlbums(session, new Date(), 4);
            postList = (List<Post>) postDAO.getPosts(session, new Date(), 15);
            //briefEventList = (List<BriefEvent>) eventDAO.getBriefEvents(session, new Date(), 4);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO exceptions handling
        }
//
//        session.close();

        //req.setAttribute("briefNewsItemList", briefNewsItemList);
        //req.setAttribute("briefAlbumList", briefAlbumList);
        req.setAttribute("postList", postList);
//
        req.getRequestDispatcher("MainPageSliderVisualizer.jsp").forward(req,resp);
//
//        for(Post post: postList) {
//            printWriter.println(post.toString());
//            //System.out.println(post.toString());
//        }

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

package controller;

import model.DAO.DAOImpl.NewsDAOImpl;
import model.entities.wrappers.BriefNewsItem;
import view.MainPageViewer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MainPageServlet extends HttpServlet{

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

        List<BriefNewsItem> briefNewsItemList = null;
        NewsDAOImpl newsDAO = new NewsDAOImpl();
        PrintWriter printWriter = resp.getWriter();
        try {
            briefNewsItemList = (List<BriefNewsItem>) newsDAO.getNewsItemsExtracts("mainpage", 10);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO exceptions handling
        }


        printWriter.println("BRIEFNEWSITEMSLIST" + "\n");
        for(BriefNewsItem briefNewsItem: briefNewsItemList) {
            printWriter.println(briefNewsItem.toString() + "\n\n");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

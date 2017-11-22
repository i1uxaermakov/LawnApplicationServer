package controller;

import com.sun.xml.internal.bind.v2.TODO;
import model.DAO.DAOImpl.NewsDAOImpl;
import model.DAO.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EducationSphereServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        resp.getWriter().println("education");

        if(path.contains("/news")) {
            path.replace("/education/news", "");
            NewsDAOImpl newsDAO = new NewsDAOImpl();
            if(path.equals("")) {
//                newsD



                if(req.getHeader("ExpectedType").equals("JSON")) {

                }
            }
            else {

            }
        }
        else if(path.contains("/homework")) {
            //TODO handouts - homework
        }
        else if(path.contains("/timetable")) {
            //TODO timetable for PK and ordinary lessons
        }
        else if(path.contains("/library")) {
            //TODO library with books
        }
        else {
            //TODO NOT FOUND 404 viewer
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}

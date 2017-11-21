package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();
        if(path.contains("/edu")) {
            req.getRequestDispatcher("EducationSphereServlet").forward(req,resp);
        }
        else if(path.contains("/social")) {
            req.getRequestDispatcher("SocialSphereServlet").forward(req,resp);
        }
        else if(path.contains("/sport")) {
            req.getRequestDispatcher("SportSphereServlet").forward(req,resp);
        }
        else {
            resp.getWriter().write("NONONO");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

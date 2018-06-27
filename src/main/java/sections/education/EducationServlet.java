package sections.education;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EducationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();//(String)req.getAttribute("requestedURI");
        resp.getWriter().println("sections/education");
        System.out.println(path);
        path = path.replace("/sections/education", "");


//        lawn.com/sections.education/news/64376

        if(path.equals("/") || path.equals("")) {
            //TODO Education Main Page
        }
        else if(path.startsWith("/homework")) {
            //TODO handouts - homework
        }
        else if(path.startsWith("/timetable")) {
            //TODO timetable for PK and ordinary lessons
        }
        else if(path.startsWith("/library")) {
            //TODO library with books
        }
        else {
            //TODO NOT FOUND 404 viewer
            resp.getWriter().println("404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
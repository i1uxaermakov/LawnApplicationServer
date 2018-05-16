package security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((new Boolean(true)).equals(req.getSession().getAttribute("Authorised"))) {
//            req.getRequestDispatcher("uralredyloggedin.html").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/signin.html").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Validator validator = new Validator();
        if(validator.checkUserSignInInfo(req,resp)) {
        }
        else {
        }
    }

}

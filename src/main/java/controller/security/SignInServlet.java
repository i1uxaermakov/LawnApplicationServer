package controller.security;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Validator validator = new Validator();
        if(validator.checkUserSignInInfo(req,resp)) {
            resp.getWriter().println("YES");
        }
        else {
            resp.getWriter().println("NO");
        }
    }

}

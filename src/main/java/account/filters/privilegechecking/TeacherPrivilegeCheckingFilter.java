package account.filters.privilegechecking;

import account.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class TeacherPrivilegeCheckingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession = request.getSession(false);
        if((new Boolean(true)).equals(httpSession.getAttribute("Authorised"))) {
            User user = (User) httpSession.getAttribute("User");
            Set<String> userPrivileges =  user.getPrivileges();
            if(userPrivileges.contains("teacher")) {
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                response.sendError(403);
            }
        }
        else {
            request.getRequestDispatcher("/signin").forward(request,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

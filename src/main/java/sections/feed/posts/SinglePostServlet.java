package sections.feed.posts;

import utils.HibernateUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.feed.posts.DAO.PostDAO;
import sections.feed.posts.entities.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SinglePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getHeader("User-Agent"));
        String postId = req.getParameter("id");
        Post post = null;
        if(StringUtils.isNumeric(postId)) {
            Session hibSession = HibernateUtil.getSessionFactory().openSession();
            PostDAO postDAO = new PostDAO();
            try {
                post = postDAO.getPostById(new Long(postId));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            hibSession.close();
        }

//        Map<String,Object> mapResp = new HashMap<>();
//        mapResp.put("post", post);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        resp.setContentType("text/html");
//
//        //todo servlet for postalums
//
//        resp.getWriter().println(objectMapper.writeValueAsString(mapResp));
//        System.out.println(objectMapper.writeValueAsString(mapResp));
        //todo include jsp visualization
    }

}

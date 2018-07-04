package sections.feed.posts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import model.DAO.HibernateUtil;
import sections.feed.posts.entities.PostAlbum;
import org.hibernate.Session;
import sections.feed.posts.DAO.PostDAO;
import sections.feed.posts.entities.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Deprecated
public class MultiplePostsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        PostDAO postDAO = new PostDAO();
        List<Post> postList = new ArrayList<>(0);
        String lastSavedDate = req.getParameter("lcd"); //last child's date

        try {
            postList = (List<Post>) postDAO.getPosts(new Timestamp(new Long(lastSavedDate)), 10, "approved");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("postList", postList);
        hibSession.close();
        req.getRequestDispatcher("MultiplePostsVisualizer.jsp").include(req, resp);

//          todo posts jsp visualization
//          todo будем делать укороченную версию или нет
        //  todo каким то образом различать первичный запрос на страницу и запрос на дополнительный контент - сделаем жто через хэдер
    }
}

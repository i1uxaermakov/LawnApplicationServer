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
import sections.feed.posts.model.entities.PostAlbum;
import sections.mediaarchive.Album;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.feed.posts.model.DAO.PostDAO;
import sections.feed.posts.model.entities.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SinglePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

//        System.out.println(post.toString());

//        PropertyFilter postAlbumFilter = new SimpleBeanPropertyFilter() {
//            @Override
//            public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
//                if (include(writer)) {
//                    if (!writer.getName().equals("album")) {
//                        writer.serializeAsField(pojo, jgen, provider);
//                        return;
//                    }
//                    PostAlbum album = ((Post) pojo).getAlbum();
//                    if (!(album==null || album.getAlbumPhotos().size() > 3)) {
//                        writer.serializeAsField(pojo, jgen, provider);
//                    }
//                } else if (!jgen.canOmitFields()) { // since 2.3
//                    writer.serializeAsOmittedField(pojo, jgen, provider);
//                }
//            }
//            @Override
//            protected boolean include(BeanPropertyWriter writer) {
//                return true;
//            }
//            @Override
//            protected boolean include(PropertyWriter writer) {
//                return true;
//            }
//        };
//        FilterProvider filters = new SimpleFilterProvider().addFilter("PostAlbumFilter", postAlbumFilter);
        Map<String,Object> mapResp = new HashMap<>();
        mapResp.put("post", post);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        resp.setContentType("text/html");
//        resp.getWriter().println(objectMapper.writer(filters).writeValueAsString(mapResp));
//        System.out.println(objectMapper.writer(filters).writeValueAsString(mapResp));

        resp.getWriter().println(objectMapper.writeValueAsString(mapResp));
        System.out.println(objectMapper.writeValueAsString(mapResp));
    }

}

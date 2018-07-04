package sections.mediaarchive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.DAO.HibernateUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import sections.mediaarchive.DAO.AlbumDAO;
import sections.mediaarchive.entities.Album;
import sections.mediaarchive.entities.BriefAlbum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class MultipleAlbumsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session hibSession = HibernateUtil.getSessionFactory().openSession();
        String lastChildDate = req.getParameter("lcd");
        AlbumDAO albumDAO = new AlbumDAO();
        List<BriefAlbum>  briefAlbums = new ArrayList<>(0);

        try {
            if (lastChildDate == null) {
                albumDAO.getBriefAlbums(new Date(), 15);
            } else {
                albumDAO.getBriefAlbums(new Timestamp(new Long(lastChildDate)), 15);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

//        Map<String,Object> mapResp = new HashMap<>();
//        mapResp.put("albums", briefAlbums);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        resp.setContentType("text/html");
//        resp.getWriter().println(objectMapper.writeValueAsString(mapResp));
//        System.out.println(objectMapper.writeValueAsString(mapResp));

        hibSession.close();
    }
    //by publishDate
    //на фронте invisible
    //todo с фронта lcd везде пусть передается в виде timestamp
}

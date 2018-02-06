package model.DAO;

import model.entities.Post;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface PostDAO {
    Post getPostById(Session session, Long id) throws SQLException;
    Collection getPosts(Session session, Date date, int maxResults) throws SQLException;
}

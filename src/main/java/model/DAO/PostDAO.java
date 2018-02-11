package model.DAO;

import model.entities.Post;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface PostDAO {
    Post getPostById(Long id) throws SQLException;
    Collection getPosts(Date date, int maxResults) throws SQLException;
}

package sections.feed.posts.model.DAO;

import sections.feed.posts.model.entities.Post;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface PostDAO {
    Post getPostById(Long id) throws SQLException;
    Collection getPosts(Date date, int maxResults, String status) throws SQLException;
}

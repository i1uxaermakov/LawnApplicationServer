package model.DAO;

import model.entities.Album;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface AlbumDAO {
    Collection getBriefAlbums(Session session, Date date, int maxResults) throws SQLException;
    Album getAlbumById(Session session, Long albumId) throws SQLException;
}

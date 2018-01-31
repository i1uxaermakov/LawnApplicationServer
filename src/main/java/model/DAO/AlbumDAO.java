package model.DAO;

import model.entities.Album;
import org.hibernate.Session;

import java.util.Collection;

public interface AlbumDAO {
    Collection getBriefAlbums(Session session, int maxResults);
    Album getAlbumById(Session session, Long albumId);
}

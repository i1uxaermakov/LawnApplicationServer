package model.DAO;

import model.entities.User;
import model.entities.wrappers.UserLoginInfo;
import org.hibernate.Session;

import java.sql.SQLException;

public interface UserDAO {
    UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) throws SQLException;
//    User getUserByLyceumId(String lyceumId) throws SQLException;
}

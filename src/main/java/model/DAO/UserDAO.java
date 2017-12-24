package model.DAO;

import model.entities.wrappers.UserLoginInfo;

import java.sql.SQLException;

public interface UserDAO {
    UserLoginInfo getUserSignInfoByLyceumId(String lyceumId) throws SQLException;
}

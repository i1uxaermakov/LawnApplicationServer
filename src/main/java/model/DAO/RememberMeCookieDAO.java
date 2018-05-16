package model.DAO;

import model.entities.RememberMeCookie;

import java.sql.SQLException;

public interface RememberMeCookieDAO {
    Long getRememberMeCookieOwner(String cookieValue) throws SQLException;
    RememberMeCookie getRememberMeCookieByUserId(Long userId);
}

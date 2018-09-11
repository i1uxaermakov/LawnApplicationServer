package security.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class RememberMeCookie implements Serializable {
    private Long cookieID;
    private Long userId;
    private String selector;
    private String hashedValidator;
    private Timestamp expiresDate;

    public RememberMeCookie() {
    }

    public Long getCookieID() {
        return cookieID;
    }

    public void setCookieID(Long id) {
        this.cookieID = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Timestamp expiresDate) {
        this.expiresDate = expiresDate;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getHashedValidator() {
        return hashedValidator;
    }

    public void setHashedValidator(String hashedValidator) {
        this.hashedValidator = hashedValidator;
    }

    @Override
    public String toString() {
        return "RememberMeCookie{" +
                "cookieID=" + cookieID +
                ", userId=" + userId +
                ", selector='" + selector + '\'' +
                ", hashedValidator='" + hashedValidator + '\'' +
                ", expiresDate=" + expiresDate +
                '}';
    }
}

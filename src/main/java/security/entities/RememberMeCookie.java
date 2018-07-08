package security.entities;

import java.io.Serializable;

public class RememberMeCookie implements Serializable {
    private Long id;
    private Long userId;
    private String cookieValue;

    public RememberMeCookie() {
    }

    public RememberMeCookie(Long userId, String cookieValue) {
        this.userId = userId;
        this.cookieValue = cookieValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }

    @Override
    public String toString() {
        return "RememberMeCookie{" +
                "id=" + id +
                ", userId=" + userId +
                ", cookieValue='" + cookieValue + '\'' +
                '}';
    }
}

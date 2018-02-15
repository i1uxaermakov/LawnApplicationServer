package model.entities;

import java.io.Serializable;

public class RememberMeCookie implements Serializable {
    private Long id;
    private Long userId;
    private String cookieValue;

    public RememberMeCookie() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RememberMeCookie that = (RememberMeCookie) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return cookieValue != null ? cookieValue.equals(that.cookieValue) : that.cookieValue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (cookieValue != null ? cookieValue.hashCode() : 0);
        return result;
    }
}

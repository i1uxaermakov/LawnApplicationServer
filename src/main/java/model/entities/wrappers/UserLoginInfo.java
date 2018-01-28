package model.entities.wrappers;

import java.util.HashSet;
import java.util.Set;

public class UserLoginInfo {
    private Long userId;
    private String lyceumId;
    private String password;

    public UserLoginInfo() {
    }

    public UserLoginInfo(Long userId, String lyceumId, String password) {
        this.userId = userId;
        this.lyceumId = lyceumId;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLyceumId() {
        return lyceumId;
    }

    public void setLyceumId(String lyceumId) {
        this.lyceumId = lyceumId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLoginInfo that = (UserLoginInfo) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (lyceumId != null ? !lyceumId.equals(that.lyceumId) : that.lyceumId != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lyceumId != null ? lyceumId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "userId=" + userId +
                ", lyceumId='" + lyceumId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

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

}

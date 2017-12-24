package model.entities.wrappers;

public class UserLoginInfo {
    private Long userId;
    private String lyceumId;
    private String password;

    public UserLoginInfo(Long userId, String lyceumId, String password) {
        this.userId = userId;
        this.lyceumId = lyceumId;
        this.password = password;
    }

    public UserLoginInfo() {
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

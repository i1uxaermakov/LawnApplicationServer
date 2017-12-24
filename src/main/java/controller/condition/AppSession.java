package controller.condition;

import java.util.Date;
import java.util.Set;

public class AppSession {
    private String sessionId;
    private Long userId;
    private Set privileges;
    private Long lastActiveTime;

    public AppSession(String sessionId, Long userId, Set privileges, Long lastActiveTime) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.privileges = privileges;
        this.lastActiveTime = lastActiveTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set privileges) {
        this.privileges = privileges;
    }

    public Long getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Long lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }
}

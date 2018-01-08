package controller.condition;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class AppSession {
    private String sessionId;
    private Long userId;
    private Set privileges;
    private Timestamp lastActiveTime;

    public AppSession(String sessionId, Long userId, Set privileges, Timestamp lastActiveTime) {
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

    public Timestamp getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Timestamp lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }
}

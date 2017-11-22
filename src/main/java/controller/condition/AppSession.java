package controller.condition;

import java.util.Date;
import java.util.Set;

public class AppSession {
    private Long sessionId;
    private Long userId;
    private Set privileges;
    private Date lastActiveTime;

    public AppSession(Long sessionId, Long userId, Set privileges, Date lastActiveTime) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.privileges = privileges;
        this.lastActiveTime = lastActiveTime;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
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

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }
}

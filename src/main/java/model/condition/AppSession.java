package model.condition;

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
}

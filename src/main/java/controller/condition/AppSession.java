package controller.condition;

import model.entities.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class AppSession {
    private User user;
    private Timestamp lastActiveTime;

    public AppSession(User user, Timestamp lastActiveTime) {
        this.user = user;
        this.lastActiveTime = lastActiveTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Timestamp lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    @Override
    public String toString() {
        return "AppSession{" +
                "user=" + user +
                ", lastActiveTime=" + lastActiveTime +
                '}';
    }
}

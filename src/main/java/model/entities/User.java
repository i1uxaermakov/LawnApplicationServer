package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    private Long userId;
    private Long lyceumId;
    private String firstName;
    private String lastName;
    private Date lastLoginDate;
    private Set privileges = new HashSet();

    public User() {}

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLyceumId() {
        return lyceumId;
    }

    public void setLyceumId(Long lyceumId) {
        this.lyceumId = lyceumId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lyceumId=" + lyceumId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", privileges=" + privileges +
                '}';
    }
}

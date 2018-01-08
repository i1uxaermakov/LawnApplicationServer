package model.entities;

import com.sun.tools.corba.se.idl.StringGen;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    private Long userId;
    private String lyceumId;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp lastLoginDate;
    private Set<String> privileges = new HashSet<String>(0);


    public User() {
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

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (lyceumId != null ? !lyceumId.equals(user.lyceumId) : user.lyceumId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(user.lastLoginDate) : user.lastLoginDate != null)
            return false;
        return privileges != null ? privileges.equals(user.privileges) : user.privileges == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lyceumId != null ? lyceumId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        return result;
    }
}

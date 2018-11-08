package account.entities;

import utils.files.File;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
    private Long userId; //internal
    private String lyceumId; //to login
    private String password; //bcrypted
    private String firstName;
    private String lastName;
    private String fathersName;
    private Long groupId;//??? do i need it
    private String groupName;
    private Long level;
    private Timestamp lastLoginDate;
    private Set<String> privileges = new HashSet<>(0);
    private Set<File> favouriteFiles = new HashSet<>(0);

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<String> privileges) {
        this.privileges = privileges;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getFullName() {
        String fullName = lastName + " " + firstName.substring(0,1) + ".";
        if(Objects.nonNull(fathersName) && fathersName.length()>1) fullName = fullName + fathersName.substring(0,1) + ".";
        return fullName;
    }

    public Set<File> getFavouriteFiles() {
        return favouriteFiles;
    }

    public void setFavouriteFiles(Set<File> favouriteFiles) {
        this.favouriteFiles = favouriteFiles;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    @Override
    public String toString() {
        return "User{" +
                ", lyceumId='" + lyceumId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", level=" + level +
                ", privileges=" + privileges +
                '}';
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
        if (fathersName != null ? !fathersName.equals(user.fathersName) : user.fathersName != null) return false;
        if (groupId != null ? !groupId.equals(user.groupId) : user.groupId != null) return false;
        if (groupName != null ? !groupName.equals(user.groupName) : user.groupName != null) return false;
        if (level != null ? !level.equals(user.level) : user.level != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(user.lastLoginDate) : user.lastLoginDate != null)
            return false;
        if (privileges != null ? !privileges.equals(user.privileges) : user.privileges != null) return false;
        return favouriteFiles != null ? favouriteFiles.equals(user.favouriteFiles) : user.favouriteFiles == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lyceumId != null ? lyceumId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fathersName != null ? fathersName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        result = 31 * result + (favouriteFiles != null ? favouriteFiles.hashCode() : 0);
        return result;
    }
}

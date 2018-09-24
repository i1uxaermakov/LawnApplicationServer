package sections.education.entities;

import account.entities.User;

import java.util.HashSet;
import java.util.Set;

public class LyceumGroup {
    private Long id;
    private String groupName;
    private Long level;
    private Set<User> students = new HashSet<>(0);

    public LyceumGroup() {
    }

    public LyceumGroup(String groupName) {
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LyceumGroup that = (LyceumGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        return level != null ? level.equals(that.level) : that.level == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LyceumGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", level=" + level +
                '}';
    }


}

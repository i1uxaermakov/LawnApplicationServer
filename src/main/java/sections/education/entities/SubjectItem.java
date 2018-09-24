package sections.education.entities;

import java.util.HashSet;
import java.util.Set;

public class SubjectItem implements Comparable<SubjectItem> {
    private Long id;
    private String name;
    private Long groupId;
    private String groupName;
    private Long teacherId;
    private String teacherName;
    private String lectureHall;
    private Set<DayLecture> whenIsSubject= new HashSet<>(0);

    public SubjectItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLectureHall() {
        return lectureHall;
    }

    public void setLectureHall(String lectureHall) {
        this.lectureHall = lectureHall;
    }

    public Set<DayLecture> getWhenIsSubject() {
        return whenIsSubject;
    }

    public void setWhenIsSubject(Set<DayLecture> whenIsSubject) {
        this.whenIsSubject = whenIsSubject;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int compareTo(SubjectItem o) {
        if(this.getId() > o.getId()) {
            return 1;
        }
        else if(this.getId() < o.getId()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "SubjectItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", lectureHall='" + lectureHall + '\'' +
                ", whenIsSubject=" + whenIsSubject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectItem that = (SubjectItem) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (lectureHall != null ? !lectureHall.equals(that.lectureHall) : that.lectureHall != null) return false;
        return whenIsSubject != null ? whenIsSubject.equals(that.whenIsSubject) : that.whenIsSubject == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (lectureHall != null ? lectureHall.hashCode() : 0);
        result = 31 * result + (whenIsSubject != null ? whenIsSubject.hashCode() : 0);
        return result;
    }
}

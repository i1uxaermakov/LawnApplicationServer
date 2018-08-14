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
}

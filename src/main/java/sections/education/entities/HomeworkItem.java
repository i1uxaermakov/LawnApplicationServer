package sections.education.entities;

import org.apache.commons.text.StringEscapeUtils;
import utils.files.File;
import utils.images.Photo;

import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;

public class HomeworkItem implements Comparable<HomeworkItem> {
    private Long hw_id;
    private Long addedById;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;
    private String subjectName;
    private String teacherName;
    private String description;
    private Timestamp publishDate;
    private Timestamp deadlineDate;
    private Set<File> files = new TreeSet<>();
    private Set<Photo> photos = new TreeSet<>();

    public HomeworkItem() {
    }

    public Long getHw_id() {
        return hw_id;
    }

    public void setHw_id(Long id) {
        this.hw_id = id;
    }

    public Long getAddedById() {
        return addedById;
    }

    public void setAddedById(Long addedById) {
        this.addedById = addedById;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int compareTo(HomeworkItem o) {
        return this.getDeadlineDate().compareTo(o.getDeadlineDate());
    }

    @Override
    public String toString() {
        return "HomeworkItem{" +
                "hw_id=" + hw_id +
                ", addedById=" + addedById +
                ", teacherId=" + teacherId +
                ", groupId=" + groupId +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                ", deadlineDate=" + deadlineDate +
                ", files=" + files +
                ", photos=" + photos +
                '}';
    }
}
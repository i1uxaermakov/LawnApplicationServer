package sections.education.entities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeworkItem that = (HomeworkItem) o;

        if (hw_id != null ? !hw_id.equals(that.hw_id) : that.hw_id != null) return false;
        if (addedById != null ? !addedById.equals(that.addedById) : that.addedById != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (subjectId != null ? !subjectId.equals(that.subjectId) : that.subjectId != null) return false;
        if (subjectName != null ? !subjectName.equals(that.subjectName) : that.subjectName != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (deadlineDate != null ? !deadlineDate.equals(that.deadlineDate) : that.deadlineDate != null) return false;
        if (files != null ? !files.equals(that.files) : that.files != null) return false;
        return photos != null ? photos.equals(that.photos) : that.photos == null;
    }

    @Override
    public int hashCode() {
        int result = hw_id != null ? hw_id.hashCode() : 0;
        result = 31 * result + (addedById != null ? addedById.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (deadlineDate != null ? deadlineDate.hashCode() : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        return result;
    }
}
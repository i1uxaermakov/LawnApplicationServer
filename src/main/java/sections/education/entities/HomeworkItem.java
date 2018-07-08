package sections.education.entities;

import utils.filemanagement.File;

import java.sql.Date;
import java.util.Set;

public class HomeworkItem implements Comparable<HomeworkItem> {
    private Long hw_id;
    private Long teacherId;
    private Long groupId;
    private Long subjectId;
    private String subjectName;
    private String teacherName;
    private String description;
    private Date publishDate;
    private Date deadlineDate;
    private Set<File> files;
    private HWAlbum hwAlbum;

    public HomeworkItem() {
    }

    public Long getHw_id() {
        return hw_id;
    }

    public void setHw_id(Long id) {
        this.hw_id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public HWAlbum getHwAlbum() {
        return hwAlbum;
    }

    public void setHwAlbum(HWAlbum hwAlbum) {
        this.hwAlbum = hwAlbum;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    @Override
    public int compareTo(HomeworkItem o) {
        return this.getDeadlineDate().compareTo(o.getDeadlineDate());
    }
}
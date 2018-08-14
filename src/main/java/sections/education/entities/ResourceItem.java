package sections.education.entities;

import utils.files.File;

import java.util.Date;

public class ResourceItem {
    private Long resourceItemId;
    private File file;
    private SubjectResourceCategory subjectCategory;
    private String addedBy;
    private Date publishDate;

    public ResourceItem() {
    }

    public ResourceItem(File file, SubjectResourceCategory subjectCategory, String addedBy, Date publishDate) {
        this.file = file;
        this.subjectCategory = subjectCategory;
        this.addedBy = addedBy;
        this.publishDate = publishDate;
    }

    public Long getResourceItemId() {
        return resourceItemId;
    }

    public void setResourceItemId(Long resourceItemId) {
        this.resourceItemId = resourceItemId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public SubjectResourceCategory getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectResourceCategory subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

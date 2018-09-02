package sections.education.entities;

import utils.files.File;

import java.sql.Timestamp;

public class ResourceItem {
    private Long resourceItemId;
    private File file;
    private Long subjectResourceCategoryId;
    private String addedBy;
    private Timestamp publishDate;

    public ResourceItem() {
    }

    public ResourceItem(File file, Long subjectResourceCategoryId, String addedBy, Timestamp publishDate) {
        this.file = file;
        this.subjectResourceCategoryId = subjectResourceCategoryId;
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

    public Long getSubjectResourceCategoryId() {
        return subjectResourceCategoryId;
    }

    public void setSubjectResourceCategoryId(Long subjectResourceCategoryId) {
        this.subjectResourceCategoryId = subjectResourceCategoryId;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }
}

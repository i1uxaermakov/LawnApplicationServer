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

    @Override
    public String toString() {
        return "ResourceItem{" +
                "resourceItemId=" + resourceItemId +
                ", file=" + file +
                ", subjectResourceCategoryId=" + subjectResourceCategoryId +
                ", addedBy='" + addedBy + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceItem that = (ResourceItem) o;

        if (resourceItemId != null ? !resourceItemId.equals(that.resourceItemId) : that.resourceItemId != null)
            return false;
        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (subjectResourceCategoryId != null ? !subjectResourceCategoryId.equals(that.subjectResourceCategoryId) : that.subjectResourceCategoryId != null)
            return false;
        if (addedBy != null ? !addedBy.equals(that.addedBy) : that.addedBy != null) return false;
        return publishDate != null ? publishDate.equals(that.publishDate) : that.publishDate == null;
    }

    @Override
    public int hashCode() {
        int result = resourceItemId != null ? resourceItemId.hashCode() : 0;
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (subjectResourceCategoryId != null ? subjectResourceCategoryId.hashCode() : 0);
        result = 31 * result + (addedBy != null ? addedBy.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        return result;
    }
}

package sections.education.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class SubjectResourceCategory {
    private Long categoryId;
    private Timestamp creationDate;
    private Long course;
    private String categoryName;
    private Set<ResourceItem> resourceItems = new HashSet<>(0);

    public SubjectResourceCategory() {
    }

    public SubjectResourceCategory(Timestamp creationDate, Long course, String categoryName, Set<ResourceItem> resourceItems) {
        this.creationDate = creationDate;
        this.course = course;
        this.categoryName = categoryName;
        this.resourceItems = resourceItems;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Set<ResourceItem> getResourceItems() {
        return resourceItems;
    }

    public void setResourceItems(Set<ResourceItem> resourceItems) {
        this.resourceItems = resourceItems;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

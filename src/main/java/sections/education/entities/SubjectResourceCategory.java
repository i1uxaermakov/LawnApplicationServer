package sections.education.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SubjectResourceCategory implements Comparable<SubjectResourceCategory>{
    private Long categoryId;
    private Timestamp creationDate;
    private Long course;
    private String categoryName;
    private Set<ResourceItem> resourceItems = new HashSet<>(0);

    public SubjectResourceCategory() {
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
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

    @Override
    public int compareTo(SubjectResourceCategory o) {
        int result = (int)(this.getCourse()-o.getCourse());
        if(result != 0) {
            return result;
        }
        else {
            return this.getCreationDate().compareTo(o.getCreationDate());
        }
    }

    @Override
    public String toString() {
        return "SubjectResourceCategory{" +
                "categoryId=" + categoryId +
                ", creationDate=" + creationDate +
                ", course=" + course +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectResourceCategory category = (SubjectResourceCategory) o;

        if (categoryId != null ? !categoryId.equals(category.categoryId) : category.categoryId != null) return false;
        if (creationDate != null ? !creationDate.equals(category.creationDate) : category.creationDate != null)
            return false;
        if (course != null ? !course.equals(category.course) : category.course != null) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        return resourceItems != null ? resourceItems.equals(category.resourceItems) : category.resourceItems == null;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (resourceItems != null ? resourceItems.hashCode() : 0);
        return result;
    }
}

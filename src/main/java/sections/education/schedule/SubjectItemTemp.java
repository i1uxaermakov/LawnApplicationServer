package sections.education.schedule;

import sections.education.entities.SubjectItem;

public class SubjectItemTemp implements Comparable<SubjectItemTemp>{
    private SubjectItem subjectItem;
    private Long forSubgroup;

    public SubjectItemTemp(SubjectItem subjectItem, Long forSubgroup) {
        this.subjectItem = subjectItem;
        this.forSubgroup = forSubgroup;
    }

    public SubjectItem getSubjectItem() {
        return subjectItem;
    }

    public void setSubjectItem(SubjectItem subjectItem) {
        this.subjectItem = subjectItem;
    }

    public Long getForSubgroup() {
        return forSubgroup;
    }

    public void setForSubgroup(Long forSubgroup) {
        this.forSubgroup = forSubgroup;
    }

    @Override
    public int compareTo(SubjectItemTemp o) {
        if(this.getForSubgroup() < o.getForSubgroup()) {
            return 1;
        }
        else if(this.getForSubgroup() > o.getForSubgroup()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectItemTemp that = (SubjectItemTemp) o;

        if (subjectItem != null ? !subjectItem.equals(that.subjectItem) : that.subjectItem != null) return false;
        if (forSubgroup != null ? !forSubgroup.equals(that.forSubgroup) : that.forSubgroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectItem != null ? subjectItem.hashCode() : 0;
        result = 31 * result + (forSubgroup != null ? forSubgroup.hashCode() : 0);
        return result;
    }
}
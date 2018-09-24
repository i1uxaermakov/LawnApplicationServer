package sections.education.schedule;

public class TeacherInfo {
    private Long teacherUserID;
    private String firstName;
    private String lastName;
    private String fathersName;

    public TeacherInfo() {
    }

    public TeacherInfo(Long teacherUserID, String firstName, String lastName) {
        this.teacherUserID = teacherUserID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TeacherInfo(Long teacherUserID, String firstName, String lastName, String fathersName) {
        this.teacherUserID = teacherUserID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fathersName = fathersName;
    }

    public Long getTeacherUserID() {
        return teacherUserID;
    }

    public void setTeacherUserID(Long teacherUserID) {
        this.teacherUserID = teacherUserID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getFullName() {
        return lastName + " " + firstName.substring(0,1) + "." + fathersName.substring(0,1) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInfo that = (TeacherInfo) o;

        if (teacherUserID != null ? !teacherUserID.equals(that.teacherUserID) : that.teacherUserID != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return fathersName != null ? fathersName.equals(that.fathersName) : that.fathersName == null;
    }

    @Override
    public int hashCode() {
        int result = teacherUserID != null ? teacherUserID.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fathersName != null ? fathersName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherUserID=" + teacherUserID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                '}';
    }
}

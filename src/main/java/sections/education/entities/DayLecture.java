package sections.education.entities;

public class DayLecture {
    private Long id;
    private Long day;
    private Long lectureOrder;

    public DayLecture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getLectureOrder() {
        return lectureOrder;
    }

    public void setLectureOrder(Long lectureOrder) {
        this.lectureOrder = lectureOrder;
    }
}

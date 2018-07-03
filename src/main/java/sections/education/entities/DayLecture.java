package sections.education.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DayLecture {
    @JsonIgnore
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

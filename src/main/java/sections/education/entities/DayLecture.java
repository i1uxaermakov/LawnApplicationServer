package sections.education.entities;

public class DayLecture implements Comparable<DayLecture>{
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

    @Override
    public int compareTo(DayLecture o) {
        if(this.getDay() >  o.getDay()) {
            return 1;
        }
        else if(this.getDay() < o.getDay()) {
            return -1;
        }
        else {
            if(this.getLectureOrder() > o.getLectureOrder()) {
                return 1;
            }
            else if(this.getLectureOrder() < o.getLectureOrder()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}

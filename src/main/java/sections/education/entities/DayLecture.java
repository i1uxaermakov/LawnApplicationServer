package sections.education.entities;

public class DayLecture implements Comparable<DayLecture>{
    private Long id;
    private Long day;
    private Long lectureOrder;
    private String venue;

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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
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

    @Override
    public String toString() {
        return "DayLecture{" +
                "id=" + id +
                ", day=" + day +
                ", lectureOrder=" + lectureOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayLecture that = (DayLecture) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        if (lectureOrder != null ? !lectureOrder.equals(that.lectureOrder) : that.lectureOrder != null) return false;
        return venue != null ? venue.equals(that.venue) : that.venue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (lectureOrder != null ? lectureOrder.hashCode() : 0);
        return result;
    }
}

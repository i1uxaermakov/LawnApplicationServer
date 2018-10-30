package sections.education.schedule;

public class DayLectureTemp {
    private long day;
    private long lecture;

    public DayLectureTemp(long day, long lecture) {
        this.day = day;
        this.lecture = lecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayLectureTemp that = (DayLectureTemp) o;

        if (day != that.day) return false;
        if (lecture != that.lecture) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (day ^ (day >>> 32));
        result = 31 * result + (int) (lecture ^ (lecture >>> 32));
        return result;
    }
}
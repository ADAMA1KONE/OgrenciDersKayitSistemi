package ogrenci.kayit;

import java.util.Objects;

public class Course implements Schedulable {
    private final String code;
    private final String title;
    private final String schedule;

    public Course(String code, String title, String schedule) {
        if (code == null || code.isBlank()) throw new IllegalArgumentException("code required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
        if (schedule == null || schedule.isBlank()) throw new IllegalArgumentException("schedule required");
        this.code = code.trim();
        this.title = title.trim();
        this.schedule = schedule.trim();
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }

    @Override
    public String getSchedule() { return schedule; }

    public String getInfo() {
        return code + " - " + title + " (" + schedule + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course c = (Course) o;
        return Objects.equals(code, c.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

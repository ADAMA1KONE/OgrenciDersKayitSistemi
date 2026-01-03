package ogrenci.kayit;

import java.util.Objects;

/**
 * Ders bilgilerini tutan sınıf (kod, başlık ve program).
 */

public class Course implements Schedulable {
    private final String code;
    private final String title;
    private final String schedule; // ex: "Mon 10:00-12:00"
    private Instructor instructor; // ✅ Eğitmen

    public Course(String code, String title, String schedule) {
        this(code, title, schedule, null);
    }

    // ✅ nouveau constructeur avec instructor
    public Course(String code, String title, String schedule, Instructor instructor) {
        this.code = code;
        this.title = title;
        this.schedule = schedule;
        this.instructor = instructor;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }

    @Override
    public String getSchedule() { return schedule; }

    public Instructor getInstructor() { return instructor; }

    // ✅ Eğitmen atama
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getInfo() {
        String ins = (instructor == null) ? "Eğitmen: Yok" : "Eğitmen: " + instructor.getName();
        return code + " - " + title + " (" + schedule + ") | " + ins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

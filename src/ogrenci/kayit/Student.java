package ogrenci.kayit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private final int id;
    private final String name;
    private final List<Course> courses = new ArrayList<>();

    public Student(int id, String name) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        this.id = id;
        this.name = name.trim();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public RegisterResult registerCourse(Course course) {
        if (course == null) return RegisterResult.INVALID;

        if (courses.contains(course)) return RegisterResult.DUPLICATE;

        for (Course c : courses) {
            if (c.getSchedule().equals(course.getSchedule())) {
                return RegisterResult.SCHEDULE_CONFLICT;
            }
        }

        courses.add(course);
        return RegisterResult.SUCCESS;
    }

    public boolean dropCourse(Course course) {
        if (course == null) return false;
        return courses.remove(course);
    }
}

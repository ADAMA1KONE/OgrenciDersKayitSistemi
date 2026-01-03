package ogrenci.kayit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Sistemde mevcut olan derslerin listesini yöneten sınıftır.
 */


public class CourseCatalog {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course == null) return;
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(courses);
    }

    public Course findByCode(String code) {
        if (code == null) return null;
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}

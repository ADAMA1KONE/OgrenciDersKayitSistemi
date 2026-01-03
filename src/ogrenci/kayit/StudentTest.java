package ogrenci.kayit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// Student sınıfı için temel unit test senaryoları
/**
 * StudentTest sınıfı,
 * Student sınıfının işlevlerini JUnit ile test eder.
 */



public class StudentTest {

    @Test
    void shouldRegisterCourseSuccessfully() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        RegisterResult r = s.registerCourse(c1);

        assertEquals(RegisterResult.SUCCESS, r);
        assertEquals(1, s.getCourses().size());
    }

    @Test
    void shouldRejectDuplicateCourse() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        s.registerCourse(c1);
        RegisterResult r2 = s.registerCourse(c1);

        assertEquals(RegisterResult.DUPLICATE, r2);
        assertEquals(1, s.getCourses().size());
    }

    @Test
    void shouldRejectScheduleConflict() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");
        Course c2 = new Course("CS102", "OOP", "Mon 10:00-12:00"); // même horaire

        assertEquals(RegisterResult.SUCCESS, s.registerCourse(c1));
        assertEquals(RegisterResult.SCHEDULE_CONFLICT, s.registerCourse(c2));
        assertEquals(1, s.getCourses().size());
    }

    @Test
    void shouldDropCourseSuccessfully() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        s.registerCourse(c1);
        boolean removed = s.dropCourse(c1);

        assertTrue(removed);
        assertEquals(0, s.getCourses().size());
    }
}

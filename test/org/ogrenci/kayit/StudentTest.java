package ogrenci.kayit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Derse kayıt başarılı olmalı")
    void register_success() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        RegisterResult result = s.registerCourse(c1);

        assertEquals(RegisterResult.SUCCESS, result);
        assertEquals(1, s.getCourses().size());
        assertTrue(s.getCourses().contains(c1));
    }

    @Test
    @DisplayName("Aynı derse 2 kez kayıt olamaz (DUPLICATE)")
    void register_duplicate() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        assertEquals(RegisterResult.SUCCESS, s.registerCourse(c1));
        assertEquals(RegisterResult.DUPLICATE, s.registerCourse(c1));
        assertEquals(1, s.getCourses().size());
    }

    @Test
    @DisplayName("Aynı saat çakışması varsa (SCHEDULE_CONFLICT)")
    void register_schedule_conflict() {
        Student s = new Student(1, "Ali");

        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");
        Course c2 = new Course("CS102", "OOP",   "Mon 10:00-12:00"); // çakışma

        assertEquals(RegisterResult.SUCCESS, s.registerCourse(c1));
        assertEquals(RegisterResult.SCHEDULE_CONFLICT, s.registerCourse(c2));
        assertEquals(1, s.getCourses().size());
    }

    @Test
    @DisplayName("Null ders gelirse INVALID dönmeli")
    void register_invalid_nullCourse() {
        Student s = new Student(1, "Ali");

        RegisterResult result = s.registerCourse(null);

        assertEquals(RegisterResult.INVALID, result);
        assertEquals(0, s.getCourses().size());
    }

    @Test
    @DisplayName("Ders bırakma başarılı olmalı")
    void drop_success() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        s.registerCourse(c1);
        assertTrue(s.dropCourse(c1));
        assertEquals(0, s.getCourses().size());
    }

    @Test
    @DisplayName("Var olmayan ders bırakılırsa false dönmeli")
    void drop_notFound() {
        Student s = new Student(1, "Ali");
        Course c1 = new Course("CS101", "Intro", "Mon 10:00-12:00");

        assertFalse(s.dropCourse(c1));
    }
}

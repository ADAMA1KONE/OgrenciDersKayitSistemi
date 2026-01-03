package ogrenci.kayit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Öğrencilerin ders kayıt ve ders bırakma işlemlerini yöneten servis sınıfıdır.
 */
/**
 * RegistrationService sınıfı,
 * ders kayıt işlemlerinin iş kurallarını yönetir.
 */


public class RegistrationService {

    private final List<Registration> registrations = new ArrayList<>();

    public RegisterResult register(Student student, Course course) {
        if (student == null || course == null) {
            return RegisterResult.INVALID;
        }

        RegisterResult result = student.registerCourse(course);

        if (result == RegisterResult.SUCCESS) {
            registrations.add(new Registration(student, course));
        }

        return result;
    }

    public boolean drop(Student student, Course course) {
        if (student == null || course == null) return false;

        boolean removed = student.dropCourse(course);
        if (removed) {
            registrations.removeIf(r ->
                    r.getStudent().equals(student) &&
                            r.getCourse().equals(course)
            );
        }
        return removed;
    }

    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrations);
    }

    public static String mesaj(RegisterResult r, Course c) {
        String kod = (c == null) ? "" : c.getCode();
        return switch (r) {
            case SUCCESS -> "✓ Kayıt başarılı: " + c.getInfo();
            case DUPLICATE -> "⚠ Zaten kayıtlı: " + c.getInfo();
            case SCHEDULE_CONFLICT -> "✗ Saat çakışması: " + c.getSchedule();
            case INVALID -> "✗ Geçersiz işlem!";
        };
    }
}

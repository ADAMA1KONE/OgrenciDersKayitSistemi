package ogrenci.kayit;

public class RegistrationService {

    public RegisterResult register(Student student, Course course) {
        if (student == null || course == null) return RegisterResult.INVALID;
        return student.registerCourse(course);
    }

    public boolean drop(Student student, Course course) {
        if (student == null || course == null) return false;
        return student.dropCourse(course);
    }

    public static String mesaj(RegisterResult r, Course c) {
        String kod = (c == null) ? "" : c.getCode();
        return switch (r) {
            case SUCCESS -> "✓ Ders başarıyla eklendi: " + kod;
            case DUPLICATE -> "✗ Öğrenci zaten bu derse kayıtlı: " + kod;
            case SCHEDULE_CONFLICT -> "✗ Ders saatleri çakışıyor: " + c.getSchedule();
            case INVALID -> "✗ Geçersiz işlem!";
        };
    }
}

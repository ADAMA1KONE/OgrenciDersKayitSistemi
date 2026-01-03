package ogrenci.kayit;

public class Main {


    private static String mesaj(RegisterResult result, Course c) {
        return switch (result) {
            case SUCCESS -> "✅ Kayıt başarılı: " + c.getInfo();
            case DUPLICATE -> "⚠️ Zaten kayıtlı: " + c.getInfo();
            case SCHEDULE_CONFLICT -> "❌ Saat çakışması: " + c.getInfo();
            case INVALID -> "❌ Geçersiz ders!";
        };
    }

    public static void main(String[] args) {
        System.out.println("=== Ogrenci Ders Kayit Sistemi Demo ===");

        Instructor i1 = new Instructor(1, "Dr. Ahmet Yılmaz");
        Instructor i2 = new Instructor(2, "Dr. Ayşe Demir");


        Student s = new Student(1, "Test Student");

        Course c1 = new Course("CS101", "Intro to CS", "Mon 10:00-12:00", i1);
        Course c2 = new Course("CS102", "Object-Oriented Programming", "Wed 14:00-16:00", i2);
        Course c3 = new Course("CS103", "Data Structures", "Mon 10:00-12:00", i1);

        CourseCatalog catalog = new CourseCatalog();

        catalog.addCourse(c1);
        catalog.addCourse(c2);
        catalog.addCourse(c3);

        System.out.println("\n--- Course Catalog ---");
        for (Course c : catalog.getAllCourses()) {
            System.out.println(c.getInfo());
        }


        RegistrationService service = new RegistrationService();

        System.out.println("--- Ders Kayıt İşlemleri ---");

        System.out.println(mesaj(service.register(s, c1), c1));
        System.out.println(mesaj(service.register(s, c2), c2));
        System.out.println(mesaj(service.register(s, c1), c1)); // duplicate
        System.out.println(mesaj(service.register(s, c3), c3)); // conflict

        System.out.println("\nÖğrencinin Dersleri:");
        for (Course c : s.getCourses()) {
            System.out.println(" * " + c.getInfo());
        }

        System.out.println("\n--- Tuition Test (Polymorphism) ---");

        Student s1 = new Student();
        Student s2 = new GraduateStudent();

        System.out.println("Student tuition: " + s1.calculateTuition());
        System.out.println("Graduate student tuition: " + s2.calculateTuition());
    }
}

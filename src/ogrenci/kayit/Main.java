package ogrenci.kayit;

public class Main {
    public static void main(String[] args) {

        Student s = new Student(1, "Test Student");

        Course c1 = new Course("CS101", "Intro to CS", "Mon 10:00-12:00");
        Course c2 = new Course("CS102", "Object-Oriented Programming", "Wed 14:00-16:00");
        Course c3 = new Course("CS103", "Data Structures", "Mon 10:00-12:00"); // conflit

        RegistrationService service = new RegistrationService();

        System.out.println("--- Ders Kayıt İşlemleri ---");

        System.out.println(RegistrationService.mesaj(service.register(s, c1), c1));
        System.out.println(RegistrationService.mesaj(service.register(s, c2), c2));
        System.out.println(RegistrationService.mesaj(service.register(s, c1), c1)); // duplicate
        System.out.println(RegistrationService.mesaj(service.register(s, c3), c3)); // conflict

        System.out.println("\nÖğrencinin Dersleri:");
        for (Course c : s.getCourses()) {
            System.out.println(" * " + c.getInfo());
        }
    }
}

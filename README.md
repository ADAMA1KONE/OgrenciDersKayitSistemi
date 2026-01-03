# Öğrenci Ders Kayıt Sistemi (Java OOP)

## Proje Açıklaması
Bu proje, öğrencilerin derslere kayıt olabildiği, derslerini listeleyebildiği ve kayıtlarını takip edebildiği basit bir sistemdir.
Kayıt sırasında:
- Aynı derse tekrar kayıt engellenir (Duplicate)
- Ders saat çakışmaları engellenir (Schedule Conflict)

## Kullanılan OOP Kavramları
- **Encapsulation (Kapsülleme):** sınıflarda private alanlar + getter/setter yapısı
- **Inheritance (Kalıtım):** `GraduateStudent extends Student`
- **Polymorphism (Çok biçimlilik):** `calculateTuition()` override edilmiştir
- **Interface:** `Schedulable`
- **Enum:** `RegisterResult`
- **Service Layer:** `RegistrationService`
- **Catalog:** `CourseCatalog`
- **Registration Takibi:** `Registration` sınıfı ile kayıt geçmişi tutulur

## Sınıflar
- `Student`, `GraduateStudent`
- `Course`, `Instructor`
- `CourseCatalog`
- `Registration`, `RegistrationService`
- `RegisterResult`, `Schedulable`

## Çalıştırma
1. `Main.java` dosyasını çalıştırın.
2. Konsolda ders kayıt işlemleri ve ders listesi görüntülenir.

## Testler (JUnit 5)
- `StudentTest`
- `RegistrationServiceTest`

Test çalıştırmak için:
- test dosyasına sağ tık → **Run**

## Örnek Çıktı
- Kayıt başarılı / Duplicate / Saat çakışması mesajları
- Öğrencinin kayıtlı ders listesi
- Tuition (Polymorphism) çıktısı

## OOP Concepts

- Encapsulation is applied using private fields and public getter methods.
- Inheritance is demonstrated by GraduateStudent extending Student.
- Polymorphism is implemented by overriding the calculateTuition() method.
- Interface usage is shown with the Schedulable interface.

## UML Diagrams and Testing

- UML Class Diagram is used to show class structure and relationships.
- UML Use Case Diagram represents user interactions with the system.
- JUnit tests are implemented for Student and RegistrationService classes.

package ogrenci.kayit;
/**
 * GraduateStudent sınıfı, Student sınıfından türetilmiştir
 * ve harç (tuition) hesaplamasını override eder.
 */


public class GraduateStudent extends Student {

    public GraduateStudent() {
        super();
    }

    @Override
    public double calculateTuition() {
        return 1500;
    }
}

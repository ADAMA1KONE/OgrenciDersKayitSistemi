package ogrenci.kayit;

public class GraduateStudent extends Student {

    public GraduateStudent() {
        super();
    }

    @Override
    public double calculateTuition() {
        return 1500;
    }
}

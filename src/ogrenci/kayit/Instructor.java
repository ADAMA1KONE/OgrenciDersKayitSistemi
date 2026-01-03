package ogrenci.kayit;

public class Instructor {
    private final int id;
    private final String name;

    public Instructor(int id, String name) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        this.id = id;
        this.name = name.trim();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getInfo() {
        return id + " - " + name;
    }
}

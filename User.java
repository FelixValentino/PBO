// MINGGU 5: Inheritance (Superclass)
public class User {
    // MINGGU 4: Access Modifier & Data Hiding (Private Attributes)
    private String nama;

    // MINGGU 3: Parameterized Constructor
    public User(String nama) {
        this.nama = nama;
    }

    // MINGGU 4: Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // MINGGU 6: Polymorphism (Method Overriding - Base)
    public void tampilkanInfo() {
        System.out.println("Nama User: " + nama);
    }
}

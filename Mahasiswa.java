// MINGGU 5: Inheritance (Subclass menggunakan 'extends')
public class Mahasiswa extends User {
    // MINGGU 4: Data Hiding
    private String nim;
    private int semester;

    // MINGGU 3: Parameterized Constructor
    public Mahasiswa(String nim, String nama, int semester) {
        super(nama); // MINGGU 5: Memanggil constructor superclass
        this.nim = nim;
        setSemester(semester); // Menggunakan setter agar tervalidasi
    }

    // MINGGU 4: Getter & Setter dengan Validasi
    public String getNim() {
        return nim;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        // MINGGU 4: Validasi data input
        if (semester >= 1 && semester <= 8) {
            this.semester = semester;
        } else {
            System.out.println("[Validasi Error: Semester harus antara 1-8! Default ke 1]");
            this.semester = 1;
        }
    }

    public String getAngkatan() {
        // Mengambil 4 digit pertama NIM untuk angkatan seperti code lamamu
        if (nim != null && nim.length() >= 4) {
            return nim.substring(0, 4);
        }
        return "2023"; 
    }

    // MINGGU 6: Polymorphism (Method Overriding dari class User)
    @Override
    public void tampilkanInfo() {
        System.out.println("NIM      : " + nim);
        System.out.println("Nama     : " + getNama());
        System.out.println("Semester : " + semester);
        System.out.println("Angkatan : " + getAngkatan());
    }
}

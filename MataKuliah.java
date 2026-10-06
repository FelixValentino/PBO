// MINGGU 2: Membuat Class & Object Representasi Jadwal
public class MataKuliah {
    // MINGGU 2: Attributes / States
    private String namaMatkul;
    private String jam;
    private String hari;
    private String ruangan;

    // MINGGU 3: Default Constructor (Konstruktor Tanpa Parameter)
    public MataKuliah() {
        this.namaMatkul = "Belum Diisi";
        this.jam = "00.00";
        this.hari = "Senin";
        this.ruangan = "P203";
    }

    // MINGGU 3: Parameterized Constructor (Constructor Overloading)
    public MataKuliah(String namaMatkul, String jam, String hari, String ruangan) {
        this.namaMatkul = namaMatkul;
        this.jam = jam;
        this.hari = hari;
        this.ruangan = ruangan;
    }

    // MINGGU 2: Behavior / Methods (Getter)
    public String getNamaMatkul() { return namaMatkul; }
    public String getJam() { return jam; }
    public String getHari() { return hari; }
    public String getRuangan() { return ruangan; }

    // Mengubah objek menjadi string terformat saat dicetak
    @Override
    public String toString() {
        return namaMatkul + " - " + jam + " - " + hari + " - " + ruangan;
    }
}

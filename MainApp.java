import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

// MINGGU 1: Mengubah Prosedural ke OOP (Main hanya mengontrol aliran/driver)
public class MainApp {
    private static final Scanner input = new Scanner(System.in);

    public static String getHariIni() {
        int hari = LocalDate.now().getDayOfWeek().getValue(); 
        return switch (hari) {
            case 1 -> "Senin"; case 2 -> "Selasa"; case 3 -> "Rabu";
            case 4 -> "Kamis"; case 5 -> "Jumat"; case 6 -> "Sabtu";
            case 7 -> "Minggu"; default -> "";
        };
    }

    // MINGGU 3: Method Overloading 1 (Mencari jadwal hari ini berdasarkan object Mahasiswa)
    public static void cetakJadwal(Mahasiswa mhs) {
        String hariIni = getHariIni();
        System.out.println("\n===== Jadwal Hari ini =====");
        System.out.println("Hari : " + hariIni);
        
        // Memanggil fungsi pencarian utama
        bacaFileJadwal(mhs.getAngkatan(), String.valueOf(mhs.getSemester()), hariIni);
    }

    // MINGGU 3: Method Overloading 2 (Mencari jadwal satu semester penuh)
    public static void cetakJadwal(Mahasiswa mhs, boolean satuSemesterPenuh) {
        if (satuSemesterPenuh) {
            System.out.println("\n===== Jadwal Semester Ini =====");
            bacaFileJadwal(mhs.getAngkatan(), String.valueOf(mhs.getSemester()), null);
        }
    }

    // MINGGU 3: Method Overloading 3 (Mencari jadwal untuk semester lain secara spesifik)
    public static void cetakJadwal(Mahasiswa mhs, String semesterLain) {
        System.out.println("\n===== Jadwal Semester Lain =====");
        bacaFileJadwal(mhs.getAngkatan(), semesterLain, null);
    }

    // Fungsi core pembaca file txt (Adaptasi dari code lamamu agar tetap bekerja)
    private static void bacaFileJadwal(String angkatan, String semester, String filterHari) {
        String targetHeader = "JADWAL KULIAH INFORMATIKA " + angkatan + " SEMESTER " + semester;
        boolean statusJadwal = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Jadwal.txt"))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                baris = baris.trim(); 

                if (baris.equals(targetHeader)) {
                    statusJadwal = true;
                    System.out.println(baris);
                    continue;
                }

                if (statusJadwal) {
                    if (baris.isEmpty() || baris.contains("JADWAL KULIAH INFORMATIKA")) {
                        break;
                    }

                    if (filterHari == null) {
                        System.out.println(baris); // Cetak semua jika tidak ada filter hari
                    } else if (baris.contains(filterHari)) {
                        System.out.println(baris); // Cetak jika harinya cocok
                    }
                }
            }

            if (!statusJadwal) {
                System.out.println("Jadwal tidak ditemukan untuk angkatan " + angkatan + " semester " + semester);
            }
        } catch (IOException e) {
            System.out.println("[Error: File Jadwal.txt tidak ditemukan atau tidak bisa dibaca!]");
        }
    }

    public static void menuDashboard(Mahasiswa mhs) {
        while (true) {
            System.out.println("\n===== DASHBOARD =====");
            // MINGGU 6: Dynamic Binding (Memanggil fungsi overriding milik Mahasiswa)
            mhs.tampilkanInfo(); 
            
            System.out.println("\n1. Lihat Jadwal Hari ini");
            System.out.println("2. Lihat Jadwal Semester Ini");
            System.out.println("3. Lihat Jadwal Semester Lain");
            System.out.println("4. Back");
            System.out.print("Masukkan pilihan : ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                cetakJadwal(mhs); // Memanggil Overloading 1
            } else if (pilihan == 2) {
                cetakJadwal(mhs, true); // Memanggil Overloading 2
            } else if (pilihan == 3) {
                System.out.print("Masukkan semester yang ingin dilihat : ");
                String semLain = input.next();
                cetakJadwal(mhs, semLain); // Memanggil Overloading 3
            } else if (pilihan == 4) {
                break;
            }
        }
    }

    public static void prosesLogin() {
        System.out.println("\n===== LOGIN =====");
        System.out.print("Masukkan NIM : ");
        String nim = input.next();
        input.nextLine(); 

        System.out.print("Masukkan nama : ");
        String nama = input.nextLine();

        System.out.print("Masukkan semester saat ini : ");
        int semester = input.nextInt();

        // MINGGU 2 & 3: Instansiasi Objek Mahasiswa menggunakan Parameterized Constructor
        Mahasiswa mhs = new Mahasiswa(nim, nama, semester);

        // MINGGU 6: Upcasting (Objek subclass dimasukkan ke variabel superclass)
        User userAktif = mhs; 
        System.out.println("\nLogin berhasil untuk user: " + userAktif.getNama());

        // Lanjut ke dashboard membawa data objek mhs
        menuDashboard(mhs);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Masukkan pilihan : ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                prosesLogin();
            } else if (pilihan == 2) {
                System.out.println("Thankyou");
                System.exit(0);
            }
        }
    }
}

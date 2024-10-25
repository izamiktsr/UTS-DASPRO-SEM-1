import java.util.*;


public class ManajemenNilaiSiswa18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi variabel
        List<Integer> nilaiSiswaList = new ArrayList<>();
        double totalNilai = 0;

        // Perulangan untuk input data siswa
        System.out.println("Masukkan data siswa (ketik 'selesai' untuk berhenti):");
        while (true) {
            System.out.print("Nama siswa: ");
            String namaSiswa = scanner.nextLine();

            if (namaSiswa.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Nilai siswa: ");
            int nilaiSiswa = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            // Tambahkan nilai siswa ke dalam list
            nilaiSiswaList.add(nilaiSiswa);
            totalNilai += nilaiSiswa;
        }

        // Menghitung rata-rata nilai kelas
        double rataRata = hitungRataRata(totalNilai, nilaiSiswaList.size());

        // Menghitung jumlah siswa di atas dan di bawah rata-rata
        int jumlahSiswaAtasRataRata = 0;
        int jumlahSiswaBawahRataRata = 0;

        for (int nilai : nilaiSiswaList) {
            if (nilai > rataRata) {
                jumlahSiswaAtasRataRata++;
            } else {
                jumlahSiswaBawahRataRata++;
            }
        }

        // Menampilkan hasil
        System.out.println("\nHasil:");
        System.out.println("Rata-rata nilai kelas: " + rataRata);
        System.out.println("Jumlah siswa di atas rata-rata: " + jumlahSiswaAtasRataRata);
        System.out.println("Jumlah siswa di bawah rata-rata: " + jumlahSiswaBawahRataRata);

        // Menentukan mayoritas
        if (jumlahSiswaAtasRataRata > nilaiSiswaList.size() / 2) {
            System.out.println("Kelas ini memiliki mayoritas siswa di atas rata-rata.");
        } else {
            System.out.println("Kelas ini tidak memiliki mayoritas siswa di atas rata-rata.");
        }
    }

    // Metode untuk menghitung rata-rata
    private static double hitungRataRata(double totalNilai, int jumlahSiswa) {
        return jumlahSiswa == 0 ? 0 : totalNilai / jumlahSiswa;
    }
}
import java.util.*;

class Barang {
    private String nama;
    private int jumlahStok;
    private double hargaPerUnit;

    public Barang(String nama, int jumlahStok, double hargaPerUnit) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.hargaPerUnit = hargaPerUnit;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public double getHargaPerUnit() {
        return hargaPerUnit;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public double getTotalNilaiStok() {
        return jumlahStok * hargaPerUnit;
    }
}

public class ManajemenStokBarang18 {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;
        while (lanjut) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    memasukkanDataBarang();
                    break;
                case 2:
                    menghitungTotalNilaiStok();
                    break;
                case 3:
                    menanganiPermintaanProduk();
                    break;
                case 4:
                    tampilkanOutput();
                    break;
                case 5:
                    lanjut = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== PROGRAM MANAJEMEN STOK BARANG ===");
        System.out.println("1. Memasukkan Data Barang");
        System.out.println("2. Hitung Total Nilai Stok");
        System.out.println("3. Menangani Permintaan Produk");
        System.out.println("4. Tampilkan Output");
        System.out.println("5. Selesai");
        System.out.print("Pilih menu (1-5): ");
    }

    private static void memasukkanDataBarang() {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan jumlah stok: ");
        int jumlahStok = scanner.nextInt();
        
        System.out.print("Masukkan harga per unit: ");
        double hargaPerUnit = scanner.nextDouble();

        Barang barang = new Barang(nama, jumlahStok, hargaPerUnit);
        daftarBarang.add(barang);
        System.out.println("Data barang berhasil ditambahkan!");
    }

    private static void menghitungTotalNilaiStok() {
        double totalNilaiSeluruhStok = 0;
        for (Barang barang : daftarBarang) {
            totalNilaiSeluruhStok += barang.getTotalNilaiStok();
            System.out.printf("Total nilai stok %s: Rp%.2f%n", 
                barang.getNama(), barang.getTotalNilaiStok());
        }
        System.out.printf("Total nilai seluruh stok: Rp%.2f%n", totalNilaiSeluruhStok);
    }

    private static void menanganiPermintaanProduk() {
        System.out.print("Masukkan nama barang yang diminta: ");
        String namaBarang = scanner.nextLine();
        
        Barang barang = null;
        for (Barang b : daftarBarang) {
            if (b.getNama().equalsIgnoreCase(namaBarang)) {
                barang = b;
                break;
            }
        }

        if (barang == null) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan jumlah permintaan: ");
        int jumlahPermintaan = scanner.nextInt();

        if (jumlahPermintaan <= barang.getJumlahStok()) {
            barang.setJumlahStok(barang.getJumlahStok() - jumlahPermintaan);
            System.out.println("Permintaan berhasil dipenuhi!");
            System.out.println("Sisa stok: " + barang.getJumlahStok());
        } else {
            System.out.println("Stok tidak mencukupi!");
            System.out.println("Stok tersedia: " + barang.getJumlahStok());
        }
    }

    private static void tampilkanOutput() {
        System.out.println("\n=== INFORMASI STOK BARANG ===");
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
            return;
        }

        for (Barang barang : daftarBarang) {
            System.out.println("\nNama Barang: " + barang.getNama());
            System.out.println("Jumlah Stok: " + barang.getJumlahStok());
            System.out.printf("Harga per Unit: Rp%.2f%n", barang.getHargaPerUnit());
            System.out.printf("Total Nilai Stok: Rp%.2f%n", barang.getTotalNilaiStok());
        }
    }
}
package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMahasiswa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int menu = scan.nextInt();
            scan.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = scan.nextLine();

                    if (isNim(dataMahasiswa, nim)) {
                        dataMahasiswa.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
                    } else {
                        System.out.println("NIM sudah ada. Mahasiswa tidak ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scan.nextLine();

                    if (hapusMahasiswa(dataMahasiswa, nimHapus)) {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " berhasil dihapus.");
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                    String nimCari = scan.nextLine();

                    Mahasiswa mahasiswa = cariMahasiswa(dataMahasiswa, nimCari);
                    if (mahasiswa != null) {
                        System.out.println("Mahasiswa ditemukan:");
                        System.out.println(mahasiswa);
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Daftar Mahasiswa:");
                    if (dataMahasiswa.isEmpty()) {
                        System.out.println("Belum ada data mahasiswa.");
                    } else {
                        for (Mahasiswa mhs : dataMahasiswa) {
                            System.out.println(mhs);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        }
    }
    
    private static boolean isNim(ArrayList<Mahasiswa> dataMahasiswa, String nim) {
        for (Mahasiswa mahasiswa : dataMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                return false;
            }
        }
        return true;
    }
    private static boolean hapusMahasiswa(ArrayList<Mahasiswa> dataMahasiswa, String nim) {
        return dataMahasiswa.removeIf(mahasiswa -> mahasiswa.getNim().equals(nim));
    }
    private static Mahasiswa cariMahasiswa(ArrayList<Mahasiswa> dataMahasiswa, String nim) {
        for (Mahasiswa mahasiswa : dataMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                return mahasiswa;
            }
        }
        return null;
    }
}

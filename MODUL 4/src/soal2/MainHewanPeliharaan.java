package soal2;

import java.util.Scanner;

public class MainHewanPeliharaan {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan	: ");
        int pilihan = in.nextInt();
        in.nextLine();
        inputOutput(pilihan, in);
    }
    private static void inputOutput(int pilihan, Scanner in) {
        System.out.print("Nama hewan peliharaan	: ");
        String nama = in.nextLine();
        System.out.print("Ras			: ");
        String ras = in.nextLine();
        System.out.print("Warna Bulu		: ");
        String warnaBulu = in.nextLine();
        if (pilihan == 1) {
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            System.out.println();
            kucing.displayDetailKucing();
        } else if (pilihan == 2) {
            System.out.print("Kemampuan		: ");
            String kemampuan = in.nextLine();
            Anjing anjing = new Anjing(ras, nama, warnaBulu, kemampuan);
            System.out.println();
            anjing.displayDetailAnjing();
        }
    }
}
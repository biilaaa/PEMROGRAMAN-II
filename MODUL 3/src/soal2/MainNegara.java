package soal2;

import java.util.LinkedList;
import java.util.Scanner;

public class MainNegara {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int jumlahNegara = scan.nextInt();
        scan.nextLine();

        LinkedList<Negara> negaraList = new LinkedList<>();

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = scan.nextLine();
            String jenisKepemimpinan = scan.nextLine();
            String namaPemimpin = scan.nextLine();

            int tanggalKemerdekaan = 0;
            int bulanKemerdekaan = 0;
            int tahunKemerdekaan = 0;

            if (!jenisKepemimpinan.equals("monarki")) {
                tanggalKemerdekaan = scan.nextInt();
                bulanKemerdekaan = scan.nextInt();
                tahunKemerdekaan = scan.nextInt();
                scan.nextLine();
            }

            Negara negara = new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan);
            negaraList.add(negara);
        }

        for (Negara negara : negaraList) {
            System.out.println("Negara " + negara.getNama() + " mempunyai " + 
                (negara.getJenisKepemimpinan().equals("monarki") ? "Raja" :
                (negara.getJenisKepemimpinan().equals("presiden") ? "Presiden" : "Perdana Menteri"))
                + " bernama " + negara.getNamaPemimpin());

            if (!negara.getJenisKepemimpinan().equals("monarki")) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + 
                    negara.getTanggalKemerdekaan() + " " + 
                    getNamaBulan(negara.getBulanKemerdekaan()) + " " + 
                    negara.getTahunKemerdekaan());
            }
            System.out.println();
        }
    }

    private static String getNamaBulan(int bulan) {
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        return (bulan >= 1 && bulan <= 12) ? namaBulan[bulan - 1] : "Bulan tidak valid";
    }
}

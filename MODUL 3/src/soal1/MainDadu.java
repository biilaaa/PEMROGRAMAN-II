package soal1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MainDadu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Jumlah Dadu : ");
        int JumlahDadu = scan.nextInt();

        LinkedList<Dadu> daduList = new LinkedList<>();
        Random acak = new Random();
        
        for (int i = 1; i <= JumlahDadu; i++) {
            Dadu dadu = new Dadu();
            dadu.lemparDadu(acak);
            daduList.add(dadu);
            System.out.println("Dadu ke-" + i + " bernilai " + dadu.getNilai());
        }

        int totalNilai = 0;
        for (Dadu dadu : daduList) {
            totalNilai += dadu.getNilai();
        }

        System.out.println("Total nilai dadu keseluruhan : " + totalNilai);
    }
}
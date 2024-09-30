package modul1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class PRAK105_2310817320007_ZahraNabila {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double phi = 3.14;

        for (int i = 0; i < 3; i++) {
            if (i > 0) {
                System.out.println();
            }

            System.out.print("Masukkan jari-jari	: ");
            double r = keyboard.nextDouble();

            System.out.print("Masukkan tinggi		: ");
            double t = keyboard.nextDouble();

            double volume = phi * r * r * t;
            DecimalFormat df = new DecimalFormat("#.###");
            System.out.print("Volume tabung dengan jari-jari " + r + " cm dan ");
            System.out.print("tinggi " + t + " cm adalah " + df.format(volume) + " m3");
            System.out.println();
        }

        keyboard.close();
    }
}
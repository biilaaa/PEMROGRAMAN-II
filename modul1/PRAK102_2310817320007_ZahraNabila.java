package modul1;
import java.util.Scanner;
public class PRAK102_2310817320007_ZahraNabila 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int j = 0; j < 10; j++) {
            System.out.print(" ");
            int NilaiAwal = input.nextInt();

            int i = 0;
            while (i <= 10) {
                int NilaiSekarang;
                if (NilaiAwal % 5 == 0) {
                    NilaiSekarang = NilaiAwal / 5 - 1;
                    System.out.print(NilaiSekarang);
                    if (i < 10) System.out.print(", ");
                } else {
                    NilaiSekarang = NilaiAwal;
                    System.out.print(NilaiSekarang);
                    if (i < 10) System.out.print(", ");
                }
                NilaiAwal++;
                i++;
            }
            System.out.println();
        }
    }
}
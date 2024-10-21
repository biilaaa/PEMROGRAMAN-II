package praktikum2_soal2;

public class KopiMain {
    public static void main(String[] args) {

        Kopi kopi1 = new Kopi();
        kopi1.NamaKopi = "Espresso";
        kopi1.Ukuran = "Medium";
        kopi1.Harga = 25000;

        kopi1.info();

        kopi1.setPembeli("Alice");
        System.out.println("Pembeli Kopi	: " + kopi1.getPembeli());
        System.out.println("Pajak Kopi	: Rp. " + kopi1.getPajak());
    }
}

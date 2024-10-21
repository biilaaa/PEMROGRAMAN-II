package praktikum2_soal2;

public class Kopi {
    public String NamaKopi; 
    public String Ukuran;
    public double Harga;
    private String Pembeli;

    public void info() {
        System.out.println("Nama Kopi	: " + NamaKopi);
        System.out.println("Ukuran		: " + Ukuran);
        System.out.println("Harga		: Rp. " + Harga);
    }

    public void setPembeli(String pembeliBaru) {
        this.Pembeli = pembeliBaru;
    }

    public String getPembeli() {
        return Pembeli;
    }

    public double getPajak() {
        return Harga * 0.11;
    }
}

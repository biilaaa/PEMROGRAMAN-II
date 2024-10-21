package praktikum2_soal1;

public class Buah {
    public final String Nama;
    public final double Berat;
    public final double Harga;
    public final double JumlahBeli;
    public final double SebelumDiskon;
    public final double TotalDiskon;
    public final double SetelahDiskon;

    public Buah(String nama, double berat, double harga, double jumlahBeli) {
        this.Nama = nama;
        this.Berat = berat;
        this.Harga = harga;
        this.JumlahBeli = jumlahBeli;
        this.SebelumDiskon = jumlahBeli / berat * harga;
        double kelipatan = this.JumlahBeli >= 4 ? this.JumlahBeli / 4 : 0.0;
        this.TotalDiskon = 0.02 * (4 * this.Harga) * Math.floor(kelipatan);
        this.SetelahDiskon = this.SebelumDiskon - this.TotalDiskon;
    }

    public void display() {
        System.out.println("Nama Buah		: " + this.Nama);
        System.out.println("Berat			: " + this.Berat);
        System.out.println("Harga			: " + this.Harga);
        System.out.printf("Jumlah Beli		: %.1fkg\n", this.JumlahBeli);
        System.out.printf("Harga Sebelum Diskon	: Rp%.2f \n", this.SebelumDiskon);
        System.out.printf("Total Diskon		: Rp%.2f\n", this.TotalDiskon);
        System.out.printf("Harga Setelah Diskon	: Rp%.2f\n", this.SetelahDiskon);
        System.out.println();
    }
}

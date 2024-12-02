package soal2;

public class HewanPeliharaan {
	private final String nama, ras;

    public HewanPeliharaan(String nama, String ras) {
        this.nama = nama;
        this.ras = ras;
    }
    public void display() {
        System.out.println("Detail Hewan Peliharaan: ");
        System.out.println("Nama hewan peliharanku adalah 	: " + nama);
        System.out.println("Dengam ras			: " + ras);
    }
}
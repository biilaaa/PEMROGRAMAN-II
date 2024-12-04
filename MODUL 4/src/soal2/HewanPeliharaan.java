package soal2;

public class HewanPeliharaan {
	private final String nama, ras;

    public HewanPeliharaan(String n, String r) {
        this.nama = n;
        this.ras = r;
    }
    public void display() {
        System.out.println("Detail Hewan Peliharaan: ");
        System.out.println("Nama hewan peliharanku adalah 	: " + nama);
        System.out.println("Dengan ras			: " + ras);
    }
}
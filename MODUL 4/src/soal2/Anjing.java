package soal2;

public class Anjing extends HewanPeliharaan {
    private final String warnaBulu, kemampuan;

    public Anjing(String nama, String ras, String warnaBulu, String kemampuan) {
        super(nama, ras);
        this.warnaBulu = warnaBulu;
        this.kemampuan = kemampuan;
    }
    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki Warna Bulu		: " + warnaBulu);
        System.out.println("Memiliki Kemampuan		: " + kemampuan);
    }
}
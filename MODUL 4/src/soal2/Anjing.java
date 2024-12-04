package soal2;

public class Anjing extends HewanPeliharaan {
    private final String warnaBulu;
    private final String[] kemampuan;

    public Anjing(String n, String r, String w, String[] k) {
        super(n, r);
        this.warnaBulu = w;
        this.kemampuan = k;
    }

    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki Warna Bulu		: " + warnaBulu);
        System.out.println("Memiliki Kemampuan		: " + String.join(" ", kemampuan));
    }
}
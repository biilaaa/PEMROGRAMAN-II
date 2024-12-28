package model;

public class Buku {
    private String judul;
    private String penulis;
    private int harga;
    private int stok;

    public Buku(String judul, String penulis, int harga, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }
    
    public void setJudul(String judul) {
		this.judul = judul;
	}
	
	public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
	
	public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

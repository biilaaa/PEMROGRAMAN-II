package model;

public class Penjualan {
    private int jumlah;
    private int total_harga;
    private String tanggal;

    public Penjualan(int jumlah, int total, String tanggal) {
        this.jumlah = jumlah;
        this.total_harga = total;
        this.tanggal = tanggal;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public int getTotalHarga() {
        return this.total_harga;
    }

    public String getTanggal() {
        return this.tanggal;
    }
    
    public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	
	public void setTotalHarga(int total_harga) {
        this.total_harga = total_harga;
    }
	
	public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

	public char[] getNama() {
		// TODO Auto-generated method stub
		return null;
	}
}

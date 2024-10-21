package praktikum2_soal3;

public class Pegawai {
	public String Nama;
    // Baris ini terjadi error karena pada file Main, value nya bukanlah karakter
    // public char Asal;
    public String Asal;
    public String Jabatan;
    public int Umur;
    public String getNama() {
        return Nama;
    }
    // Baris ini terdapat error karena tipe data nya harus sama dengan variabel Asal
    // public char getAsal() {
    public String getAsal() {
        return Asal;
    }
    // Baris ini terdapat error karena variabel j dideklarasikan lebih dulu menjadi parameter
    // public void setJabatan() {
    public void setJabatan(String j) {
        this.Jabatan = j;
    }
}


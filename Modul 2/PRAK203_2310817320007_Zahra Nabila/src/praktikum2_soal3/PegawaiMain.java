package praktikum2_soal3;

public class PegawaiMain{
	public static void main(String[] args) {

        Pegawai p1 = new Pegawai();
        // Baris ini terdapat error karena titik koma ';' yang kurang
        // p1.nama = "Roi"
        p1.Nama = "Roi";
        p1.Asal = "Kingdom of Orvel";
        p1.Umur = 17;
        p1.setJabatan("Assasin");

        System.out.println("Nama Pegawai	: " + p1.getNama());
        System.out.println("Asal		: " + p1.getAsal());
        System.out.println("Jabatan		: " + p1.Jabatan);
        System.out.println("Umur		: " + p1.Umur + " tahun");  
	}
}


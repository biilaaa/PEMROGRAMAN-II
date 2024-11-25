package soal2;

public class Negara {
    private final String Nama;
    private final String JenisKepemimpinan;
    private final String NamaPemimpin;
    private final int TanggalKemerdekaan;
    private final int BulanKemerdekaan;
    private final int TahunKemerdekaan;

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin,
                  int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
        this.Nama = nama;
        this.JenisKepemimpinan = jenisKepemimpinan;
        this.NamaPemimpin = namaPemimpin;
        this.TanggalKemerdekaan = tanggalKemerdekaan;
        this.BulanKemerdekaan = bulanKemerdekaan;
        this.TahunKemerdekaan = tahunKemerdekaan;
    }

    public String getNama() {
        return Nama;
    }

    public String getJenisKepemimpinan() {
        return JenisKepemimpinan;
    }

    public String getNamaPemimpin() {
        return NamaPemimpin;
    }

    public int getTanggalKemerdekaan() {
        return TanggalKemerdekaan;
    }

    public int getBulanKemerdekaan() {
        return BulanKemerdekaan;
    }

    public int getTahunKemerdekaan() {
        return TahunKemerdekaan;
    }
}

package soal1;

import java.util.Random;

public class Dadu {
    private int AcakNilai;

    public Dadu() {
        this.AcakNilai = 1;
    }

    public int getNilai() {
        return AcakNilai;
    }

    public void lemparDadu(Random acak) { 
        this.AcakNilai = acak.nextInt(6) + 1; 
    }
}

package BangunRuang;

import BangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements BangunRuang {
    public double tinggiTabung;

    public Tabung(double rad, double tinggiTabung) {
        super(rad);
        this.tinggiTabung = tinggiTabung;
    }

    public double Volume() {
        return Luas() * tinggiTabung;
    }

    public double luasPermukaan() {
        return 2 * Luas() + Keliling() * tinggiTabung; 
    }
}

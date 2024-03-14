package BangunDatar;

public class Lingkaran implements BangunDatar{
    public double rad;

    public Lingkaran(double rad) {
        this.rad = rad;
    }

    public double Luas() {
        return 22.0/7.0 * this.rad * this.rad;
    }

    public double Keliling() {
        return 2 * 22.0/7.0 * rad;
    }
}

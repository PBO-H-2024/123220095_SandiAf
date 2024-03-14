package BangunRuang;
import BangunDatar.Segitiga;

public class Limas extends Segitiga implements BangunRuang  {
    public double tinggiLimas;
    public Limas(double a, double b, double c, double tinggiLimas) {
        super(a, b, c);
        this.tinggiLimas = tinggiLimas;
    }

    public double Volume(){
        return 1.0/3.0 * Luas() * tinggiLimas;
    }

    public double luasPermukaan() {
        double lpA = 1.0/2.0 * a * (Math.sqrt(Math.pow(a, 2)  (Math.pow(tinggiLimas, 2))));
        return Luas() + lpA + (1.0/2.0 * b * Math.sqrt(Math.pow(b, 2) - (Math.pow(tinggiLimas, 2)))) + (1.0/2.0 * c * Math.sqrt(Math.pow(c, 2) - (Math.pow(tinggiLimas, 2)))) ; 
    }
    
}
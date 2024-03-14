import java.util.Scanner;
import BangunRuang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        while (true) {
            System.out.println("1. Limas Segitiga");
            System.out.println("2. Tabung");
            System.out.println("3. Exit");

            System.out.print(">> ");
            String input = scannerObj.next();
            if (input.equals("1")) {
                hitungLimas(scannerObj);
            } else if (input.equals("2")) {
                hitungTabung(scannerObj);
            } else if (input.equals("3")) {
                scannerObj.close();
                System.exit(0);
                return;
            }
            System.out.print("\nPress Enter To Continue");
            scannerObj.nextLine();
            scannerObj.nextLine();
        }
    }

    public static void hitungLimas(Scanner scannerObj) {
        System.out.println("\nINPUT");
        System.out.print("Input a: ");
        double a = scannerObj.nextDouble();
        System.out.print("Input b: ");
        double b = scannerObj.nextDouble();
        System.out.print("Input c: ");
        double c = scannerObj.nextDouble();
        System.out.print("Input Tinggi Limas: ");
        double tinggiLimas = scannerObj.nextDouble();

        System.out.println("\nOUTPUT");
        Limas limas = new Limas(a, b, c, tinggiLimas);
        System.out.println("Luas Segitiga\t\t: " + limas.Luas());
        System.out.println("Keliling Segitiga\t: " + limas.Keliling());
        System.out.println("Volume Limas\t\t: " + limas.Volume());
        System.out.println("LuasPermukaan Limas\t: " + limas.luasPermukaan());
    }

    public static void hitungTabung(Scanner scannerObj) {
        System.out.println("\nINPUT");
        System.out.print("Input Jari-Jari: ");
        double rad = scannerObj.nextDouble();
        System.out.print("Input Tinggi Tabung: ");
        double tinggiTabung = scannerObj.nextDouble();

        System.out.println("\nOUTPUT");
        Tabung tabung = new Tabung( rad, tinggiTabung);
        System.out.println("Luas Lingkaran\t\t: " + tabung.Luas());
        System.out.println("Keliling Lingkaran\t: " + tabung.Keliling());
        System.out.println("Volume Tabung\t\t: " + tabung.Volume());
        System.out.println("LuasPermukaan Tabung\t: " + tabung.luasPermukaan());
    }
}
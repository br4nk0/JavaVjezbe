package vjezbeV;

import java.util.Scanner;

public class Razlomci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi prvi razlomak (brojnik i nazivnik odvojeni razmakom):");
        int n1 = sc.nextInt();
        int d1 = sc.nextInt();

        System.out.println("Unesi drugi razlomak (brojnik i nazivnik odvojeni razmakom):");
        int n2 = sc.nextInt();
        int d2 = sc.nextInt();

        try {
            Fraction f1 = new Fraction(n1, d1);
            Fraction f2 = new Fraction(n2, d2);

            Fraction suma = f1.add(f2);
            Fraction razlika = f1.subtract(f2);

            System.out.println("Zbir: " + suma);
            System.out.println("Razlika: " + razlika);
        } catch (IllegalArgumentException e) {
            System.out.println("Greska: " + e.getMessage());
        }

        sc.close();
    }

    // Jednostavna klasa za razlomke sa sabiranjem, oduzimanjem i skra07ivanjem
    static class Fraction {
        private final int num;
        private final int den;

        public Fraction(int num, int den) {
            if (den == 0) throw new IllegalArgumentException("Nazivnik ne moze biti 0.");
            int g = gcd(num, den);
            num /= g;
            den /= g;
            if (den < 0) { // normalizacija znaka u brojniku
                num = -num;
                den = -den;
            }
            this.num = num;
            this.den = den;
        }

        public Fraction add(Fraction other) {
            int n = this.num * other.den + other.num * this.den;
            int d = this.den * other.den;
            return new Fraction(n, d);
        }

        public Fraction subtract(Fraction other) {
            int n = this.num * other.den - other.num * this.den;
            int d = this.den * other.den;
            return new Fraction(n, d);
        }

        @Override
        public String toString() {
            if (den == 1) return Integer.toString(num);
            return num + "/" + den;
        }

        private static int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            if (a == 0) return b;
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return a;
        }
    }
}

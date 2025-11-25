package vjezbeV;

import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi 3 cijela broja:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("Zbir: " + zbir(a, b, c));
        System.out.printf("Prosjek: %.2f%n", prosjek(a, b, c));
        System.out.println("Najveci: " + najveci(a, b, c));

        sc.close();
    }

    public static int zbir(int a, int b, int c) {
        return a + b + c;
    }

    public static double prosjek(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static int najveci(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        if (b >= a && b >= c) return b;
        return c;
    }

}
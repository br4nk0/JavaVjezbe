package vjezbeIV;

import java.util.Scanner;

public class TestAnalizaNiza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int n = scanner.nextInt();
        int[] niz = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Unesite element niza na poziciji " + i + ": ");
            niz[i] = scanner.nextInt();
        }
        double prosjek = analizaNiza.nadjiParniPozitivniProsjek(niz);
        if (prosjek == 0) {
            System.out.println("Nema pozitivnih parnih brojeva u nizu.");
        } else {
            System.out.println("Prosjecna vrijednost pozitivnih parnih brojeva u nizu je: " + prosjek);
        }
        scanner.close();
    }
}

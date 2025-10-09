package vjezbeIV;

import java.util.Arrays;
import java.util.Scanner;

public class SortiraniNizPretraga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int n = scanner.nextInt();
        int[] niz = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Unesite element niza na poziciji " + i + ": ");
            niz[i] = scanner.nextInt();
        }
        Arrays.sort(niz);
        System.out.print("Sortiran niz: ");
        for (int x : niz) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Unesite broj koji zelite da provjerite: ");
        int broj = scanner.nextInt();
        // Koristimo binarySearch jer je niz sortiran
        int indeks = Arrays.binarySearch(niz, broj);
        if (indeks >= 0) {
            System.out.println("Broj " + broj + " postoji u nizu (indeks: " + indeks + ").");
        } else {
            System.out.println("Broj " + broj + " ne postoji u nizu.");
        }
        scanner.close();
    }
}

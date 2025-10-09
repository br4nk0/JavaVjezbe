package vjezbeIV;

import java.util.Scanner;

public class nizII { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Niz je prazan.");
            scanner.close();
            return;
        }
        int[] bodovi = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Unesite broj bodova za element " + i + ": ");
            bodovi[i] = scanner.nextInt();
        }
        // Racunanje prosjeka
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += bodovi[i];
        }
        double prosjek = (double)suma / n;
        // Trazenje najmanjeg elementa i njegovog indeksa
        int min = bodovi[0];
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (bodovi[i] < min) {
                min = bodovi[i];
                minIndex = i;
            }
        }
        System.out.println("Prosjecan broj bodova: " + prosjek);
        System.out.println("Najmanji broj bodova: " + min + ", indeks: " + minIndex);
        scanner.close();
    }
}
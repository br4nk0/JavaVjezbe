package vjezbeVI;

/*
Zadatak: Napisati program koji učitava tri cijela broja s tastature i ispisuje ih u posebnom poretku.
Na izlazu treba biti: prvi broj = najmanji od tri, drugi broj = najveći, treći = preostali (srednji).
Ulaz: tri cijela broja.
Izlaz: "Izlaz: a b c" gdje su a, b, c poredani kako je gore navedeno.
*/

import java.util.Scanner;

public class Priprema_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, temp;

        System.out.print("Unesite tri cijela broja: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
       
        
        if (a > b) {
        	temp = a;	
        	a = b;
        	b = temp;
        }
        if (a > c) {
			temp = a;	
			a = c;
			c = temp;
        }
        if (b < c) {
        	temp = b;
        	b = c;
        	c = temp;
        	
        }
        System.out.printf("Izlaz: %d %d %d", a, b, c);

        sc.close();
    }

}
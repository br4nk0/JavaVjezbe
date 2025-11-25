package vjezbeVIII;

public class TestProgram {
    public static void main(String[] args) {
        Restoran r = new Restoran("Trastavere", "Main St 1", "123456789");

        Konobar k1 = new Konobar(1, "Petar", "Petrovic", 8.5, 40, 5); 
        Kuvar ku1 = new Kuvar(2, "Marko", "Markovic", 10.0, 42);
        Menadzer m1 = new Menadzer(3, "Jelena", "Jankovic", 12.0, 38, 200);
        Konobar k2 = new Konobar(4, "Ana", "Anic", 7.5, 36, 0);
        Kuvar ku2 = new Kuvar(5, "Ivana", "Ivanovic", 9.0, 40);

        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(ku1);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(ku2);

        
        r.generisiObracun(5, 2025);

        double ukupno = r.ukupniTrosakZaMesec(5, 2025);
        System.out.printf("\nUkupan trosak (iz metoda): %.2f EUR\n", ukupno);
    }
}

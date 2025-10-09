package vjezbeIV;

public class analizaNiza {
    // Metoda koja izračunava prosjek svih pozitivnih parnih brojeva u nizu
    public static double nadjiParniPozitivniProsjek(int[] niz) {
        int suma = 0;
        int broj = 0;
        for (int x : niz) {
            if (x > 0 && x % 2 == 0) {
                suma += x;
                broj++;
            }
        }
        if (broj == 0) return 0;
        return (double) suma / broj;
    }

	public static void main(String[] args) {
	}

}
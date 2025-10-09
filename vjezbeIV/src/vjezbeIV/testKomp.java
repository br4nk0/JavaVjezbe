package vjezbeIV;

public class testKomp {

	public static void main(String[] args) {
		KompleksniBroj z1 = new KompleksniBroj();
		z1.odstampaj();
		KompleksniBroj z2 = new KompleksniBroj(-3);
		z2.odstampaj();
		KompleksniBroj z3 = new KompleksniBroj(3,-4);
		z3.odstampaj();
		z3.postaviRealniDio(-10);
		z3.odstampaj();
		System.out.println("Imaginarni dio  z3 je: %.2f " + z3.getImaginarniDio());
		System.out.printf("Modul z3 je: %.2f %n", z3.modul());
		KompleksniBroj z4 = z3.saberi(z2);
		z4.odstampaj();

	}

}
